package elevatelabs_task5;

public class CurrentAccount extends Account {
    public CurrentAccount(String accountNumber, String accountHolder, double initialBalance, int pin) {
        super(accountNumber, accountHolder, initialBalance, pin, "Current");
    }
}

