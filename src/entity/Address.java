package entity;

import annotation.Column;
import annotation.Entity;

/**
 * Created by Asus on 29.05.2017.
 */
@Entity(name = "Adres")
public class Address {
    @Column(name = "Miasto")
    String city;
    @Column(name = "Ulica")
    String street;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
