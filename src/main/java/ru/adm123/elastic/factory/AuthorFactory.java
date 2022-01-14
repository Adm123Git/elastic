package ru.adm123.elastic.factory;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import ru.adm123.elastic.model.Author;

/**
 * @author Dmitry Ushakov at 24.11.2021
 * Вспомогательный класс для заполнения базы в демо-приложении
 */
@Component
public class AuthorFactory {

    @NonNull
    public Author getNewAuthor(long id,
                               String firstName,
                               String lastName) {
        return new Author(id, firstName, lastName);
    }

}
