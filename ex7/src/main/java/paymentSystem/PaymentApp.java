package paymentSystem;

import paymentSystem.externalSystems.BankSystem;

public class PaymentApp {
    private BankSystem bankSystem;

    // Constructor
    public PaymentApp(BankSystem bankSystem) {
        this.bankSystem = bankSystem;
    }

    // Method to process a payment
    public String processPayment(double amount) {
        // Assume communication with bank system
        boolean paymentSuccessful = bankSystem.processPayment(amount);

        // Return response based on payment status
        if (paymentSuccessful) {
            return "Payment successful";
        } else {
            return "Payment failed";
        }
    }
}

