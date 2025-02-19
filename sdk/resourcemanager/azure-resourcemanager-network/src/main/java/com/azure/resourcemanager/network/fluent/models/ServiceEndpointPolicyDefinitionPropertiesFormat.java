// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.network.models.ProvisioningState;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Service Endpoint policy definition resource. */
@Fluent
public final class ServiceEndpointPolicyDefinitionPropertiesFormat {
    /*
     * A description for this rule. Restricted to 140 chars.
     */
    @JsonProperty(value = "description")
    private String description;

    /*
     * Service endpoint name.
     */
    @JsonProperty(value = "service")
    private String service;

    /*
     * A list of service resources.
     */
    @JsonProperty(value = "serviceResources")
    private List<String> serviceResources;

    /*
     * The provisioning state of the service endpoint policy definition resource.
     */
    @JsonProperty(value = "provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private ProvisioningState provisioningState;

    /**
     * Get the description property: A description for this rule. Restricted to 140 chars.
     *
     * @return the description value.
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description property: A description for this rule. Restricted to 140 chars.
     *
     * @param description the description value to set.
     * @return the ServiceEndpointPolicyDefinitionPropertiesFormat object itself.
     */
    public ServiceEndpointPolicyDefinitionPropertiesFormat withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the service property: Service endpoint name.
     *
     * @return the service value.
     */
    public String service() {
        return this.service;
    }

    /**
     * Set the service property: Service endpoint name.
     *
     * @param service the service value to set.
     * @return the ServiceEndpointPolicyDefinitionPropertiesFormat object itself.
     */
    public ServiceEndpointPolicyDefinitionPropertiesFormat withService(String service) {
        this.service = service;
        return this;
    }

    /**
     * Get the serviceResources property: A list of service resources.
     *
     * @return the serviceResources value.
     */
    public List<String> serviceResources() {
        return this.serviceResources;
    }

    /**
     * Set the serviceResources property: A list of service resources.
     *
     * @param serviceResources the serviceResources value to set.
     * @return the ServiceEndpointPolicyDefinitionPropertiesFormat object itself.
     */
    public ServiceEndpointPolicyDefinitionPropertiesFormat withServiceResources(List<String> serviceResources) {
        this.serviceResources = serviceResources;
        return this;
    }

    /**
     * Get the provisioningState property: The provisioning state of the service endpoint policy definition resource.
     *
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
