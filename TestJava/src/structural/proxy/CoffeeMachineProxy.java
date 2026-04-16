package structural.proxy;

public class CoffeeMachineProxy implements CoffeeService
{
    private RealCoffeeService realService;
    private boolean hasWater = true;

    @Override
    public void makeCoffee() {
        if (hasWater) {
            if (realService == null) realService = new RealCoffeeService();
            realService.makeCoffee();
        } else {
            System.out.println("Proxy: No water! Refill needed.");
        }
    }
}
