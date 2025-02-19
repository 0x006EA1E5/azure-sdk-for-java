// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.JsonFlatten;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.List;

/**
 * This activity executes inner activities until the specified boolean expression results to true or timeout is reached,
 * whichever is earlier.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonTypeName("Until")
@JsonFlatten
@Fluent
public class UntilActivity extends ControlActivity {
    /*
     * An expression that would evaluate to Boolean. The loop will continue until this expression evaluates to true
     */
    @JsonProperty(value = "typeProperties.expression", required = true)
    private Expression expression;

    /*
     * Specifies the timeout for the activity to run. If there is no value specified, it takes the value of
     * TimeSpan.FromDays(7) which is 1 week as default. Type: string (or Expression with resultType string), pattern:
     * ((\d+)\.)?(\d\d):(60|([0-5][0-9])):(60|([0-5][0-9])). Type: string (or Expression with resultType string),
     * pattern: ((\d+)\.)?(\d\d):(60|([0-5][0-9])):(60|([0-5][0-9])).
     */
    @JsonProperty(value = "typeProperties.timeout")
    private Object timeout;

    /*
     * List of activities to execute.
     */
    @JsonProperty(value = "typeProperties.activities", required = true)
    private List<Activity> activities;

    /**
     * Get the expression property: An expression that would evaluate to Boolean. The loop will continue until this
     * expression evaluates to true.
     *
     * @return the expression value.
     */
    public Expression getExpression() {
        return this.expression;
    }

    /**
     * Set the expression property: An expression that would evaluate to Boolean. The loop will continue until this
     * expression evaluates to true.
     *
     * @param expression the expression value to set.
     * @return the UntilActivity object itself.
     */
    public UntilActivity setExpression(Expression expression) {
        this.expression = expression;
        return this;
    }

    /**
     * Get the timeout property: Specifies the timeout for the activity to run. If there is no value specified, it takes
     * the value of TimeSpan.FromDays(7) which is 1 week as default. Type: string (or Expression with resultType
     * string), pattern: ((\d+)\.)?(\d\d):(60|([0-5][0-9])):(60|([0-5][0-9])). Type: string (or Expression with
     * resultType string), pattern: ((\d+)\.)?(\d\d):(60|([0-5][0-9])):(60|([0-5][0-9])).
     *
     * @return the timeout value.
     */
    public Object getTimeout() {
        return this.timeout;
    }

    /**
     * Set the timeout property: Specifies the timeout for the activity to run. If there is no value specified, it takes
     * the value of TimeSpan.FromDays(7) which is 1 week as default. Type: string (or Expression with resultType
     * string), pattern: ((\d+)\.)?(\d\d):(60|([0-5][0-9])):(60|([0-5][0-9])). Type: string (or Expression with
     * resultType string), pattern: ((\d+)\.)?(\d\d):(60|([0-5][0-9])):(60|([0-5][0-9])).
     *
     * @param timeout the timeout value to set.
     * @return the UntilActivity object itself.
     */
    public UntilActivity setTimeout(Object timeout) {
        this.timeout = timeout;
        return this;
    }

    /**
     * Get the activities property: List of activities to execute.
     *
     * @return the activities value.
     */
    public List<Activity> getActivities() {
        return this.activities;
    }

    /**
     * Set the activities property: List of activities to execute.
     *
     * @param activities the activities value to set.
     * @return the UntilActivity object itself.
     */
    public UntilActivity setActivities(List<Activity> activities) {
        this.activities = activities;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public UntilActivity setName(String name) {
        super.setName(name);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public UntilActivity setDescription(String description) {
        super.setDescription(description);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public UntilActivity setDependsOn(List<ActivityDependency> dependsOn) {
        super.setDependsOn(dependsOn);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public UntilActivity setUserProperties(List<UserProperty> userProperties) {
        super.setUserProperties(userProperties);
        return this;
    }
}
