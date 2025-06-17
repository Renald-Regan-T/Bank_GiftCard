package org.example;
import java.util.*;
public class Application
{
    private int id_generater_customer=0;
    private int id_generater_card=0;
    private int id_generater_transaction=0;

    private Map<Integer,Customer>customerMap=new HashMap<>();

    public void load_customer()
    {
            add_customer(++id_generater_customer,10000);
            add_customer(++id_generater_customer,20000);
            add_customer(++id_generater_customer,30000);
    }

    public void add_customer(int balance)
    {
        add_customer(++id_generater_customer,balance);
    }

    public void add_customer(int id,int balance)
    {
        Customer customer=new Customer(id,balance);
        this.customerMap.put(id,customer);
        System.out.println("Your account is suucessfuly create and your id:"+id);
    }

    public void load_card()
    {
        add_card(1,++id_generater_card,1111,2500);
        add_card(1,++id_generater_card,2222,2500);
        add_card(2,++id_generater_card,3333,5000);
        add_card(3,++id_generater_card,1234,0);
    }

    public void add_card(int id,int amount)
    {
        add_card(id,++id_generater_card,id_generater_card*1001,amount);
    }

    public void add_card(int id,int cardNo,int pin,int balance)
    {
        if(balance>0 && ishave_balance(id,balance))
        {

            Gift card=new Gift(id,cardNo,pin,balance,true);
            Customer customer= this.customerMap.get(id);
            customer.card.put(cardNo,card);
            customer.setBalance(customer.getBalance() - balance);
            Transaction transaction=new Transaction(++id_generater_transaction,cardNo,balance,"initial amount");
            customer.transactionMap.put(id_generater_transaction,transaction);
            System.out.println("your card is successfully generate \nyour cardNo: "+cardNo+"\nyour pin: "+pin);

        }
        else
        {
            Gift card=new Gift(id,cardNo,pin,0,false);
            Customer customer= this.customerMap.get(id);
            customer.card.put(cardNo,card);
            System.out.println("Insufficient balance or invalid amount");
        }
    }

    public boolean ishave_balance(int id,int balance)
    {
        return this.customerMap.get(id).getBalance() >= balance;
    }

    public void top_up_card(int id,int cardNo,int amount)
    {
        Customer customer=this.customerMap.get(id);
        if(customer!=null && customer.getBalance()>=amount)
        {
            Gift card= customer.card.get(cardNo);
            if(card!=null)
            {
                card.setBalance(card.getBalance()+amount);
                customer.setBalance(customer.getBalance() - amount);
                Transaction transaction=new Transaction(++id_generater_transaction,cardNo,amount,"Top-Up Card");
                customer.transactionMap.put(id_generater_transaction,transaction);
                System.out.println("Successfully top up completed "+card.getBalance());
            }
            else
            {
                System.out.println("Create a Gift card");
            }
        }
        else
        {
            System.out.println("Insufficent ammount....t");
        }
    }

    public void closed_card(int id,int cardNo,int pin)
    {
        if(Authentication(id,cardNo,pin))
        {
            Customer customer=this.customerMap.get(id);
            Gift card=customer.card.get(cardNo);
            customer.setBalance(customer.getBalance() + card.getBalance());
            card.setBalance(0);
            card.setSatus(false);
            System.out.println("Successfully card is closed and current balance is :"+customer.getBalance());
        }
        else
            System.out.println("Authentication failed!!!....c");
    }

    public void purchase(int id,int cardNo,int pin,int amount)
    {
        if(Authentication(id,cardNo,pin))
        {
            Gift card=this.customerMap.get(id).card.get(cardNo);
            if(card.getBalance() >= amount && !this.customerMap.get(id).blockCard.contains(cardNo))
            {
                card.setPoint(card.getPoint()+(amount/500 * 50));
                if(card.getPoint()>=200)
                {
                    card.setPoint(0);
                    card.setType(upgrade(card.getType()));
                }
                Transaction transaction=new Transaction(++id_generater_transaction,cardNo,amount,"Purchase Item");
                this.customerMap.get(id).transactionMap.put(id_generater_transaction,transaction);
                card.setBalance(card.getBalance() - amount);
            }
            else
                System.out.println("Insufficeint amount...p or block the card");
        }
    }

    public String upgrade(String s)
    {
        if(s.equals("Silver"))
            return "Gold";
        return "Platinum";
    }

    public void block_card(int id,int cardNo,int pin)
    {
        if(Authentication(id,cardNo,pin))
        {
            Customer customer=this.customerMap.get(id);
            customer.blockCard.add(cardNo);
        }
        else
            System.out.println("Invalid pin...b");
    }

    public void unblock_card(int id,int cardNo,int pin)
    {
        if(Authentication(id,cardNo,pin))
        {
            Customer customer=this.customerMap.get(id);
            customer.blockCard.remove(cardNo);
        }
        else
            System.out.println("Invalid pin...ub");
    }

    public boolean Authentication(int id,int cardNo,int pin)
    {
        Customer customer=this.customerMap.get(id);
        if(customer==null)
        {
            System.out.println("Customer not found");
            return false;
        }
        Gift card=customer.card.get(cardNo);
        if(card==null)
        {
            System.out.println("Gift card not found");
            return false;
        }
        if(card.getPin() != pin)
        {
            System.out.println("Invalid pin");
            return false;
        }
        return true;
    }

    public Map<Integer, Customer> getCustomerMap() {
        return customerMap;
    }

    public void display_customer_details()
    {
        System.out.println("Customer details......\nCustomer Id     Balance");
        for(Integer i:this.customerMap.keySet())
        {
            Customer customer=this.customerMap.get(i);
            System.out.println(customer.getId()+" "+customer.getBalance());
        }
    }

    public void display_card_details()
    {
        System.out.println("Card Details.....\nCustomer Id    Gift CardNo    Pin    Balance    Status");
        for(Integer i:this.customerMap.keySet())
        {
            Customer customer=this.customerMap.get(i);
            for(Integer j:customer.card.keySet())
            {
                Gift card=customer.card.get(j);
                System.out.println(card.getType()+" "+card.getId()+" "+card.getCardNo()+" "+card.getPin()+" "+card.getBalance()+" "+(card.isSatus()?"Active":"Closed"));
            }
        }
    }

    public void display_transaction_details()
    {
        System.out.println("Transaction Details....\nTransactionId   Gift CardNo  Amount  Type ");
        for(int i:this.customerMap.keySet())
        {
            Customer customer=this.customerMap.get(i);
            for(int j:customer.transactionMap.keySet())
            {
                Transaction transaction=customer.transactionMap.get(j);
                System.out.println(transaction.getTid()+" "+transaction.getCardNo()+" "+transaction.getBalance()+" "+transaction.getType());
            }
        }
    }
}
