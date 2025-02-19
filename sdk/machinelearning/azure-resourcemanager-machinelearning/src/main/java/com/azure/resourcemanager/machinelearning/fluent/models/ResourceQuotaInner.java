// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.fluent.models;

import com.azure.core.annotation.Immutable;
import com.azure.resourcemanager.machinelearning.models.QuotaUnit;
import com.azure.resourcemanager.machinelearning.models.ResourceName;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The quota assigned to a resource. */
@Immutable
public final class ResourceQuotaInner {
    /*
     * Specifies the resource ID.
     */
    @JsonProperty(value = "id", access = JsonProperty.Access.WRITE_ONLY)
    private String id;

    /*
     * Region of the AML workspace in the id.
     */
    @JsonProperty(value = "amlWorkspaceLocation", access = JsonProperty.Access.WRITE_ONLY)
    private String amlWorkspaceLocation;

    /*
     * Specifies the resource type.
     */
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private String type;

    /*
     * Name of the resource.
     */
    @JsonProperty(value = "name", access = JsonProperty.Access.WRITE_ONLY)
    private ResourceName name;

    /*
     * Limit. The maximum permitted quota of the resource.
     */
    @JsonProperty(value = "limit", access = JsonProperty.Access.WRITE_ONLY)
    private Long limit;

    /*
     * An enum describing the unit of quota measurement.
     */
    @JsonProperty(value = "unit", access = JsonProperty.Access.WRITE_ONLY)
    private QuotaUnit unit;

    /**
     * Get the id property: Specifies the resource ID.
     *
     * @return the id value.
     */
    public String id() {
        return this.id;
    }

    /**
     * Get the amlWorkspaceLocation property: Region of the AML workspace in the id.
     *
     * @return the amlWorkspaceLocation value.
     */
    public String amlWorkspaceLocation() {
        return this.amlWorkspaceLocation;
    }

    /**
     * Get the type property: Specifies the resource type.
     *
     * @return the type value.
     */
    public String type() {
        return this.type;
    }

    /**
     * Get the name property: Name of the resource.
     *
     * @return the name value.
     */
    public ResourceName name() {
        return this.name;
    }

    /**
     * Get the limit property: Limit. The maximum permitted quota of the resource.
     *
     * @return the limit value.
     */
    public Long limit() {
        return this.limit;
    }

    /**
     * Get the unit property: An enum describing the unit of quota measurement.
     *
     * @return the unit value.
     */
    public QuotaUnit unit() {
        return this.unit;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (name() != null) {
            name().validate();
        }
    }
}
