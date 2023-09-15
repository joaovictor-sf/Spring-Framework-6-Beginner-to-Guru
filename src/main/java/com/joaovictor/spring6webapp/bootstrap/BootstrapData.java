package com.joaovictor.spring6webapp.bootstrap;

import com.joaovictor.spring6webapp.domain.Author;
import com.joaovictor.spring6webapp.domain.Book;
import com.joaovictor.spring6webapp.domain.Publisher;
import com.joaovictor.spring6webapp.repositories.AuthorRepository;
import com.joaovictor.spring6webapp.repositories.BookRepository;
import com.joaovictor.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    // Essa classe serve para: ao iniciar a aplicação, ela já insere alguns dados no banco de dados.

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setName("Domain Driven Design");
        ddd.setIsbn("123456");

        Author john = new Author();
        Book alho = new Book();

        john.setFirstName("John");
        john.setLastName("Thompson");

        alho.setName("Alho");
        alho.setIsbn("654321");

        Publisher publisher = new Publisher();
        publisher.setPublisherName("My Publisher");
        publisher.setAddress("123 Main");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author johnSaved = authorRepository.save(john);
        Book alhoSaved = bookRepository.save(alho);

        Publisher publisherSaved = publisherRepository.save(publisher);

        ericSaved.getBooks().add(dddSaved);
        johnSaved.getBooks().add(alhoSaved);
        dddSaved.getAuthors().add(ericSaved);
        alhoSaved.getAuthors().add(johnSaved);

        dddSaved.setPublisher(publisherSaved);
        alhoSaved.setPublisher(publisherSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(johnSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(alhoSaved);
        publisherRepository.save(publisherSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());
    }
}
