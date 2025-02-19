// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/** Trial component definition. */
@Fluent
public final class TrialComponent {
    /*
     * ARM resource ID of the code asset.
     */
    @JsonProperty(value = "codeId")
    private String codeId;

    /*
     * [Required] The command to execute on startup of the job. eg. "python
     * train.py"
     */
    @JsonProperty(value = "command", required = true)
    private String command;

    /*
     * Distribution configuration of the job. If set, this should be one of
     * Mpi, Tensorflow, PyTorch, or null.
     */
    @JsonProperty(value = "distribution")
    private DistributionConfiguration distribution;

    /*
     * [Required] The ARM resource ID of the Environment specification for the
     * job.
     */
    @JsonProperty(value = "environmentId", required = true)
    private String environmentId;

    /*
     * Environment variables included in the job.
     */
    @JsonProperty(value = "environmentVariables")
    @JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.ALWAYS)
    private Map<String, String> environmentVariables;

    /*
     * Compute Resource configuration for the job.
     */
    @JsonProperty(value = "resources")
    private ResourceConfiguration resources;

    /**
     * Get the codeId property: ARM resource ID of the code asset.
     *
     * @return the codeId value.
     */
    public String codeId() {
        return this.codeId;
    }

    /**
     * Set the codeId property: ARM resource ID of the code asset.
     *
     * @param codeId the codeId value to set.
     * @return the TrialComponent object itself.
     */
    public TrialComponent withCodeId(String codeId) {
        this.codeId = codeId;
        return this;
    }

    /**
     * Get the command property: [Required] The command to execute on startup of the job. eg. "python train.py".
     *
     * @return the command value.
     */
    public String command() {
        return this.command;
    }

    /**
     * Set the command property: [Required] The command to execute on startup of the job. eg. "python train.py".
     *
     * @param command the command value to set.
     * @return the TrialComponent object itself.
     */
    public TrialComponent withCommand(String command) {
        this.command = command;
        return this;
    }

    /**
     * Get the distribution property: Distribution configuration of the job. If set, this should be one of Mpi,
     * Tensorflow, PyTorch, or null.
     *
     * @return the distribution value.
     */
    public DistributionConfiguration distribution() {
        return this.distribution;
    }

    /**
     * Set the distribution property: Distribution configuration of the job. If set, this should be one of Mpi,
     * Tensorflow, PyTorch, or null.
     *
     * @param distribution the distribution value to set.
     * @return the TrialComponent object itself.
     */
    public TrialComponent withDistribution(DistributionConfiguration distribution) {
        this.distribution = distribution;
        return this;
    }

    /**
     * Get the environmentId property: [Required] The ARM resource ID of the Environment specification for the job.
     *
     * @return the environmentId value.
     */
    public String environmentId() {
        return this.environmentId;
    }

    /**
     * Set the environmentId property: [Required] The ARM resource ID of the Environment specification for the job.
     *
     * @param environmentId the environmentId value to set.
     * @return the TrialComponent object itself.
     */
    public TrialComponent withEnvironmentId(String environmentId) {
        this.environmentId = environmentId;
        return this;
    }

    /**
     * Get the environmentVariables property: Environment variables included in the job.
     *
     * @return the environmentVariables value.
     */
    public Map<String, String> environmentVariables() {
        return this.environmentVariables;
    }

    /**
     * Set the environmentVariables property: Environment variables included in the job.
     *
     * @param environmentVariables the environmentVariables value to set.
     * @return the TrialComponent object itself.
     */
    public TrialComponent withEnvironmentVariables(Map<String, String> environmentVariables) {
        this.environmentVariables = environmentVariables;
        return this;
    }

    /**
     * Get the resources property: Compute Resource configuration for the job.
     *
     * @return the resources value.
     */
    public ResourceConfiguration resources() {
        return this.resources;
    }

    /**
     * Set the resources property: Compute Resource configuration for the job.
     *
     * @param resources the resources value to set.
     * @return the TrialComponent object itself.
     */
    public TrialComponent withResources(ResourceConfiguration resources) {
        this.resources = resources;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (command() == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException("Missing required property command in model TrialComponent"));
        }
        if (distribution() != null) {
            distribution().validate();
        }
        if (environmentId() == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException("Missing required property environmentId in model TrialComponent"));
        }
        if (resources() != null) {
            resources().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(TrialComponent.class);
}
