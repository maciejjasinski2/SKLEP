package com.shop.command;

import com.shop.domain.*;
import com.shop.util.ListSelector;
import com.shop.util.io.IO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.shop.util.Precondition.requireNonNulls;

/**
 * ... comment class ...
 *
 * @author maciej.jasinski2@gmail.com
 * @since 01.12.2019
 */
public final class AddOrderMenuCommand implements MenuCommand<Account> {
    private final IO io;
    private final ListSelector listSelector;

    public AddOrderMenuCommand(IO io, ListSelector listSelector) {
        requireNonNulls(io);
        this.io = io;
        this.listSelector = listSelector;
    }


    @Override
    public void execute(Account account) {
        io.out().text("Please choice discount policy");

        int choice = listSelector.select(Arrays.asList("FIXED Policy", "Coupon Policy","NO Discount Policy"));
        switch (choice) {
            case 1:
               createFixedDiscountPolicy(account);
                return;
            case 2:
                createCouponDiscountPolicy(account);
                return;
            case 3:
                createZeroDiscountPolicy(account);
                return;
            default:
                throw new IllegalArgumentException("Invalid selection");
        }

    }
private void createFixedDiscountPolicy(Account account) {
        io.out().text("Please Privide fixed discount");
        String discount = io.in().text();
    DiscountPolicy policy = new FixedDiscountPolicy(Float.valueOf(discount));

}
    private void createCouponDiscountPolicy(Account account) {
        io.out().text("Please Privide discount with coupons");
        String discount = io.in().text();
        List<String> codes = new ArrayList<>();
        while (true) {
            io.out().text("Please insert code");
            String code = io.in().text();
            codes.add(code);
            io.out().text("Do you want to insert another code?");
            int answer = listSelector.select(Arrays.asList("Yes", "No"));
            if (answer == 2) {
                break;

            }

        }
        DiscountPolicy policy = new CouponCodesDiscountPolicy(codes, Float.valueOf(discount));
        Order order = new Order(policy);
        account.addOrder(order);
    }
    private void createZeroDiscountPolicy (Account account) {


    }

    @Override
    public String toString() {
        return "ADD NEW ORDER";

    }
}
