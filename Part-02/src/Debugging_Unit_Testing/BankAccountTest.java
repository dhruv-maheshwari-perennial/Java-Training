package Debugging_Unit_Testing;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount account;
    private static int count;

    @org.junit.jupiter.api.BeforeAll
    public static void beforeClass() {
        System.out.println("This executes before any test case. Count: " + count++);
    }

    @org.junit.jupiter.api.BeforeEach
    void setup() {
        account = new BankAccount("Dhruv","Maheshwari",1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @org.junit.jupiter.api.Test
    void deposit() {
        double balance = account.deposit(200.00,true);
        assertEquals(1200.00, balance, 0);
    }

    @org.junit.jupiter.api.Test
    void withdraw_branch() {
        double balance = account.withdraw(200.00, true);
        assertEquals(800.00,balance,0);
    }

    @org.junit.jupiter.api.Test()
    void withdraw_notBranch() {
        account.withdraw(200.00, false);
    }

    @org.junit.jupiter.api.Test
    void getBalance_deposit() {
        account.deposit(200.00,true);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void getBalance_withdraw() {
        account.withdraw(200.00,true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void isChecking_true() {
        assertTrue(account.isChecking(), "Not a checking account");
    }

    @org.junit.jupiter.api.AfterAll
    public static void afterClass() {
        System.out.println("This executes after class. Count: " + count++);
    }

    @org.junit.jupiter.api.AfterEach
    public void teardown() {
        System.out.println("Count: " + count++);
    }
}