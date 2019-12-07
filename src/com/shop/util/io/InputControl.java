package com.shop.util.io;

import java.math.BigDecimal;

/**
 * Input system
 *
 * @author maciej.jasinski2@gmail.com
 * @since 24.11.2019
 */
public interface InputControl {
    String text();
    int integer();
    BigDecimal decimal();
    boolean bool();


}
