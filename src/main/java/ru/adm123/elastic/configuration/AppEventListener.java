package ru.adm123.elastic.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import ru.adm123.elastic.factory.AuthorFactory;
import ru.adm123.elastic.factory.BookFactory;
import ru.adm123.elastic.model.Author;
import ru.adm123.elastic.model.Book;
import ru.adm123.elastic.repository.AuthorRepository;
import ru.adm123.elastic.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmitry Ushakov at 27.11.2021
 */
@Component
public class AppEventListener {

    private final AuthorFactory authorFactory;
    private final BookFactory bookFactory;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final List<Author> authorList = new ArrayList<>();
    private final List<Book> bookList = new ArrayList<>();

    @Autowired
    public AppEventListener(AuthorFactory authorFactory,
                            BookFactory bookFactory,
                            AuthorRepository authorRepository,
                            BookRepository bookRepository) {
        this.authorFactory = authorFactory;
        this.bookFactory = bookFactory;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationStartedEvent.class)
    public void handleEvent(@NonNull ApplicationStartedEvent event) {
        generateAuthors(5);
        generateBooks(20);
        authorRepository.saveAll(authorList);
        bookRepository.saveAll(bookList);
    }

    public void generateAuthors(int count) {
        for (int i = 0; i++ < count; ) {
            Author author = authorFactory.getNewAuthor(i, "authorFirstName_" + i, "authorLastName_" + i);
            authorList.add(author);
        }

    }

    public void generateBooks(int count) {
        for (int i = 0; i++ < count; ) {
            Author author = getRandomAuth();
            bookList.add(bookFactory.getNewBook(i, "bookTitle_" + i, author));
        }
    }

    @NonNull
    private Author getRandomAuth() {
        int maxIndex = authorList.isEmpty() ? 100 : authorList.size() - 1;
        int authorIndex = getRandomInt(0, maxIndex);
        if (!authorList.isEmpty()) {
            return authorList.get(authorIndex);
        }
        return authorFactory.getNewAuthor(authorIndex, "authorFirstName_" + authorIndex, "authorLastName_" + authorIndex);
    }

    private int getRandomInt(int min,
                             int max) {
        return Math.round((max - min) * (float) Math.random()) + min;
    }

}
