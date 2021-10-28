package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.*;

public class Book
{
    private String title;
    private String isbn;

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    public Long id;
   @ManyToMany
  @JoinTable(name = "author_book",joinColumns = @JoinColumn(name="book_id"),
           inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> author = new HashSet<Author>();

    public Book()
    {

    }

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title= title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthor() {
        return author;
    }

    public void setAuthor(Set<Author> author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", id=" + id +
                ", author=" + author +
                '}';
    }
}

