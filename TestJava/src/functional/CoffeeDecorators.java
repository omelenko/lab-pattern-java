package functional;

import entity.Coffee;

import java.util.function.UnaryOperator;

public class CoffeeDecorators
{

    public static final UnaryOperator<Coffee> WITH_CINNAMON = coffee -> {
        String currentSyrup = coffee.getSyrup();
        coffee.setSyrup(currentSyrup + " + Extra: Cinnamon");
        return coffee;
    };

    public static final UnaryOperator<Coffee> WITH_MARSHMALLOW = coffee -> {
        String currentSyrup = coffee.getSyrup();
        coffee.setSyrup(currentSyrup + " + Extra: Marshmallow");
        return coffee;
    };
}