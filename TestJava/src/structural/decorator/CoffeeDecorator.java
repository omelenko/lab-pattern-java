package structural.decorator;

public abstract class CoffeeDecorator extends entity.Coffee
{
    protected entity.Coffee decoratedCoffee;
    public CoffeeDecorator(entity.Coffee coffee) { this.decoratedCoffee = coffee; }
}

