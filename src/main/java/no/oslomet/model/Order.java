package no.oslomet.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idOrder")
    private long id;
    private String date;

    @Transient
    private ArrayList<Book> bookList;

    @ManyToOne
    @JoinColumn(name="idShipping")
    private Shipping shipping;

    public Order() {
    }

    public Order(long id, String date, Shipping shipping) {
        this.id = id;
        this.date = date;
        this.shipping = shipping;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public Shipping getShipping() { return shipping; }
    public void setShipping(Shipping shipping) { this.shipping = shipping; }

    public ArrayList<Book> getBookList() { return bookList; }
    public void setBookList(ArrayList<Book> bookList) { this.bookList = bookList; }
}
