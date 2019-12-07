package com.shop.command;

import com.shop.domain.Account;
import com.shop.domain.Adress;
import com.shop.domain.Company;
import com.shop.domain.VatNumber;
import com.shop.util.Precondition;
import com.shop.util.io.IO;

import static com.shop.util.Precondition.requireNonNulls;

/**
 * add address of customer
 *
 * @author maciej.jasinski2@gmail.com
 * @since 01.12.2019
 */
public final class AddAdressManuCommand implements MenuCommand<Account> {
    private final IO io;

    public AddAdressManuCommand(IO io) {
        requireNonNulls(io);
        this.io = io;
    }


    @Override
    public void execute(Account account) {
        io.out().text("Please provide Street:");
        String street = io.in().text();
        io.out().text("Please provide City");
        String city = io.in().text();
        io.out().text("Please provide postcode");
        String postcode = io.in().text();
        io.out().text("Please provide country");
        String country = io.in().text();

        Adress adress = new Adress(street, city, postcode, country);
        account.getCustomer().addAddress(adress);
    }

    @Override
    public String toString() {
        return "Add new adress";
    }
}
