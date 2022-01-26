package ru.adm123.elastic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.adm123.elastic.model.Author;
import ru.adm123.elastic.model.Book;
import ru.adm123.elastic.service.entity.AuthorService;

/**
 * @author Dmitry Ushakov at 28.11.2021
 */
@RestController
@RequestMapping("/author")
public class AuthorController {

    @NonNull
    private final AuthorService authorService;

    @Autowired
    public AuthorController(@NonNull AuthorService authorService) {
        this.authorService = authorService;
    }

    @NonNull
    @GetMapping("/all")
    public Iterable<Author> getAll() {
        return authorService.getAll();
    }

    @Nullable
    @GetMapping("/{authorId}")
    public Author getById(@PathVariable int authorId) {
        return authorService.getById(authorId);
    }

    @NonNull
    @GetMapping("/{authorId}/book")
    public Iterable<Book> getBooksByAuthorId(@PathVariable int authorId) {
        return authorService.getBooks(authorId);
    }

}
