package com.shop.command;

import com.shop.domain.Account;
import com.shop.util.ListSelector;
import com.shop.util.io.IO;

import java.util.Arrays;

import static com.shop.util.Precondition.requireNonNulls;

/**
 * ... comment class ...
 *
 * @author maciej.jasinski2@gmail.com
 * @since 30.11.2019
 */
public final class RemovePhoneNumberCommand implements MenuCommand<Account> {
    private final IO io;
    private final ListSelector listSelector;


    public RemovePhoneNumberCommand(IO io, ListSelector listSelector) {
                requireNonNulls(io);
        this.io = io;
        this.listSelector = listSelector;
    }

    @Override
    public void execute(Account account) {
        if (account.getCustomer().getPhoneNumbers().isEmpty()){
            io.out().text("Phone numbeer list is epmty");
            return;
        }
      io.out().text("Select phone number to remove");
      int selected = listSelector.select(account.getCustomer().getPhoneNumbers());
      io.out().text("Are you sure?");
      int choice = listSelector.select(Arrays.asList("yes", "no"));
      if (choice == 1) {
          String removedNumber = account.getCustomer().removePhoneNumber(selected - 1);
          io.out().text("You removed " + removedNumber);
      }
      return;


    }

    @Override
    public String toString() {
        return "Remove phone number";
    }


}
