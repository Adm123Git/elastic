package ru.adm123.elastic.service.entity.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import ru.adm123.elastic.application.properties.FormatProperties;
import ru.adm123.elastic.model.Book;
import ru.adm123.elastic.repository.BookRepository;
import ru.adm123.elastic.service.entity.BookService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static ru.adm123.elastic.application.LogFilter.APPLICATION_LOG;

/**
 * @author Dmitry Ushakov at 24.11.2021
 */
@Slf4j(topic = APPLICATION_LOG)
@Service
public class BookServiceImpl implements BookService {

    @NonNull
    private final BookRepository bookRepository;
    @NonNull
    private final FormatProperties formatProperties;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository,
                           FormatProperties formatProperties) {
        this.bookRepository = bookRepository;
        this.formatProperties = formatProperties;
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
    public Iterable<Book> getByCreatedDateRange(String strDateFrom,
                                                String strDateTo) throws ParseException {
        log.info("query for books created between " + strDateFrom + " and " + strDateTo);
        DateFormat dateFormat = new SimpleDateFormat(formatProperties.getRequest().getDate());
        Date dateFrom = dateFormat.parse(strDateFrom);
        Date dateTo = dateFormat.parse(strDateTo);
        return bookRepository.findAllByPublishedAfterAndPublishedBefore(dateFrom, dateTo);
    }

    @NonNull
    public Iterable<Book> getAll() {
        log.info("query for all books");
        return bookRepository.findAll();
    }

}
