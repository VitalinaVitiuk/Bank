import java.util.ArrayList;
import java.util.Random;

public class App {
    private static final int SIZE = 100;

    public static void main(String[] args) {
        Random random = new Random();

        Account[] accounts = new Account[SIZE];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(random.nextDouble());
        }

        Bank bank = new Bank(accounts);
        System.out.println("BEFORE TRANSACTIONS: bank total is " + bank.findTotal());

        ArrayList<ATM> threads = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            threads.add(new ATM(bank));
            threads.get(i).start();
        }

        System.out.println("AFTER TRANSACTIONS: bank total is " + bank.findTotal());
    }
}
