package com.redhat.shipping;

// What does it do?
public class ShippingCalculator {
    /**
     * Compute cost ...
     */
    public int costForRegion(Region region) throws RegionNotFoundException {
        if(region == null) {
            throw new RegionNotFoundException("region cannot be null");
        }
        return region.shippingCosts;
    }
}
