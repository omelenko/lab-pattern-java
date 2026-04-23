package behavioral.templateMethod;

public abstract class CoffeeTemplate
{
    public final void makeCoffee() {
        boilWater();
        brew();
        pourInCup();
        addIngredients();
    }
    abstract void brew();
    abstract void addIngredients();
    void boilWater() { System.out.println("Boiling water..."); }
    void pourInCup() { System.out.println("Pouring into cup..."); }
}
