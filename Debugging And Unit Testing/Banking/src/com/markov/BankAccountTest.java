package com.markov;

import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account;
    private static int count = 0;

    @org.junit.BeforeClass
    public static void beforeClass() {
        System.out.println("This executes before any test cases. Count = " + count++);
    }

    @org.junit.Before
    public void setup() {
        account = new BankAccount("Pavel", "Markov", 10000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @org.junit.Test
    public void deposit() {
        double balance = account.deposit(1000.00, true);
        assertEquals(11000.00, balance, 0);
    }

    @org.junit.Test
    public void withdraw_branch() {
        double balance = account.withdraw(6000.00, true);
        assertEquals(4000.00, balance, 0);
    }

//    @org.junit.Test
//    public void withdraw_notBranch() {
//        try {
//            account.withdraw(1000.00, false);
//            fail("Should've thrown an IllegalArgumentException");
//        } catch (IllegalArgumentException e) {
//
//        }
//    }

    @org.junit.Test (expected = IllegalArgumentException.class)
    public void withdraw_notBranch() throws Exception {
        account.withdraw(1000.00, false);
        fail("Should have thrown IllegalArgumentException");
    }

    @org.junit.Test
    public void getBalance_deposit() {
        account.deposit(1000.00, true);
        assertEquals(11000.00, account.getBalance(), 0);
    }

    @org.junit.Test
    public void getBalance_withdraw() {
        account.withdraw(1000.00, true);
        assertEquals(9000.00, account.getBalance(), 0);
    }

    @org.junit.Test
    public void isChecking() {
        assertTrue("This is NOT a checking account", account.isChecking());
    }

    @org.junit.After
    public void teardown() {
        System.out.println("Count = " + count++);
    }

    @org.junit.AfterClass
    public static void afterClass() {
        System.out.println("This executes after any test cases. Count = " + count++);
    }

}












