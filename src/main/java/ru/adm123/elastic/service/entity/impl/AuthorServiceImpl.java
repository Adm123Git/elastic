package ru.adm123.elastic.service.entity.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import ru.adm123.elastic.model.Author;
import ru.adm123.elastic.model.Book;
import ru.adm123.elastic.repository.AuthorRepository;
import ru.adm123.elastic.repository.BookRepository;
import ru.adm123.elastic.service.entity.AuthorService;

import static ru.adm123.elastic.application.LogFilter.APPLICATION_LOG;

/**
 * @author Dmitry Ushakov at 24.11.2021
 */
@Slf4j(topic = APPLICATION_LOG)
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
        log.info("query for all authors");
        return authorRepository.findAll();
    }

    @NonNull
    public Iterable<Book> getBooks(long authorId) {
        log.info("query for book by authorId = " + authorId);
        return bookRepository.findAllByAuthorId(authorId);
    }

    @Nullable
    public Author getById(long authorId) {
        log.info("query author by authorId = " + authorId);
        return authorRepository.findById(authorId)
                .orElse(null);
    }

}
