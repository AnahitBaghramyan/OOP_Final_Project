public class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(int number, double balance, String owner) {
        super(number, balance, owner);
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void depositMoney() {
        if (overdraftLimit > 0) {
            double currentBalance = getBalance();
            System.out.println("Current balance: $" + currentBalance);
        } else {
            System.out.println("Overdraft limit is not set. Deposit not allowed.");
        }
    }

    @Override
    public void withdrawMoney() {
        if (getBalance() > 0 || Math.abs(getBalance()) <= overdraftLimit) {
            double currentBalance = getBalance();
            System.out.println("Current balance: $" + currentBalance);
        } else {
            System.out.println("Insufficient balance. Withdrawal not allowed.");
        }
    }

    @Override
    public void calculateInterest() {
        System.out.println("Calculating interest for CheckingAccount");
        double currentBalance = getBalance();
        System.out.println("Current balance: $" + currentBalance);
    }
}
