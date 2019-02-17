package no.oslomet.model;

import javax.persistence.*;

@Entity
@Table(name = "orderline")
public class Orderline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOrderline")
    private long id;

    @ManyToOne
    @JoinColumn(name="idOrder")
    private Order order;

    @ManyToOne
    @JoinColumn(name="idBook")
    private Book book;

    public Orderline() {
    }

    public Orderline(long id, Order order, Book book) {
        this.id = id;
        this.order = order;
        this.book = book;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) {  this.order = order; }

    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
}