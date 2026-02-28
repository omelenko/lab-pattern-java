import creational.*;
import entity.*;

public class CoffeeFacade
{
    CoffeeMachine coffeeMachine = CoffeeMachine.getInstance();
    CoffeeBuilder coffeeBuilder = new CoffeeBuilder();
    CoffeeFactory coffeeFactory = new CoffeeFactory();
    CoffeeAbstractFactory coffeeAbstractFactory = new CoffeeAbstractFactory();

    public void makeLatteWithBuilder(int sugar, String syrup)
    {
        System.out.println("--- Facade: making Latte for client ---");

        coffeeMachine.pressButton();

        Coffee myCoffee = coffeeBuilder.setType(CoffeeType.latte)
                .addMilk()
                .addSugar(sugar)
                .setCup(CupType.L)
                .addSyrup(syrup)
                .build();

        myCoffee.info();

        System.out.println("--- Your order is ready! ---");
    }

    public void makeEspressoWithBuilder(int sugar, String syrup)
    {
        System.out.println("--- Facade: making Espresso for client ---");

        coffeeMachine.pressButton();

        Coffee myCoffee = coffeeBuilder.setType(CoffeeType.espresso)
                .addSugar(sugar)
                .setCup(CupType.S)
                .addSyrup(syrup)
                .build();

        myCoffee.info();

        System.out.println("--- Your order is ready! ---");
    }

    public void makeLatteWithFactory(int sugar, String syrup)
    {
        System.out.println("--- Facade: making Latte for client ---");

        coffeeMachine.pressButton();

        Coffee myCoffee = coffeeFactory.getCoffee(CoffeeType.latte, sugar, syrup);

        myCoffee.info();

        System.out.println("--- Your order is ready! ---");
    }

    public void makeEspressoWithFactory(int sugar, String syrup)
    {
        System.out.println("--- Facade: making Espresso for client ---");

        coffeeMachine.pressButton();

        Coffee myCoffee = coffeeFactory.getCoffee(CoffeeType.espresso, sugar, syrup);

        myCoffee.info();

        System.out.println("--- Your order is ready! ---");
    }

    public void makeLatteWithAbstractFactory(int sugar, String syrup)
    {
        System.out.println("--- Facade: making Latte for client ---");

        coffeeMachine.pressButton();

        CoffeeAbstractFactory.LatteFactory latteFactory =
                (CoffeeAbstractFactory.LatteFactory) coffeeAbstractFactory.getCoffeeFactory(CoffeeType.latte);

        Coffee myCoffee = latteFactory.getCoffee(sugar, syrup);

        myCoffee.info();

        System.out.println("--- Your order is ready! ---");
    }

    public void makeEspressoWithAbstractFactory(int sugar, String syrup)
    {
        System.out.println("--- Facade: making Espresso for client ---");

        coffeeMachine.pressButton();

        CoffeeAbstractFactory.EspressoFactory espressoFactory =
                (CoffeeAbstractFactory.EspressoFactory) coffeeAbstractFactory.getCoffeeFactory(CoffeeType.espresso);

        Coffee myCoffee = espressoFactory.getCoffee(sugar, syrup);

        myCoffee.info();

        System.out.println("--- Your order is ready! ---");
    }

    public void makeLatteWithPrototype(int sugar, String syrup)
    {
        System.out.println("--- Facade: making Latte for client ---");

        coffeeMachine.pressButton();

        Coffee myCoffee = new Coffee();
        myCoffee.setType(CoffeeType.latte);
        myCoffee.setSugar(sugar);
        myCoffee.setMilk(true);
        myCoffee.setCupType(CupType.L);
        myCoffee.setSyrup(syrup);

        Coffee myCoffeeClone = (Coffee) myCoffee.doClone();

        myCoffeeClone.info();

        System.out.println("--- Your order is ready! ---");
    }

    public void makeEspressoWithPrototype(int sugar, String syrup)
    {
        System.out.println("--- Facade: making Espresso for client ---");

        coffeeMachine.pressButton();

        Coffee myCoffee = new Coffee();
        myCoffee.setType(CoffeeType.espresso);
        myCoffee.setSugar(sugar);
        myCoffee.setMilk(false);
        myCoffee.setCupType(CupType.S);
        myCoffee.setSyrup(syrup);

        Coffee myCoffeeClone = (Coffee) myCoffee.doClone();

        myCoffeeClone.info();

        System.out.println("--- Your order is ready! ---");
    }
}
