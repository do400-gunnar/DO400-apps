package com.redhat.training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.redhat.training.books.Book;
import com.redhat.training.books.BookNotAvailableException;
import com.redhat.training.inventory.InMemoryInventory;


public class LibraryTest {

    InMemoryInventory inventory;
    Library library;

    @BeforeEach
    public void setUp() {
        inventory = new InMemoryInventory();
        library = new Library(inventory);
    }

    @Test
    public void checkingOutDecreasesNumberOfBooksInInventory() throws BookNotAvailableException {
        inventory.add(new Book("book1"));
        inventory.add(new Book("book1"));

        library.checkOut("gh1", "book1");
        assertEquals(1, inventory.countCopies("book1"));
    }
    @Test
    public void checkingOutFailsWhenNoBooksAvailable() throws BookNotAvailableException {
        Book book1 = new Book("book1");
        inventory.add(book1);
        inventory.add(book1);

        library.checkOut("gh1", "book1");
        library.checkOut("gh2", "book1");
        final  BookNotAvailableException exception = assertThrows(
                BookNotAvailableException.class,
                () -> {
                    library.checkOut("gh1", "book1");
                });
        assertTrue(exception.getMessage().contains("book1"));
    }
}
