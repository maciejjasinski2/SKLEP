package com.shop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.shop.util.Precondition.requireNonNulls;

/**
 * Represents customer order
 *
 * @author maciej.jasinski2@gmail.com
 * @since 24.11.2019
 */
public final class Order implements Serializable {

    private final DiscountPolicy discountPolicy;
    private final List<Item> items;
    private float discount;
    private OrderStatus status;

    public Order(DiscountPolicy discountPolicy) {
        requireNonNulls(discountPolicy);
        this.discountPolicy = discountPolicy;
        this.items = new ArrayList<>();
        this.status = OrderStatus.IN_PROGRES;
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void addItem(Item item) {
        if (item != null && !items.contains(item) && status.equals(OrderStatus.IN_PROGRES)) {
            items.add(item);
        }
    }

    public void send() {
        if (items.size() > 0) {
            status = OrderStatus.SENT;
        }
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Item item : items) {
            BigDecimal itemPrice = item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())); //price * quantity
            total = total.add(itemPrice);
        }//total * (1 - discount)
        return total.multiply(BigDecimal.ONE.subtract(BigDecimal.valueOf(discount)))
                .setScale(2, RoundingMode.HALF_UP); // ustawia BigDecimela do dwoch miejsc po przecinku i zaokrągla w górę
    }

    public void applyDiscount(String code) {
        discount = discountPolicy.getDiscount(code);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(discountPolicy, order.discountPolicy) &&
                Objects.equals(items, order.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountPolicy, items);
    }
}
