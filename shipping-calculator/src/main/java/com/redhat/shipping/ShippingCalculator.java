package com.redhat.shipping;

public class ShippingCalculator {
    public int costForRegion(Region region) throws RegionNotFoundException {
        if(region == null) {
            throw new RegionNotFoundException("region cannot be null");
        }
        return region.shippingCosts;
    }
}
