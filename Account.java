public abstract class Account {
    private int number;
    private double balance;
    private String owner;
    private double interestRate;

    public Account(int number, double balance, String owner) {
        this.number = number;
        this.balance = balance;
        this.owner = owner;
    }

    public Account(String accountNumber, double balance, String accountOwner) {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void depositMoney(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
        System.out.println("Current balance: $" + balance);
    }

    public boolean withdrawMoney(double amount) {
        if (balance < amount) {
            System.out.println("Insufficient balance.");
            return false;
        }
        balance -= amount;
        System.out.println("Withdrawn: $" + amount);
        System.out.println("Current balance: $" + balance);
        return true;
    }

    public abstract void depositMoney();

    public abstract void withdrawMoney();

    public double getCurrentBalance() {
        return balance;
    }

    public abstract void calculateInterest();

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}