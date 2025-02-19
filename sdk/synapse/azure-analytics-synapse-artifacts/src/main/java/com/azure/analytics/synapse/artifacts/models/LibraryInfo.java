// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/**
 * Information about a library/package created at the workspace level.
 *
 * <p>Library/package information of a Big Data pool powered by Apache Spark.
 */
@Fluent
public final class LibraryInfo {
    /*
     * Name of the library.
     */
    @JsonProperty(value = "name")
    private String name;

    /*
     * Storage blob path of library.
     */
    @JsonProperty(value = "path")
    private String path;

    /*
     * Storage blob container name.
     */
    @JsonProperty(value = "containerName")
    private String containerName;

    /*
     * The last update time of the library.
     */
    @JsonProperty(value = "uploadedTimestamp")
    private OffsetDateTime uploadedTimestamp;

    /*
     * Type of the library.
     */
    @JsonProperty(value = "type")
    private String type;

    /*
     * Provisioning status of the library/package.
     */
    @JsonProperty(value = "provisioningStatus", access = JsonProperty.Access.WRITE_ONLY)
    private String provisioningStatus;

    /*
     * Creator Id of the library/package.
     */
    @JsonProperty(value = "creatorId", access = JsonProperty.Access.WRITE_ONLY)
    private String creatorId;

    /**
     * Get the name property: Name of the library.
     *
     * @return the name value.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name property: Name of the library.
     *
     * @param name the name value to set.
     * @return the LibraryInfo object itself.
     */
    public LibraryInfo setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the path property: Storage blob path of library.
     *
     * @return the path value.
     */
    public String getPath() {
        return this.path;
    }

    /**
     * Set the path property: Storage blob path of library.
     *
     * @param path the path value to set.
     * @return the LibraryInfo object itself.
     */
    public LibraryInfo setPath(String path) {
        this.path = path;
        return this;
    }

    /**
     * Get the containerName property: Storage blob container name.
     *
     * @return the containerName value.
     */
    public String getContainerName() {
        return this.containerName;
    }

    /**
     * Set the containerName property: Storage blob container name.
     *
     * @param containerName the containerName value to set.
     * @return the LibraryInfo object itself.
     */
    public LibraryInfo setContainerName(String containerName) {
        this.containerName = containerName;
        return this;
    }

    /**
     * Get the uploadedTimestamp property: The last update time of the library.
     *
     * @return the uploadedTimestamp value.
     */
    public OffsetDateTime getUploadedTimestamp() {
        return this.uploadedTimestamp;
    }

    /**
     * Set the uploadedTimestamp property: The last update time of the library.
     *
     * @param uploadedTimestamp the uploadedTimestamp value to set.
     * @return the LibraryInfo object itself.
     */
    public LibraryInfo setUploadedTimestamp(OffsetDateTime uploadedTimestamp) {
        this.uploadedTimestamp = uploadedTimestamp;
        return this;
    }

    /**
     * Get the type property: Type of the library.
     *
     * @return the type value.
     */
    public String getType() {
        return this.type;
    }

    /**
     * Set the type property: Type of the library.
     *
     * @param type the type value to set.
     * @return the LibraryInfo object itself.
     */
    public LibraryInfo setType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get the provisioningStatus property: Provisioning status of the library/package.
     *
     * @return the provisioningStatus value.
     */
    public String getProvisioningStatus() {
        return this.provisioningStatus;
    }

    /**
     * Get the creatorId property: Creator Id of the library/package.
     *
     * @return the creatorId value.
     */
    public String getCreatorId() {
        return this.creatorId;
    }
}
