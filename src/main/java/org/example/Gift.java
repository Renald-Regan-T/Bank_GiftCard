package org.example;

public class Gift
{
    private int id;
    private int cardNo;
    private int pin;
    private int balance;
    private String type;
    private int point;
    boolean satus;
    public Gift(int id,int cardNo,int pin,int balance,boolean satus)
    {
        this.id=id;
        this.cardNo=cardNo;
        this.pin=pin;
        this.balance=balance;
        this.type="Silver";
        this.point=0;
        this.satus=satus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
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

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public boolean isSatus() {
        return satus;
    }

    public void setSatus(boolean satus) {
        this.satus = satus;
    }
}