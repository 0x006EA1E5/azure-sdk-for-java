// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.sqlvirtualmachine.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Set tempDb storage settings for SQL Server. */
@Fluent
public final class SqlTempDbSettings {
    /*
     * SQL Server tempdb data file size
     */
    @JsonProperty(value = "dataFileSize")
    private Integer dataFileSize;

    /*
     * SQL Server tempdb data file autoGrowth size
     */
    @JsonProperty(value = "dataGrowth")
    private Integer dataGrowth;

    /*
     * SQL Server tempdb log file size
     */
    @JsonProperty(value = "logFileSize")
    private Integer logFileSize;

    /*
     * SQL Server tempdb log file autoGrowth size
     */
    @JsonProperty(value = "logGrowth")
    private Integer logGrowth;

    /*
     * SQL Server tempdb data file count
     */
    @JsonProperty(value = "dataFileCount")
    private Integer dataFileCount;

    /*
     * SQL Server tempdb persist folder choice
     */
    @JsonProperty(value = "persistFolder")
    private Boolean persistFolder;

    /*
     * SQL Server tempdb persist folder location
     */
    @JsonProperty(value = "persistFolderPath")
    private String persistFolderPath;

    /*
     * Logical Unit Numbers for the disks.
     */
    @JsonProperty(value = "luns")
    private List<Integer> luns;

    /*
     * SQL Server default file path
     */
    @JsonProperty(value = "defaultFilePath")
    private String defaultFilePath;

    /**
     * Get the dataFileSize property: SQL Server tempdb data file size.
     *
     * @return the dataFileSize value.
     */
    public Integer dataFileSize() {
        return this.dataFileSize;
    }

    /**
     * Set the dataFileSize property: SQL Server tempdb data file size.
     *
     * @param dataFileSize the dataFileSize value to set.
     * @return the SqlTempDbSettings object itself.
     */
    public SqlTempDbSettings withDataFileSize(Integer dataFileSize) {
        this.dataFileSize = dataFileSize;
        return this;
    }

    /**
     * Get the dataGrowth property: SQL Server tempdb data file autoGrowth size.
     *
     * @return the dataGrowth value.
     */
    public Integer dataGrowth() {
        return this.dataGrowth;
    }

    /**
     * Set the dataGrowth property: SQL Server tempdb data file autoGrowth size.
     *
     * @param dataGrowth the dataGrowth value to set.
     * @return the SqlTempDbSettings object itself.
     */
    public SqlTempDbSettings withDataGrowth(Integer dataGrowth) {
        this.dataGrowth = dataGrowth;
        return this;
    }

    /**
     * Get the logFileSize property: SQL Server tempdb log file size.
     *
     * @return the logFileSize value.
     */
    public Integer logFileSize() {
        return this.logFileSize;
    }

    /**
     * Set the logFileSize property: SQL Server tempdb log file size.
     *
     * @param logFileSize the logFileSize value to set.
     * @return the SqlTempDbSettings object itself.
     */
    public SqlTempDbSettings withLogFileSize(Integer logFileSize) {
        this.logFileSize = logFileSize;
        return this;
    }

    /**
     * Get the logGrowth property: SQL Server tempdb log file autoGrowth size.
     *
     * @return the logGrowth value.
     */
    public Integer logGrowth() {
        return this.logGrowth;
    }

    /**
     * Set the logGrowth property: SQL Server tempdb log file autoGrowth size.
     *
     * @param logGrowth the logGrowth value to set.
     * @return the SqlTempDbSettings object itself.
     */
    public SqlTempDbSettings withLogGrowth(Integer logGrowth) {
        this.logGrowth = logGrowth;
        return this;
    }

    /**
     * Get the dataFileCount property: SQL Server tempdb data file count.
     *
     * @return the dataFileCount value.
     */
    public Integer dataFileCount() {
        return this.dataFileCount;
    }

    /**
     * Set the dataFileCount property: SQL Server tempdb data file count.
     *
     * @param dataFileCount the dataFileCount value to set.
     * @return the SqlTempDbSettings object itself.
     */
    public SqlTempDbSettings withDataFileCount(Integer dataFileCount) {
        this.dataFileCount = dataFileCount;
        return this;
    }

    /**
     * Get the persistFolder property: SQL Server tempdb persist folder choice.
     *
     * @return the persistFolder value.
     */
    public Boolean persistFolder() {
        return this.persistFolder;
    }

    /**
     * Set the persistFolder property: SQL Server tempdb persist folder choice.
     *
     * @param persistFolder the persistFolder value to set.
     * @return the SqlTempDbSettings object itself.
     */
    public SqlTempDbSettings withPersistFolder(Boolean persistFolder) {
        this.persistFolder = persistFolder;
        return this;
    }

    /**
     * Get the persistFolderPath property: SQL Server tempdb persist folder location.
     *
     * @return the persistFolderPath value.
     */
    public String persistFolderPath() {
        return this.persistFolderPath;
    }

    /**
     * Set the persistFolderPath property: SQL Server tempdb persist folder location.
     *
     * @param persistFolderPath the persistFolderPath value to set.
     * @return the SqlTempDbSettings object itself.
     */
    public SqlTempDbSettings withPersistFolderPath(String persistFolderPath) {
        this.persistFolderPath = persistFolderPath;
        return this;
    }

    /**
     * Get the luns property: Logical Unit Numbers for the disks.
     *
     * @return the luns value.
     */
    public List<Integer> luns() {
        return this.luns;
    }

    /**
     * Set the luns property: Logical Unit Numbers for the disks.
     *
     * @param luns the luns value to set.
     * @return the SqlTempDbSettings object itself.
     */
    public SqlTempDbSettings withLuns(List<Integer> luns) {
        this.luns = luns;
        return this;
    }

    /**
     * Get the defaultFilePath property: SQL Server default file path.
     *
     * @return the defaultFilePath value.
     */
    public String defaultFilePath() {
        return this.defaultFilePath;
    }

    /**
     * Set the defaultFilePath property: SQL Server default file path.
     *
     * @param defaultFilePath the defaultFilePath value to set.
     * @return the SqlTempDbSettings object itself.
     */
    public SqlTempDbSettings withDefaultFilePath(String defaultFilePath) {
        this.defaultFilePath = defaultFilePath;
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
