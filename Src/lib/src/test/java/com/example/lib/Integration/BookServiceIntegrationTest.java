package com.example.lib.Integration;

import com.example.lib.model.Book;
import com.example.lib.Service.BookService;
import com.example.lib.Repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class BookServiceIntegrationTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testSaveAndRetrieveBook() {
        Book book = new Book();
        book.setTitle("Integration Test Book");

        Book savedBook = bookService.createBook(book);

        Optional<Book> retrievedBook = bookService.getBookById(savedBook.getId());
        assertTrue(retrievedBook.isPresent());
        assertEquals("Integration Test Book", retrievedBook.get().getTitle());
    }

    @Test
    public void testDeleteBook() {
        Book book = new Book();
        book.setTitle("Book to Delete");

        Book savedBook = bookService.createBook(book);
        bookService.deleteBook(savedBook.getId());

        Optional<Book> deletedBook = bookService.getBookById(savedBook.getId());
        assertTrue(deletedBook.isEmpty());
    }
}