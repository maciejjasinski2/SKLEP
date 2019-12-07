package com.shop.domain;

import com.shop.util.Precondition;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import static com.shop.util.Precondition.*;

/**
 * Represents order items
 *
 * @author maciej.jasinski2@gmail.com
 * @since 23.11.2019
 */
public final class Item implements Serializable {
    private final String name;
    private final BigDecimal price;
    private final int quantity;

    public Item(String name, BigDecimal price, int quantity) {
        requireNonNulls(name, price);
        checkArgument(price.compareTo(BigDecimal.ZERO) > 0, "Wrong price");
        checkArgument(quantity > 1, "Wrong quantity");
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return getQuantity() == item.getQuantity() &&
                Objects.equals(getName(), item.getName()) &&
                Objects.equals(getPrice(), item.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice(), getQuantity());
    }
}
