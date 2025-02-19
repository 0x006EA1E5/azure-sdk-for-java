// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storagecache.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for ProvisioningStateType. */
public final class ProvisioningStateType extends ExpandableStringEnum<ProvisioningStateType> {
    /** Static value Succeeded for ProvisioningStateType. */
    public static final ProvisioningStateType SUCCEEDED = fromString("Succeeded");

    /** Static value Failed for ProvisioningStateType. */
    public static final ProvisioningStateType FAILED = fromString("Failed");

    /** Static value Cancelled for ProvisioningStateType. */
    public static final ProvisioningStateType CANCELLED = fromString("Cancelled");

    /** Static value Creating for ProvisioningStateType. */
    public static final ProvisioningStateType CREATING = fromString("Creating");

    /** Static value Deleting for ProvisioningStateType. */
    public static final ProvisioningStateType DELETING = fromString("Deleting");

    /** Static value Updating for ProvisioningStateType. */
    public static final ProvisioningStateType UPDATING = fromString("Updating");

    /**
     * Creates or finds a ProvisioningStateType from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding ProvisioningStateType.
     */
    @JsonCreator
    public static ProvisioningStateType fromString(String name) {
        return fromString(name, ProvisioningStateType.class);
    }

    /**
     * Gets known ProvisioningStateType values.
     *
     * @return known ProvisioningStateType values.
     */
    public static Collection<ProvisioningStateType> values() {
        return values(ProvisioningStateType.class);
    }
}
