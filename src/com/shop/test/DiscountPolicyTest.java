package com.shop.test;

import com.shop.domain.CouponCodesDiscountPolicy;
import com.shop.domain.DiscountPolicy;
import com.shop.domain.FixedDiscountPolicy;

import java.util.Arrays;

/**
 * Discount Policy Test
 *
 * @author maciej.jasinski2@gmail.com
 * @since 23.11.2019
 */
final class DiscountPolicyTest {

    void  testFixedDiscountPolicy(){
        DiscountPolicy policy = new FixedDiscountPolicy(0.2F);
        assert policy.getDiscount(null) == 0.2F : "Invalid discount";

        DiscountPolicy fullDiscountPolicy = new FixedDiscountPolicy(1F);
        assert fullDiscountPolicy.getDiscount(null) == 1F : "Invalid Discount";

        DiscountPolicy noDiscountPolicy = new FixedDiscountPolicy(0F);
        assert noDiscountPolicy.getDiscount(null) == 0F : "Invalid discount";
    }
    void testCouponDiscountPolicy(){
        DiscountPolicy policy = new CouponCodesDiscountPolicy(Arrays.asList("KOD", "DOK"), 0.2F);
        assert policy.getDiscount("KOD") == 0.2F : "Invalid discount";
        assert policy.getDiscount("KOD") == 0 : "Invalid discount";
        assert policy.getDiscount("DOK") == 0.2F : "Invalid discount";
        assert policy.getDiscount("KDO") == 0 : "Invalid discount";
        }

}
