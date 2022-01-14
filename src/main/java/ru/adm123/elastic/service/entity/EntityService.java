package ru.adm123.elastic.service.entity;

/**
 * @author Dmitry Ushakov at 14.01.2022
 */
public interface EntityService<T> {

    T getById(long id);

    Iterable<T> getAll();

}
