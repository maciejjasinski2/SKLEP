package com.shop.test;

import com.shop.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ... comment class ...
 *
 * @author maciej.jasinski2@gmail.com
 * @since 23.11.2019
 */
final class CustomerTest {

    void testCreateCustomer () {
        Customer customer1 = new Company("ADIDAS", new VatNumber("PL0123456789"));
        assert customer1.getName().equals("ADIDAS") : "invalid company name";
        assert customer1.getTaxId().equals("PL0123456789") : "invalid tax id";

        Customer customer2 = new Person("Jan", "Kowalski");
        assert customer2.getName().equals("Jan Kowalski") : "invalid person name";
        assert customer2.getTaxId() == null : "Tax id not null";

        assert customer1 instanceof Company : "customer1 is not Company";
        assert customer2 instanceof Person : "customer2 is not Person";

        Person person = (Person) customer2;
        assert person.getFirstName().equals("Jan") : "First name is not Jan";

    }

    void testPolimorfizm() {
        Customer[] customers = new Customer[] {
          new Person("Jan", "Kowalski"),
          new Company("ADIDAS", new VatNumber("PL0123456789"))

        };
        List<String> taxIds = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getTaxId() !=null){
                taxIds.add(customer.getTaxId());
            }
        }
        assert taxIds.equals(Arrays.asList("PL0123456789")) : "invalid list of tax ids";


    }
    void testCustomerAddressCreation() {
        Customer customer = new Company("ADIDAS", new VatNumber("PL0123456789"));
        Adress address = new Adress(
                "Obwodowa 5",
                "Warszawa",
                "01-329",
                "PL");
        customer.addAddress(address);
        customer.addAddress(address);

        assert customer.getAddress().size() == 1 : "Invalid address list";
        assert  customer.getAddress().get(0).equals(new Adress(
                "Obwodowa 5",
                "Warszawa",
                "01-329",
                "PL"
        )) : "Invalid adress in the list";
    }
}
