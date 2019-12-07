package com.shop.domain;

import com.shop.util.Precondition;

import java.io.Serializable;

import static com.shop.util.Precondition.checkArgument;

/**
 * fixed discount policy
 *
 * @author maciej.jasinski2@gmail.com
 * @since 23.11.2019
 */
public final class FixedDiscountPolicy implements DiscountPolicy, Serializable {

    private final float discount;

    public FixedDiscountPolicy(float discount) {
        checkArgument(discount >= 0 && discount <= 1, "Invalid discount: " + discount);

        this.discount = discount;
    }

    @Override
    public float getDiscount(String code) {
        return discount;
    }
}
