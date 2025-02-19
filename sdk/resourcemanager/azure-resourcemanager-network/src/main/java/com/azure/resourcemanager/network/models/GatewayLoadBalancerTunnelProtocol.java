// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Protocol of gateway load balancer tunnel interface. */
public final class GatewayLoadBalancerTunnelProtocol extends ExpandableStringEnum<GatewayLoadBalancerTunnelProtocol> {
    /** Static value None for GatewayLoadBalancerTunnelProtocol. */
    public static final GatewayLoadBalancerTunnelProtocol NONE = fromString("None");

    /** Static value Native for GatewayLoadBalancerTunnelProtocol. */
    public static final GatewayLoadBalancerTunnelProtocol NATIVE = fromString("Native");

    /** Static value VXLAN for GatewayLoadBalancerTunnelProtocol. */
    public static final GatewayLoadBalancerTunnelProtocol VXLAN = fromString("VXLAN");

    /**
     * Creates or finds a GatewayLoadBalancerTunnelProtocol from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding GatewayLoadBalancerTunnelProtocol.
     */
    @JsonCreator
    public static GatewayLoadBalancerTunnelProtocol fromString(String name) {
        return fromString(name, GatewayLoadBalancerTunnelProtocol.class);
    }

    /**
     * Gets known GatewayLoadBalancerTunnelProtocol values.
     *
     * @return known GatewayLoadBalancerTunnelProtocol values.
     */
    public static Collection<GatewayLoadBalancerTunnelProtocol> values() {
        return values(GatewayLoadBalancerTunnelProtocol.class);
    }
}
