# 🏦 Bank Simulation Project (Java)

This project is a **console-based Bank Account Simulation** built in Java.
  
It simulates basic ATM/Banking features such as **account creation, login, deposit, withdrawal, balance check, and transaction history** — with **real-time persistent storage**.

## 📌 Features

- **Create Account**
  - Randomly generated **Account Number** (10 digits)
  - Randomly generated **PIN** (4 digits)
  - Select account type (**Savings** or **Current**)
- **Secure Login**
  - Requires account number and PIN
- **Transactions**
  - Deposit money
  - Withdraw money
  - Balance enquiry
- **Transaction History**
  - View **current session** history
  - View **saved transaction file**
  - Auto-loads old transactions from file on login
- **ATM-Style Receipts**
  - Shows masked account number
  - Displays date/time of transaction
- **Persistent Storage**
  - Each account has its own history file: <account_number>_history.txt`

## 📂 Project Structure

BankSimulation/
├── Account.java
├── SavingsAccount.java
├── CurrentAccount.java
├── BankSimulation.java
└── README.md

## ⚙️ Requirements
- Java **8 or later**
- Any Java-compatible IDE or terminal

## 🚀 How to Run
1. **Clone or Download** the project folder.
2. Open in your IDE (e.g., Eclipse, IntelliJ, VS Code) or terminal.
3. Compile: javac BankSimulation.java
4. run : java BankSimulation


## 🖥 Usage Flow
1. **Create a new account**:
   - Enter account holder name
   - Enter initial balance
   - Choose account type (**Savings** / **Current**)
   - System generates **Account Number** and **PIN**
2. **Login** using generated Account Number and PIN.
3. **Choose Menu Options**:
   1. Deposit
   2. Withdraw
   3. Show Balance
   4. Show Transaction History (Current Session)
   5. View Saved Transaction File
   0. Exit
4. **Perform transactions** and see instant **ATM-style receipts**.
5. **Transaction files** are saved as:  
   <account_number>_history.txt
   
## Sample Console Outputs:

 Welcome to the Bank Account Simulation
Enter Account Holder Name: Bylapudi Kiran
Enter Initial Balance: 4000
Enter Account Type (Savings/Current): Savings

 Account created successfully!
 Your Account Number: 1545498288
 Your PIN: 2648
 Account Type: Savings
 Please note down your details for login.

*** Login ***
Enter Account Number: 1545498288
Enter PIN:  2648
 Login successful!

***** BANK MENU *****
1. Deposit
2. Withdraw
3. Show Balance
4. Show Transaction History (Current Session)
5. View Saved Transaction File
0. Exit
Enter choice: 1
Enter amount to deposit:  400

***** Transaction Receipt *****
Transaction Type : Deposit
Amount Deposited : ₹400.0
Account Number   : XXXXXX8288
Updated Balance  : ₹4400.0
Date/Time        : 11-Aug-2025  03:07 pm
Thank you for using our ATM/Bank!
******************************


***** BANK MENU *****
1. Deposit
2. Withdraw
3. Show Balance
4. Show Transaction History (Current Session)
5. View Saved Transaction File
0. Exit
Enter choice: 3
 Current balance: ₹4400.0

***** BANK MENU *****
1. Deposit
2. Withdraw
3. Show Balance
4. Show Transaction History (Current Session)
5. View Saved Transaction File
0. Exit
Enter choice: 2
Enter amount to withdraw: 200

***** Transaction Receipt *****
Transaction Type : Withdrawal
Amount Withdrawn : ₹200.0
Account Number   : XXXXXX8288
Updated Balance  : ₹4200.0
Date/Time        : 11-Aug-2025  03:08 pm
Thank you for using our ATM/Bank!
******************************


***** BANK MENU *****
1. Deposit
2. Withdraw
3. Show Balance
4. Show Transaction History (Current Session)
5. View Saved Transaction File
0. Exit
Enter choice: 4

 Transaction History:
Account created with balance: ₹4000.0
Deposited: ₹400.0
Withdrew: ₹200.0

***** BANK MENU *****
1. Deposit
2. Withdraw
3. Show Balance
4. Show Transaction History (Current Session)
5. View Saved Transaction File
0. Exit
Enter choice: 5

 Saved Transactions from File:
Account created with balance: ₹4000.0

***** Transaction Receipt *****
Transaction Type : Deposit
Amount Deposited : ₹400.0
Account Number   : XXXXXX8288
Updated Balance  : ₹4400.0
Date/Time        : 11-Aug-2025  03:07 pm
Thank you for using our ATM/Bank!
******************************


***** Transaction Receipt *****
Transaction Type : Withdrawal
Amount Withdrawn : ₹200.0
Account Number   : XXXXXX8288
Updated Balance  : ₹4200.0
Date/Time        : 11-Aug-2025  03:08 pm
Thank you for using our ATM/Bank!
******************************


***** BANK MENU *****
1. Deposit
2. Withdraw
3. Show Balance
4. Show Transaction History (Current Session)
5. View Saved Transaction File
0. Exit
Enter choice: 0
 Thank you for using the banking system!
 
 ## 📜 Example Transaction Receipt
 
 ***** Transaction Receipt *****
Transaction Type : Deposit
Amount Deposited : ₹400.0
Account Number   : XXXXXX8288
Updated Balance  : ₹4400.0
Date/Time        : 11-Aug-2025  03:07 pm
Thank you for using our ATM/Bank!
******************************
 
 ## 🛠 Future Enhancements
 
- Multiple account storage and retrieval from a database
- Transfer between accounts
- PIN change option
- GUI-based version
   

