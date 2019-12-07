package com.shop.domain.printer;

import com.shop.domain.Account;
import com.shop.domain.Customer;
import com.shop.util.TablePrinter;

import java.util.List;

/**
 * Print account into table format
 *
 * @author maciej.jasinski2@gmail.com
 * @since 30.11.2019
 */
public final class AccountTablePrinter extends TablePrinter<Account> {
    public AccountTablePrinter(int[] columnsWidth) {
        super(columnsWidth, 5);     // krok 4 zwiekszenie o 1
    }

    @Override
    protected void buildHeader(StringBuilder builder) {
        builder
                .append(field("Client nr", columnsWidth[0]))   // krok 1 + zmiana numeracji
                .append("|")
                .append(field("NAME", columnsWidth[1]))
                .append("|")
                .append(field("TAX ID", columnsWidth[2]))
                .append("|")
                .append(field("phonenumbers ", columnsWidth[3]))
                .append("|")
                .append(field("Active", columnsWidth[4]))
                .append('\n')
                .append("-".repeat(tableWidth()))
                .append('\n');
    }

    @Override
    protected void buildRows(List<Account> list, StringBuilder builder) {
        int i = 1; //krok 2

        for (Account account : list) {
            Customer customer = account.getCustomer();
            builder.append(field(String.valueOf(i++), columnsWidth[0])).append("|") //krok 3 + zmiana numeracji
                    .append(field(customer.getName(), columnsWidth[1])).append("|")
                    .append(field(customer.getTaxId(), columnsWidth[2])).append("|")
                    .append(field(buildPhoneNumber(customer), columnsWidth[3])).append("|")
                    .append(field(String.valueOf(customer.isActive()), columnsWidth[4])).append("|")
                    .append('\n');

        }

    }

    private String buildPhoneNumber(Customer customer) {
        String phoneNumber = "";
        if (!customer.getPhoneNumbers().isEmpty()) {
            phoneNumber = customer.getPhoneNumbers().get(0);
            phoneNumber += " (" + (customer.getPhoneNumbers().size() - 1) + ")";
        }
        return phoneNumber;
    }
}
