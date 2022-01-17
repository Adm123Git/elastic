package ru.adm123.elastic.service.entity;

import ru.adm123.elastic.model.Book;

/**
 * @author Dmitry Ushakov at 14.01.2022
 */
public interface BookService extends EntityService<Book> {

    Iterable<Book> getByAuthorId(long authorId);

}
