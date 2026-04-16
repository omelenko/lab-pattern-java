package structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class CoffeeTypeFactory
{
    private static Map<String, entity.CoffeeType> types = new HashMap<>();

    public static entity.CoffeeType getType(String name)
    {
        if (!types.containsKey(name))
        {
            types.put(name, entity.CoffeeType.valueOf(name.toLowerCase()));
        }
        return types.get(name);
    }
}