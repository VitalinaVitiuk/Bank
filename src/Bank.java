import java.util.concurrent.TimeUnit;

public class Bank {
    private double total;
    private Account[] accounts;

    public Bank(Account[] accounts) {
        this.accounts = accounts;
    }

    public void transfer(Account from, Account to, double amount) {
        try {
            if (from.semaphore.tryAcquire(1, 100, TimeUnit.MILLISECONDS) &&
                    to.semaphore.tryAcquire(1, 100, TimeUnit.MILLISECONDS)) {
                if (from.getBalance() >= amount) {
                    from.withdraw(amount);
                    to.deposit(amount);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            from.semaphore.release();
            to.semaphore.release();
        }
    }

    public double findTotal() {
        total = 0;
        for (int i = 0; i < accounts.length; i++) {
            total += accounts[i].getBalance();
        }
        return total;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

}
