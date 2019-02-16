package no.oslomet.model;

/*
This class is both POJO and BEAN.
 */

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idAuthor")
    private long id;
    private String firstName;
    private String lastName;
    private String nationality;
    private String rating;

    @OneToMany(mappedBy = "author")
    private Set<Book> book;

    public Author() {
    }

    public Author(long id, String firstName, String lastName, String nationality, String rating) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String getNationality() {return nationality;}

    public String getRating() { return rating; }
    public void setRating(String rating) { this.rating = rating; }
}
