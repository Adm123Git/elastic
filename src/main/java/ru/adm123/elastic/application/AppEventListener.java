package ru.adm123.elastic.application;

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

import static ru.adm123.elastic.util.NumberUtil.getRandomInt;

/**
 * @author Dmitry Ushakov at 27.11.2021
 */
@Component
public class AppEventListener {

    private final InitProperties initProperties;
    private final AuthorFactory authorFactory;
    private final BookFactory bookFactory;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final List<Author> authorList = new ArrayList<>();
    private final List<Book> bookList = new ArrayList<>();

    @Autowired
    public AppEventListener(InitProperties initProperties,
                            AuthorFactory authorFactory,
                            BookFactory bookFactory,
                            AuthorRepository authorRepository,
                            BookRepository bookRepository) {
        this.initProperties = initProperties;
        this.authorFactory = authorFactory;
        this.bookFactory = bookFactory;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationStartedEvent.class)
    public void handleEvent() {
        generateAuthors();
        generateBooks();
        authorRepository.saveAll(authorList);
        bookRepository.saveAll(bookList);
    }

    private void generateAuthors() {
        for (int i = 0; i++ < initProperties.getAuthor().getCount();) {
            Author author = authorFactory.getNewAuthor(i, "authorFirstName_" + i, "authorLastName_" + i);
            authorList.add(author);
        }
    }

    private void generateBooks() {
        for (int i = 0; i++ < initProperties.getBook().getCount();) {
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
        Author author = authorFactory.getNewAuthor(authorIndex, "authorFirstName_" + authorIndex, "authorLastName_" + authorIndex);
        authorList.add(author);
        return author;
    }

}
