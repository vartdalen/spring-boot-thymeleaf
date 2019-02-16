package no.oslomet.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCategory")
    private long id;

    @OneToMany(mappedBy = "category")
    private Set<Book> book;

    private String name;

    public Category() {
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

}
