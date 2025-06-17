package org.example;
import java.util.*;
public class Customer
{
    private int id;
    private int balance;
    Set<Integer>blockCard;
    Map<Integer,Gift>card;
    Map<Integer,Transaction>transactionMap;

    public Customer(int id,int balance)
    {
        this.id=id;
        this.balance=balance;
        this.blockCard=new HashSet<>();
        this.card=new HashMap<>();
        this.transactionMap=new TreeMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}
