package design_pattern.statergy;


/**
 * Payment using strategy pattern, different type paypal, credit card, crypto
 */
public class PaymentStrategy {

    private final IPaymentStrategy paymentStrategy;

    public PaymentStrategy(IPaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void makePayment(double amount) {
        if (paymentStrategy != null) {
            paymentStrategy.pay(amount);
        } else {
            System.out.println("No payment strategy selected.");
        }
    }

    public static void main(String[] args) {
        PaymentStrategy paymentStrategy = new PaymentStrategy(new CreditCardPayment("123-123-123-123"));
        paymentStrategy.makePayment(12.9);

        PaymentStrategy paypalStrategy = new PaymentStrategy(new PayPalPayment("ray@paypal"));
        paypalStrategy.makePayment(1);

        PaymentStrategy cryptoStrategy = new PaymentStrategy(new CryptoPayment("8999.999.89999"));
        cryptoStrategy.makePayment(2.2);

    }
}


class CreditCardPayment implements IPaymentStrategy {
    private final String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card: " + cardNumber);
    }
}

class PayPalPayment implements IPaymentStrategy {
    final private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal: " + email);
    }
}

class CryptoPayment implements IPaymentStrategy {
    final private String walletAddress;

    public CryptoPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Cryptocurrency: " + walletAddress);
    }
}

interface IPaymentStrategy {
    void pay(double amount);
}
