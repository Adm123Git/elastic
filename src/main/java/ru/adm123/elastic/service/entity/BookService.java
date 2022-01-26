package ru.adm123.elastic.service.entity;

import org.springframework.lang.NonNull;
import ru.adm123.elastic.model.Book;

import java.text.ParseException;

/**
 * @author Dmitry Ushakov at 14.01.2022
 */
public interface BookService extends EntityService<Book> {

    @NonNull
    Iterable<Book> getByAuthorId(long authorId);

    @NonNull
    Iterable<Book> getByCreatedDateRange(String dateFrom,
                                         String dateTo) throws ParseException;

}
