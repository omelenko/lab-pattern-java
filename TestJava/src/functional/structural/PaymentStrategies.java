package functional.structural;

public class PaymentStrategies {
    public static final PaymentStrategy CARD = amount ->
            System.out.println("Paid " + amount + " UAH via card");

    public static final PaymentStrategy CASH = amount ->
            System.out.println("Paid " + amount + " UAH via Cash.");

    public static final PaymentStrategy APPLE_PAY = amount ->
            System.out.println("Paid " + amount + " UAH via Apple Pay.");
}
