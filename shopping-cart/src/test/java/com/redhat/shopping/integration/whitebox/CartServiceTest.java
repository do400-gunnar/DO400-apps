package com.redhat.shopping.integration.whitebox;

import io.quarkus.test.junit.QuarkusTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.inject.Inject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.redhat.shopping.cart.CartService;
import com.redhat.shopping.catalog.ProductNotFoundInCatalogException;

@QuarkusTest
class CartServiceTest {

    @Inject
    CartService cartService;

    @BeforeEach
    void clearCart() {
        cartService.clear();
    }

    @Test
    void addingNonExistingProductInCatalogRaisesAnException() {
        assertThrows(
        ProductNotFoundInCatalogException.class,
        () -> this.cartService.addProduct(9999, 10));
    }

    @Test
    void addingNonExistingProductInCartTheTotalItemsMatchTheInitialQuantity()
    throws ProductNotFoundInCatalogException {

        this.cartService.addProduct(1, 10);

        assertEquals(10, this.cartService.totalItems());
    }

    @Test
    void addingProductThatIsInTheCartTheTotalItemsMatchTheSumOfQuantities()
    throws ProductNotFoundInCatalogException {

        this.cartService.addProduct(1, 10);
        this.cartService.addProduct(1, 100);

        assertEquals(110, this.cartService.totalItems());
    }
}