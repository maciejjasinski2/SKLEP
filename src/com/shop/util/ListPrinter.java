package com.shop.util;

import com.shop.util.io.OutputControl;

import java.util.List;

import static com.shop.util.Precondition.requireNonNulls;

/**
 * pritnts command lists
 *
 * @author maciej.jasinski2@gmail.com
 * @since 30.11.2019
 */
public final class ListPrinter {

    private final OutputControl outputControl;

    public ListPrinter(OutputControl outputControl) {
        requireNonNulls(outputControl);
        this.outputControl = outputControl;
    }

    public void print(List<?> objects) {
        int i = 1;
        for (Object object : objects) {
            outputControl.text(i++ + ". " + object);
        }
    }
}
