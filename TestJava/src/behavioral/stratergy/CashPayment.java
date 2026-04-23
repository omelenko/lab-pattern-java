package behavioral.stratergy;

public class CashPayment implements PaymentStrategy {
    public void pay(int amount) { System.out.println("Paid " + amount + " UAH via Cash."); }
}
