package Debugging_Unit_Testing;

public class Debug_02 {
    public static void main(String[] args) {
        System.out.println("App. is running");
    }
}

class BankAccount {
    private String firstName, lastName;
    private double balance;
    private int accountType;

    public static final int CHECKING = 1;
    public static final int SAVINGS = 2;

    public BankAccount(String firstName, String lastName, double balance, int typeOfAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType = typeOfAccount;
    }

    // branch -> true, if customer is performing transaction at a branch, with a teller
    // branch -> false, if customer if performing transaction at an ATM
    public double deposit(double amount, boolean branch) {
        return (balance += amount);
    }

    // branch -> true, if customer is performing transaction at a branch, with a teller
    // branch -> false, if customer if performing transaction at an ATM
    public double withdraw(double amount, boolean branch) {
        if ((amount > 500.00) && branch) {
            throw new IllegalArgumentException();
        }

        return (balance -= amount);
    }

    public double getBalance() {
        return balance;
    }

    public boolean isChecking() {
        return accountType == CHECKING;
    }

    // more methods that uses firstname, lastname & perform other functions
}
