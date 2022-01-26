package ru.adm123.elastic.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import ru.adm123.elastic.model.Book;

import java.util.Date;

/**
 * @author Dmitry Ushakov at 24.11.2021
 */
@Repository
public interface BookRepository extends ElasticsearchRepository<Book, Long> {

    @NonNull
    Iterable<Book> findAllByAuthorId(long authorId);

    @NonNull
    Iterable<Book> findAllByPublishedAfterAndPublishedBefore(Date dateFrom,
                                                             Date dateTo);

}
