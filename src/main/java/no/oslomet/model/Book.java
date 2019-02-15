package no.oslomet.model;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idBook")
    private long id;
    private String title;
    private String releaseYear;

    @ManyToOne
    @JoinColumn(name="idAuthor")
    private Author author;

    public Book() {
    }

    public Book(long id, String title, String releaseYear, Author author) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}