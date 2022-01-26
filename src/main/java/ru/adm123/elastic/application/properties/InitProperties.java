package ru.adm123.elastic.application.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dmitry Ushakov at 17.01.2022
 * Данные, используемые для инициализации тестового приложения
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties("init")
public class InitProperties {

    @Getter
    @Setter
    public static class Book {
        private int count = 20;
    }

    @Getter
    @Setter
    public static class Author {
        private int count = 5;
    }

    private Book book = new Book();
    private Author author = new Author();

}
