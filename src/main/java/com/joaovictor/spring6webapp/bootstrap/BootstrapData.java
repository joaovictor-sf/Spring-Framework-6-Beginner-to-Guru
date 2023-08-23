package com.joaovictor.spring6webapp.bootstrap;

import com.joaovictor.spring6webapp.domain.Author;
import com.joaovictor.spring6webapp.domain.Book;
import com.joaovictor.spring6webapp.repositories.AuthorRepository;
import com.joaovictor.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
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

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author johnSaved = authorRepository.save(john);
        Book alhoSaved = bookRepository.save(alho);

        ericSaved.getBooks().add(dddSaved);
        johnSaved.getBooks().add(alhoSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(johnSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
    }
}
