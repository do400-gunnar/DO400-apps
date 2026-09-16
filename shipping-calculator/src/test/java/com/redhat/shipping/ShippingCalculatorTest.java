package com.redhat.shipping;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShippingCalculatorTest {

    private ShippingCalculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new ShippingCalculator();
    }

    @Test
    public void testCalculateShippingNA() throws RegionNotFoundException {
        assertEquals(100, calculator.costForRegion(Region.NA));
    }

    @Test
    public void testNameNA() throws RegionNotFoundException {
        assertEquals("NA", Region.NA.name());
    }

    @Test
    public void testCalculateShippingArgumentNull() {
        assertThrows(RegionNotFoundException.class,
                () -> calculator.costForRegion(null));
    }
}
