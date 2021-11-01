package guru.springframework.spring5webapp.BootStrap;

import guru.springframework.spring5webapp.Repository.AuthorRepository;
import guru.springframework.spring5webapp.Repository.BookRepository;
import guru.springframework.spring5webapp.Repository.publisherRepository;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class bootStrapData implements CommandLineRunner
{



    private final AuthorRepository authorRepo;
    private final BookRepository bookRepo;
    private final publisherRepository publisherRepo;
    public bootStrapData(AuthorRepository authorRepo, BookRepository bookRepo, publisherRepository publisherRepo)
    {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void run(String... args) throws Exception
    {
        System.out.println("started in BootStarp");
        Author eric = new Author("Eric");
        Book ddd= new Book("1234552","Domain driven Design");
        Publisher ITC = new Publisher();
        ITC.setName("ITCpublishiung");
        ITC.setAddress("Richardson");
        ITC.setCity("LosAngels");
        ITC.setState("Texsas");

publisherRepo.save(ITC);

        System.out.println("Number of publsihers "+publisherRepo.count());

        eric.getBooks().add(ddd);
        ddd.getAuthor().add(eric);

        ddd.setPublisher(ITC);
        ITC.getBooks().add(ddd);



        authorRepo.save(eric);
        bookRepo.save(ddd);
        publisherRepo.save(ITC);

        System.out.println("Started in BootStrap");
        System.out.println("Number of books "+bookRepo.count());
        System.out.println("publisher number of books "+ITC.getBooks().size());

    }
}
