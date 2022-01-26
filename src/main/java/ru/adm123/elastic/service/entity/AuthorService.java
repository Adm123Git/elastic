package ru.adm123.elastic.service.entity;

import org.springframework.lang.NonNull;
import ru.adm123.elastic.model.Author;
import ru.adm123.elastic.model.Book;

/**
 * @author Dmitry Ushakov at 14.01.2022
 */
public interface AuthorService extends EntityService<Author> {

    @NonNull
    Iterable<Book> getBooks(long authorId);

}
