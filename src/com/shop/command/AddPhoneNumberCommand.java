package com.shop.command;

import com.shop.domain.Account;
import com.shop.util.io.IO;

import static com.shop.util.Precondition.requireNonNulls;

/**
 * Adds phone number to customer
 *
 * @author maciej.jasinski2@gmail.com
 * @since 30.11.2019
 */
public final class AddPhoneNumberCommand implements MenuCommand<Account> {
    private final IO io;

    public AddPhoneNumberCommand(IO io) {
        requireNonNulls(io);
        this.io = io;
    }


    @Override
    public void execute(Account account) {
        io.out().text("Add phone number");
        String number = io.in().text();
        account.getCustomer().addPhoneNumber(number);
        io.out().text("you added :" + number);

    }



    @Override

    public String toString() {
        return "Add phone number";
    }


}
