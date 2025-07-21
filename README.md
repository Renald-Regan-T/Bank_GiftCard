Your **Gift Card Management System** is a **Java console-based application** that simulates how customers use gift cards to make purchases, manage balances, and handle transactions.

---

## ✅ **Project Overview**

This system allows:

1. **Customers** to register and create gift cards.
2. **Top-up** and **close** gift cards.
3. **Purchase items** using gift cards.
4. **Block/Unblock** gift cards.
5. View **Customer**, **Card**, and **Transaction** details.

---

## ✅ **Main Features**

* Add customers and assign a unique ID.
* Issue multiple gift cards per customer.
* Track and upgrade gift cards based on reward points.
* Record all top-ups and purchases in a transaction log.
* Enable or disable cards (block/unblock/close).
* Display full details of all operations.

---

## ✅ **Class Diagram**

Here’s a UML-style **class diagram** to show the relationships among classes:

```
+----------------+        1       *        +--------------+
|   Application  |------------------------>|   Customer   |
+----------------+                         +--------------+
| - customerMap  |                         | - id         |
| - generators   |                         | - balance    |
|                |                         | - blockCard  |
| +load_customer()                         | - card       |
| +load_card()                             | - transactionMap |
| +add_customer()                          +--------------+
| +add_card()                                          |
| +top_up_card()                                       | 1
| +closed_card()                                       |      *
| +purchase()                                          v
| +block_card()                                +---------------+
| +unblock_card()                              |     Gift      |
| +display_customer_details()                  +---------------+
| +display_card_details()                      | - id          |
| +display_transaction_details()               | - cardNo      |
+----------------+                             | - pin         |
                                               | - balance     |
                                               | - status      |
                                               | - point       |
                                               | - type        |
                                               +---------------+

            *                                           1
            +---------------------------------------->+
            |                                         |
            v                                         |
    +----------------+                               |
    |  Transaction   |<-------------------------------+
    +----------------+
    | - tid          |
    | - cardNo       |
    | - balance      |
    | - type         |
    +----------------+
```

---

## ✅ **Class Responsibilities Summary**

### 1. **Main**

* Handles user input and interacts with `Application` class to perform operations.

### 2. **Application**

* Business logic layer.
* Maintains a map of all customers.
* Handles card and transaction creation.
* Authenticates actions using card number and PIN.
* Handles display logic.

### 3. **Customer**

* Represents a customer with:

  * ID and balance.
  * A list of blocked cards.
  * Maps of `Gift` cards and `Transaction` logs.

### 4. **Gift**

* Represents a gift card with:

  * Card number, PIN, balance.
  * Status (active/closed).
  * Type (Silver, Gold, Platinum).
  * Reward points.

### 5. **Transaction**

* Represents a transaction with:

  * ID, associated card number.
  * Amount and type (Top-up, Purchase, etc.).

---

## ✅ **Gift Card Reward System**

* Earn **50 points** per **₹500** spent.
* On reaching **200 points**, the card type upgrades:

  * Silver → Gold → Platinum.

---

## ✅ **Suggestions for README (GitHub)**

Include the following in your `README.md`:

### Project Title

**Gift Card Management System**

### Description

A console-based Java application to simulate a real-world gift card management system including customer registration, card issuance, transactions, and card upgrades.

### Features

* Customer registration
* Issue and top-up gift cards
* Reward points & card upgrades
* View customer/card/transaction details
* Card block/unblock/close functionality

### Tech Stack

* Java (Core)
* Collections (Map, HashMap, TreeMap, Set)

### How to Run

```
javac Main.java
java Main
```
