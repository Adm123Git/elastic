package ru.adm123.elastic.factory;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import ru.adm123.elastic.model.Author;
import ru.adm123.elastic.model.Book;

import java.util.Date;

/**
 * @author Dmitry Ushakov at 24.11.2021
 * Вспомогательный класс для заполнения базы в демо-приложении
 */
@Component
public class BookFactory {

    @NonNull
    public Book getNewBook(long id,
                           String title,
                           Author author) {
        return new Book(id, title, new Date(), author);
    }

}
