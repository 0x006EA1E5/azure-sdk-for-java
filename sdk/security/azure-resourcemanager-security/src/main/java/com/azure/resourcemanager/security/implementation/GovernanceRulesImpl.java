// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.security.fluent.GovernanceRulesClient;
import com.azure.resourcemanager.security.fluent.models.GovernanceRuleInner;
import com.azure.resourcemanager.security.models.GovernanceRule;
import com.azure.resourcemanager.security.models.GovernanceRules;

public final class GovernanceRulesImpl implements GovernanceRules {
    private static final ClientLogger LOGGER = new ClientLogger(GovernanceRulesImpl.class);

    private final GovernanceRulesClient innerClient;

    private final com.azure.resourcemanager.security.SecurityManager serviceManager;

    public GovernanceRulesImpl(
        GovernanceRulesClient innerClient, com.azure.resourcemanager.security.SecurityManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public PagedIterable<GovernanceRule> list() {
        PagedIterable<GovernanceRuleInner> inner = this.serviceClient().list();
        return Utils.mapPage(inner, inner1 -> new GovernanceRuleImpl(inner1, this.manager()));
    }

    public PagedIterable<GovernanceRule> list(Context context) {
        PagedIterable<GovernanceRuleInner> inner = this.serviceClient().list(context);
        return Utils.mapPage(inner, inner1 -> new GovernanceRuleImpl(inner1, this.manager()));
    }

    private GovernanceRulesClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.security.SecurityManager manager() {
        return this.serviceManager;
    }
}
