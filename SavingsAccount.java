public class SavingsAccount extends Account {
    private double interestRate;
    private int compoundingPeriod;

    public SavingsAccount(int number, double balance, String owner) {
        super(number, balance, owner);
    }

    @Override
    public void depositMoney() {
        if (interestRate > 0) {
            double currentBalance = getBalance();
            System.out.println("Current balance: $" + currentBalance);
        } else {
            System.out.println("Interest rate is not set. Deposit not allowed.");
        }
    }

    @Override
    public void withdrawMoney() {
        if (getBalance() > 0) {
            double currentBalance = getBalance();
            System.out.println("Current balance: $" + currentBalance);
        } else {
            System.out.println("Insufficient balance. Withdrawal not allowed.");
        }
    }

    @Override
    public void calculateInterest() {
        System.out.println("Calculating interest for SavingsAccount");
        if (interestRate > 0 && compoundingPeriod > 0) {
            double interestAmount = getBalance() * (interestRate / 100) * compoundingPeriod;
            System.out.println("Interest amount: $" + interestAmount);
        } else {
            System.out.println("Interest rate or compounding period is not set. Cannot calculate interest.");
        }
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getCompoundingPeriod() {
        return compoundingPeriod;
    }

    public void setCompoundingPeriod(int compoundingPeriod) {
        this.compoundingPeriod = compoundingPeriod;
    }
}
