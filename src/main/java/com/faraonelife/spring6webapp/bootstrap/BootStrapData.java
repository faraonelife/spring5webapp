package com.faraonelife.spring6webapp.bootstrap;

import com.faraonelife.spring6webapp.domain.Author;
import com.faraonelife.spring6webapp.domain.Book;
import com.faraonelife.spring6webapp.domain.Publisher;
import com.faraonelife.spring6webapp.repositories.AuthorRepository;
import com.faraonelife.spring6webapp.repositories.BookRepository;
import com.faraonelife.spring6webapp.repositories.PublisherRepository;
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
        System.out.println("started in bookstrap");


        Publisher publisher=new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Peterburg");
        publisher.setState("FL");
        publisherRepository.save(publisher);
        System.out.println("Publisher Count:"+publisherRepository.count());

        Author eric=new Author("Eric","Evans");
        Book ddd=new Book("Domain Driver Design","12345");
eric.getBooks().add(ddd);
ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);
authorRepository.save(eric);
bookRepository.save(ddd);
publisherRepository.save(publisher);

Author rod=new Author("Rod","Johnson");
Book noEjb=new Book("J2EE dev","7654657");
noEjb.getAuthors().add(rod);
rod.getBooks().add(noEjb);
publisher.getBooks().add(noEjb);
authorRepository.save(rod);
bookRepository.save(noEjb);
publisherRepository.save(publisher);

        System.out.println("Number of book" + bookRepository.count());
        System.out.println("Publisher Number of books"+publisher.getBooks().size());
    }
}
