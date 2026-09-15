package com.redhat.shopping.integration.whitebox;

import com.redhat.shopping.cart.CartService;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class ShoppingCartTest {

    @Inject
    CartService cartService;

    @BeforeEach
    void clearCart() {
        cartService.clear();
    }

    @Test
    void addingNonExistingProduct() {
        
    }
}
