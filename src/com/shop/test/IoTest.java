package com.shop.test;

import com.shop.util.io.InputControl;
import com.shop.util.io.ScannerInputControl;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;

/**
 * Input/Output System test
 *
 * @author maciej.jasinski2@gmail.com
 * @since 24.11.2019
 */
final class IoTest {

    void testScannerInputControl() {
        String userInput = "test\n" +
                "123\n" +
                "23,00\n" +
                "true";

        InputControl control = new ScannerInputControl(new ByteArrayInputStream(userInput.getBytes()));
        assert control.text().equals("test") : "Invalid text";
        assert control.integer() == 123 : "Invalid number";
        assert control.decimal().compareTo(new BigDecimal("23.00")) == 0 : "Invalid Decimal";
        assert control.bool() : "Invalid boolean";
    }
}
