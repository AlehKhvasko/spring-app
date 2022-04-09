package com.springapp.spring.app.bootstrap;

import com.springapp.spring.app.domain.Author;
import com.springapp.spring.app.domain.Book;
import com.springapp.spring.app.domain.Publisher;
import com.springapp.spring.app.repositories.AuthorRepository;
import com.springapp.spring.app.repositories.BookRepository;
import com.springapp.spring.app.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evan");
        Book ddd = new Book("Domain DD", "Random");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "234155");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);


        Publisher publisher = new Publisher();
        publisher.setName("Jady");
        publisher.setAddressLine1("some address");

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        publisherRepository.save(publisher);
        System.out.println("Publisher count : " + publisherRepository.count());

        System.out.println("Started in Bootstrap");
        System.out.println("Nums of books is: " + bookRepository.count());

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        publisherRepository.save(publisher);

        System.out.println("Publisher num of books " + publisher.getBooks().size());

    }
}
