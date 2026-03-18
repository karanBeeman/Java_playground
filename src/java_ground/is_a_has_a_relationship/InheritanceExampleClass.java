package java_ground.is_a_has_a_relationship;

// show me an example how inheritance is bad when it leads to tight coupling and violates the Liskov Substitution Principle. using the same PaymentProcessor example, but with a bad design.

class PaymentProcessor {
    public void processPayment(double amount) {
        validatePayment();
        sendPayment(amount);
        sendEmailNotification(amount);
    }

    private void sendEmailNotification(double amount) {
        System.out.println("Sending email notification for payment of $" + amount);
    }

    void sendPayment(double amount) {
        System.out.println("Processing payment of $" + amount);
    }

    void validatePayment() {
        System.out.println("Validating payment...");
    }

}

//class MetroCardPaymentProcessor extends PaymentProcessor {
//
//    public void paymentProcessor(double amount) {
//      processPayment(amount); //
//    } instead of this, we can use composition and have a separate class for MetroCardPaymentProcessor that uses PaymentProcessor as a dependency, which would allow us to avoid the tight coupling and violation of Liskov Substitution Principle.
//}

class DebitCardPaymentProcessor extends PaymentProcessor {
    @Override
    public void processPayment(double amount) {
       validatePayment();
       sendPayment(amount);
       // DebitCardPaymentProcessor does not need to send email notifications, but it's being forced to do so because of the inheritance from PaymentProcessor, which violates Liskov Substitution Principle.
    }
}

class CreditCardPaymentProcessor extends PaymentProcessor {
    @Override
    public void processPayment(double amount) {
       validatePayment();
       sendPayment(amount);
       sendNotification(amount); // This method is specific to CreditCardPaymentProcessor, but it's being called in the base class's processPayment method, which violates Liskov Substitution Principle.
    }

    private void sendNotification(double amount) {
    }
}

// Client code
public class InheritanceExampleClass {
    public static void main(String[] args) {
        PaymentProcessor creditCardProcessor = new CreditCardPaymentProcessor();
        creditCardProcessor.processPayment(100.0); // This will call the overridden processPayment method, which may not be expected by the client code, leading to tight coupling and violation of Liskov Substitution Principle.

    }
}
