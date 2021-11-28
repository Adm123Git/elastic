package ru.adm123.elastic.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import ru.adm123.elastic.model.Author;

/**
 * @author Dmitry Ushakov at 24.11.2021
 */
@Repository
public interface AuthorRepository extends ElasticsearchRepository<Author, Long> {
}
