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
    private int quantity;

    @ManyToOne
    @JoinColumn(name="idAuthor")
    private Author author;

    @ManyToOne
    @JoinColumn(name="idCategory")
    private Category category;

    public Book() {
    }

    public Book(long id, String title, String releaseYear, Category category, Author author, int quantity) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.category = category;
        this.author = author;
        this.quantity = quantity;
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

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}