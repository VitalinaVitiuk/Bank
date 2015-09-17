import java.util.Random;

public class ATM extends Thread {
    private Bank bank;
    Random random = new Random();

    public ATM(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        Account[]  accounts = bank.getAccounts();
        int accountsNumber = accounts.length;
        Account from = accounts[(random.nextInt(accountsNumber))];
        Account to = accounts[(random.nextInt(accountsNumber))];
        bank.transfer(from, to, random.nextDouble());
    }
}
