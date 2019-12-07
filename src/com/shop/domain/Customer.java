package com.shop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.shop.util.Precondition.requireNonNulls;

/**
 * Represents Customer
 *
 * @author maciej.jasinski2@gmail.com
 * @since 17.11.2019
 */
public abstract class Customer implements Serializable {

    private static final long serialVersionUid = 100L;

    private final String name;
    private final List<String> phoneNumbers;
    private final List<Adress> adresses;
    private boolean active;


    public Customer(String name) {
        requireNonNulls(name);
        this.name = name;
        this.phoneNumbers = new ArrayList<>();
        this.adresses = new ArrayList<>();
        this.active = true;

    }
    public Customer(String name, boolean active) {
        this (name);
        this.active = active;

    }



    public abstract String getTaxId();

    public String getName() {
        return name;

    }
    public List<String> getPhoneNumbers() {
        return new ArrayList<>(phoneNumbers);
    }
    public List<Adress> getAddress() {
        return new ArrayList<>((adresses));
    }

    public Adress removeAdress(int idx) {
        if (idx >=0 && idx < adresses.size()){
            return adresses.remove(idx);
        }
        return null;
    }

    public boolean isActive() {
        return active;
    }
    public void addPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && !phoneNumber.isEmpty() && !phoneNumbers.contains(phoneNumber)) {
            phoneNumbers.add(phoneNumber);
        }
    }

    public String removePhoneNumber (int index){
        if (index >= 0 && index < phoneNumbers.size()) {
            String removed = phoneNumbers.remove(index);
            return removed;

        }
        return null;
    }
    public void toggleActive() {
        active = !active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return isActive() == customer.isActive() &&
                getName().equals(customer.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    public void addAddress(Adress address) {

        if (address != null && !adresses.contains(address)){
            adresses.add(address);
        }
    }
}
