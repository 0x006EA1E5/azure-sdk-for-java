// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.monitor.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.monitor.models.MetricAlertAction;
import com.azure.resourcemanager.monitor.models.MetricAlertCriteria;
import com.azure.resourcemanager.monitor.models.ResourceAutoGenerated4;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/** The metric alert resource. */
@Fluent
public final class MetricAlertResourceInner extends ResourceAutoGenerated4 {
    /*
     * The alert rule properties of the resource.
     */
    @JsonProperty(value = "properties", required = true)
    private MetricAlertProperties innerProperties = new MetricAlertProperties();

    /**
     * Get the innerProperties property: The alert rule properties of the resource.
     *
     * @return the innerProperties value.
     */
    private MetricAlertProperties innerProperties() {
        return this.innerProperties;
    }

    /** {@inheritDoc} */
    @Override
    public MetricAlertResourceInner withLocation(String location) {
        super.withLocation(location);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public MetricAlertResourceInner withTags(Map<String, String> tags) {
        super.withTags(tags);
        return this;
    }

    /**
     * Get the description property: the description of the metric alert that will be included in the alert email.
     *
     * @return the description value.
     */
    public String description() {
        return this.innerProperties() == null ? null : this.innerProperties().description();
    }

    /**
     * Set the description property: the description of the metric alert that will be included in the alert email.
     *
     * @param description the description value to set.
     * @return the MetricAlertResourceInner object itself.
     */
    public MetricAlertResourceInner withDescription(String description) {
        if (this.innerProperties() == null) {
            this.innerProperties = new MetricAlertProperties();
        }
        this.innerProperties().withDescription(description);
        return this;
    }

    /**
     * Get the severity property: Alert severity {0, 1, 2, 3, 4}.
     *
     * @return the severity value.
     */
    public int severity() {
        return this.innerProperties() == null ? 0 : this.innerProperties().severity();
    }

    /**
     * Set the severity property: Alert severity {0, 1, 2, 3, 4}.
     *
     * @param severity the severity value to set.
     * @return the MetricAlertResourceInner object itself.
     */
    public MetricAlertResourceInner withSeverity(int severity) {
        if (this.innerProperties() == null) {
            this.innerProperties = new MetricAlertProperties();
        }
        this.innerProperties().withSeverity(severity);
        return this;
    }

    /**
     * Get the enabled property: the flag that indicates whether the metric alert is enabled.
     *
     * @return the enabled value.
     */
    public boolean enabled() {
        return this.innerProperties() == null ? false : this.innerProperties().enabled();
    }

    /**
     * Set the enabled property: the flag that indicates whether the metric alert is enabled.
     *
     * @param enabled the enabled value to set.
     * @return the MetricAlertResourceInner object itself.
     */
    public MetricAlertResourceInner withEnabled(boolean enabled) {
        if (this.innerProperties() == null) {
            this.innerProperties = new MetricAlertProperties();
        }
        this.innerProperties().withEnabled(enabled);
        return this;
    }

    /**
     * Get the scopes property: the list of resource id's that this metric alert is scoped to.
     *
     * @return the scopes value.
     */
    public List<String> scopes() {
        return this.innerProperties() == null ? null : this.innerProperties().scopes();
    }

    /**
     * Set the scopes property: the list of resource id's that this metric alert is scoped to.
     *
     * @param scopes the scopes value to set.
     * @return the MetricAlertResourceInner object itself.
     */
    public MetricAlertResourceInner withScopes(List<String> scopes) {
        if (this.innerProperties() == null) {
            this.innerProperties = new MetricAlertProperties();
        }
        this.innerProperties().withScopes(scopes);
        return this;
    }

    /**
     * Get the evaluationFrequency property: how often the metric alert is evaluated represented in ISO 8601 duration
     * format.
     *
     * @return the evaluationFrequency value.
     */
    public Duration evaluationFrequency() {
        return this.innerProperties() == null ? null : this.innerProperties().evaluationFrequency();
    }

    /**
     * Set the evaluationFrequency property: how often the metric alert is evaluated represented in ISO 8601 duration
     * format.
     *
     * @param evaluationFrequency the evaluationFrequency value to set.
     * @return the MetricAlertResourceInner object itself.
     */
    public MetricAlertResourceInner withEvaluationFrequency(Duration evaluationFrequency) {
        if (this.innerProperties() == null) {
            this.innerProperties = new MetricAlertProperties();
        }
        this.innerProperties().withEvaluationFrequency(evaluationFrequency);
        return this;
    }

    /**
     * Get the windowSize property: the period of time (in ISO 8601 duration format) that is used to monitor alert
     * activity based on the threshold.
     *
     * @return the windowSize value.
     */
    public Duration windowSize() {
        return this.innerProperties() == null ? null : this.innerProperties().windowSize();
    }

    /**
     * Set the windowSize property: the period of time (in ISO 8601 duration format) that is used to monitor alert
     * activity based on the threshold.
     *
     * @param windowSize the windowSize value to set.
     * @return the MetricAlertResourceInner object itself.
     */
    public MetricAlertResourceInner withWindowSize(Duration windowSize) {
        if (this.innerProperties() == null) {
            this.innerProperties = new MetricAlertProperties();
        }
        this.innerProperties().withWindowSize(windowSize);
        return this;
    }

    /**
     * Get the targetResourceType property: the resource type of the target resource(s) on which the alert is
     * created/updated. Mandatory if the scope contains a subscription, resource group, or more than one resource.
     *
     * @return the targetResourceType value.
     */
    public String targetResourceType() {
        return this.innerProperties() == null ? null : this.innerProperties().targetResourceType();
    }

    /**
     * Set the targetResourceType property: the resource type of the target resource(s) on which the alert is
     * created/updated. Mandatory if the scope contains a subscription, resource group, or more than one resource.
     *
     * @param targetResourceType the targetResourceType value to set.
     * @return the MetricAlertResourceInner object itself.
     */
    public MetricAlertResourceInner withTargetResourceType(String targetResourceType) {
        if (this.innerProperties() == null) {
            this.innerProperties = new MetricAlertProperties();
        }
        this.innerProperties().withTargetResourceType(targetResourceType);
        return this;
    }

    /**
     * Get the targetResourceRegion property: the region of the target resource(s) on which the alert is
     * created/updated. Mandatory if the scope contains a subscription, resource group, or more than one resource.
     *
     * @return the targetResourceRegion value.
     */
    public String targetResourceRegion() {
        return this.innerProperties() == null ? null : this.innerProperties().targetResourceRegion();
    }

    /**
     * Set the targetResourceRegion property: the region of the target resource(s) on which the alert is
     * created/updated. Mandatory if the scope contains a subscription, resource group, or more than one resource.
     *
     * @param targetResourceRegion the targetResourceRegion value to set.
     * @return the MetricAlertResourceInner object itself.
     */
    public MetricAlertResourceInner withTargetResourceRegion(String targetResourceRegion) {
        if (this.innerProperties() == null) {
            this.innerProperties = new MetricAlertProperties();
        }
        this.innerProperties().withTargetResourceRegion(targetResourceRegion);
        return this;
    }

    /**
     * Get the criteria property: defines the specific alert criteria information.
     *
     * @return the criteria value.
     */
    public MetricAlertCriteria criteria() {
        return this.innerProperties() == null ? null : this.innerProperties().criteria();
    }

    /**
     * Set the criteria property: defines the specific alert criteria information.
     *
     * @param criteria the criteria value to set.
     * @return the MetricAlertResourceInner object itself.
     */
    public MetricAlertResourceInner withCriteria(MetricAlertCriteria criteria) {
        if (this.innerProperties() == null) {
            this.innerProperties = new MetricAlertProperties();
        }
        this.innerProperties().withCriteria(criteria);
        return this;
    }

    /**
     * Get the autoMitigate property: the flag that indicates whether the alert should be auto resolved or not. The
     * default is true.
     *
     * @return the autoMitigate value.
     */
    public Boolean autoMitigate() {
        return this.innerProperties() == null ? null : this.innerProperties().autoMitigate();
    }

    /**
     * Set the autoMitigate property: the flag that indicates whether the alert should be auto resolved or not. The
     * default is true.
     *
     * @param autoMitigate the autoMitigate value to set.
     * @return the MetricAlertResourceInner object itself.
     */
    public MetricAlertResourceInner withAutoMitigate(Boolean autoMitigate) {
        if (this.innerProperties() == null) {
            this.innerProperties = new MetricAlertProperties();
        }
        this.innerProperties().withAutoMitigate(autoMitigate);
        return this;
    }

    /**
     * Get the actions property: the array of actions that are performed when the alert rule becomes active, and when an
     * alert condition is resolved.
     *
     * @return the actions value.
     */
    public List<MetricAlertAction> actions() {
        return this.innerProperties() == null ? null : this.innerProperties().actions();
    }

    /**
     * Set the actions property: the array of actions that are performed when the alert rule becomes active, and when an
     * alert condition is resolved.
     *
     * @param actions the actions value to set.
     * @return the MetricAlertResourceInner object itself.
     */
    public MetricAlertResourceInner withActions(List<MetricAlertAction> actions) {
        if (this.innerProperties() == null) {
            this.innerProperties = new MetricAlertProperties();
        }
        this.innerProperties().withActions(actions);
        return this;
    }

    /**
     * Get the lastUpdatedTime property: Last time the rule was updated in ISO8601 format.
     *
     * @return the lastUpdatedTime value.
     */
    public OffsetDateTime lastUpdatedTime() {
        return this.innerProperties() == null ? null : this.innerProperties().lastUpdatedTime();
    }

    /**
     * Get the isMigrated property: the value indicating whether this alert rule is migrated.
     *
     * @return the isMigrated value.
     */
    public Boolean isMigrated() {
        return this.innerProperties() == null ? null : this.innerProperties().isMigrated();
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
        if (innerProperties() == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        "Missing required property innerProperties in model MetricAlertResourceInner"));
        } else {
            innerProperties().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(MetricAlertResourceInner.class);
}
