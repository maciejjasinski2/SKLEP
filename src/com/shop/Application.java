package com.shop;

import com.shop.command.*;
import com.shop.domain.Account;
import com.shop.domain.printer.AccountTablePrinter;
import com.shop.util.ListSelector;
import com.shop.util.io.IO;
import com.shop.util.io.PrintOutputControl;
import com.shop.util.io.ScannerInputControl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Application startup
 *
 * @author maciej.jasinski2@gmail.com
 * @since 30.11.2019
 */
final class Application {

    public static void main(String[] args) {


        IO io = new IO(new ScannerInputControl(System.in), new PrintOutputControl());
        io.out().text("SHOP MANAGER APPLICATION");

        List<Account> accounts = loadAccounts(io);

        ListSelector listSelector = new ListSelector(io);

        AccountTablePrinter accountTablePrinter = new AccountTablePrinter(new int[]{12, 18, 14, 16, 8}); //krok 5.b dodanie wartosci nowej kolumny
        List<MenuCommand<List<Account>>> commands = Arrays.asList(
                new CreateAccountMenuCommand(io, listSelector),
                new ListAccountsMenuCommand(io, accountTablePrinter),
                new SelectAccountMenuCommand(io, listSelector),
                new SaveAccountsMenuCommand(io),
                new ExitMenuCommand<>());

        CommandSelector<List<Account>> selector = new CommandSelector<>(commands, listSelector);
        selector.select(accounts);
    }
    private static List<Account> loadAccounts(IO io) {
        try (ObjectInputStream stream = new ObjectInputStream((new FileInputStream("data.txt")))) {

            List<Account> accounts = (List<Account>) stream.readObject();
            io.out().text("Accounts loaded from file.");
            return accounts;
        }catch (IOException ex) {
            io.out().text("Failed to load file " + ex.getMessage());
            ex.printStackTrace();
        }catch (ClassNotFoundException ex){
            io.out().text("Cannot read object from file: " + ex.getMessage());
        }
        return new ArrayList<>();
    }
}
