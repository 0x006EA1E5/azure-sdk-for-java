// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.models;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;

/** Resource collection API of SoftwareInventories. */
public interface SoftwareInventories {
    /**
     * Gets the software inventory of the virtual machine.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param resourceNamespace The namespace of the resource.
     * @param resourceType The type of the resource.
     * @param resourceName Name of the resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the software inventory of the virtual machine as paginated response with {@link PagedIterable}.
     */
    PagedIterable<Software> listByExtendedResource(
        String resourceGroupName, String resourceNamespace, String resourceType, String resourceName);

    /**
     * Gets the software inventory of the virtual machine.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param resourceNamespace The namespace of the resource.
     * @param resourceType The type of the resource.
     * @param resourceName Name of the resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the software inventory of the virtual machine as paginated response with {@link PagedIterable}.
     */
    PagedIterable<Software> listByExtendedResource(
        String resourceGroupName, String resourceNamespace, String resourceType, String resourceName, Context context);

    /**
     * Gets the software inventory of all virtual machines in the subscriptions.
     *
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the software inventory of all virtual machines in the subscriptions as paginated response with {@link
     *     PagedIterable}.
     */
    PagedIterable<Software> list();

    /**
     * Gets the software inventory of all virtual machines in the subscriptions.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the software inventory of all virtual machines in the subscriptions as paginated response with {@link
     *     PagedIterable}.
     */
    PagedIterable<Software> list(Context context);

    /**
     * Gets a single software data of the virtual machine.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param resourceNamespace The namespace of the resource.
     * @param resourceType The type of the resource.
     * @param resourceName Name of the resource.
     * @param softwareName Name of the installed software.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a single software data of the virtual machine.
     */
    Software get(
        String resourceGroupName,
        String resourceNamespace,
        String resourceType,
        String resourceName,
        String softwareName);

    /**
     * Gets a single software data of the virtual machine.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param resourceNamespace The namespace of the resource.
     * @param resourceType The type of the resource.
     * @param resourceName Name of the resource.
     * @param softwareName Name of the installed software.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a single software data of the virtual machine along with {@link Response}.
     */
    Response<Software> getWithResponse(
        String resourceGroupName,
        String resourceNamespace,
        String resourceType,
        String resourceName,
        String softwareName,
        Context context);
}
