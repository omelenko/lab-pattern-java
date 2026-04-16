package structural.decorator;

public class CinnamonDecorator extends CoffeeDecorator
{
    public CinnamonDecorator(entity.Coffee coffee) { super(coffee); }

    @Override
    public void info()
    {
        decoratedCoffee.info();
        System.out.println(" + Extra: Cinnamon");
    }
}
