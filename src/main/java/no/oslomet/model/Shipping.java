package no.oslomet.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shipping")
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idShipping")
    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private int postalCode;

    @OneToMany(mappedBy = "shipping")
    private Set<Order> order;

    public Shipping(){
    }

    public Shipping(long id, String firstName, String lastName, String address, int postalCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postalCode = postalCode;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public int getPostalCode() { return postalCode; }
    public void setPostalCode(int postalCode) { this.postalCode = postalCode; }
}
