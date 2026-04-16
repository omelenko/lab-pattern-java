package structural.bridge;

public abstract class CoffeeOrder
{
    protected BrewingProcess process;
    public CoffeeOrder(BrewingProcess process) { this.process = process; }
    public abstract void make();
}
