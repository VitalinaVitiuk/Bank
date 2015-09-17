import java.util.concurrent.Semaphore;

public class Account {
    private Double balance;
    public Semaphore semaphore;

    public Account(double sum) {
        this.balance = sum;
        semaphore=new Semaphore(1);
    }

    public void withdraw(double amount)  {
        balance -= amount;
    }

    public void deposit(double amount) {
            balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}
