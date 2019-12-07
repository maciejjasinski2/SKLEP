package com.shop.util;

import java.util.Objects;

/**
 * Precondition of constructors
 *
 * @author maciej.jasinski2@gmail.com
 * @since 24.11.2019
 */
public final class Precondition {

    private Precondition() {}

    public static void requireNonNulls(Object...objects){
        for(Object object : objects) {
            if (object == null) {
                throw new NullPointerException();
            }
        }
    }

    public static void checkArgument(boolean valid, String message) {
        if (!valid){
            throw new IllegalArgumentException(message);
        }
    }
}
