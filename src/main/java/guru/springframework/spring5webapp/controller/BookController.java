package guru.springframework.spring5webapp.controller;

import guru.springframework.spring5webapp.Repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController
{
    private final BookRepository bookRepository;//dependency injection
//injected an instance of bookRepo

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books") //we will get this method involked Spring mvc where there is request with //books

    public String getBooks(Model model)
    {
model.addAttribute("books",bookRepository.findAll());
//when a request with /books this method will excute this model for this model this model is going to get return back to our view layer and is going to have an attribute books
   //now this model will return back to our view layer and list of books will add to this model

        return "books/list";

    }
}
