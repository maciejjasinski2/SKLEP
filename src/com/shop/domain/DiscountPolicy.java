package com.shop.domain;

import java.io.Serializable;

/**
 * Represents discount policy
 *
 * @author maciej.jasinski2@gmail.com
 * @since 23.11.2019
 */
public interface DiscountPolicy extends Serializable {
    /**
     *  It retrns discount for given code
     *     Only values between 0 and 1 where:
     *     0 - no discount
     *     1 - 100% discount
     * @param code
     * @return
     */

    float getDiscount(String code);
}
