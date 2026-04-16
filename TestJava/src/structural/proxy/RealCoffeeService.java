package structural.proxy;

public class RealCoffeeService implements CoffeeService
{
    public void makeCoffee() { System.out.println("Real machine making coffee..."); }
}
