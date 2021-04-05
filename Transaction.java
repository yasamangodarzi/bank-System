package com.company;
import java.util.Date;

public final class Transaction
{
    private final int amount;
    private final Date date;

    public Transaction(int amount)
    {
        this.amount = amount;
          date = new Date();

    }
    public void print ( )
    {
        System.out.println( " amount = " + amount + " date = " + date);
    }

}
