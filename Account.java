package com.company;
import java.util.UUID;
import java.util.ArrayList;

public class Account
{
   private UUID serial;
   private String id;
   private String firstName;
   private String lastName;
   private String type;
   private int balance;
   private ArrayList<Transaction> transactions;


    public Account(String id, String firstName, String lastName, String type, int balance) {
        serial=UUID.randomUUID();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.balance = balance;
        transactions=new ArrayList<>();

    }
    public void updateBalance(int amount)
    {
        balance=amount;
    }
    public int getBalance() {
        return balance;
    }
    public void addTransaction(Transaction trans)
    {
        transactions.add(trans);
    }

    public String getId() {
        return id;
    }

    public void printTransactions()
    {
        int i=1;
        for (Transaction str : transactions)
        {
            System.out.print("Transaction " + i +":");
            str.print();
            i++;
        }
    }

    public UUID getSerial() {
        return serial;
    }

    public void printAccountData()
    {
        System.out.println("serial=" + serial +
                ", type='" + type + '\'' +
                ", balance=" + balance );
    }

}
