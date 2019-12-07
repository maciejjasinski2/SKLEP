package com.shop.util.io;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Scanner based input control system
 *
 * @author maciej.jasinski2@gmail.com
 * @since 24.11.2019
 */
public final class ScannerInputControl implements InputControl {

    private final Scanner scanner;

    public ScannerInputControl(InputStream stream) {
        this.scanner = new Scanner(stream);
    }

    @Override
    public String text() {
        return scanner.nextLine();
    }

    @Override
    public int integer() {
        int res = scanner.nextInt();
         scanner.nextLine();
         return res;
    }

    @Override
    public BigDecimal decimal() {
        return scanner.nextBigDecimal();
    }

    @Override
    public boolean bool() {
        return scanner.nextBoolean();
    }
}
