package behavioral.stratergy;

public class CardPayment implements PaymentStrategy {
    public void pay(int amount) { System.out.println("Paid " + amount + " UAH via Card."); }
}
