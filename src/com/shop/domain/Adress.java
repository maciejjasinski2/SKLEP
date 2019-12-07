package com.shop.domain;

import java.io.Serializable;
import java.util.Objects;

import static com.shop.util.Precondition.requireNonNulls;

/**
 * represents customer adress
 *
 * @author maciej.jasinski2@gmail.com
 * @since 23.11.2019
 */
public final class Adress implements Serializable {
    private final String street;
    private final String city;
    private final String postcode;
    private final String country;

    public Adress(String street, String city, String postcode, String country) {
        requireNonNulls(street, city, postcode, country);
        this.street = street;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adress)) return false;
        Adress adress = (Adress) o;
        return getStreet().equals(adress.getStreet()) &&
                getCity().equals(adress.getCity()) &&
                getPostcode().equals(adress.getPostcode()) &&
                getCountry().equals(adress.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStreet(), getCity(), getPostcode(), getCountry());
    }


    @Override
    public String toString() {
        return "Adress " +
                "street " + street + '\'' +
                ", city " + city + '\'' +
                ", postcode " + postcode + '\'' +
                ", country " + country + '\''                ;
    }
}
