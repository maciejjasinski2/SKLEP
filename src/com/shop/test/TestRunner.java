package com.shop.test;

import java.lang.reflect.Method;

final class TestRunner {

    private final Object[] tests;

    TestRunner(Object... tests) {
        this.tests = tests;
    }

    void runTests() {
        runTests("test.+");
    }

    final void runTests(String pattern) {
        for (Object test : tests) {
            Method[] declaredMethods = test.getClass().getDeclaredMethods();
            System.out.println("Test Class: " + test.getClass().getName());
            for (Method method : declaredMethods) {
                if (method.getName().matches(pattern)) {
                    try {
                        method.invoke(test);
                        System.out.println("+ " + method.getName());
                    } catch (Exception ex) {
                        System.out.println("- " + method.getName());
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}
