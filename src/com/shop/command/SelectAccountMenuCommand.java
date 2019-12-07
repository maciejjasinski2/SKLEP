package com.shop.command;

import com.shop.domain.Account;
import com.shop.util.ListSelector;
import com.shop.util.io.IO;

import java.util.Arrays;
import java.util.List;

import static com.shop.util.Precondition.requireNonNulls;

/**
 * command to modify phone numbers list
 *
 * @author maciej.jasinski2@gmail.com
 * @since 30.11.2019
 */
public final class SelectAccountMenuCommand implements MenuCommand<List<Account>> {
    private final IO io;
    private final ListSelector listSelector;

    public SelectAccountMenuCommand(IO io, ListSelector listSelector) {
        requireNonNulls(io, listSelector);
        this.io = io;
        this.listSelector = listSelector;
    }


    @Override
    public void execute(List<Account> accounts) {
        if (accounts.isEmpty()) {
            io.out().text("Accounts list is empty. Add customer");
            return;
        }
       int selected = listSelector.select(accounts);
       Account account = accounts.get(selected - 1);
       io.out().text("Account selected: " + account);

       List<MenuCommand<Account>> commands = Arrays.asList(
               new AddPhoneNumberCommand(io),
               new RemovePhoneNumberCommand(io, listSelector),
               new AddAdressManuCommand(io),
               new RemoveAddressMenuCommand(io, listSelector),
               new ListAddressMenuCommand(io),
               new AddOrderMenuCommand(io, listSelector),
               new ExitMenuCommand<>()
       );
       new CommandSelector<>(commands, listSelector).select(account);
    }

    @Override
    public String toString() {
        return "Select account";
    }
}
