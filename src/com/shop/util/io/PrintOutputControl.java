package com.shop.util.io;

/**
 * Prints given text to console
 *
 * @author maciej.jasinski2@gmail.com
 * @since 24.11.2019
 */
public final class PrintOutputControl implements OutputControl{

    @Override
    public void text(String text) {
        System.out.println(text);
    }
}
