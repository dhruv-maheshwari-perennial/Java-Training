package Exercise;

// Exercise 32 - Banking

import java.util.ArrayList;

class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public void setBranches(ArrayList<Branch> branches) {
        this.branches = branches;
    }

    public boolean addBranch(String branchName) {
        if(findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double transactionAmount) {
        Branch existingBranch = findBranch(branchName);
        if(existingBranch != null) {
            return existingBranch.newCustomer(customerName, transactionAmount);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transactionAmount) {
        Branch existingBranch = findBranch(branchName);
        if(existingBranch != null) {
            return existingBranch.addCustomerTransaction(customerName, transactionAmount);
        }
        return false;
    }

    public boolean listCustomer(String branchName, boolean showTransaction) {
        Branch existingBranch = findBranch(branchName);
        if(existingBranch != null) {
            System.out.println("/*--- Customer details for branch " + existingBranch.getName() + " ---*/");
            ArrayList<Customer> branchCustomers = existingBranch.getCustomerList();
            for(int i = 0; i < branchCustomers.size(); i++) {
                System.out.println("Customer: " + branchCustomers.get(i).getName() + "[" + (i+1) + "]");
                if(showTransaction) {
                    System.out.println("/*--- Transactions ---*/");
                    ArrayList<Double> transactions = branchCustomers.get(i).getTransactions();
                    for(int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j+1) + "] Amount " + transactions.get(j));
                    }
                }
            }
            return true;

        } else {
            return false;
        }
    }

    private Branch findBranch(String branchName) {
        for(int i = 0; i < this.branches.size(); i++) {
            if(this.branches.get(i).getName().equals(branchName)) {
                return this.branches.get(i);
            }
        }
        return null;
    }

}

class Branch {

    private String name;
    private ArrayList<Customer> customerList;

    // Constructor
    public Branch(String name) {
        this.name = name;
        this.customerList = new ArrayList<Customer>();
    }

    // Methods
    public boolean newCustomer(String customerName, double initialAmount) {
        if(findCustomer(customerName) == null) {
            this.customerList.add(new Customer(customerName, initialAmount));
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String customerName, double amount) {
        Customer existingCustomer = findCustomer(customerName);
        if(existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

    public Customer findCustomer(String customerName) {
        for(int i = 0; i < this.customerList.size(); i++) {
            if(this.customerList.get(i).getName().equals(customerName)) {
                return this.customerList.get(i);
            }
        }
        return null;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }

}

class Customer {

    private String name;
    private ArrayList<Double> transactions;

    // Constructor
    public Customer(String name, double initialAmount) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        addTransaction(initialAmount);
    }

    // Methods
    public void addTransaction(double amount) {
        this.transactions.add(amount);
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Double> transactions) {
        this.transactions = transactions;
    }

}

public class Exercise_32 {
    public static void main(String[] args) {
        Bank bank = new Bank("National Australia Bank");

        bank.addBranch("Adelaide");

        bank.addCustomer("Adelaide", "Tim", 50.05);
        bank.addCustomer("Adelaide", "Mike", 175.34);
        bank.addCustomer("Adelaide", "Percy", 220.12);

        bank.addCustomerTransaction("Adelaide", "Tim", 44.22);
        bank.addCustomerTransaction("Adelaide", "Tim", 12.44);
        bank.addCustomerTransaction("Adelaide", "Mike", 1.65);

        bank.listCustomer("Adelaide", true);
    }
}
