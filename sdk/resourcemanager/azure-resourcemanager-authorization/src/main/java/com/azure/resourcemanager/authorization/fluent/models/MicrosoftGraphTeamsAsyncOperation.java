// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.authorization.fluent.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

/** teamsAsyncOperation. */
@Fluent
public final class MicrosoftGraphTeamsAsyncOperation extends MicrosoftGraphEntity {
    /*
     * Number of times the operation was attempted before being marked
     * successful or failed.
     */
    @JsonProperty(value = "attemptsCount")
    private Integer attemptsCount;

    /*
     * Time when the operation was created.
     */
    @JsonProperty(value = "createdDateTime")
    private OffsetDateTime createdDateTime;

    /*
     * operationError
     */
    @JsonProperty(value = "error")
    private MicrosoftGraphOperationError error;

    /*
     * Time when the async operation was last updated.
     */
    @JsonProperty(value = "lastActionDateTime")
    private OffsetDateTime lastActionDateTime;

    /*
     * teamsAsyncOperationType
     */
    @JsonProperty(value = "operationType")
    private MicrosoftGraphTeamsAsyncOperationType operationType;

    /*
     * teamsAsyncOperationStatus
     */
    @JsonProperty(value = "status")
    private MicrosoftGraphTeamsAsyncOperationStatus status;

    /*
     * The ID of the object that's created or modified as result of this async
     * operation, typically a team.
     */
    @JsonProperty(value = "targetResourceId")
    private String targetResourceId;

    /*
     * The location of the object that's created or modified as result of this
     * async operation. This URL should be treated as an opaque value and not
     * parsed into its component paths.
     */
    @JsonProperty(value = "targetResourceLocation")
    private String targetResourceLocation;

    /*
     * teamsAsyncOperation
     */
    @JsonIgnore private Map<String, Object> additionalProperties;

    /**
     * Get the attemptsCount property: Number of times the operation was attempted before being marked successful or
     * failed.
     *
     * @return the attemptsCount value.
     */
    public Integer attemptsCount() {
        return this.attemptsCount;
    }

    /**
     * Set the attemptsCount property: Number of times the operation was attempted before being marked successful or
     * failed.
     *
     * @param attemptsCount the attemptsCount value to set.
     * @return the MicrosoftGraphTeamsAsyncOperation object itself.
     */
    public MicrosoftGraphTeamsAsyncOperation withAttemptsCount(Integer attemptsCount) {
        this.attemptsCount = attemptsCount;
        return this;
    }

    /**
     * Get the createdDateTime property: Time when the operation was created.
     *
     * @return the createdDateTime value.
     */
    public OffsetDateTime createdDateTime() {
        return this.createdDateTime;
    }

    /**
     * Set the createdDateTime property: Time when the operation was created.
     *
     * @param createdDateTime the createdDateTime value to set.
     * @return the MicrosoftGraphTeamsAsyncOperation object itself.
     */
    public MicrosoftGraphTeamsAsyncOperation withCreatedDateTime(OffsetDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
        return this;
    }

    /**
     * Get the error property: operationError.
     *
     * @return the error value.
     */
    public MicrosoftGraphOperationError error() {
        return this.error;
    }

    /**
     * Set the error property: operationError.
     *
     * @param error the error value to set.
     * @return the MicrosoftGraphTeamsAsyncOperation object itself.
     */
    public MicrosoftGraphTeamsAsyncOperation withError(MicrosoftGraphOperationError error) {
        this.error = error;
        return this;
    }

    /**
     * Get the lastActionDateTime property: Time when the async operation was last updated.
     *
     * @return the lastActionDateTime value.
     */
    public OffsetDateTime lastActionDateTime() {
        return this.lastActionDateTime;
    }

    /**
     * Set the lastActionDateTime property: Time when the async operation was last updated.
     *
     * @param lastActionDateTime the lastActionDateTime value to set.
     * @return the MicrosoftGraphTeamsAsyncOperation object itself.
     */
    public MicrosoftGraphTeamsAsyncOperation withLastActionDateTime(OffsetDateTime lastActionDateTime) {
        this.lastActionDateTime = lastActionDateTime;
        return this;
    }

    /**
     * Get the operationType property: teamsAsyncOperationType.
     *
     * @return the operationType value.
     */
    public MicrosoftGraphTeamsAsyncOperationType operationType() {
        return this.operationType;
    }

    /**
     * Set the operationType property: teamsAsyncOperationType.
     *
     * @param operationType the operationType value to set.
     * @return the MicrosoftGraphTeamsAsyncOperation object itself.
     */
    public MicrosoftGraphTeamsAsyncOperation withOperationType(MicrosoftGraphTeamsAsyncOperationType operationType) {
        this.operationType = operationType;
        return this;
    }

    /**
     * Get the status property: teamsAsyncOperationStatus.
     *
     * @return the status value.
     */
    public MicrosoftGraphTeamsAsyncOperationStatus status() {
        return this.status;
    }

    /**
     * Set the status property: teamsAsyncOperationStatus.
     *
     * @param status the status value to set.
     * @return the MicrosoftGraphTeamsAsyncOperation object itself.
     */
    public MicrosoftGraphTeamsAsyncOperation withStatus(MicrosoftGraphTeamsAsyncOperationStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Get the targetResourceId property: The ID of the object that's created or modified as result of this async
     * operation, typically a team.
     *
     * @return the targetResourceId value.
     */
    public String targetResourceId() {
        return this.targetResourceId;
    }

    /**
     * Set the targetResourceId property: The ID of the object that's created or modified as result of this async
     * operation, typically a team.
     *
     * @param targetResourceId the targetResourceId value to set.
     * @return the MicrosoftGraphTeamsAsyncOperation object itself.
     */
    public MicrosoftGraphTeamsAsyncOperation withTargetResourceId(String targetResourceId) {
        this.targetResourceId = targetResourceId;
        return this;
    }

    /**
     * Get the targetResourceLocation property: The location of the object that's created or modified as result of this
     * async operation. This URL should be treated as an opaque value and not parsed into its component paths.
     *
     * @return the targetResourceLocation value.
     */
    public String targetResourceLocation() {
        return this.targetResourceLocation;
    }

    /**
     * Set the targetResourceLocation property: The location of the object that's created or modified as result of this
     * async operation. This URL should be treated as an opaque value and not parsed into its component paths.
     *
     * @param targetResourceLocation the targetResourceLocation value to set.
     * @return the MicrosoftGraphTeamsAsyncOperation object itself.
     */
    public MicrosoftGraphTeamsAsyncOperation withTargetResourceLocation(String targetResourceLocation) {
        this.targetResourceLocation = targetResourceLocation;
        return this;
    }

    /**
     * Get the additionalProperties property: teamsAsyncOperation.
     *
     * @return the additionalProperties value.
     */
    @JsonAnyGetter
    public Map<String, Object> additionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Set the additionalProperties property: teamsAsyncOperation.
     *
     * @param additionalProperties the additionalProperties value to set.
     * @return the MicrosoftGraphTeamsAsyncOperation object itself.
     */
    public MicrosoftGraphTeamsAsyncOperation withAdditionalProperties(Map<String, Object> additionalProperties) {
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

    /** {@inheritDoc} */
    @Override
    public MicrosoftGraphTeamsAsyncOperation withId(String id) {
        super.withId(id);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
        if (error() != null) {
            error().validate();
        }
    }
}
