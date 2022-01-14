package ru.adm123.elastic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.adm123.elastic.model.Book;
import ru.adm123.elastic.service.entity.BookService;

/**
 * @author Dmitry Ushakov at 28.11.2021
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @NonNull
    private final BookService bookService;

    @Autowired
    public BookController(@NonNull BookService bookService) {
        this.bookService = bookService;
    }

    @NonNull
    @GetMapping("/all")
    public Iterable<Book> getAll() {
        return bookService.getAll();
    }

    @Nullable
    @GetMapping("/{bookId}")
    public Book getById(@PathVariable int bookId) {
        return bookService.getById(bookId);
    }

    @Nullable
    @GetMapping("/author/{authorId}")
    public Iterable<Book> getAllByAuthorId(@PathVariable int authorId) {
        return bookService.getByAuthorId(authorId);
    }

}
