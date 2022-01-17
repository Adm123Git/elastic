package ru.adm123.elastic.service.entity.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import ru.adm123.elastic.model.Book;
import ru.adm123.elastic.repository.BookRepository;
import ru.adm123.elastic.service.entity.BookService;

import static ru.adm123.elastic.application.LogFilter.APPLICATION_LOG;

/**
 * @author Dmitry Ushakov at 24.11.2021
 */
@Slf4j(topic = APPLICATION_LOG)
@Service
public class BookServiceImpl implements BookService {

    @NonNull
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Nullable
    public Book getById(long bookId) {
        log.info("query for book by bookId " + bookId);
        return bookRepository.findById(bookId)
                .orElse(null);
    }

    @NonNull
    public Iterable<Book> getByAuthorId(long authorId) {
        log.info("query for books by authorId = " + authorId);
        return bookRepository.findAllByAuthorId(authorId);
    }

    @NonNull
    public Iterable<Book> getAll() {
        log.info("query for all books");
        return bookRepository.findAll();
    }

}
