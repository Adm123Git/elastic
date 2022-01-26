package ru.adm123.elastic.service.entity;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * @author Dmitry Ushakov at 14.01.2022
 */
public interface EntityService<T> {

    @Nullable
    T getById(long id);

    @NonNull
    Iterable<T> getAll();

}
