package com.shop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.shop.util.Precondition.requireNonNulls;

/**
 * represent customers account
 *
 * @author maciej.jasinski2@gmail.com
 * @since 24.11.2019
 */
public final class Account implements Serializable {
    private final Customer customer;
    private final List<Order> orders;


    public Account(Customer customer) {
        requireNonNulls(customer);
        this.customer = customer;
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        if (order != null) {
            orders.add(order);
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return getCustomer().equals(account.getCustomer()) &&
                getOrders().equals(account.getOrders());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomer(), getOrders());
    }

    @Override
    public String toString() {
        return customer.getName() + ", taxID: " + customer.getTaxId();
    }

}
