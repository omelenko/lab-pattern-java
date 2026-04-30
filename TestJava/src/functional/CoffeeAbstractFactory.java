package functional;

import entity.Coffee;
import entity.CoffeeType;
import entity.Espresso;
import entity.Latte;

import java.util.Map;
import java.util.function.BiFunction;

public class CoffeeAbstractFactory
{
    private static final Map<CoffeeType, BiFunction<Integer, String, Coffee>> FACTORIES = Map.of(
            CoffeeType.latte,
            (sugar, syrup) ->
            {
                Latte latte = new Latte();
                latte.setSugar(sugar);
                latte.setSyrup(syrup);
                return latte;
            },
            CoffeeType.espresso,
            (sugar, syrup) ->
            {
                Espresso espresso = new Espresso();
                espresso.setSugar(sugar);
                espresso.setSyrup(syrup);
                return espresso;
            }
    );

    public BiFunction<Integer, String, Coffee> getCoffeeFactory(CoffeeType type)
    {
        BiFunction<Integer, String, Coffee> factory = FACTORIES.get(type);
        if (factory == null) {
            throw new IllegalArgumentException("Unknown coffee type: " + type);
        }
        return factory;
    }
}
