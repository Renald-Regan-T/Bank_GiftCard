package org.example;

import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Application app=new Application();

        int choice;
        int amount;
        int id;
        int cardNo;
        int pin;

        app.load_customer();
        //System.out.println("------");

        //app.display_customer_details();
        //System.out.println("----------");

        app.load_card();
        //System.out.println("-------");

        boolean loop=true;
        while(loop)
        {
            System.out.println("Enter a choice:\n1. Add Customer\n2. Add Gift card\n3.Top-Up Gift Card\n4.Closed gift card\n5.Purchase Item\n6.Display\n7.Block Card\n8.Unblock Card\n9.Exit");
            choice=sc.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Enter your balance");
                    amount=sc.nextInt();
                    app.add_customer(amount);
                    break;

                case 2:
                    System.out.println("Enter your id:");
                    id= sc.nextInt();
                    System.out.println("Enter your amount");
                    amount= sc.nextInt();
                    app.add_card(id,amount);
                    break;

                case 3:
                    System.out.println("Enter your id:");
                    id= sc.nextInt();
                    System.out.println("Enter your cardNo");
                    cardNo=sc.nextInt();
                    System.out.println("Enter your amount");
                    amount= sc.nextInt();
                    app.top_up_card(id,cardNo,amount);
                    break;

                case 4:
                    System.out.println("Enter your id:");
                    id= sc.nextInt();
                    System.out.println("Enter your cardNo");
                    cardNo=sc.nextInt();
                    System.out.println("Enter your pin");
                    pin=sc.nextInt();
                    app.closed_card(id,cardNo,pin);
                    break;

                case 5:
                    System.out.println("Enter your id:");
                    id= sc.nextInt();
                    System.out.println("Enter your cardNo");
                    cardNo=sc.nextInt();
                    System.out.println("Enter your pin");
                    pin=sc.nextInt();
                    System.out.println("Enter your amount");
                    amount= sc.nextInt();
                    app.purchase(id,cardNo,pin,amount);
                    break;

                case 6:
                    app.display_customer_details();
                    System.out.println("---------");

                    app.display_card_details();
                    System.out.println("-----------------");

                    app.display_transaction_details();
                    System.out.println("-----------------");
                    break;

                case 7:
                    System.out.println("Enter your id:");
                    id= sc.nextInt();
                    System.out.println("Enter your cardNo");
                    cardNo=sc.nextInt();
                    System.out.println("Enter your pin");
                    pin=sc.nextInt();
                    app.block_card(id,cardNo,pin);
                    break;

                case 8:
                    System.out.println("Enter your id:");
                    id= sc.nextInt();
                    System.out.println("Enter your cardNo");
                    cardNo=sc.nextInt();
                    System.out.println("Enter your pin");
                    pin=sc.nextInt();
                    app.unblock_card(id,cardNo,pin);
                    break;

                case 9:
                    loop=false;
                    break;
            }
        }
    }
}