package com.shop.test;

import com.shop.domain.Account;
import com.shop.domain.Company;
import com.shop.domain.Person;
import com.shop.domain.VatNumber;
import com.shop.domain.printer.AccountTablePrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * Test for PersonTablePrinter
 *
 * @author maciej.jasinski2@gmail.com
 * @since 17.11.2019
 */
final class AccountTablePrinterTest {

    void testCreateAccountTablePrinter() {
        AccountTablePrinter printer = new AccountTablePrinter(new int[]{12, 18, 14, 16, 8}); // krok 5 dodanie wartosci nowej kolumny
        assert printer != null : "Cannot create account table printer";
    }

    void testPrintAccountTable() {
        AccountTablePrinter printer = new AccountTablePrinter(new int[]{12, 18, 14, 16, 8}); // krok 5.a dodanie wartosci nowej kolumny
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(new Person("Kamil", "Jasek")));
        accounts.add(new Account(new Company("ABC", new VatNumber("PL0123456789"))));
        String table = printer.print(accounts);
        System.out.println(table);
        String expecedString =
                " Client nr  |       NAME       |    TAX ID    |  phonenumbers  | Active \n" +
                        "-------------------------------------------------------------------------\n" +
                        "     1      |   Kamil Jasek    |      -       |                |  true  |\n" +
                        "     2      |       ABC        | PL0123456789 |                |  true  |\n";
        assert expecedString.equals(table) : "Table format is wrong";
        System.out.println(table);
    }

}
