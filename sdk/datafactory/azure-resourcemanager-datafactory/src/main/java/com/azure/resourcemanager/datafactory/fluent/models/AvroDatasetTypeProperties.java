// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.datafactory.models.DatasetLocation;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Avro dataset properties. */
@Fluent
public final class AvroDatasetTypeProperties {
    /*
     * The location of the avro storage.
     */
    @JsonProperty(value = "location", required = true)
    private DatasetLocation location;

    /*
     * The data avroCompressionCodec. Type: string (or Expression with resultType string).
     */
    @JsonProperty(value = "avroCompressionCodec")
    private Object avroCompressionCodec;

    /*
     * The avroCompressionLevel property.
     */
    @JsonProperty(value = "avroCompressionLevel")
    private Integer avroCompressionLevel;

    /**
     * Get the location property: The location of the avro storage.
     *
     * @return the location value.
     */
    public DatasetLocation location() {
        return this.location;
    }

    /**
     * Set the location property: The location of the avro storage.
     *
     * @param location the location value to set.
     * @return the AvroDatasetTypeProperties object itself.
     */
    public AvroDatasetTypeProperties withLocation(DatasetLocation location) {
        this.location = location;
        return this;
    }

    /**
     * Get the avroCompressionCodec property: The data avroCompressionCodec. Type: string (or Expression with resultType
     * string).
     *
     * @return the avroCompressionCodec value.
     */
    public Object avroCompressionCodec() {
        return this.avroCompressionCodec;
    }

    /**
     * Set the avroCompressionCodec property: The data avroCompressionCodec. Type: string (or Expression with resultType
     * string).
     *
     * @param avroCompressionCodec the avroCompressionCodec value to set.
     * @return the AvroDatasetTypeProperties object itself.
     */
    public AvroDatasetTypeProperties withAvroCompressionCodec(Object avroCompressionCodec) {
        this.avroCompressionCodec = avroCompressionCodec;
        return this;
    }

    /**
     * Get the avroCompressionLevel property: The avroCompressionLevel property.
     *
     * @return the avroCompressionLevel value.
     */
    public Integer avroCompressionLevel() {
        return this.avroCompressionLevel;
    }

    /**
     * Set the avroCompressionLevel property: The avroCompressionLevel property.
     *
     * @param avroCompressionLevel the avroCompressionLevel value to set.
     * @return the AvroDatasetTypeProperties object itself.
     */
    public AvroDatasetTypeProperties withAvroCompressionLevel(Integer avroCompressionLevel) {
        this.avroCompressionLevel = avroCompressionLevel;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (location() == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        "Missing required property location in model AvroDatasetTypeProperties"));
        } else {
            location().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(AvroDatasetTypeProperties.class);
}
