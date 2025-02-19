// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.generated;

import com.azure.resourcemanager.machinelearning.models.UriFileDataVersion;
import java.util.HashMap;
import java.util.Map;

/** Samples for DataVersions CreateOrUpdate. */
public final class DataVersionsCreateOrUpdateSamples {
    /*
     * x-ms-original-file: specification/machinelearningservices/resource-manager/Microsoft.MachineLearningServices/preview/2022-02-01-preview/examples/DataVersionBase/createOrUpdate.json
     */
    /**
     * Sample code: CreateOrUpdate Data Version Base.
     *
     * @param manager Entry point to MachineLearningManager.
     */
    public static void createOrUpdateDataVersionBase(
        com.azure.resourcemanager.machinelearning.MachineLearningManager manager) {
        manager
            .dataVersions()
            .define("string")
            .withExistingData("test-rg", "my-aml-workspace", "string")
            .withProperties(
                new UriFileDataVersion()
                    .withDescription("string")
                    .withProperties(mapOf("string", "string"))
                    .withTags(mapOf("string", "string"))
                    .withIsAnonymous(false)
                    .withDataUri("string"))
            .create();
    }

    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
