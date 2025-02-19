// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.education.fluent.models;

import com.azure.core.annotation.Immutable;
import com.azure.resourcemanager.education.models.StudentLabStatus;
import com.azure.resourcemanager.education.models.StudentRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/** Student lab detail properties. */
@Immutable
public final class StudentLabProperties {
    /*
     * Student lab Display Name
     */
    @JsonProperty(value = "displayName", access = JsonProperty.Access.WRITE_ONLY)
    private String displayName;

    /*
     * Detail description of this lab
     */
    @JsonProperty(value = "description", access = JsonProperty.Access.WRITE_ONLY)
    private String description;

    /*
     * Date the lab will expire and by default will be the expiration date for
     * each student in this lab
     */
    @JsonProperty(value = "expirationDate", access = JsonProperty.Access.WRITE_ONLY)
    private OffsetDateTime expirationDate;

    /*
     * Student Role
     */
    @JsonProperty(value = "role", access = JsonProperty.Access.WRITE_ONLY)
    private StudentRole role;

    /*
     * Student Budget
     */
    @JsonProperty(value = "budget", access = JsonProperty.Access.WRITE_ONLY)
    private Amount budget;

    /*
     * Subscription Id
     */
    @JsonProperty(value = "subscriptionId", access = JsonProperty.Access.WRITE_ONLY)
    private String subscriptionId;

    /*
     * Student Lab Status
     */
    @JsonProperty(value = "status", access = JsonProperty.Access.WRITE_ONLY)
    private StudentLabStatus status;

    /*
     * User Added Date
     */
    @JsonProperty(value = "effectiveDate", access = JsonProperty.Access.WRITE_ONLY)
    private OffsetDateTime effectiveDate;

    /*
     * Lab Scope.
     * /providers/Microsoft.Billing/billingAccounts/{billingAccountName}/billingProfiles/{billingProfileName}/invoiceSections/{invoiceSectionName}/providers/Microsoft.Education/labs/default
     */
    @JsonProperty(value = "labScope", access = JsonProperty.Access.WRITE_ONLY)
    private String labScope;

    /**
     * Get the displayName property: Student lab Display Name.
     *
     * @return the displayName value.
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Get the description property: Detail description of this lab.
     *
     * @return the description value.
     */
    public String description() {
        return this.description;
    }

    /**
     * Get the expirationDate property: Date the lab will expire and by default will be the expiration date for each
     * student in this lab.
     *
     * @return the expirationDate value.
     */
    public OffsetDateTime expirationDate() {
        return this.expirationDate;
    }

    /**
     * Get the role property: Student Role.
     *
     * @return the role value.
     */
    public StudentRole role() {
        return this.role;
    }

    /**
     * Get the budget property: Student Budget.
     *
     * @return the budget value.
     */
    public Amount budget() {
        return this.budget;
    }

    /**
     * Get the subscriptionId property: Subscription Id.
     *
     * @return the subscriptionId value.
     */
    public String subscriptionId() {
        return this.subscriptionId;
    }

    /**
     * Get the status property: Student Lab Status.
     *
     * @return the status value.
     */
    public StudentLabStatus status() {
        return this.status;
    }

    /**
     * Get the effectiveDate property: User Added Date.
     *
     * @return the effectiveDate value.
     */
    public OffsetDateTime effectiveDate() {
        return this.effectiveDate;
    }

    /**
     * Get the labScope property: Lab Scope.
     * /providers/Microsoft.Billing/billingAccounts/{billingAccountName}/billingProfiles/{billingProfileName}/invoiceSections/{invoiceSectionName}/providers/Microsoft.Education/labs/default.
     *
     * @return the labScope value.
     */
    public String labScope() {
        return this.labScope;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (budget() != null) {
            budget().validate();
        }
    }
}
