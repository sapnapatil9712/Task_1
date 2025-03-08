public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
}
public String getAccountNumber() {
    return accountNumber;
}
public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
}
public String getAccountHolder() {
    return accountHolder;
}
public void setAccountHolder(String accountHolder) {
    this.accountHolder = accountHolder;
}
public double getBalance() {
    return balance;
}
public void setBalance(double balance) {
    if (balance >= 0) {  
        this.balance = balance;
    } else {
        System.out.println("Balance cannot be negative.");
    }
}
public void deposit(double amount) {
    if (amount > 0) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    } else {
        System.out.println("Deposit amount must be positive.");
    }
}
public void withdraw(double amount) {
    if (amount > 0 && amount <= balance) {
        balance -= amount;
        System.out.println("Withdrew: " + amount);
    } else {
        System.out.println("Insufficient balance or invalid withdrawal amount.");
    }
}
}

public class Main {
    public static void main(String[] args) {
    BankAccount account1 = new BankAccount("123456789", "Sapna", 10987.00);


    System.out.println("Account Number: " + account1.getAccountNumber());
    System.out.println("Account Holder: " + account1.getAccountHolder());
    System.out.println("Balance: " + account1.getBalance());

    account1.deposit(500.00);
    account1.withdraw(200.00);
    System.out.println("Updated Balance: " + account1.getBalance());
}


}
