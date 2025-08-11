package elevatelabs_task5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Account {
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;
    protected int pin;
    protected String accountType;
    protected List<String> transactionHistory;

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MMM-yyyy  hh:mm a");

    public Account(String accountNumber, String accountHolder, double initialBalance, int pin, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.pin = pin;
        this.accountType = accountType;
        this.transactionHistory = new ArrayList<>();

        // Load previous history from file (if exists)
        loadFromFile();

        transactionHistory.add("Account created with balance: ₹" + initialBalance);
        saveToFile("Account created with balance: ₹" + initialBalance);
    }

    public int getPin() {
        return pin;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: ₹" + amount);
            String receipt = printReceipt("Deposit", amount, balance);
            saveToFile(receipt);
        } else {
            System.out.println(" Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: ₹" + amount);
            String receipt = printReceipt("Withdrawal", amount, balance);
            saveToFile(receipt);
        } else {
            System.out.println(" Insufficient balance or invalid amount.");
        }
    }

    private String printReceipt(String type, double amount, double updatedBalance) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n***** Transaction Receipt *****\n");
        sb.append("Transaction Type : ").append(type).append("\n");
        sb.append("Amount ").append(type.equals("Deposit") ? "Deposited" : "Withdrawn")
          .append(" : ₹").append(amount).append("\n");
        sb.append("Account Number   : ").append(maskAccountNumber(accountNumber)).append("\n");
        sb.append("Updated Balance  : ₹").append(updatedBalance).append("\n");
        sb.append("Date/Time        : ").append(LocalDateTime.now().format(FORMATTER)).append("\n");
        sb.append("Thank you for using our ATM/Bank!\n");
        sb.append("******************************\n");

        System.out.println(sb.toString());
        return sb.toString();
    }

    private String maskAccountNumber(String accNo) {
        if (accNo.length() <= 4) return accNo;
        String last4 = accNo.substring(accNo.length() - 4);
        return "XXXXXX" + last4;
    }

    public void showBalance() {
        System.out.println(" Current balance: ₹" + balance);
    }

    public void showTransactionHistory() {
        System.out.println("\n Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public void viewSavedTransactionFile() {
        String fileName = accountNumber + "_history.txt";
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println(" No saved transactions found for this account.");
            return;
        }

        System.out.println("\n Saved Transactions from File:");
        try (Scanner fileReader = new Scanner(file)) {
            while (fileReader.hasNextLine()) {
                System.out.println(fileReader.nextLine());
            }
        } catch (IOException e) {
            System.out.println(" Error reading transaction file: " + e.getMessage());
        }
    }

    private void saveToFile(String data) {
        String fileName = accountNumber + "_history.txt";
        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.write(data + "\n");
        } catch (IOException e) {
            System.out.println(" Error saving transaction to file: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        String fileName = accountNumber + "_history.txt";
        File file = new File(fileName);
        if (!file.exists()) return;

        try (Scanner fileReader = new Scanner(file)) {
            while (fileReader.hasNextLine()) {
                transactionHistory.add(fileReader.nextLine());
            }
        } catch (IOException e) {
            System.out.println(" Error loading previous transactions: " + e.getMessage());
        }
    }
}

