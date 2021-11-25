package nl.novi.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    // attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String make;
    private String model;
    private String year;

    // constructor

    public Car() {
    }

    public Car(String make, String model, String year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return model;
    }

    public void setType(String type) {
        this.model = type;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
