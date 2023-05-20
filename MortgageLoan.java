public class MortgageLoan implements Loan {
    private double loanAmount;
    private double interestRate;
    private String paymentSchedule;
    private String property;
    private String loanType;
    private int loanDuration;

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setPaymentSchedule(String paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public void setLoanDuration(int loanDuration) {
        this.loanDuration = loanDuration;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public String getPaymentSchedule() {
        return paymentSchedule;
    }

    public String getProperty() {
        return property;
    }

    @Override
    public String getLoanType() {
        return loanType;
    }

    @Override
    public int getLoanDuration() {
        return loanDuration;
    }

    public boolean isEligibleForPayment() {
        return loanAmount > 0;
    }

    public double calculateMonthlyPayment() {
        return loanAmount * (interestRate / loanDuration);
    }
}
