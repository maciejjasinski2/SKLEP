package com.shop.util.io;

import java.util.Objects;

/**
 * Input/Output System
 *
 * @author maciej.jasinski2@gmail.com
 * @since 24.11.2019
 */
public final class IO {
    private final InputControl in;
    private final OutputControl out;

    public IO(InputControl in, OutputControl out) {
        Objects.requireNonNull(in);
        Objects.requireNonNull(out);
        this.in = in;
        this.out = out;
    }

    public InputControl in() {
        return in;
    }

    public OutputControl out() {
        return out;
    }
}
