package paymentSystem;

import org.junit.jupiter.api.Test;
import paymentSystem.externalSystems.BankSystem;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PaymentAppTest {

    @Test
    public void testPaymentSuccess() {
        // Create a mock bank system
        BankSystem mockBankSystem = mock(BankSystem.class);
        when(mockBankSystem.processPayment(anyDouble())).thenReturn(true);

        // Create PaymentApp instance with the mock bank system
        PaymentApp paymentApp = new PaymentApp(mockBankSystem);

        // Test payment success
        String result = paymentApp.processPayment(100.0);
        assertEquals("Payment successful", result);
    }

    @Test
    public void testPaymentFailure() {
        // Create a mock bank system
        BankSystem mockBankSystem = mock(BankSystem.class);
        when(mockBankSystem.processPayment(anyDouble())).thenReturn(false);

        // Create PaymentApp instance with the mock bank system
        PaymentApp paymentApp = new PaymentApp(mockBankSystem);

        // Test payment failure
        String result = paymentApp.processPayment(-100.0); // Negative amount to simulate failure
        assertEquals("Payment failed", result);
    }
}
