package ru.adm123.elastic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import ru.adm123.elastic.model.Author;
import ru.adm123.elastic.model.Book;
import ru.adm123.elastic.repository.AuthorRepository;
import ru.adm123.elastic.repository.BookRepository;
import ru.adm123.elastic.service.AuthorService;

/**
 * @author Dmitry Ushakov at 24.11.2021
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    @NonNull
    private final AuthorRepository authorRepository;
    @NonNull
    private final BookRepository bookRepository;

    @Autowired
    public AuthorServiceImpl(@NonNull AuthorRepository authorRepository,
                             @NonNull BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @NonNull
    public Iterable<Author> getAll() {
        return authorRepository.findAll();
    }

    @NonNull
    public Iterable<Book> getBooks(int authorId) {
        return bookRepository.findAllByAuthorId(authorId);
    }

    @Nullable
    public Author getById(long id) {
        return authorRepository.findById(id)
                .orElse(null);
    }

}
