package no.oslomet.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idOrder")
    private long id;
    private String date;

    @ManyToOne
    @JoinColumn(name="idBook")
    private Book book;

//    @ManyToOne
//    @JoinColumn(name="idShipping")
//    private Shipping shipping;

    public Order() {
    }

    public Order(long id) {
        this.id = id;
        this.date = date;
        this.book = book;
//        this.shipping = shipping;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }

//    public Shipping getShipping() { return shipping; }
//    public void setShipping(Shipping shipping) { this.shipping = shipping; }
}
