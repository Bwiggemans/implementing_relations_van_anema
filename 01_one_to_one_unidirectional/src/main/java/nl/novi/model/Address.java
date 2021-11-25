package nl.novi.model;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    // attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String street;
    private String number;
    private String city;
    private String postal_code;

    // constructor

    public Address() {
    }

    public Address(String street, String number, String city, String postal_code) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.postal_code = postal_code;
    }

    // getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postal_code;
    }

    public void setPostalCode(String postal_code) {
        this.postal_code = postal_code;
    }

}
