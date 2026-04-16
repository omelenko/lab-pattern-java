package structural.adapter;

public class CoffeeAdapter implements OldOrderSystem
{
    private entity.Coffee coffee;

    public CoffeeAdapter(entity.Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public void processOrder(String coffeeData) {
        String adaptedData = "Order: " + coffee.getClass().getSimpleName();
        System.out.println("Adapter: Sending to old system: " + adaptedData);
    }
}
