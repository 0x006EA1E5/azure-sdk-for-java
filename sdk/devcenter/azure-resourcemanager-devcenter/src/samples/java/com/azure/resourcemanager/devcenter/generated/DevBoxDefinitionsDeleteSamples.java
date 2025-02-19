// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devcenter.generated;

import com.azure.core.util.Context;

/** Samples for DevBoxDefinitions Delete. */
public final class DevBoxDefinitionsDeleteSamples {
    /*
     * x-ms-original-file: specification/devcenter/resource-manager/Microsoft.DevCenter/preview/2022-08-01-preview/examples/DevBoxDefinitions_Delete.json
     */
    /**
     * Sample code: DevBoxDefinitions_Delete.
     *
     * @param manager Entry point to DevCenterManager.
     */
    public static void devBoxDefinitionsDelete(com.azure.resourcemanager.devcenter.DevCenterManager manager) {
        manager.devBoxDefinitions().delete("rg1", "Contoso", "WebDevBox", Context.NONE);
    }
}
