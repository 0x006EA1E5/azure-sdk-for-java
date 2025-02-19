// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Query parameters for triggers. */
@Fluent
public final class TriggerFilterParameters {
    /*
     * The continuation token for getting the next page of results. Null for first page.
     */
    @JsonProperty(value = "continuationToken")
    private String continuationToken;

    /*
     * The name of the parent TumblingWindowTrigger to get the child rerun triggers
     */
    @JsonProperty(value = "parentTriggerName")
    private String parentTriggerName;

    /**
     * Get the continuationToken property: The continuation token for getting the next page of results. Null for first
     * page.
     *
     * @return the continuationToken value.
     */
    public String continuationToken() {
        return this.continuationToken;
    }

    /**
     * Set the continuationToken property: The continuation token for getting the next page of results. Null for first
     * page.
     *
     * @param continuationToken the continuationToken value to set.
     * @return the TriggerFilterParameters object itself.
     */
    public TriggerFilterParameters withContinuationToken(String continuationToken) {
        this.continuationToken = continuationToken;
        return this;
    }

    /**
     * Get the parentTriggerName property: The name of the parent TumblingWindowTrigger to get the child rerun triggers.
     *
     * @return the parentTriggerName value.
     */
    public String parentTriggerName() {
        return this.parentTriggerName;
    }

    /**
     * Set the parentTriggerName property: The name of the parent TumblingWindowTrigger to get the child rerun triggers.
     *
     * @param parentTriggerName the parentTriggerName value to set.
     * @return the TriggerFilterParameters object itself.
     */
    public TriggerFilterParameters withParentTriggerName(String parentTriggerName) {
        this.parentTriggerName = parentTriggerName;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
