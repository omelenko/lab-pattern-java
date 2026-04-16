package creational;

import entity.*;

public class CoffeeAbstractFactory
{
    public CoffeeFactory getCoffeeFactory(CoffeeType type)
    {
        switch(type)
        {
            case latte:
                return new LatteFactory();
            case espresso:
                return new EspressoFactory();
            default:
                throw new IllegalArgumentException("Unknown coffee type: " + type);
        }
    }

    public abstract class CoffeeFactory
    {
        public abstract Coffee getCoffee(int sugar, String syrup);
    }

    public class LatteFactory extends CoffeeFactory
    {
        @Override
        public Coffee getCoffee(int sugar, String syrup) {
            Latte myCoffee = new Latte();
            myCoffee.setSugar(sugar);
            myCoffee.setSyrup(syrup);
            return myCoffee;
        }
    }

    public class EspressoFactory extends CoffeeFactory
    {
        @Override
        public Coffee getCoffee(int sugar, String syrup) {
            Espresso myCoffee = new Espresso();
            myCoffee.setSugar(sugar);
            myCoffee.setSyrup(syrup);
            return myCoffee;
        }
    }
}
