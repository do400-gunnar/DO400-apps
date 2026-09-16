package com.redhat.shipping;

public enum Region {

    NA(100),
    LATAM(200);

    final int shippingCosts;


    Region(int cost) {
        shippingCosts = cost;
    }
}
