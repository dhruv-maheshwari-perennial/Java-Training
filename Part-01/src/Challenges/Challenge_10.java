package Challenges;

// Create a new class bank Account
class BankAccount {
    public int accNumber;
    public double balance;
    public String customerName, email, phoneNumber;

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double deposit(double depositAmount) {
        balance += depositAmount;
        setBalance(balance);
        return getBalance();
    }

    public double withDraw(double depositAmount) {
        balance -= depositAmount;
        setBalance(balance);
        return getBalance();
    }
}
public class Challenge_10 {
    public static void main(String[] args) {
        BankAccount bAcc = new BankAccount();
        bAcc.setCustomerName("Dhruv Maheshwari");
        bAcc.setEmail("dhruv@gmail.com");
        bAcc.setPhoneNumber("8077394176");
        bAcc.setAccNumber(123);
        bAcc.setBalance(12000.50);

        System.out.println("Name: " + bAcc.getCustomerName());
        System.out.println("Email: " + bAcc.getEmail());
        System.out.println("Phone No.: " + bAcc.getPhoneNumber());
        System.out.println("Account No: " + bAcc.getAccNumber());
        System.out.println("Balance: " + bAcc.getBalance());

        double dep = bAcc.deposit(120.50);
        System.out.println("Balance After Deposit: " + dep);

        double with = bAcc.withDraw(1500.45);
        System.out.println("Balance After Withdraw: " + with);
    }
}
