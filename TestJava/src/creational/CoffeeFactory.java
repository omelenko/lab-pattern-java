package creational;

import entity.*;

public class CoffeeFactory {
    public Coffee getCoffee(CoffeeType type, int sugar, String syrup)
    {
        if(type == CoffeeType.latte)
        {
            Latte myCoffee = new Latte();
            myCoffee.setSugar(sugar);
            myCoffee.setSyrup(syrup);
            return myCoffee;
        }
        else
        {
            Espresso myCoffee = new Espresso();
            myCoffee.setSugar(sugar);
            myCoffee.setSyrup(syrup);
            return myCoffee;
        }
    }
}


