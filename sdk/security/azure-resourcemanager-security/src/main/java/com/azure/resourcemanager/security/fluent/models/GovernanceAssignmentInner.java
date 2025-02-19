// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.azure.resourcemanager.security.models.GovernanceAssignmentAdditionalData;
import com.azure.resourcemanager.security.models.GovernanceEmailNotification;
import com.azure.resourcemanager.security.models.RemediationEta;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/** Security GovernanceAssignment over a given scope. */
@Fluent
public final class GovernanceAssignmentInner extends ProxyResource {
    /*
     * Properties of a security governanceAssignment
     */
    @JsonProperty(value = "properties")
    private GovernanceAssignmentProperties innerProperties;

    /**
     * Get the innerProperties property: Properties of a security governanceAssignment.
     *
     * @return the innerProperties value.
     */
    private GovernanceAssignmentProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the owner property: The Owner for the governance assignment - e.g. user@contoso.com - see example.
     *
     * @return the owner value.
     */
    public String owner() {
        return this.innerProperties() == null ? null : this.innerProperties().owner();
    }

    /**
     * Set the owner property: The Owner for the governance assignment - e.g. user@contoso.com - see example.
     *
     * @param owner the owner value to set.
     * @return the GovernanceAssignmentInner object itself.
     */
    public GovernanceAssignmentInner withOwner(String owner) {
        if (this.innerProperties() == null) {
            this.innerProperties = new GovernanceAssignmentProperties();
        }
        this.innerProperties().withOwner(owner);
        return this;
    }

    /**
     * Get the remediationDueDate property: The remediation due-date - after this date Secure Score will be affected (in
     * case of active grace-period).
     *
     * @return the remediationDueDate value.
     */
    public OffsetDateTime remediationDueDate() {
        return this.innerProperties() == null ? null : this.innerProperties().remediationDueDate();
    }

    /**
     * Set the remediationDueDate property: The remediation due-date - after this date Secure Score will be affected (in
     * case of active grace-period).
     *
     * @param remediationDueDate the remediationDueDate value to set.
     * @return the GovernanceAssignmentInner object itself.
     */
    public GovernanceAssignmentInner withRemediationDueDate(OffsetDateTime remediationDueDate) {
        if (this.innerProperties() == null) {
            this.innerProperties = new GovernanceAssignmentProperties();
        }
        this.innerProperties().withRemediationDueDate(remediationDueDate);
        return this;
    }

    /**
     * Get the remediationEta property: The ETA (estimated time of arrival) for remediation (optional), see example.
     *
     * @return the remediationEta value.
     */
    public RemediationEta remediationEta() {
        return this.innerProperties() == null ? null : this.innerProperties().remediationEta();
    }

    /**
     * Set the remediationEta property: The ETA (estimated time of arrival) for remediation (optional), see example.
     *
     * @param remediationEta the remediationEta value to set.
     * @return the GovernanceAssignmentInner object itself.
     */
    public GovernanceAssignmentInner withRemediationEta(RemediationEta remediationEta) {
        if (this.innerProperties() == null) {
            this.innerProperties = new GovernanceAssignmentProperties();
        }
        this.innerProperties().withRemediationEta(remediationEta);
        return this;
    }

    /**
     * Get the isGracePeriod property: Defines whether there is a grace period on the governance assignment.
     *
     * @return the isGracePeriod value.
     */
    public Boolean isGracePeriod() {
        return this.innerProperties() == null ? null : this.innerProperties().isGracePeriod();
    }

    /**
     * Set the isGracePeriod property: Defines whether there is a grace period on the governance assignment.
     *
     * @param isGracePeriod the isGracePeriod value to set.
     * @return the GovernanceAssignmentInner object itself.
     */
    public GovernanceAssignmentInner withIsGracePeriod(Boolean isGracePeriod) {
        if (this.innerProperties() == null) {
            this.innerProperties = new GovernanceAssignmentProperties();
        }
        this.innerProperties().withIsGracePeriod(isGracePeriod);
        return this;
    }

    /**
     * Get the governanceEmailNotification property: The email notifications settings for the governance rule, states
     * whether to disable notifications for mangers and owners.
     *
     * @return the governanceEmailNotification value.
     */
    public GovernanceEmailNotification governanceEmailNotification() {
        return this.innerProperties() == null ? null : this.innerProperties().governanceEmailNotification();
    }

    /**
     * Set the governanceEmailNotification property: The email notifications settings for the governance rule, states
     * whether to disable notifications for mangers and owners.
     *
     * @param governanceEmailNotification the governanceEmailNotification value to set.
     * @return the GovernanceAssignmentInner object itself.
     */
    public GovernanceAssignmentInner withGovernanceEmailNotification(
        GovernanceEmailNotification governanceEmailNotification) {
        if (this.innerProperties() == null) {
            this.innerProperties = new GovernanceAssignmentProperties();
        }
        this.innerProperties().withGovernanceEmailNotification(governanceEmailNotification);
        return this;
    }

    /**
     * Get the additionalData property: The additional data for the governance assignment - e.g. links to ticket
     * (optional), see example.
     *
     * @return the additionalData value.
     */
    public GovernanceAssignmentAdditionalData additionalData() {
        return this.innerProperties() == null ? null : this.innerProperties().additionalData();
    }

    /**
     * Set the additionalData property: The additional data for the governance assignment - e.g. links to ticket
     * (optional), see example.
     *
     * @param additionalData the additionalData value to set.
     * @return the GovernanceAssignmentInner object itself.
     */
    public GovernanceAssignmentInner withAdditionalData(GovernanceAssignmentAdditionalData additionalData) {
        if (this.innerProperties() == null) {
            this.innerProperties = new GovernanceAssignmentProperties();
        }
        this.innerProperties().withAdditionalData(additionalData);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }
}
