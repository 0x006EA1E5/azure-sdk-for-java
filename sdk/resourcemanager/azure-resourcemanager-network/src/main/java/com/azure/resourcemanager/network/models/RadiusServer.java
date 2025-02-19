// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Radius Server Settings. */
@Fluent
public final class RadiusServer {
    /*
     * The address of this radius server.
     */
    @JsonProperty(value = "radiusServerAddress", required = true)
    private String radiusServerAddress;

    /*
     * The initial score assigned to this radius server.
     */
    @JsonProperty(value = "radiusServerScore")
    private Long radiusServerScore;

    /*
     * The secret used for this radius server.
     */
    @JsonProperty(value = "radiusServerSecret")
    private String radiusServerSecret;

    /**
     * Get the radiusServerAddress property: The address of this radius server.
     *
     * @return the radiusServerAddress value.
     */
    public String radiusServerAddress() {
        return this.radiusServerAddress;
    }

    /**
     * Set the radiusServerAddress property: The address of this radius server.
     *
     * @param radiusServerAddress the radiusServerAddress value to set.
     * @return the RadiusServer object itself.
     */
    public RadiusServer withRadiusServerAddress(String radiusServerAddress) {
        this.radiusServerAddress = radiusServerAddress;
        return this;
    }

    /**
     * Get the radiusServerScore property: The initial score assigned to this radius server.
     *
     * @return the radiusServerScore value.
     */
    public Long radiusServerScore() {
        return this.radiusServerScore;
    }

    /**
     * Set the radiusServerScore property: The initial score assigned to this radius server.
     *
     * @param radiusServerScore the radiusServerScore value to set.
     * @return the RadiusServer object itself.
     */
    public RadiusServer withRadiusServerScore(Long radiusServerScore) {
        this.radiusServerScore = radiusServerScore;
        return this;
    }

    /**
     * Get the radiusServerSecret property: The secret used for this radius server.
     *
     * @return the radiusServerSecret value.
     */
    public String radiusServerSecret() {
        return this.radiusServerSecret;
    }

    /**
     * Set the radiusServerSecret property: The secret used for this radius server.
     *
     * @param radiusServerSecret the radiusServerSecret value to set.
     * @return the RadiusServer object itself.
     */
    public RadiusServer withRadiusServerSecret(String radiusServerSecret) {
        this.radiusServerSecret = radiusServerSecret;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (radiusServerAddress() == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        "Missing required property radiusServerAddress in model RadiusServer"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(RadiusServer.class);
}
