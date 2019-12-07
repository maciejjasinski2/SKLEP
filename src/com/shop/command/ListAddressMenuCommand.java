package com.shop.command;
import com.shop.domain.Account;
import com.shop.domain.Adress;
import com.shop.util.ListPrinter;
import com.shop.util.Precondition;
import com.shop.util.io.IO;
/**
 * ... comment class ...
 *
 * @author maciej.jasinski2@gmail.com
 * @since 01.12.2019
 */


public final class ListAddressMenuCommand implements MenuCommand<Account> {
    private final IO io;
    private  final ListPrinter listPrinter;

    ListAddressMenuCommand(IO io) {

        Precondition.requireNonNulls(io);
        this.io = io;
        this.listPrinter = new ListPrinter(io.out());
    }


    @Override
    public void execute(Account account ) {
        io.out().text("Your Addresses");
       listPrinter.print(account.getCustomer().getAddress());
    }

    @Override
    public String toString() {
        return "Your Addresses";
    }
}
