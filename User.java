package com.company;

import java.util.ArrayList;

public class User {

    private final String firstName;
    private final String lastName;
    private final String id;
    private final String password;
    ArrayList<Account> accounts;

    public User(String firstName, String lastName, String id, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.password = password;
        accounts = new ArrayList<>();
    }

    public void printAllAvailableAccounts() {
        int i = 1;
        for (Account str : accounts) {
            System.out.print("Account " + i + ":");
            str.printAccountData();
            i++;
        }
    }

    public void printUserData() {
        System.out.println("firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id='" + id + '\'');
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public void checkBalance(Account account) {
        System.out.println("balance :" + account.getBalance());
    }

    public void deposit(Account account, int amount) {
        if (accounts.contains(account)) {
            int balance = account.getBalance();
            balance += amount;
            account.updateBalance(balance);
            Transaction transaction = new Transaction(amount);
            account.addTransaction(transaction);


        } else {
            System.out.println("your account incorract");
        }

    }

    public void withdrawal(Account account, int amount) {
        if (accounts.contains(account)) {
            int balance = account.getBalance();
            balance -= amount;
            if (balance < 0) {
                System.out.println("Destination account doesn’t exist or there is not enough money \n" +
                        "in your account.");
            } else {
                account.updateBalance(balance);
                Transaction transaction = new Transaction((amount * -1));
                account.addTransaction(transaction);
                System.out.println("Completed");
            }
        } else {
            System.out.println("Destination account doesn’t exist or there is not enough money \n" +
                    "in your account.");
        }

    }

    public void transfer(Account srcAccount, Account destAccount, int amount) {
        if (accounts.contains(srcAccount)) {
            int balanceSrcAccount = srcAccount.getBalance();
            int balanceDestAccount = destAccount.getBalance();
            balanceSrcAccount -= amount;
            balanceDestAccount += amount;
            if (balanceSrcAccount < 0) {
                System.out.println("Destination account doesn’t exist or there is not enough money \n" +
                        "in your account.");
            } else {
                srcAccount.updateBalance(balanceSrcAccount);
                destAccount.updateBalance(balanceDestAccount);
                Transaction transactionSrc = new Transaction((amount * -1));
                Transaction transactionDest = new Transaction(amount);
                srcAccount.addTransaction(transactionSrc);
                destAccount.addTransaction(transactionDest);
                System.out.println("Completed");
            }
        } else {
            System.out.println("Destination account doesn’t exist or there is not enough money \n" +
                    "in your account.");
        }
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
