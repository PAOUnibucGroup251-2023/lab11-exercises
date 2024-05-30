package mockExtSystems;

import paymentSystem.externalSystems.BankSystem;

public class MockBankSystem implements BankSystem {
    @Override
    public boolean processPayment(double amount) {
        // Simulate successful payment for positive amounts
        return amount > 0;
    }
}

