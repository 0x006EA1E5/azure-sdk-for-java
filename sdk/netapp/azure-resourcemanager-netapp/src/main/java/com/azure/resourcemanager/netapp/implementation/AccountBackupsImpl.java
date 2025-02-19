// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.netapp.fluent.AccountBackupsClient;
import com.azure.resourcemanager.netapp.fluent.models.BackupInner;
import com.azure.resourcemanager.netapp.models.AccountBackups;
import com.azure.resourcemanager.netapp.models.Backup;

public final class AccountBackupsImpl implements AccountBackups {
    private static final ClientLogger LOGGER = new ClientLogger(AccountBackupsImpl.class);

    private final AccountBackupsClient innerClient;

    private final com.azure.resourcemanager.netapp.NetAppFilesManager serviceManager;

    public AccountBackupsImpl(
        AccountBackupsClient innerClient, com.azure.resourcemanager.netapp.NetAppFilesManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public PagedIterable<Backup> list(String resourceGroupName, String accountName) {
        PagedIterable<BackupInner> inner = this.serviceClient().list(resourceGroupName, accountName);
        return Utils.mapPage(inner, inner1 -> new BackupImpl(inner1, this.manager()));
    }

    public PagedIterable<Backup> list(String resourceGroupName, String accountName, Context context) {
        PagedIterable<BackupInner> inner = this.serviceClient().list(resourceGroupName, accountName, context);
        return Utils.mapPage(inner, inner1 -> new BackupImpl(inner1, this.manager()));
    }

    public Backup get(String resourceGroupName, String accountName, String backupName) {
        BackupInner inner = this.serviceClient().get(resourceGroupName, accountName, backupName);
        if (inner != null) {
            return new BackupImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<Backup> getWithResponse(
        String resourceGroupName, String accountName, String backupName, Context context) {
        Response<BackupInner> inner =
            this.serviceClient().getWithResponse(resourceGroupName, accountName, backupName, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new BackupImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public void delete(String resourceGroupName, String accountName, String backupName) {
        this.serviceClient().delete(resourceGroupName, accountName, backupName);
    }

    public void delete(String resourceGroupName, String accountName, String backupName, Context context) {
        this.serviceClient().delete(resourceGroupName, accountName, backupName, context);
    }

    private AccountBackupsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.netapp.NetAppFilesManager manager() {
        return this.serviceManager;
    }
}
