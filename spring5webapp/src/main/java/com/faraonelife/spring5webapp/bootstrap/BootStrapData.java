package com.faraonelife.spring5webapp.bootstrap;
import com.faraonelife.spring5webapp.domain.Author;
import com.faraonelife.spring5webapp.domain.Book;
import com.faraonelife.spring5webapp.repositories.AuthorRepository;
import com.faraonelife.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric=new Author("Eric","Evans");
        Book ddd=new Book("Domain Driver Design","12345");
eric.getBooks().add(ddd);
ddd.getAuthors().add(eric);
authorRepository.save(eric);
bookRepository.save(ddd);
Author rod=new Author("Rod","Johnson");
Book noEjb=new Book("J2EE dev","7654657");
noEjb.getAuthors().add(rod);
rod.getBooks().add(noEjb);
authorRepository.save(rod);
bookRepository.save(noEjb);
        System.out.println("started in bookstrap");
        System.out.println("Number of book" + bookRepository.count());
    }
}
