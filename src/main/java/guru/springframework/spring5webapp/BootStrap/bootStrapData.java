package guru.springframework.spring5webapp.BootStrap;

import guru.springframework.spring5webapp.Repository.AuthorRepository;
import guru.springframework.spring5webapp.Repository.BookRepository;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class bootStrapData implements CommandLineRunner
{
    private final AuthorRepository authorRepo;
    private final BookRepository bookRepo;

    public bootStrapData(AuthorRepository authorRepo, BookRepository bookRepo)
    {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public void run(String... args) throws Exception
    {
        Author eric = new Author("Eric");
        Book ddd= new Book("1234552","Domain driven Design");


        eric.getBooks().add(ddd);
        ddd.getAuthor().add(eric);

        authorRepo.save(eric);
        bookRepo.save(ddd);

        System.out.println("Started in BootStrap");
        System.out.println("Number if books "+bookRepo.count());

    }
}
