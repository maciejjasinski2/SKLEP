package com.shop.domain;

import com.shop.util.Precondition;

import java.io.Serializable;
import java.util.Objects;

import static com.shop.util.Precondition.checkArgument;
import static com.shop.util.Precondition.requireNonNulls;

/**
 * Represents Company Vat Number
 *
 * @author maciej.jasinski2@gmail.com
 * @since 23.11.2019
 */
public final class VatNumber implements Serializable {
    private final String value;

    public VatNumber(String value) {
        requireNonNulls(value);
        checkArgument(value.matches("[A-Z]{2}\\d{10}"), "Invalid vat number");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VatNumber)) return false;
        VatNumber vatNumber = (VatNumber) o;
        return getValue().equals(vatNumber.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
