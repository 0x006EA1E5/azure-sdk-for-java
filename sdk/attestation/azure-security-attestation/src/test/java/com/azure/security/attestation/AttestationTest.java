// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.security.attestation;

import com.azure.core.http.HttpClient;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.rest.Response;
import com.azure.core.test.TestMode;
import com.azure.core.util.BinaryData;
import com.azure.core.util.Context;
import com.azure.core.util.serializer.JacksonAdapter;
import com.azure.core.util.serializer.SerializerEncoding;
import com.azure.security.attestation.models.AttestationData;
import com.azure.security.attestation.models.AttestationDataInterpretation;
import com.azure.security.attestation.models.AttestationOptions;
import com.azure.security.attestation.models.AttestationPolicySetOptions;
import com.azure.security.attestation.models.AttestationResponse;
import com.azure.security.attestation.models.AttestationResult;
import com.azure.security.attestation.models.AttestationSigningKey;
import com.azure.security.attestation.models.AttestationTokenValidationOptions;
import com.azure.security.attestation.models.AttestationType;
import com.azure.security.attestation.models.PolicyModification;
import com.azure.security.attestation.models.PolicyResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.opentelemetry.api.trace.Span;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.azure.core.util.tracing.Tracer.PARENT_TRACE_CONTEXT_KEY;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AttestationTest extends AttestationClientTestBase {
    private static final String DISPLAY_NAME_WITH_ARGUMENTS = "{displayName} with [{arguments}]";

    private final String runtimeData =
        "CiAgICAgICAgewogI"
            + "CAgICAgICAgICAiandrIiA6IHsKICAgICAgICAgICAgICAgICJrdHkiOiJFQyIsCiAg"
            + "ICAgICAgICAgICAgICAidXNlIjoic2lnIiwKICAgICAgICAgICAgICAgICJjcnYiOiJ"
            + "QLTI1NiIsCiAgICAgICAgICAgICAgICAieCI6IjE4d0hMZUlnVzl3Vk42VkQxVHhncH"
            + "F5MkxzellrTWY2SjhualZBaWJ2aE0iLAogICAgICAgICAgICAgICAgInkiOiJjVjRkU"
            + "zRVYUxNZ1BfNGZZNGo4aXI3Y2wxVFhsRmRBZ2N4NTVvN1RrY1NBIgogICAgICAgICAg"
            + "ICB9CiAgICAgICAgfQogICAgICAgIA";


    private final String openEnclaveReport =
        "AQAAAAIAAADkEQAAAAAAAAMAAg"
            + "AAAAAABQAKAJOacjP3nEyplAoNs5V_Bgc42MPzGo7hPWS_h-3tExJrAAAAABERAwX_g"
            + "AYAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAUAAAAAAAAA"
            + "BwAAAAAAAAC3eSAmGL7LY2do5dkC8o1SQiJzX6-1OeqboHw_wXGhwgAAAAAAAAAAAAA"
            + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAALBpElSroIHE1xsKbdbjAKTcu6UtnfhXCC9QjQP"
            + "ENQaoAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
            + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB"
            + "AAEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
            + "AAAAAAAAAAAAAAAAA7RGp65ffwXBToyppkucdBPfsmW5FUZq3EJNq-0j5BB0AAAAAAA"
            + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADAQAAB4iv_XjOJsrFMrPvIYOBCeMR2q6"
            + "xB08KluTNAtIgpZQUIzLNyy78Gmb5LE77UIVye2sao77dOGiz3wP2f5jhEE5iovgPhy"
            + "6-Qg8JQkqe8XJI6B5ZlWsfq3E7u9EvH7ZZ33MihT7aM-sXca4u92L8OIhpM2cfJguOS"
            + "AS3Q4pR4NdRERAwX_gAYAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
            + "AAAAAAABUAAAAAAAAABwAAAAAAAAA_sKzghp0uMPKOhtcMdmQDpU-7zWWO7ODhuUipF"
            + "VkXQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAjE9XddeWUD6WE393xoqC"
            + "mgBWrI3tcBQLCBsJRJDFe_8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
            + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
            + "AAAAAAAAAAAAAAAAABAAUAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
            + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD9rOmAu-jSSf1BAj_cC0mu7YCnx4QosD"
            + "78yj3sQX81IAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH5Au8JZ_dpXiLY"
            + "aE1TtyGjGz0dtFZa7eGooRGTQzoJJuR8Xj-zUvyCKE4ABy0pajfE8lOGSUHuJoifisJ"
            + "NAhg4gAAABAgMEBQYHCAkKCwwNDg8QERITFBUWFxgZGhscHR4fBQDIDQAALS0tLS1CR"
            + "UdJTiBDRVJUSUZJQ0FURS0tLS0tCk1JSUVmekNDQkNhZ0F3SUJBZ0lVRk5xSnZZZTU4"
            + "ZXlpUjI2Yzd0L2lxU0pNYnFNd0NnWUlLb1pJemowRUF3SXcKY1RFak1DRUdBMVVFQXd"
            + "3YVNXNTBaV3dnVTBkWUlGQkRTeUJRY205alpYTnpiM0lnUTBFeEdqQVlCZ05WQkFvTQ"
            + "pFVWx1ZEdWc0lFTnZjbkJ2Y21GMGFXOXVNUlF3RWdZRFZRUUhEQXRUWVc1MFlTQkRiR"
            + "0Z5WVRFTE1Ba0dBMVVFCkNBd0NRMEV4Q3pBSkJnTlZCQVlUQWxWVE1CNFhEVEl4TURR"
            + "eU1USXdOVGt6T0ZvWERUSTRNRFF5TVRJd05Ua3oKT0Zvd2NERWlNQ0FHQTFVRUF3d1p"
            + "TVzUwWld3Z1UwZFlJRkJEU3lCRFpYSjBhV1pwWTJGMFpURWFNQmdHQTFVRQpDZ3dSU1"
            + "c1MFpXd2dRMjl5Y0c5eVlYUnBiMjR4RkRBU0JnTlZCQWNNQzFOaGJuUmhJRU5zWVhKa"
            + "E1Rc3dDUVlEClZRUUlEQUpEUVRFTE1Ba0dBMVVFQmhNQ1ZWTXdXVEFUQmdjcWhrak9Q"
            + "UUlCQmdncWhrak9QUU1CQndOQ0FBUTgKU2V1NWV4WCtvMGNkclhkeEtHMGEvQXRzdnV"
            + "lNVNoUFpmOHgwa2czc0xSM2E5TzVHWWYwcW1XSkptL0c4bzZyVgpvbVI2Nmh3cFJXNl"
            + "pqSm9ocXdvT280SUNtekNDQXBjd0h3WURWUjBqQkJnd0ZvQVUwT2lxMm5YWCtTNUpGN"
            + "Wc4CmV4UmwwTlh5V1Uwd1h3WURWUjBmQkZnd1ZqQlVvRktnVUlaT2FIUjBjSE02THk5"
            + "aGNHa3VkSEoxYzNSbFpITmwKY25acFkyVnpMbWx1ZEdWc0xtTnZiUzl6WjNndlkyVnl"
            + "kR2xtYVdOaGRHbHZiaTkyTWk5d1kydGpjbXcvWTJFOQpjSEp2WTJWemMyOXlNQjBHQT"
            + "FVZERnUVdCQlFzbnhWelhVWnhwRkd5YUtXdzhWZmdOZXBjcHpBT0JnTlZIUThCCkFmO"
            + "EVCQU1DQnNBd0RBWURWUjBUQVFIL0JBSXdBRENDQWRRR0NTcUdTSWI0VFFFTkFRU0NB"
            + "Y1V3Z2dIQk1CNEcKQ2lxR1NJYjRUUUVOQVFFRUVEeEI4dUNBTVU0bmw1ZlBFaktxdG8"
            + "wd2dnRmtCZ29xaGtpRytFMEJEUUVDTUlJQgpWREFRQmdzcWhraUcrRTBCRFFFQ0FRSU"
            + "JFVEFRQmdzcWhraUcrRTBCRFFFQ0FnSUJFVEFRQmdzcWhraUcrRTBCCkRRRUNBd0lCQ"
            + "WpBUUJnc3Foa2lHK0UwQkRRRUNCQUlCQkRBUUJnc3Foa2lHK0UwQkRRRUNCUUlCQVRB"
            + "UkJnc3EKaGtpRytFMEJEUUVDQmdJQ0FJQXdFQVlMS29aSWh2aE5BUTBCQWdjQ0FRWXd"
            + "FQVlMS29aSWh2aE5BUTBCQWdnQwpBUUF3RUFZTEtvWklodmhOQVEwQkFna0NBUUF3RU"
            + "FZTEtvWklodmhOQVEwQkFnb0NBUUF3RUFZTEtvWklodmhOCkFRMEJBZ3NDQVFBd0VBW"
            + "UxLb1pJaHZoTkFRMEJBZ3dDQVFBd0VBWUxLb1pJaHZoTkFRMEJBZzBDQVFBd0VBWUwK"
            + "S29aSWh2aE5BUTBCQWc0Q0FRQXdFQVlMS29aSWh2aE5BUTBCQWc4Q0FRQXdFQVlMS29"
            + "aSWh2aE5BUTBCQWhBQwpBUUF3RUFZTEtvWklodmhOQVEwQkFoRUNBUW93SHdZTEtvWk"
            + "lodmhOQVEwQkFoSUVFQkVSQWdRQmdBWUFBQUFBCkFBQUFBQUF3RUFZS0tvWklodmhOQ"
            + "VEwQkF3UUNBQUF3RkFZS0tvWklodmhOQVEwQkJBUUdBSkJ1MVFBQU1BOEcKQ2lxR1NJ"
            + "YjRUUUVOQVFVS0FRQXdDZ1lJS29aSXpqMEVBd0lEUndBd1JBSWdjREZEZHl1UFRHRVR"
            + "ORm5BU0QzOApDWTNSNmlBREpEVHZBbHZTWDNIekk4a0NJRDZsVm1DWklYUHk4ekpKMW"
            + "gvMnJ1NjJsdlVVWDJJaU1ibVFOUEEwClBzMC8KLS0tLS1FTkQgQ0VSVElGSUNBVEUtL"
            + "S0tLQotLS0tLUJFR0lOIENFUlRJRklDQVRFLS0tLS0KTUlJQ2x6Q0NBajZnQXdJQkFn"
            + "SVZBTkRvcXRwMTEva3VTUmVZUEhzVVpkRFY4bGxOTUFvR0NDcUdTTTQ5QkFNQwpNR2d"
            + "4R2pBWUJnTlZCQU1NRVVsdWRHVnNJRk5IV0NCU2IyOTBJRU5CTVJvd0dBWURWUVFLRE"
            + "JGSmJuUmxiQ0JECmIzSndiM0poZEdsdmJqRVVNQklHQTFVRUJ3d0xVMkZ1ZEdFZ1Eye"
            + "GhjbUV4Q3pBSkJnTlZCQWdNQWtOQk1Rc3cKQ1FZRFZRUUdFd0pWVXpBZUZ3MHhPREEx"
            + "TWpFeE1EUTFNRGhhRncwek16QTFNakV4TURRMU1EaGFNSEV4SXpBaApCZ05WQkFNTUd"
            + "rbHVkR1ZzSUZOSFdDQlFRMHNnVUhKdlkyVnpjMjl5SUVOQk1Sb3dHQVlEVlFRS0RCRk"
            + "piblJsCmJDQkRiM0p3YjNKaGRHbHZiakVVTUJJR0ExVUVCd3dMVTJGdWRHRWdRMnhoY"
            + "21FeEN6QUpCZ05WQkFnTUFrTkIKTVFzd0NRWURWUVFHRXdKVlV6QlpNQk1HQnlxR1NN"
            + "NDlBZ0VHQ0NxR1NNNDlBd0VIQTBJQUJMOXErTk1wMklPZwp0ZGwxYmsvdVdaNStUR1F"
            + "tOGFDaTh6NzhmcytmS0NRM2QrdUR6WG5WVEFUMlpoRENpZnlJdUp3dk4zd05CcDlpCk"
            + "hCU1NNSk1KckJPamdic3dnYmd3SHdZRFZSMGpCQmd3Rm9BVUltVU0xbHFkTkluemc3U"
            + "1ZVcjlRR3prbkJxd3cKVWdZRFZSMGZCRXN3U1RCSG9FV2dRNFpCYUhSMGNITTZMeTlq"
            + "WlhKMGFXWnBZMkYwWlhNdWRISjFjM1JsWkhObApjblpwWTJWekxtbHVkR1ZzTG1OdmJ"
            + "TOUpiblJsYkZOSFdGSnZiM1JEUVM1amNtd3dIUVlEVlIwT0JCWUVGTkRvCnF0cDExL2"
            + "t1U1JlWVBIc1VaZERWOGxsTk1BNEdBMVVkRHdFQi93UUVBd0lCQmpBU0JnTlZIUk1CQ"
            + "WY4RUNEQUcKQVFIL0FnRUFNQW9HQ0NxR1NNNDlCQU1DQTBjQU1FUUNJQy85ais4NFQr"
            + "SHp0Vk8vc09RQldKYlNkKy8ydWV4Swo0K2FBMGpjRkJMY3BBaUEzZGhNckY1Y0Q1MnQ"
            + "2RnFNdkFJcGo4WGRHbXkyYmVlbGpMSksrcHpwY1JBPT0KLS0tLS1FTkQgQ0VSVElGSU"
            + "NBVEUtLS0tLQotLS0tLUJFR0lOIENFUlRJRklDQVRFLS0tLS0KTUlJQ2pqQ0NBalNnQ"
            + "XdJQkFnSVVJbVVNMWxxZE5JbnpnN1NWVXI5UUd6a25CcXd3Q2dZSUtvWkl6ajBFQXdJ"
            + "dwphREVhTUJnR0ExVUVBd3dSU1c1MFpXd2dVMGRZSUZKdmIzUWdRMEV4R2pBWUJnTlZ"
            + "CQW9NRVVsdWRHVnNJRU52CmNuQnZjbUYwYVc5dU1SUXdFZ1lEVlFRSERBdFRZVzUwWV"
            + "NCRGJHRnlZVEVMTUFrR0ExVUVDQXdDUTBFeEN6QUoKQmdOVkJBWVRBbFZUTUI0WERUR"
            + "TRNRFV5TVRFd05ERXhNVm9YRFRNek1EVXlNVEV3TkRFeE1Gb3dhREVhTUJnRwpBMVVF"
            + "QXd3UlNXNTBaV3dnVTBkWUlGSnZiM1FnUTBFeEdqQVlCZ05WQkFvTUVVbHVkR1ZzSUV"
            + "OdmNuQnZjbUYwCmFXOXVNUlF3RWdZRFZRUUhEQXRUWVc1MFlTQkRiR0Z5WVRFTE1Ba0"
            + "dBMVVFQ0F3Q1EwRXhDekFKQmdOVkJBWVQKQWxWVE1Ga3dFd1lIS29aSXpqMENBUVlJS"
            + "29aSXpqMERBUWNEUWdBRUM2bkV3TURJWVpPai9pUFdzQ3phRUtpNwoxT2lPU0xSRmhX"
            + "R2pibkJWSmZWbmtZNHUzSWprRFlZTDBNeE80bXFzeVlqbEJhbFRWWXhGUDJzSkJLNXp"
            + "sS09CCnV6Q0J1REFmQmdOVkhTTUVHREFXZ0JRaVpReldXcDAwaWZPRHRKVlN2MUFiT1"
            + "NjR3JEQlNCZ05WSFI4RVN6QkoKTUVlZ1JhQkRoa0ZvZEhSd2N6b3ZMMk5sY25ScFptb"
            + "GpZWFJsY3k1MGNuVnpkR1ZrYzJWeWRtbGpaWE11YVc1MApaV3d1WTI5dEwwbHVkR1Zz"
            + "VTBkWVVtOXZkRU5CTG1OeWJEQWRCZ05WSFE0RUZnUVVJbVVNMWxxZE5JbnpnN1NWClV"
            + "yOVFHemtuQnF3d0RnWURWUjBQQVFIL0JBUURBZ0VHTUJJR0ExVWRFd0VCL3dRSU1BWU"
            + "JBZjhDQVFFd0NnWUkKS29aSXpqMEVBd0lEU0FBd1JRSWdRUXMvMDhyeWNkUGF1Q0ZrO"
            + "FVQUVhDTUFsc2xvQmU3TndhUUdUY2RwYTBFQwpJUUNVdDhTR3Z4S21qcGNNL3owV1A5"
            + "RHZvOGgyazVkdTFpV0RkQmtBbiswaWlBPT0KLS0tLS1FTkQgQ0VSVElGSUNBVEUtLS0"
            + "tLQoA";

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("getAttestationClients")
    void testAttestSgxEnclave(HttpClient httpClient, String clientUri) {

        AttestationClientBuilder attestationBuilder = getAttestationBuilder(httpClient, clientUri);

        AttestationClient client = attestationBuilder.buildClient();

        BinaryData decodedRuntimeData = BinaryData.fromBytes(Base64.getUrlDecoder().decode(runtimeData));
        BinaryData decodedOpenEnclaveReport = BinaryData.fromBytes(Base64.getUrlDecoder().decode(openEnclaveReport));
        BinaryData sgxQuote = BinaryData.fromBytes(Arrays.copyOfRange(decodedOpenEnclaveReport.toBytes(), 0x10, decodedOpenEnclaveReport.toBytes().length));

        AttestationOptions request = new AttestationOptions(sgxQuote)
            .setRunTimeData(new AttestationData(decodedRuntimeData, AttestationDataInterpretation.BINARY));
        AttestationResult result = client.attestSgxEnclave(request);

        verifyAttestationResult(clientUri, result, decodedRuntimeData, false);
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("getAttestationClients")
    void testAttestSgxEnclaveNoRuntimeData(HttpClient httpClient, String clientUri) {

        AttestationClientBuilder attestationBuilder = getAttestationBuilder(httpClient, clientUri);

        AttestationClient client = attestationBuilder.buildClient();

        BinaryData decodedRuntimeData = BinaryData.fromBytes(Base64.getUrlDecoder().decode(runtimeData));
        BinaryData decodedOpenEnclaveReport = BinaryData.fromBytes(Base64.getUrlDecoder().decode(openEnclaveReport));
        BinaryData sgxQuote = BinaryData.fromBytes(Arrays.copyOfRange(decodedOpenEnclaveReport.toBytes(), 0x10, decodedOpenEnclaveReport.toBytes().length));

        AttestationResult result = client.attestSgxEnclave(sgxQuote);
        verifyAttestationResult(clientUri, result, null, false);
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("getAttestationClients")
    void testAttestSgxEnclaveRuntimeJson(HttpClient httpClient, String clientUri) {

        AttestationClientBuilder attestationBuilder = getAttestationBuilder(httpClient, clientUri);

        AttestationClient client = attestationBuilder.buildClient();

        BinaryData decodedRuntimeData = BinaryData.fromBytes(Base64.getUrlDecoder().decode(runtimeData));
        BinaryData decodedOpenEnclaveReport = BinaryData.fromBytes(Base64.getUrlDecoder().decode(openEnclaveReport));
        BinaryData sgxQuote = BinaryData.fromBytes(Arrays.copyOfRange(decodedOpenEnclaveReport.toBytes(), 0x10, decodedOpenEnclaveReport.toBytes().length));

        AttestationOptions request = new AttestationOptions(sgxQuote)
            .setRunTimeData(new AttestationData(decodedRuntimeData, AttestationDataInterpretation.JSON));

        AttestationResult result = client.attestSgxEnclave(request);
        verifyAttestationResult(clientUri, result, decodedRuntimeData, true);
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("getAttestationClients")
    void testAttestSgxEnclaveDraftPolicy(HttpClient httpClient, String clientUri) {

        AttestationClientBuilder attestationBuilder = getAttestationBuilder(httpClient, clientUri);

        AttestationClient client = attestationBuilder.buildClient();

        BinaryData decodedRuntimeData = BinaryData.fromBytes(Base64.getUrlDecoder().decode(runtimeData));
        BinaryData decodedOpenEnclaveReport = BinaryData.fromBytes(Base64.getUrlDecoder().decode(openEnclaveReport));
        BinaryData sgxQuote = BinaryData.fromBytes(Arrays.copyOfRange(decodedOpenEnclaveReport.toBytes(), 0x10, decodedOpenEnclaveReport.toBytes().length));

        AttestationOptions request = new AttestationOptions(sgxQuote)
            .setDraftPolicyForAttestation("version=1.0; authorizationrules{=> permit();}; issuancerules{};")
            .setRunTimeData(new AttestationData(decodedRuntimeData, AttestationDataInterpretation.JSON));

        Response<AttestationResult> response = client.attestSgxEnclaveWithResponse(request, Context.NONE);
        assertTrue(response instanceof AttestationResponse);
        AttestationResponse<AttestationResult> attestResponse = (AttestationResponse<AttestationResult>) response;

        // When a draft policy is specified, the token is unsecured.
        assertTrue(attestResponse.getToken().getAlgorithm().equals("none"));

        verifyAttestationResult(clientUri, response.getValue(), decodedRuntimeData, true);
    }


    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("getAttestationClients")
    void testAttestSgxEnclaveAsync(HttpClient httpClient, String clientUri) {

        AttestationClientBuilder attestationBuilder = getAttestationBuilder(httpClient, clientUri);
        AttestationAsyncClient client = attestationBuilder.buildAsyncClient();

        BinaryData decodedRuntimeData = BinaryData.fromBytes(Base64.getUrlDecoder().decode(runtimeData));
        BinaryData decodedOpenEnclaveReport = BinaryData.fromBytes(Base64.getUrlDecoder().decode(openEnclaveReport));
        BinaryData sgxQuote = BinaryData.fromBytes(Arrays.copyOfRange(decodedOpenEnclaveReport.toBytes(), 0x10, decodedOpenEnclaveReport.toBytes().length));

        final AtomicBoolean callbackCalled = new AtomicBoolean(false);
        AttestationOptions request = new AttestationOptions(sgxQuote)
            .setRunTimeData(new AttestationData(decodedRuntimeData, AttestationDataInterpretation.BINARY))
            .setValidationOptions(new AttestationTokenValidationOptions()
                .setValidationCallback((token, signer) -> {
                    callbackCalled.set(true);
                    // Perform minimal validation of the issued SGX token. The
                    // token validation logic will have checked the issuance_time
                    // and expiration_time, but this shows accessing those fields.
                    //
                    // The validation logic also checks the subject of the certificate to verify
                    // that the issuer of the certificate is the expected instance of the service.
                    logger.info("In validation callback, checking token...");
                    logger.info(String.format("     Token issuer: %s", token.getIssuer()));
                    if (!interceptorManager.isPlaybackMode()) {
                        logger.info(String.format("     Token was issued at: %tc", token.getIssuedAt()));
                        logger.info(String.format("     Token expires at: %tc", token.getExpiresOn()));
                        if (!token.getIssuer().equals(clientUri)) {
                            logger.error(String.format("Token issuer %s does not match expected issuer %s",
                                token.getIssuer(), clientUri
                            ));
                            throw new RuntimeException(String.format("Issuer Mismatch: found %s, expected %s", token.getIssuer(), clientUri));
                        }
                        logger.info(String.format("Issuer of signing certificate is: %s", signer.getCertificates().get(0).getIssuerDN().getName()));
                    }
                })
                // Only validate time based properties when not in PLAYBACK mode. PLAYBACK mode has these values
                // hard-coded into the session record.
                .setValidateExpiresOn(getTestMode() != TestMode.PLAYBACK));

        StepVerifier.create(client.attestSgxEnclave(request))
            .assertNext(result -> {
                assertTrue(callbackCalled.get());
                verifyAttestationResult(clientUri, result, decodedRuntimeData, false);
            })
            .expectComplete()
            .verify();
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("getAttestationClients")
    void testAttestSgxEnclaveNoRuntimeDataAsync(HttpClient httpClient, String clientUri) {

        AttestationClientBuilder attestationBuilder = getAttestationBuilder(httpClient, clientUri);

        AttestationAsyncClient client = attestationBuilder.buildAsyncClient();

        BinaryData decodedRuntimeData = BinaryData.fromBytes(Base64.getUrlDecoder().decode(runtimeData));
        BinaryData decodedOpenEnclaveReport = BinaryData.fromBytes(Base64.getUrlDecoder().decode(openEnclaveReport));
        BinaryData sgxQuote = BinaryData.fromBytes(Arrays.copyOfRange(decodedOpenEnclaveReport.toBytes(), 0x10, decodedOpenEnclaveReport.toBytes().length));

        AttestationOptions request = new AttestationOptions(sgxQuote);

        StepVerifier.create(client.attestSgxEnclave(request))
            .assertNext(result -> verifyAttestationResult(clientUri, result, null, false))
            .expectComplete()
            .verify();
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("getAttestationClients")
    void testAttestSgxEnclaveRuntimeJsonAsync(HttpClient httpClient, String clientUri) {

        AttestationClientBuilder attestationBuilder = getAttestationBuilder(httpClient, clientUri);

        Span span = tracer.spanBuilder("AttestWithDraft").startSpan();
        Context contextWithSpan = new Context(PARENT_TRACE_CONTEXT_KEY, io.opentelemetry.context.Context.current());

        AttestationAsyncClient client = attestationBuilder.buildAsyncClient();

        BinaryData decodedRuntimeData = BinaryData.fromBytes(Base64.getUrlDecoder().decode(runtimeData));
        BinaryData decodedOpenEnclaveReport = BinaryData.fromBytes(Base64.getUrlDecoder().decode(openEnclaveReport));
        BinaryData sgxQuote = BinaryData.fromBytes(Arrays.copyOfRange(decodedOpenEnclaveReport.toBytes(), 0x10, decodedOpenEnclaveReport.toBytes().length));

        AttestationOptions options = new AttestationOptions(sgxQuote)
            .setRunTimeData(new AttestationData(decodedRuntimeData, AttestationDataInterpretation.JSON));

        StepVerifier.create(client.attestSgxEnclaveWithResponse(options, contextWithSpan))
            .assertNext(result -> {
                verifyAttestationResult(clientUri, result.getValue(), decodedRuntimeData, true);
            })
            .expectComplete()
            .verify();
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("getAttestationClients")
    void testAttestSgxEnclaveDraftPolicyAsync(HttpClient httpClient, String clientUri) {
        AttestationClientBuilder attestationBuilder = getAttestationBuilder(httpClient, clientUri);

        AttestationAsyncClient client = attestationBuilder.buildAsyncClient();

        BinaryData decodedRuntimeData = BinaryData.fromBytes(Base64.getUrlDecoder().decode(runtimeData));
        BinaryData decodedOpenEnclaveReport = BinaryData.fromBytes(Base64.getUrlDecoder().decode(openEnclaveReport));
        BinaryData sgxQuote = BinaryData.fromBytes(Arrays.copyOfRange(decodedOpenEnclaveReport.toBytes(), 0x10, decodedOpenEnclaveReport.toBytes().length));


        Span span = tracer.spanBuilder("AttestWithDraft").startSpan();
        Context contextWithSpan = new Context(PARENT_TRACE_CONTEXT_KEY, io.opentelemetry.context.Context.current());

        AttestationOptions request = new AttestationOptions(sgxQuote)
            .setDraftPolicyForAttestation("version=1.0; authorizationrules{=> permit();}; issuancerules{};")
            .setRunTimeData(new AttestationData(decodedRuntimeData, AttestationDataInterpretation.JSON));

        try {
            StepVerifier.create(client.attestSgxEnclaveWithResponse(request, contextWithSpan))
                .assertNext(response -> {
                    // Make sure that the request included a traceparent header and that the response contains a
                    // traceresponse header.
                    // Note: The recording infrastructure doesn't record traceparent or traceresponse, so we can
                    // only perform this check on live servers.
                    if (getTestMode() != TestMode.PLAYBACK) {
                        HttpHeaders requestHeaders = response.getRequest().getHeaders();
                        assertNotNull(requestHeaders.getValue("traceparent"));
                        HttpHeaders responseHeaders = response.getHeaders();
                        // NB: As of 1-5-2022, MAA doesn't include the standardized traceresponse header, instead
                        // it includes the response in x-ms-request-id.
                        assertNotNull(responseHeaders.getValue("x-ms-request-id"));
                        assertEquals(requestHeaders.getValue("traceparent"), responseHeaders.getValue("x-ms-request-id"));
                    }
                    verifyAttestationResult(clientUri, response.getValue(), decodedRuntimeData, true);
                })
                .expectComplete()
                .verify();
        } finally {
            span.end();
        }
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("getAttestationClients")
    void testTpmAttestation(HttpClient httpClient, String clientUri) {
        ClientTypes clientType = classifyClient(clientUri);
        // TPM attestation requires that we have an attestation policy set, and we can't set attestation policy on the shared client, so just exit early.
        assumeTrue(clientType != ClientTypes.SHARED, "This test does not work on shared instances.");

        // Set the TPM attestation policy to a default value.
        AttestationAdministrationClientBuilder adminBuilder = getAttestationAdministrationBuilder(httpClient, clientUri);
        AttestationAdministrationClient adminClient = adminBuilder.buildClient();
        PolicyResult result = adminClient.setAttestationPolicy(AttestationType.TPM, new AttestationPolicySetOptions()
            .setAttestationPolicy("version=1.0; authorizationrules{=>permit();};issuancerules{};")
            .setAttestationSigner(new AttestationSigningKey(getIsolatedSigningCertificate(), getIsolatedSigningKey())));

        if (result.getPolicyResolution() != PolicyModification.UPDATED) {
            System.out.printf("Unexpected resolution setting TPM policy: %s", result.getPolicyResolution().toString());
            return;
        }

        // We cannot perform the entire protocol exchange for TPM attestation, but we CAN perform the
        // first leg of the attestation operation.
        //
        // Note that TPM attestation requires an authenticated attestation builder.
        AttestationClientBuilder attestationBuilder = getAuthenticatedAttestationBuilder(httpClient, clientUri);
        AttestationClient client = attestationBuilder.buildClient();

        // The initial payload for TPM attestation is a JSON object with a property named "payload",
        // containing an object with a property named "type" whose value is "aikcert".

        String attestInitialPayload = "{\"payload\": { \"type\": \"aikcert\" } }";
        String tpmResponse = client.attestTpm(attestInitialPayload);

        JacksonAdapter serializer = new JacksonAdapter();
        Object deserializedResponse = assertDoesNotThrow(() -> serializer.deserialize(tpmResponse, Object.class, SerializerEncoding.JSON));
        assertTrue(deserializedResponse instanceof LinkedHashMap);
        @SuppressWarnings("unchecked")
        LinkedHashMap<String, Object> initialResponse = (LinkedHashMap<String, Object>) deserializedResponse;
        assertTrue(initialResponse.containsKey("payload"));
        assertTrue(initialResponse.get("payload") instanceof LinkedHashMap);
        @SuppressWarnings("unchecked")
        LinkedHashMap<String, Object> payload = (LinkedHashMap<String, Object>) initialResponse.get("payload");
        assertTrue(payload.containsKey("challenge"));
        assertTrue(payload.containsKey("service_context"));

    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("getAttestationClients")
    void testTpmAttestationWithResult(HttpClient httpClient, String clientUri) {
        ClientTypes clientType = classifyClient(clientUri);
        // TPM attestation requires that we have an attestation policy set, and we can't set attestation policy on the shared client, so just exit early.
        assumeTrue(clientType != ClientTypes.SHARED, "This test does not work on shared instances.");

        // Set the TPM attestation policy to a default value.
        AttestationAdministrationClientBuilder adminBuilder = getAttestationAdministrationBuilder(httpClient, clientUri);
        AttestationAdministrationClient adminClient = adminBuilder.buildClient();
        PolicyResult result = adminClient.setAttestationPolicy(AttestationType.TPM, new AttestationPolicySetOptions()
            .setAttestationPolicy("version=1.0; authorizationrules{=>permit();};issuancerules{};")
            .setAttestationSigner(new AttestationSigningKey(getIsolatedSigningCertificate(), getIsolatedSigningKey())));

        if (result.getPolicyResolution() != PolicyModification.UPDATED) {
            System.out.printf("Unexpected resolution setting TPM policy: %s", result.getPolicyResolution().toString());
            return;
        }

        // We cannot perform the entire protocol exchange for TPM attestation, but we CAN perform the
        // first leg of the attestation operation.
        //
        // Note that TPM attestation requires an authenticated attestation builder.
        AttestationClientBuilder attestationBuilder = getAuthenticatedAttestationBuilder(httpClient, clientUri);
        AttestationClient client = attestationBuilder.buildClient();

        // BEGIN: com.azure.security.attestation.AttestationClient.attestTpmWithResponse
        // The initial payload for TPM attestation is a JSON object with a property named "payload",
        // containing an object with a property named "type" whose value is "aikcert".

        String attestInitialPayload = "{\"payload\": { \"type\": \"aikcert\" } }";
        Response<String> tpmResponse = client.attestTpmWithResponse(attestInitialPayload, Context.NONE);
        // END: com.azure.security.attestation.AttestationClient.attestTpmWithResponse

        JacksonAdapter serializer = new JacksonAdapter();
        Object deserializedResponse = assertDoesNotThrow(() -> serializer.deserialize(tpmResponse.getValue(), Object.class, SerializerEncoding.JSON));
        assertTrue(deserializedResponse instanceof LinkedHashMap);
        @SuppressWarnings("unchecked")
        LinkedHashMap<String, Object> initialResponse = (LinkedHashMap<String, Object>) deserializedResponse;
        assertTrue(initialResponse.containsKey("payload"));
        assertTrue(initialResponse.get("payload") instanceof LinkedHashMap);
        @SuppressWarnings("unchecked")
        LinkedHashMap<String, Object> payload = (LinkedHashMap<String, Object>) initialResponse.get("payload");
        assertTrue(payload.containsKey("challenge"));
        assertTrue(payload.containsKey("service_context"));
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("getAttestationClients")
    void testTpmAttestationAsync(HttpClient httpClient, String clientUri) {
        ClientTypes clientType = classifyClient(clientUri);
        // TPM attestation requires that we have an attestation policy set, and we can't set attestation policy on the shared client, so just exit early.
        assumeTrue(clientType != ClientTypes.SHARED, "This test does not work on shared instances.");

        // Set the TPM attestation policy to a default value.
        AttestationAdministrationClientBuilder adminBuilder = getAttestationAdministrationBuilder(httpClient, clientUri);
        AttestationAdministrationClient adminClient = adminBuilder.buildClient();
        PolicyResult result = adminClient.setAttestationPolicy(AttestationType.TPM, new AttestationPolicySetOptions()
            .setAttestationPolicy("version=1.0; authorizationrules{=>permit();};issuancerules{};")
            .setAttestationSigner(new AttestationSigningKey(getIsolatedSigningCertificate(), getIsolatedSigningKey())));

        if (result.getPolicyResolution() != PolicyModification.UPDATED) {
            System.out.printf("Unexpected resolution setting TPM policy: %s", result.getPolicyResolution().toString());
            return;
        }

        // We cannot perform the entire protocol exchange for TPM attestation, but we CAN perform the
        // first leg of the attestation operation.
        //
        // Note that TPM attestation requires an authenticated attestation builder.
        AttestationClientBuilder attestationBuilder = getAuthenticatedAttestationBuilder(httpClient, clientUri);
        AttestationAsyncClient client = attestationBuilder.buildAsyncClient();

        // The initial payload for TPM attestation is a JSON object with a property named "payload",
        // containing an object with a property named "type" whose value is "aikcert".

        String attestInitialPayload = "{\"payload\": { \"type\": \"aikcert\" } }";
        StepVerifier.create(client.attestTpm(attestInitialPayload))
            .assertNext(tpmResponse -> {
                JacksonAdapter serializer = new JacksonAdapter();
                Object deserializedResponse = assertDoesNotThrow(() -> serializer.deserialize(tpmResponse, Object.class, SerializerEncoding.JSON));
                assertTrue(deserializedResponse instanceof LinkedHashMap);
                @SuppressWarnings("unchecked")
                LinkedHashMap<String, Object> initialResponse = (LinkedHashMap<String, Object>) deserializedResponse;
                assertTrue(initialResponse.containsKey("payload"));
                assertTrue(initialResponse.get("payload") instanceof LinkedHashMap);
                @SuppressWarnings("unchecked")
                LinkedHashMap<String, Object> payload = (LinkedHashMap<String, Object>) initialResponse.get("payload");
                assertTrue(payload.containsKey("challenge"));
                assertTrue(payload.containsKey("service_context"));
            })
            .verifyComplete();
    }

    @Test()
    void testAttestationOptions() {
        BinaryData decodedRuntimeData = BinaryData.fromBytes(Base64.getUrlDecoder().decode(runtimeData));
        BinaryData decodedOpenEnclaveReport = BinaryData.fromBytes(Base64.getUrlDecoder().decode(openEnclaveReport));

        AttestationOptions request1 = new AttestationOptions(decodedOpenEnclaveReport);
        AttestationOptions request2 = new AttestationOptions(decodedOpenEnclaveReport)
            .setInitTimeData(new AttestationData(decodedRuntimeData, AttestationDataInterpretation.JSON))
            .setInitTimeData(new AttestationData(decodedOpenEnclaveReport, AttestationDataInterpretation.BINARY))
            .setRunTimeData(new AttestationData(BinaryData.fromBytes(new byte[]{1, 2, 3, 4, 5}), AttestationDataInterpretation.BINARY));

        assertArrayEquals(decodedOpenEnclaveReport.toBytes(), request2.getInitTimeData().getData().toBytes());
        assertArrayEquals(new byte[]{1, 2, 3, 4, 5}, request2.getRunTimeData().getData().toBytes());
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("getAttestationClients")
    void testAttestOpenEnclave(HttpClient httpClient, String clientUri) {

        AttestationClientBuilder attestationBuilder = getAttestationBuilder(httpClient, clientUri);

        AttestationClient client = attestationBuilder.buildClient();

        BinaryData decodedRuntimeData = BinaryData.fromBytes(Base64.getUrlDecoder().decode(runtimeData));
        BinaryData decodedOpenEnclaveReport = BinaryData.fromBytes(Base64.getUrlDecoder().decode(openEnclaveReport));

        AttestationOptions request = new AttestationOptions(decodedOpenEnclaveReport)
            .setRunTimeData(new AttestationData(decodedRuntimeData, AttestationDataInterpretation.BINARY));
        AttestationResult result = client.attestOpenEnclave(request);

        verifyAttestationResult(clientUri, result, decodedRuntimeData, false);
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("getAttestationClients")
    void testAttestOpenEnclaveNoRuntimeData(HttpClient httpClient, String clientUri) {

        AttestationClientBuilder attestationBuilder = getAttestationBuilder(httpClient, clientUri);

        AttestationClient client = attestationBuilder.buildClient();

        BinaryData decodedOpenEnclaveReport = BinaryData.fromBytes(Base64.getUrlDecoder().decode(openEnclaveReport));

        AttestationOptions request = new AttestationOptions(decodedOpenEnclaveReport);

        AttestationResult result = client.attestOpenEnclave(request);
        verifyAttestationResult(clientUri, result, null, false);
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("getAttestationClients")
    void testAttestOpenEnclaveRuntimeJson(HttpClient httpClient, String clientUri) {

        AttestationClientBuilder attestationBuilder = getAttestationBuilder(httpClient, clientUri);

        AttestationClient client = attestationBuilder.buildClient();

        BinaryData decodedRuntimeData = BinaryData.fromBytes(Base64.getUrlDecoder().decode(runtimeData));
        BinaryData decodedOpenEnclaveReport = BinaryData.fromBytes(Base64.getUrlDecoder().decode(openEnclaveReport));

        AttestationOptions request = new AttestationOptions(decodedOpenEnclaveReport)
            .setRunTimeData(new AttestationData(decodedRuntimeData, AttestationDataInterpretation.JSON));

        AttestationResult result = client.attestOpenEnclave(request);
        verifyAttestationResult(clientUri, result, decodedRuntimeData, true);
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("getAttestationClients")
    void testAttestOpenEnclaveDraftPolicy(HttpClient httpClient, String clientUri) {

        AttestationClientBuilder attestationBuilder = getAttestationBuilder(httpClient, clientUri);

        AttestationClient client = attestationBuilder.buildClient();

        BinaryData decodedRuntimeData = BinaryData.fromBytes(Base64.getUrlDecoder().decode(runtimeData));
        BinaryData decodedOpenEnclaveReport = BinaryData.fromBytes(Base64.getUrlDecoder().decode(openEnclaveReport));

        AttestationOptions request = new AttestationOptions(decodedOpenEnclaveReport)
            .setDraftPolicyForAttestation("version=1.0; authorizationrules{=> permit();}; issuancerules{};")
            .setRunTimeData(new AttestationData(decodedRuntimeData, AttestationDataInterpretation.JSON));

        Response<AttestationResult> response = client.attestOpenEnclaveWithResponse(request, Context.NONE);
        assertTrue(response instanceof AttestationResponse);
        AttestationResponse<AttestationResult> attestResponse = (AttestationResponse<AttestationResult>) response;

        // When a draft policy is specified, the token is unsecured.
        assertTrue(attestResponse.getToken().getAlgorithm().equals("none"));

        verifyAttestationResult(clientUri, response.getValue(), decodedRuntimeData, true);
    }


    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("getAttestationClients")
    void testAttestOpenEnclaveAsync(HttpClient httpClient, String clientUri) {

        AttestationClientBuilder attestationBuilder = getAttestationBuilder(httpClient, clientUri);
        AttestationAsyncClient client = attestationBuilder.buildAsyncClient();

        BinaryData decodedRuntimeData = BinaryData.fromBytes(Base64.getUrlDecoder().decode(runtimeData));
        BinaryData decodedOpenEnclaveReport = BinaryData.fromBytes(Base64.getUrlDecoder().decode(openEnclaveReport));

        AttestationOptions options = new AttestationOptions(decodedOpenEnclaveReport)
            .setRunTimeData(new AttestationData(decodedRuntimeData, AttestationDataInterpretation.BINARY));

        StepVerifier.create(client.attestOpenEnclave(options))
            .assertNext(result -> verifyAttestationResult(clientUri, result, decodedRuntimeData, false))
            .expectComplete()
            .verify();
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("getAttestationClients")
    void testAttestOpenEnclaveNoRuntimeDataAsync(HttpClient httpClient, String clientUri) {

        AttestationClientBuilder attestationBuilder = getAttestationBuilder(httpClient, clientUri);

        AttestationAsyncClient client = attestationBuilder.buildAsyncClient();

        BinaryData decodedOpenEnclaveReport = BinaryData.fromBytes(Base64.getUrlDecoder().decode(openEnclaveReport));

        StepVerifier.create(client.attestOpenEnclave(decodedOpenEnclaveReport))
            .assertNext(result -> verifyAttestationResult(clientUri, result, null, false))
            .expectComplete()
            .verify();
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("getAttestationClients")
    void testAttestOpenEnclaveRuntimeJsonAsync(HttpClient httpClient, String clientUri) {

        AttestationClientBuilder attestationBuilder = getAttestationBuilder(httpClient, clientUri);

        AttestationAsyncClient client = attestationBuilder.buildAsyncClient();

        BinaryData decodedRuntimeData = BinaryData.fromBytes(Base64.getUrlDecoder().decode(runtimeData));
        BinaryData decodedOpenEnclaveReport = BinaryData.fromBytes(Base64.getUrlDecoder().decode(openEnclaveReport));

        AttestationOptions options = new AttestationOptions(decodedOpenEnclaveReport)
            .setRunTimeData(new AttestationData(decodedRuntimeData, AttestationDataInterpretation.JSON));

        StepVerifier.create(client.attestOpenEnclave(options))
            .assertNext(result -> verifyAttestationResult(clientUri, result, decodedRuntimeData, true))
            .expectComplete()
            .verify();
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("getAttestationClients")
    void testAttestOpenEnclaveDraftPolicyAsync(HttpClient httpClient, String clientUri) {

        AttestationClientBuilder attestationBuilder = getAttestationBuilder(httpClient, clientUri);

        AttestationAsyncClient client = attestationBuilder.buildAsyncClient();

        BinaryData decodedRuntimeData = BinaryData.fromBytes(Base64.getUrlDecoder().decode(runtimeData));
        BinaryData decodedOpenEnclaveReport = BinaryData.fromBytes(Base64.getUrlDecoder().decode(openEnclaveReport));

        AttestationOptions options = new AttestationOptions(decodedOpenEnclaveReport)
            .setDraftPolicyForAttestation("version=1.0; authorizationrules{=> permit();}; issuancerules{};")
            .setRunTimeData(new AttestationData(decodedRuntimeData, AttestationDataInterpretation.JSON));

        StepVerifier.create(client.attestOpenEnclaveWithResponse(options))
            .assertNext(response -> {
                verifyAttestationResult(clientUri, response.getValue(), decodedRuntimeData, true);
            })
            .expectComplete()
            .verify();

    }


    private void verifyAttestationResult(String clientUri, AttestationResult result, BinaryData runtimeData, boolean expectJson) {
        assertNotNull(result.getIssuer());

        // In playback mode, the client URI is bogus and thus cannot be relied on for test purposes.
        if (testContextManager.getTestMode() != TestMode.PLAYBACK) {
            Assertions.assertEquals(clientUri, result.getIssuer());
        }

        assertNotNull(result.getMrEnclave());
        assertNotNull(result.getMrSigner());
        assertNotNull(result.getSvn());
        assertNull(result.getNonce());

        if (expectJson) {
            ObjectMapper mapper = new ObjectMapper();
            assertTrue(result.getRuntimeClaims() instanceof Map);
            @SuppressWarnings("unchecked")
            Map<String, Object> runtimeClaims = (Map<String, Object>) result.getRuntimeClaims();
            @SuppressWarnings("unchecked")
            Map<String, Object> expectedClaims = assertDoesNotThrow(() -> (Map<String, Object>) mapper.readValue(runtimeData.toBytes(), Object.class));
            assertObjectEqual(expectedClaims, runtimeClaims);
        } else if (runtimeData != null) {
            Assertions.assertArrayEquals(runtimeData.toBytes(), result.getEnclaveHeldData().toBytes());
        }
    }

    void assertObjectEqual(Map<String, Object> expected, Map<String, Object> actual) {
        expected.forEach((key, o) -> {
            logger.verbose("Key: " + key);
            assertTrue(actual.containsKey(key));
            if (expected.get(key) instanceof Map) {
                assertTrue(actual.get(key) instanceof Map);
                @SuppressWarnings("unchecked")
                Map<String, Object> expectedInner = (Map<String, Object>) expected.get(key);
                @SuppressWarnings("unchecked")
                Map<String, Object> actualInner = (Map<String, Object>) actual.get(key);
                assertObjectEqual(expectedInner, actualInner);
            } else {
                assertEquals(o, actual.get(key));
            }
        });

    }
}

