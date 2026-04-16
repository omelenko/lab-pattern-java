package structural;

import creational.*;
import entity.*;
import structural.adapter.CoffeeAdapter;
import structural.adapter.OldOrderSystem;
import structural.bridge.AutoBrew;
import structural.bridge.BrewingProcess;
import structural.bridge.CoffeeOrder;
import structural.bridge.PremiumOrder;
import structural.composite.ComboOrder;
import structural.decorator.CinnamonDecorator;
import structural.proxy.CoffeeMachineProxy;
import structural.proxy.CoffeeService;

public class CoffeeFacade
{
    private static final Coffee LATTE_PROTOTYPE;
    private static final Coffee ESPRESSO_PROTOTYPE;
    CoffeeMachine coffeeMachine = CoffeeMachine.getInstance();
    CoffeeBuilder coffeeBuilder = new CoffeeBuilder();
    CoffeeFactory coffeeFactory = new CoffeeFactory();
    CoffeeAbstractFactory coffeeAbstractFactory = new CoffeeAbstractFactory();

    static {
        LATTE_PROTOTYPE = new Coffee();
        LATTE_PROTOTYPE.setType(CoffeeType.latte);
        LATTE_PROTOTYPE.setMilk(true);
        LATTE_PROTOTYPE.setCupType(CupType.L);

        ESPRESSO_PROTOTYPE = new Coffee();
        ESPRESSO_PROTOTYPE.setType(CoffeeType.espresso);
        ESPRESSO_PROTOTYPE.setCupType(CupType.S);
    }

    private void prepareOrder(Coffee coffee, String method)
    {
        System.out.println("--- Facade: preparing order using " + method + " ---");
        coffeeMachine.pressButton();
        coffee.info();
        System.out.println("--- Order is ready! ---\n");
    }

    // 1
    public void makeLatteWithBuilder(int sugar, String syrup) {
        Coffee latte = coffeeBuilder.setType(CoffeeType.latte)
                .addMilk()
                .addSugar(sugar)
                .setCup(CupType.L)
                .addSyrup(syrup)
                .build();
        prepareOrder(latte, "Builder");
    }
    public void makeEspressoWithBuilder(int sugar, String syrup) {
        Coffee espresso = coffeeBuilder.setType(CoffeeType.espresso)
                .addSugar(sugar)
                .setCup(CupType.S)
                .addSyrup(syrup)
                .build();
        prepareOrder(espresso, "Builder");
    }
    public void makeCoffeeWithFactory(CoffeeType type, int sugar, String syrup) {
        Coffee coffee = coffeeFactory.getCoffee(type, sugar, syrup);
        prepareOrder(coffee, "Factory");
    }
    public void makeCoffeeWithAbstractFactory(CoffeeType type, int sugar, String syrup) {
        var factory = coffeeAbstractFactory.getCoffeeFactory(type);
        Coffee coffee = factory.getCoffee(sugar, syrup);
        prepareOrder(coffee, "Abstract Factory");
    }
    public void makeCoffeeWithPrototype(CoffeeType type, int sugar, String syrup) {
        Coffee prototype = (type == CoffeeType.latte) ? LATTE_PROTOTYPE : ESPRESSO_PROTOTYPE;

        Coffee clone = (Coffee) prototype.doClone();
        clone.setSugar(sugar);
        clone.setSyrup(syrup);

        prepareOrder(clone, "Prototype");
    }

    // 2
    public void makeDecoratedLatte(int sugar) {
        Coffee myCoffee = coffeeFactory.getCoffee(CoffeeType.latte, sugar, "None");
        Coffee decoratedCoffee = new CinnamonDecorator(myCoffee);
        prepareOrder(decoratedCoffee,"Decorator");
    }
    public void sendOrderToOldSystem(Coffee coffee) {
        OldOrderSystem adapter = new CoffeeAdapter(coffee);
        adapter.processOrder("Legacy_Data_Format");
        prepareOrder(coffee, "Adapter");
    }
    public void makeComboOrder() {
        System.out.println("--- Facade: preparing order using Composite ---");

        ComboOrder bigOrder = new ComboOrder();

        bigOrder.add(coffeeFactory.getCoffee(CoffeeType.espresso, 1, "None"));
        bigOrder.add(coffeeFactory.getCoffee(CoffeeType.latte, 2, "Vanilla"));

        bigOrder.showDetails();
        System.out.println("--- Combo order completed! ---");
    }
    public void makeCoffeeSecurely() {
        CoffeeService proxy = new CoffeeMachineProxy();
        proxy.makeCoffee();
    }
    public void makePremiumBridgeOrder() {
        System.out.println("--- Facade: preparing order using Bridge (Auto Brewing) ---");
        BrewingProcess manual = new AutoBrew();
        CoffeeOrder order = new PremiumOrder(manual);
        order.make();
    }
}
