// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appplatform.models;

import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.List;

/** Certificate resource payload. */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type",
    defaultImpl = CertificateProperties.class)
@JsonTypeName("CertificateProperties")
@JsonSubTypes({
    @JsonSubTypes.Type(name = "KeyVaultCertificate", value = KeyVaultCertificateProperties.class),
    @JsonSubTypes.Type(name = "ContentCertificate", value = ContentCertificateProperties.class)
})
@Immutable
public class CertificateProperties {
    /*
     * The thumbprint of certificate.
     */
    @JsonProperty(value = "thumbprint", access = JsonProperty.Access.WRITE_ONLY)
    private String thumbprint;

    /*
     * The issuer of certificate.
     */
    @JsonProperty(value = "issuer", access = JsonProperty.Access.WRITE_ONLY)
    private String issuer;

    /*
     * The issue date of certificate.
     */
    @JsonProperty(value = "issuedDate", access = JsonProperty.Access.WRITE_ONLY)
    private String issuedDate;

    /*
     * The expiration date of certificate.
     */
    @JsonProperty(value = "expirationDate", access = JsonProperty.Access.WRITE_ONLY)
    private String expirationDate;

    /*
     * The activate date of certificate.
     */
    @JsonProperty(value = "activateDate", access = JsonProperty.Access.WRITE_ONLY)
    private String activateDate;

    /*
     * The subject name of certificate.
     */
    @JsonProperty(value = "subjectName", access = JsonProperty.Access.WRITE_ONLY)
    private String subjectName;

    /*
     * The domain list of certificate.
     */
    @JsonProperty(value = "dnsNames", access = JsonProperty.Access.WRITE_ONLY)
    private List<String> dnsNames;

    /**
     * Get the thumbprint property: The thumbprint of certificate.
     *
     * @return the thumbprint value.
     */
    public String thumbprint() {
        return this.thumbprint;
    }

    /**
     * Get the issuer property: The issuer of certificate.
     *
     * @return the issuer value.
     */
    public String issuer() {
        return this.issuer;
    }

    /**
     * Get the issuedDate property: The issue date of certificate.
     *
     * @return the issuedDate value.
     */
    public String issuedDate() {
        return this.issuedDate;
    }

    /**
     * Get the expirationDate property: The expiration date of certificate.
     *
     * @return the expirationDate value.
     */
    public String expirationDate() {
        return this.expirationDate;
    }

    /**
     * Get the activateDate property: The activate date of certificate.
     *
     * @return the activateDate value.
     */
    public String activateDate() {
        return this.activateDate;
    }

    /**
     * Get the subjectName property: The subject name of certificate.
     *
     * @return the subjectName value.
     */
    public String subjectName() {
        return this.subjectName;
    }

    /**
     * Get the dnsNames property: The domain list of certificate.
     *
     * @return the dnsNames value.
     */
    public List<String> dnsNames() {
        return this.dnsNames;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
