public class PersonalLoan implements Loan {
    private double loanAmount;
    private double interestRate;
    private String paymentSchedule;
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

    public double getLoanAmount() {
        return loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public String getPaymentSchedule() {
        return paymentSchedule;
    }

    @Override
    public String getLoanType() {
        return loanType;
    }

    @Override
    public int getLoanDuration() {
        return loanDuration;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public void setLoanDuration(int loanDuration) {
        this.loanDuration = loanDuration;
    }

    public boolean isEligibleForLoan() {
        return loanAmount > 0 && interestRate >= 3.5 && interestRate <= 10.0;
    }

    public double calculateInterest() {
        return loanAmount * (interestRate / 100);
    }
}
