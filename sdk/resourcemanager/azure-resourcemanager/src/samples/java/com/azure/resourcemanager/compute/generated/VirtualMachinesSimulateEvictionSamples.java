// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.compute.generated;

import com.azure.core.util.Context;

/** Samples for VirtualMachines SimulateEviction. */
public final class VirtualMachinesSimulateEvictionSamples {
    /*
     * x-ms-original-file: specification/compute/resource-manager/Microsoft.Compute/ComputeRP/stable/2022-08-01/examples/virtualMachineExamples/VirtualMachine_SimulateEviction.json
     */
    /**
     * Sample code: Simulate Eviction a virtual machine.
     *
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void simulateEvictionAVirtualMachine(com.azure.resourcemanager.AzureResourceManager azure) {
        azure
            .virtualMachines()
            .manager()
            .serviceClient()
            .getVirtualMachines()
            .simulateEvictionWithResponse("ResourceGroup", "VMName", Context.NONE);
    }
}
