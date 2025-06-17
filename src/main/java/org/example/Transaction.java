package org.example;

public class Transaction
{
    private int tid;
    private int cardNo;
    private int balance;
    private String type;

    public Transaction(int tid,int cardNo,int balance,String type)
    {
        this.tid=tid;
        this.type=type;
        this.cardNo=cardNo;
        this.balance=balance;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
