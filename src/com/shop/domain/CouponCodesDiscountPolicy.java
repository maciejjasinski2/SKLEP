package com.shop.domain;

import com.shop.util.Precondition;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.shop.util.Precondition.checkArgument;
import static com.shop.util.Precondition.requireNonNulls;

/**
 * Coupon Codes Discoun tPolicy
 *
 * @author maciej.jasinski2@gmail.com
 * @since 23.11.2019
 */
public final class CouponCodesDiscountPolicy implements DiscountPolicy, Serializable {
    private final List<String> codes;
    private final float discount;


    public CouponCodesDiscountPolicy(List<String> codes, float discount) {
        requireNonNulls(codes, discount);
        checkArgument(!codes.isEmpty(), "Codes list is empty");
        checkArgument(discount >= 0 && discount <= 1, "Invalid discount: " + discount);

        this.codes = new ArrayList<>(codes);
        this.discount = discount;
    }

    @Override
    public float getDiscount(String code) {

        if (codes.contains(code)) {
            codes.remove(code);
            return discount;
        }
        return 0;
    }
}
