package ru.adm123.elastic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author Dmitry Ushakov at 24.11.2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "book")
public class Book {

    @Id
    @Field(type = FieldType.Long)
    private long id;
    @Field(type = FieldType.Text)
    private String title;
    @Field(type = FieldType.Nested, includeInParent = true)
    private Author author;

}
