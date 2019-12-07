package com.shop.command;

import com.shop.domain.Account;
import com.shop.domain.Adress;
import com.shop.util.ListSelector;
import com.shop.util.Precondition;
import com.shop.util.io.IO;

import java.util.Arrays;

/**
 * ... comment class ...
 *
 * @author maciej.jasinski2@gmail.com
 * @since 01.12.2019
 */
public final class RemoveAddressMenuCommand implements MenuCommand<Account> {
    private final IO io;
    private final ListSelector listSelector;

    public RemoveAddressMenuCommand(IO io, ListSelector listSelector) {
        Precondition.requireNonNulls(io,listSelector);
        this.io = io;
        this.listSelector = listSelector;
    }

    @Override
    public void execute(Account account) {
        if (account.getCustomer().getAddress().isEmpty()){
            io.out().text("Addresses list is empty");
            return;
        }
        io.out().text("Select address to remove");
        int selected = listSelector.select(account.getCustomer().getAddress());
        io.out().text("Are you sure?");
        int choice = listSelector.select(Arrays.asList("yes", "no"));
        if (choice == 1) {
            Adress removedAddress = account.getCustomer().removeAdress(selected - 1);
            io.out().text("You removed " + removedAddress);
        }
        return;

    }

    @Override
    public String toString() {
        return "Remove address";
    }
}
