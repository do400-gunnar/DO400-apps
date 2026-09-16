package com.redhat.shipping;

public class RegionNotFoundException extends Exception {
    public RegionNotFoundException(String regionCannotBeNull) {
        super("Region not found: " + regionCannotBeNull);
    }
}
