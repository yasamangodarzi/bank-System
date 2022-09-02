package com.company;

import java.util.UUID;
import java.util.ArrayList;

public class Account {
    private final UUID serial;
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String type;
    private int balance;
    private final ArrayList<Transaction> transactions;


    public Account(String id, String firstName, String lastName, String type, int balance) {
        serial = UUID.randomUUID();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.balance = balance;
        transactions = new ArrayList<>();

    }

    public void updateBalance(int amount) {
        balance = amount;
    }

    public int getBalance() {
        return balance;
    }

    public void addTransaction(Transaction trans) {
        transactions.add(trans);
    }

    public String getId() {
        return id;
    }

    public UUID getSerial() {
        return serial;
    }

    public void printAccountData() {
        System.out.println("serial=" + serial +
                ", id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                '}');
    }

}
