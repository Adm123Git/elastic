package ru.adm123.elastic.application.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dmitry Ushakov at 18.01.2022
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties("format")
public class FormatProperties {

    @Getter
    @Setter
    public static class Request {
        private String date = "yyyy-MM-dd";
    }

    private Request request = new Request();

}
