package com.shop.domain;

import com.shop.util.Precondition;

import java.io.Serializable;
import java.util.Objects;

import static com.shop.util.Precondition.requireNonNulls;

/**
 * ... comment class ...
 *
 * @author maciej.jasinski2@gmail.com
 * @since 23.11.2019
 */
public final class Company extends Customer implements Serializable {
    public final VatNumber vatNumber;

    public Company(String name, VatNumber vatNumber){
        super (name);
        Objects.requireNonNull(vatNumber);
        this.vatNumber = vatNumber;
    }
    public Company(String name, VatNumber vatNumber, boolean active) {
        super(name, active);
        requireNonNulls(vatNumber);
        this.vatNumber = vatNumber;
    }

    @Override
    public String getTaxId() {
        return vatNumber.getValue();
    }
}



