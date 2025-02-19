// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.HashMap;
import java.util.Map;

/** The format definition of a storage. */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type",
    defaultImpl = DatasetStorageFormat.class)
@JsonTypeName("DatasetStorageFormat")
@JsonSubTypes({
    @JsonSubTypes.Type(name = "TextFormat", value = TextFormat.class),
    @JsonSubTypes.Type(name = "JsonFormat", value = JsonFormat.class),
    @JsonSubTypes.Type(name = "AvroFormat", value = AvroFormat.class),
    @JsonSubTypes.Type(name = "OrcFormat", value = OrcFormat.class),
    @JsonSubTypes.Type(name = "ParquetFormat", value = ParquetFormat.class)
})
@Fluent
public class DatasetStorageFormat {
    /*
     * Serializer. Type: string (or Expression with resultType string).
     */
    @JsonProperty(value = "serializer")
    private Object serializer;

    /*
     * Deserializer. Type: string (or Expression with resultType string).
     */
    @JsonProperty(value = "deserializer")
    private Object deserializer;

    /*
     * The format definition of a storage.
     */
    @JsonIgnore private Map<String, Object> additionalProperties;

    /**
     * Get the serializer property: Serializer. Type: string (or Expression with resultType string).
     *
     * @return the serializer value.
     */
    public Object serializer() {
        return this.serializer;
    }

    /**
     * Set the serializer property: Serializer. Type: string (or Expression with resultType string).
     *
     * @param serializer the serializer value to set.
     * @return the DatasetStorageFormat object itself.
     */
    public DatasetStorageFormat withSerializer(Object serializer) {
        this.serializer = serializer;
        return this;
    }

    /**
     * Get the deserializer property: Deserializer. Type: string (or Expression with resultType string).
     *
     * @return the deserializer value.
     */
    public Object deserializer() {
        return this.deserializer;
    }

    /**
     * Set the deserializer property: Deserializer. Type: string (or Expression with resultType string).
     *
     * @param deserializer the deserializer value to set.
     * @return the DatasetStorageFormat object itself.
     */
    public DatasetStorageFormat withDeserializer(Object deserializer) {
        this.deserializer = deserializer;
        return this;
    }

    /**
     * Get the additionalProperties property: The format definition of a storage.
     *
     * @return the additionalProperties value.
     */
    @JsonAnyGetter
    public Map<String, Object> additionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Set the additionalProperties property: The format definition of a storage.
     *
     * @param additionalProperties the additionalProperties value to set.
     * @return the DatasetStorageFormat object itself.
     */
    public DatasetStorageFormat withAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
        return this;
    }

    @JsonAnySetter
    void withAdditionalProperties(String key, Object value) {
        if (additionalProperties == null) {
            additionalProperties = new HashMap<>();
        }
        additionalProperties.put(key, value);
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
