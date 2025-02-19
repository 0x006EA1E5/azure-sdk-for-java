// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.datafactory.models.DatasetCompression;
import com.azure.resourcemanager.datafactory.models.DatasetStorageFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Azure Data Lake Storage Gen2 dataset properties. */
@Fluent
public final class AzureBlobFSDatasetTypeProperties {
    /*
     * The path of the Azure Data Lake Storage Gen2 storage. Type: string (or Expression with resultType string).
     */
    @JsonProperty(value = "folderPath")
    private Object folderPath;

    /*
     * The name of the Azure Data Lake Storage Gen2. Type: string (or Expression with resultType string).
     */
    @JsonProperty(value = "fileName")
    private Object fileName;

    /*
     * The format of the Azure Data Lake Storage Gen2 storage.
     */
    @JsonProperty(value = "format")
    private DatasetStorageFormat format;

    /*
     * The data compression method used for the blob storage.
     */
    @JsonProperty(value = "compression")
    private DatasetCompression compression;

    /**
     * Get the folderPath property: The path of the Azure Data Lake Storage Gen2 storage. Type: string (or Expression
     * with resultType string).
     *
     * @return the folderPath value.
     */
    public Object folderPath() {
        return this.folderPath;
    }

    /**
     * Set the folderPath property: The path of the Azure Data Lake Storage Gen2 storage. Type: string (or Expression
     * with resultType string).
     *
     * @param folderPath the folderPath value to set.
     * @return the AzureBlobFSDatasetTypeProperties object itself.
     */
    public AzureBlobFSDatasetTypeProperties withFolderPath(Object folderPath) {
        this.folderPath = folderPath;
        return this;
    }

    /**
     * Get the fileName property: The name of the Azure Data Lake Storage Gen2. Type: string (or Expression with
     * resultType string).
     *
     * @return the fileName value.
     */
    public Object fileName() {
        return this.fileName;
    }

    /**
     * Set the fileName property: The name of the Azure Data Lake Storage Gen2. Type: string (or Expression with
     * resultType string).
     *
     * @param fileName the fileName value to set.
     * @return the AzureBlobFSDatasetTypeProperties object itself.
     */
    public AzureBlobFSDatasetTypeProperties withFileName(Object fileName) {
        this.fileName = fileName;
        return this;
    }

    /**
     * Get the format property: The format of the Azure Data Lake Storage Gen2 storage.
     *
     * @return the format value.
     */
    public DatasetStorageFormat format() {
        return this.format;
    }

    /**
     * Set the format property: The format of the Azure Data Lake Storage Gen2 storage.
     *
     * @param format the format value to set.
     * @return the AzureBlobFSDatasetTypeProperties object itself.
     */
    public AzureBlobFSDatasetTypeProperties withFormat(DatasetStorageFormat format) {
        this.format = format;
        return this;
    }

    /**
     * Get the compression property: The data compression method used for the blob storage.
     *
     * @return the compression value.
     */
    public DatasetCompression compression() {
        return this.compression;
    }

    /**
     * Set the compression property: The data compression method used for the blob storage.
     *
     * @param compression the compression value to set.
     * @return the AzureBlobFSDatasetTypeProperties object itself.
     */
    public AzureBlobFSDatasetTypeProperties withCompression(DatasetCompression compression) {
        this.compression = compression;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (format() != null) {
            format().validate();
        }
        if (compression() != null) {
            compression().validate();
        }
    }
}
