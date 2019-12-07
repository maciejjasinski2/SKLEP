package com.shop.test;

import com.shop.domain.*;

/**
 * test accounts class
 *
 * @author maciej.jasinski2@gmail.com
 * @since 24.11.2019
 */
final class AccountTest {


    void testCreateAccount() {
        Customer customer = new Company("ADIDAS", new VatNumber("PL0123456789"));
        Account account = new Account(customer);
        assert account.getOrders().isEmpty() : "Invalid Orders";

        DiscountPolicy discountPolicy = new FixedDiscountPolicy(0.4F);
        account.addOrder(new Order(discountPolicy));
        assert account.getOrders().size() == 1 : "Invalid order list";

        assert account.getCustomer() != null : "Invalid customer";

    }
}
