package elevatelabs_task5;

import java.security.SecureRandom;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankSimulation {

    private static String generateAccountNumber() {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    private static int generatePIN() {
        SecureRandom random = new SecureRandom();
        return 1000 + random.nextInt(9000);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account = null;

        try {
            System.out.println(" Welcome to the Bank Account Simulation");

            System.out.print("Enter Account Holder Name: ");
            String name = sc.nextLine();

            double initialBalance = 0;
            while (true) {
                try {
                    System.out.print("Enter Initial Balance: ");
                    initialBalance = sc.nextDouble();
                    if (initialBalance < 0) throw new IllegalArgumentException("Balance cannot be negative.");
                    break;
                } catch (InputMismatchException e) {
                    System.out.println(" Please enter a valid number.");
                    sc.nextLine();
                } catch (IllegalArgumentException e) {
                    System.out.println("Error " + e.getMessage());
                }
            }

            sc.nextLine();

            String accType = "";
            while (true) {
                System.out.print("Enter Account Type (Savings/Current): ");
                accType = sc.nextLine().trim().toLowerCase();
                if (accType.equals("savings") || accType.equals("current")) break;
                else System.out.println(" Please enter either 'Savings' or 'Current'.");
            }

            String accNo = generateAccountNumber();
            int pin = generatePIN();

            if (accType.equals("savings")) {
                account = new SavingsAccount(accNo, name, initialBalance, pin);
            } else {
                account = new CurrentAccount(accNo, name, initialBalance, pin);
            }

            System.out.println("\n Account created successfully!");
            System.out.println(" Your Account Number: " + account.getAccountNumber());
            System.out.println(" Your PIN: " + account.getPin());
            System.out.println(" Account Type: " + account.getAccountType());
            System.out.println(" Please note down your details for login.\n");

        } catch (Exception e) {
            System.out.println(" Error creating account: " + e.getMessage());
            sc.close();
            return;
        }

        System.out.println("*** Login ***");
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.print("Enter Account Number: ");
            String enteredAcc = sc.next();
            System.out.print("Enter PIN: ");
            int enteredPin = sc.nextInt();

            if (enteredAcc.equals(account.getAccountNumber()) && enteredPin == account.getPin()) {
                System.out.println(" Login successful!");
                loggedIn = true;
            } else {
                System.out.println(" Invalid account number or PIN. Try again.");
            }
        }

        while (true) {
            try {
                System.out.println("\n***** BANK MENU *****");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Show Balance");
                System.out.println("4. Show Transaction History (Current Session)");
                System.out.println("5. View Saved Transaction File");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        account.deposit(sc.nextDouble());
                        break;

                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        account.withdraw(sc.nextDouble());
                        break;

                    case 3:
                        account.showBalance();
                        break;

                    case 4:
                        account.showTransactionHistory();
                        break;

                    case 5:
                        account.viewSavedTransactionFile();
                        break;

                    case 0:
                        System.out.println(" Thank you for using the banking system!");
                        sc.close();
                        return;

                    default:
                        System.out.println(" Invalid choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println(" Invalid input! Please enter a valid number.");
                sc.nextLine();
            }
        }
    }
}

