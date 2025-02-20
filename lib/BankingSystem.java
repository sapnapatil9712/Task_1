import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private int balance;
    private final Lock lock = new ReentrantLock();

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public void withdraw(int amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                System.out.println(Thread.currentThread().getName() + " withdrawing " + amount);
                Thread.sleep(100); // Simulating processing delay
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " new balance: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " attempted to withdraw " + amount + " but insufficient funds!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public int getBalance() {
        return balance;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500);
        int[] withdrawalAmounts = {100, 200, 150, 50, 75, 125};
        
        Thread[] threads = new Thread[withdrawalAmounts.length];
        
        for (int i = 0; i < withdrawalAmounts.length; i++) {
            int amount = withdrawalAmounts[i];
            threads[i] = new Thread(() -> account.withdraw(amount));
            threads[i].start();
        }
        
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("Final account balance: " + account.getBalance());
    }
}
