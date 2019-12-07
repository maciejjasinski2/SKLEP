package com.shop.test;
 final class ApplicationTest {

    public static void main(String[] args) {
        System.out.println("Running application tests...");
        TestRunner runner = new TestRunner(
                new PersonTest(),
                new AccountTablePrinterTest(),
                new CompanyTest(),
                new DiscountPolicyTest(),
                new CustomerTest(),
                new OrderTest(),
                new AccountTest(),
                new IoTest(),
                new CreateAccountMenuCommandTest());
        runner.runTests();

    }
}

