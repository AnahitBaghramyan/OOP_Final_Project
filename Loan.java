public interface Loan {
    double getLoanAmount();
    double getInterestRate();
    String getPaymentSchedule();

    String getLoanType();
    int getLoanDuration();
}
