package behavioral.templateMethod;

public class LatteTemplate extends CoffeeTemplate
{
    @Override
    protected void brew() { System.out.println("Brewing light espresso..."); }
    @Override
    protected void addIngredients() { System.out.println("Adding frothed milk and a little foam."); }
}
