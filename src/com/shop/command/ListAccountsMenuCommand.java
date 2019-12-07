package com.shop.command;

import com.shop.domain.Account;
import com.shop.domain.printer.AccountTablePrinter;
import com.shop.util.io.IO;

import java.util.List;

import static com.shop.util.Precondition.requireNonNulls;

/**
 * ... comment class ...
 *
 * @author maciej.jasinski2@gmail.com
 * @since 30.11.2019
 */
public final class ListAccountsMenuCommand implements MenuCommand<List<Account>> {
    private final IO io;
    private final AccountTablePrinter accountTablePrinter;

    public ListAccountsMenuCommand(IO io, AccountTablePrinter accountTablePrinter) {
        requireNonNulls(io, accountTablePrinter);
        this.io = io;
        this.accountTablePrinter = accountTablePrinter;
    }


    @Override
    public void execute(List<Account> accounts) {
        io.out().text("Your Accounts");
        accountTablePrinter.print(accounts);
        String table = accountTablePrinter.print(accounts);
        io.out().text(table);

    }

    @Override
    public String toString() {
        return "Accounts list";
    }
}
