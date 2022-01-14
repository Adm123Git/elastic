package ru.adm123.elastic.service.entity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import ru.adm123.elastic.model.Book;
import ru.adm123.elastic.repository.BookRepository;
import ru.adm123.elastic.service.entity.BookService;

/**
 * @author Dmitry Ushakov at 24.11.2021
 */
@Service
public class BookServiceImpl implements BookService {

    @NonNull
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @NonNull
    public Book add(@NonNull Book book) {
        return bookRepository.save(book);
    }

    @Nullable
    public Book getById(long id) {
        return bookRepository.findById(id)
                .orElse(null);
    }

    @NonNull
    public Iterable<Book> getByAuthorId(int authorId) {
        return bookRepository.findAllByAuthorId(authorId);
    }

    @NonNull
    public Iterable<Book> getAll() {
        return bookRepository.findAll();
    }

}
