package ru.adm123.elastic.service;

import org.springframework.lang.NonNull;
import ru.adm123.elastic.model.Book;

/**
 * @author Dmitry Ushakov at 14.01.2022
 */
public interface BookService extends EntityService<Book> {

    Book add(@NonNull Book book);

    Iterable<Book> getByAuthorId(int authorId);

}
