package structural.bridge;

public class PremiumOrder extends CoffeeOrder
{
    public PremiumOrder(BrewingProcess p) { super(p); }
    public void make() { System.out.print("Premium style: "); process.brew(); }
}
