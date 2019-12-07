package com.shop.test;

import com.shop.command.CreateAccountMenuCommand;
import com.shop.command.MenuCommand;
import com.shop.domain.Account;
import com.shop.domain.Company;
import com.shop.domain.Person;
import com.shop.util.ListSelector;
import com.shop.util.io.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Tests for creating account via menu command
 *
 * @author maciej.jasinski2@gmail.com
 * @since 30.11.2019
 */
final class CreateAccountMenuCommandTest {

    void testCreateCompany() {
        String userInput =
                "1\n" +
                        "ABc\n" +
                        "PL0123456789\n";

        IO io = buildIO(userInput);


        ListSelector listSelector = new ListSelector(io);
        MenuCommand<List<Account>> command = new CreateAccountMenuCommand(io, listSelector);
        List<Account> accounts = new ArrayList<>();
        command.execute(accounts);
        assert accounts.size() == 1 : "Invalid accounts size";
        assert accounts.get(0).getCustomer() instanceof Company : "not company";
    }



    void testCreatePerson() {
        String userInput =
                "2\n" +
                        "Maciej\n" +
                        "Jasinski\n";
        IO io = buildIO(userInput);
        ListSelector listSelector = new ListSelector(io);
        MenuCommand<List<Account>> command = new CreateAccountMenuCommand(io, listSelector);
        List<Account> accounts = new ArrayList<>();
        command.execute(accounts);
        assert accounts.size() == 1 : "Invalid accounts size";
        assert accounts.get(0).getCustomer() instanceof Person : "not person";


    }
    private IO buildIO(String userInput) {
        InputControl inputControl = new ScannerInputControl(new ByteArrayInputStream(userInput.getBytes()));
        OutputControl outputControl = new OutputControl() {
            @Override
            public void text(String text) {
            }
        };
        return new IO(inputControl, outputControl);
    }

}
