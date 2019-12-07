package com.shop.test;

import com.shop.domain.*;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * tests Order Class
 *
 * @author maciej.jasinski2@gmail.com
 * @since 24.11.2019
 */
final class OrderTest {

    void testOrderWithFixedDiscountPolicy() {
        DiscountPolicy discountPolicy = new FixedDiscountPolicy(0.2F);
        Order order = new Order(discountPolicy);
        assert order.getTotal().compareTo(BigDecimal.ZERO) == 0 : "Invalid Total";

        order.addItem(new Item("komputer", BigDecimal.valueOf(3200), 15));
        assert order.getTotal()
                .equals(new BigDecimal("48000.00")) : "Invalid total";
        assert order.getTotal()
                .compareTo(new BigDecimal("48000")) == 0 : "Invalid total";
        order.applyDiscount(null);
        assert order.getTotal().compareTo(new BigDecimal("38400")) == 0 : "Invalid total";
    }

    void testOrderWithCouponDiscountPolicy() {
        DiscountPolicy discountPolicy = new CouponCodesDiscountPolicy(Arrays.asList("KOD", "DOK"), 0.2F);
        Order order = new Order(discountPolicy);
        assert order.getTotal().compareTo(BigDecimal.ZERO) == 0 : "Invalid Total";

        order.addItem(new Item("komputer", BigDecimal.valueOf(3200), 15));
        order.applyDiscount("KOD");
        assert order.getTotal().compareTo(new BigDecimal("38400")) == 0 : "Invalid total";

        order.applyDiscount(null);
        assert order.getTotal().compareTo(new BigDecimal("48000")) == 0 : "Invalid total";

        order.applyDiscount("ZLY");
        assert order.getTotal().compareTo(new BigDecimal("48000")) == 0 : "Invalid total";

        order.addItem(new Item("monitor", BigDecimal.valueOf(1000), 12));
        order.applyDiscount(null);
        assert order.getTotal().compareTo(new BigDecimal("60000")) == 0 : "Invalid total";

    }

    void testSend() {
        DiscountPolicy discountPolicy = new FixedDiscountPolicy(0.0F);
        Order order = new Order(discountPolicy);
        order.addItem(new Item("komputer", BigDecimal.valueOf(3200), 15));
        order.addItem(new Item("monitor", BigDecimal.valueOf(1000), 12));
        assert order.getStatus().equals(OrderStatus.IN_PROGRES) : "invalid Status";

        order.send();
        assert order.getStatus().equals(OrderStatus.SENT) : "invalid Status";
        assert order.getItems().size() == 2 : "invalid size";

        order.addItem((new Item("myszka", BigDecimal.valueOf(100), 10)));
        assert order.getStatus().equals(OrderStatus.SENT) : "invalid Status";
        assert order.getItems().size() == 2 : "invalid size";

    }

    void testOrderStatus() {
        OrderStatus[] values = OrderStatus.values();
        assert values[0] == OrderStatus.IN_PROGRES : "invalid enum";
        assert values[1] == OrderStatus.SENT : "invalid enum";

        assert OrderStatus.IN_PROGRES.getStatusName().equals("in progress") : "invalid status name";
        assert OrderStatus.IN_PROGRES.name().equals("IN_PROGRES") : "invalid enum option name";
        assert OrderStatus.IN_PROGRES.ordinal() == 0 : "invalid enum position";
    }

}

