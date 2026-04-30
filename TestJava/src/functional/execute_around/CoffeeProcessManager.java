package functional.execute_around;

import entity.CoffeeType;

public class CoffeeProcessManager {

    public static void process(CoffeeType type, CoffeeAction action)
    {
        System.out.println("[System]: Heating up the machine...");
        try {
            action.execute(type);
        } finally {
            System.out.println("[System]: Cleaning the pipes...");
        }
    }
}