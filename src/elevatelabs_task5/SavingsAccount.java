package elevatelabs_task5;

public class SavingsAccount extends Account {
    public SavingsAccount(String accountNumber, String accountHolder, double initialBalance, int pin) {
        super(accountNumber, accountHolder, initialBalance, pin, "Savings");
    }
}

