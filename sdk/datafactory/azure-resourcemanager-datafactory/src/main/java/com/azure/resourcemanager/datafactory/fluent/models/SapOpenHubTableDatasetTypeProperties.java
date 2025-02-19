// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Sap Business Warehouse Open Hub Destination Table properties. */
@Fluent
public final class SapOpenHubTableDatasetTypeProperties {
    /*
     * The name of the Open Hub Destination with destination type as Database Table. Type: string (or Expression with
     * resultType string).
     */
    @JsonProperty(value = "openHubDestinationName", required = true)
    private Object openHubDestinationName;

    /*
     * Whether to exclude the records of the last request. The default value is true. Type: boolean (or Expression with
     * resultType boolean).
     */
    @JsonProperty(value = "excludeLastRequest")
    private Object excludeLastRequest;

    /*
     * The ID of request for delta loading. Once it is set, only data with requestId larger than the value of this
     * property will be retrieved. The default value is 0. Type: integer (or Expression with resultType integer ).
     */
    @JsonProperty(value = "baseRequestId")
    private Object baseRequestId;

    /**
     * Get the openHubDestinationName property: The name of the Open Hub Destination with destination type as Database
     * Table. Type: string (or Expression with resultType string).
     *
     * @return the openHubDestinationName value.
     */
    public Object openHubDestinationName() {
        return this.openHubDestinationName;
    }

    /**
     * Set the openHubDestinationName property: The name of the Open Hub Destination with destination type as Database
     * Table. Type: string (or Expression with resultType string).
     *
     * @param openHubDestinationName the openHubDestinationName value to set.
     * @return the SapOpenHubTableDatasetTypeProperties object itself.
     */
    public SapOpenHubTableDatasetTypeProperties withOpenHubDestinationName(Object openHubDestinationName) {
        this.openHubDestinationName = openHubDestinationName;
        return this;
    }

    /**
     * Get the excludeLastRequest property: Whether to exclude the records of the last request. The default value is
     * true. Type: boolean (or Expression with resultType boolean).
     *
     * @return the excludeLastRequest value.
     */
    public Object excludeLastRequest() {
        return this.excludeLastRequest;
    }

    /**
     * Set the excludeLastRequest property: Whether to exclude the records of the last request. The default value is
     * true. Type: boolean (or Expression with resultType boolean).
     *
     * @param excludeLastRequest the excludeLastRequest value to set.
     * @return the SapOpenHubTableDatasetTypeProperties object itself.
     */
    public SapOpenHubTableDatasetTypeProperties withExcludeLastRequest(Object excludeLastRequest) {
        this.excludeLastRequest = excludeLastRequest;
        return this;
    }

    /**
     * Get the baseRequestId property: The ID of request for delta loading. Once it is set, only data with requestId
     * larger than the value of this property will be retrieved. The default value is 0. Type: integer (or Expression
     * with resultType integer ).
     *
     * @return the baseRequestId value.
     */
    public Object baseRequestId() {
        return this.baseRequestId;
    }

    /**
     * Set the baseRequestId property: The ID of request for delta loading. Once it is set, only data with requestId
     * larger than the value of this property will be retrieved. The default value is 0. Type: integer (or Expression
     * with resultType integer ).
     *
     * @param baseRequestId the baseRequestId value to set.
     * @return the SapOpenHubTableDatasetTypeProperties object itself.
     */
    public SapOpenHubTableDatasetTypeProperties withBaseRequestId(Object baseRequestId) {
        this.baseRequestId = baseRequestId;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (openHubDestinationName() == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        "Missing required property openHubDestinationName in model"
                            + " SapOpenHubTableDatasetTypeProperties"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(SapOpenHubTableDatasetTypeProperties.class);
}
