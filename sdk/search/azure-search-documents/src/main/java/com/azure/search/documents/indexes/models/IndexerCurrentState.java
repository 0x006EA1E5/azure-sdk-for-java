// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
//
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is regenerated.

package com.azure.search.documents.indexes.models;

import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Represents all of the state that defines and dictates the indexer's current execution. */
@Immutable
public final class IndexerCurrentState {
    /*
     * The mode the indexer is running in.
     */
    @JsonProperty(value = "mode", access = JsonProperty.Access.WRITE_ONLY)
    private IndexingMode mode;

    /*
     * Change tracking state used when indexing starts on all documents in the datasource.
     */
    @JsonProperty(value = "allDocsInitialChangeTrackingState", access = JsonProperty.Access.WRITE_ONLY)
    private String allDocsInitialChangeTrackingState;

    /*
     * Change tracking state value when indexing finishes on all documents in the datasource.
     */
    @JsonProperty(value = "allDocsFinalChangeTrackingState", access = JsonProperty.Access.WRITE_ONLY)
    private String allDocsFinalChangeTrackingState;

    /*
     * Change tracking state used when indexing starts on select, reset documents in the datasource.
     */
    @JsonProperty(value = "resetDocsInitialChangeTrackingState", access = JsonProperty.Access.WRITE_ONLY)
    private String resetDocsInitialChangeTrackingState;

    /*
     * Change tracking state value when indexing finishes on select, reset documents in the datasource.
     */
    @JsonProperty(value = "resetDocsFinalChangeTrackingState", access = JsonProperty.Access.WRITE_ONLY)
    private String resetDocsFinalChangeTrackingState;

    /*
     * The list of document keys that have been reset. The document key is the document's unique identifier for the
     * data in the search index. The indexer will prioritize selectively re-ingesting these keys.
     */
    @JsonProperty(value = "resetDocumentKeys", access = JsonProperty.Access.WRITE_ONLY)
    private List<String> resetDocumentKeys;

    /*
     * The list of datasource document ids that have been reset. The datasource document id is the unique identifier
     * for the data in the datasource. The indexer will prioritize selectively re-ingesting these ids.
     */
    @JsonProperty(value = "resetDatasourceDocumentIds", access = JsonProperty.Access.WRITE_ONLY)
    private List<String> resetDatasourceDocumentIds;

    /**
     * Get the mode property: The mode the indexer is running in.
     *
     * @return the mode value.
     */
    public IndexingMode getMode() {
        return this.mode;
    }

    /**
     * Get the allDocsInitialChangeTrackingState property: Change tracking state used when indexing starts on all
     * documents in the datasource.
     *
     * @return the allDocsInitialChangeTrackingState value.
     */
    public String getAllDocsInitialChangeTrackingState() {
        return this.allDocsInitialChangeTrackingState;
    }

    /**
     * Get the allDocsFinalChangeTrackingState property: Change tracking state value when indexing finishes on all
     * documents in the datasource.
     *
     * @return the allDocsFinalChangeTrackingState value.
     */
    public String getAllDocsFinalChangeTrackingState() {
        return this.allDocsFinalChangeTrackingState;
    }

    /**
     * Get the resetDocsInitialChangeTrackingState property: Change tracking state used when indexing starts on select,
     * reset documents in the datasource.
     *
     * @return the resetDocsInitialChangeTrackingState value.
     */
    public String getResetDocsInitialChangeTrackingState() {
        return this.resetDocsInitialChangeTrackingState;
    }

    /**
     * Get the resetDocsFinalChangeTrackingState property: Change tracking state value when indexing finishes on select,
     * reset documents in the datasource.
     *
     * @return the resetDocsFinalChangeTrackingState value.
     */
    public String getResetDocsFinalChangeTrackingState() {
        return this.resetDocsFinalChangeTrackingState;
    }

    /**
     * Get the resetDocumentKeys property: The list of document keys that have been reset. The document key is the
     * document's unique identifier for the data in the search index. The indexer will prioritize selectively
     * re-ingesting these keys.
     *
     * @return the resetDocumentKeys value.
     */
    public List<String> getResetDocumentKeys() {
        return this.resetDocumentKeys;
    }

    /**
     * Get the resetDatasourceDocumentIds property: The list of datasource document ids that have been reset. The
     * datasource document id is the unique identifier for the data in the datasource. The indexer will prioritize
     * selectively re-ingesting these ids.
     *
     * @return the resetDatasourceDocumentIds value.
     */
    public List<String> getResetDatasourceDocumentIds() {
        return this.resetDatasourceDocumentIds;
    }
}
