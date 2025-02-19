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

/**
 * endpoint Represents an Azure Active Directory object. The directoryObject type is the base type for many other
 * directory entity types.
 */
@Fluent
public final class MicrosoftGraphEndpoint extends MicrosoftGraphDirectoryObjectInner {
    /*
     * Describes the capability that is associated with this resource. (e.g.
     * Messages, Conversations, etc.)  Not nullable. Read-only.
     */
    @JsonProperty(value = "capability")
    private String capability;

    /*
     * Application id of the publishing underlying service. Not nullable.
     * Read-only.
     */
    @JsonProperty(value = "providerId")
    private String providerId;

    /*
     * Name of the publishing underlying service. Read-only.
     */
    @JsonProperty(value = "providerName")
    private String providerName;

    /*
     * For Microsoft 365 groups, this is set to a well-known name for the
     * resource (e.g. Yammer.FeedURL etc.). Not nullable. Read-only.
     */
    @JsonProperty(value = "providerResourceId")
    private String providerResourceId;

    /*
     * URL of the published resource. Not nullable. Read-only.
     */
    @JsonProperty(value = "uri")
    private String uri;

    /*
     * Represents an Azure Active Directory object. The directoryObject type is
     * the base type for many other directory entity types.
     */
    @JsonIgnore private Map<String, Object> additionalProperties;

    /**
     * Get the capability property: Describes the capability that is associated with this resource. (e.g. Messages,
     * Conversations, etc.) Not nullable. Read-only.
     *
     * @return the capability value.
     */
    public String capability() {
        return this.capability;
    }

    /**
     * Set the capability property: Describes the capability that is associated with this resource. (e.g. Messages,
     * Conversations, etc.) Not nullable. Read-only.
     *
     * @param capability the capability value to set.
     * @return the MicrosoftGraphEndpoint object itself.
     */
    public MicrosoftGraphEndpoint withCapability(String capability) {
        this.capability = capability;
        return this;
    }

    /**
     * Get the providerId property: Application id of the publishing underlying service. Not nullable. Read-only.
     *
     * @return the providerId value.
     */
    public String providerId() {
        return this.providerId;
    }

    /**
     * Set the providerId property: Application id of the publishing underlying service. Not nullable. Read-only.
     *
     * @param providerId the providerId value to set.
     * @return the MicrosoftGraphEndpoint object itself.
     */
    public MicrosoftGraphEndpoint withProviderId(String providerId) {
        this.providerId = providerId;
        return this;
    }

    /**
     * Get the providerName property: Name of the publishing underlying service. Read-only.
     *
     * @return the providerName value.
     */
    public String providerName() {
        return this.providerName;
    }

    /**
     * Set the providerName property: Name of the publishing underlying service. Read-only.
     *
     * @param providerName the providerName value to set.
     * @return the MicrosoftGraphEndpoint object itself.
     */
    public MicrosoftGraphEndpoint withProviderName(String providerName) {
        this.providerName = providerName;
        return this;
    }

    /**
     * Get the providerResourceId property: For Microsoft 365 groups, this is set to a well-known name for the resource
     * (e.g. Yammer.FeedURL etc.). Not nullable. Read-only.
     *
     * @return the providerResourceId value.
     */
    public String providerResourceId() {
        return this.providerResourceId;
    }

    /**
     * Set the providerResourceId property: For Microsoft 365 groups, this is set to a well-known name for the resource
     * (e.g. Yammer.FeedURL etc.). Not nullable. Read-only.
     *
     * @param providerResourceId the providerResourceId value to set.
     * @return the MicrosoftGraphEndpoint object itself.
     */
    public MicrosoftGraphEndpoint withProviderResourceId(String providerResourceId) {
        this.providerResourceId = providerResourceId;
        return this;
    }

    /**
     * Get the uri property: URL of the published resource. Not nullable. Read-only.
     *
     * @return the uri value.
     */
    public String uri() {
        return this.uri;
    }

    /**
     * Set the uri property: URL of the published resource. Not nullable. Read-only.
     *
     * @param uri the uri value to set.
     * @return the MicrosoftGraphEndpoint object itself.
     */
    public MicrosoftGraphEndpoint withUri(String uri) {
        this.uri = uri;
        return this;
    }

    /**
     * Get the additionalProperties property: Represents an Azure Active Directory object. The directoryObject type is
     * the base type for many other directory entity types.
     *
     * @return the additionalProperties value.
     */
    @JsonAnyGetter
    public Map<String, Object> additionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Set the additionalProperties property: Represents an Azure Active Directory object. The directoryObject type is
     * the base type for many other directory entity types.
     *
     * @param additionalProperties the additionalProperties value to set.
     * @return the MicrosoftGraphEndpoint object itself.
     */
    public MicrosoftGraphEndpoint withAdditionalProperties(Map<String, Object> additionalProperties) {
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
    public MicrosoftGraphEndpoint withDeletedDateTime(OffsetDateTime deletedDateTime) {
        super.withDeletedDateTime(deletedDateTime);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public MicrosoftGraphEndpoint withId(String id) {
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
    }
}
