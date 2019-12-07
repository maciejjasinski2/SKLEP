package com.shop.command;

import com.shop.command.MenuCommand;
import com.shop.domain.Account;
import com.shop.util.io.IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import static com.shop.util.Precondition.requireNonNulls;

/**
 * Save to file
 *
 * @author maciej.jasinski2@gmail.com
 * @since 01.12.2019
 */
public final class SaveAccountsMenuCommand implements MenuCommand<List<Account>> {
    private final IO io;

    public SaveAccountsMenuCommand(IO io) {
        requireNonNulls(io);
        this.io = io;
    }

    @Override
    public void execute(List<Account> accounts) {

        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("data.txt"))) {
            stream.writeObject(accounts);
            io.out().text("Successfully data saved");
        } catch (IOException ex) {
            ex.printStackTrace();
            io.out().text("Failed to save file: " + ex.getMessage());
            ex.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "Save data to file";
    }
}
