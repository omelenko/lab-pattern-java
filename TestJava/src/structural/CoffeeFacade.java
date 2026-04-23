package structural;

import behavioral.chainOfResponsibility.CoffeeCheck;
import behavioral.command.Command;
import behavioral.interpretator.CoffeeExpression;
import behavioral.iterator.MenuIterator;
import behavioral.mediator.CoffeeMediator;
import behavioral.memento.CoffeeCaretaker;
import behavioral.observer.CoffeeOrderSubject;
import behavioral.observer.Observer;
import behavioral.stratergy.PaymentStrategy;
import behavioral.templateMethod.CoffeeTemplate;
import behavioral.visitor.CoffeeMixer;
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
import structural.flyweight.CoffeeTypeFactory;
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
    public void makeCoffeeWithFlyweight(String type) {
        CoffeeType sharedDescription = CoffeeTypeFactory.getType(type);
        Coffee myCoffee = coffeeFactory.getCoffee(sharedDescription, 0, "None");

        prepareOrder(myCoffee, "Flyweight");
        System.out.println("Shared Knowledge: " + sharedDescription);
    }

    // 3
    public void processPayment(int amount, PaymentStrategy strategy) {
        System.out.println("--- Facade: processing payment using Strategy ---");
        strategy.pay(amount);
    }
    public void makeCoffeeWithNotification(CoffeeType type, Observer customer) {
        CoffeeOrderSubject subject = new CoffeeOrderSubject();
        subject.addObserver(customer);

        Coffee coffee = coffeeFactory.getCoffee(type, 1, "None");
        prepareOrder(coffee, "Observer");

        subject.notifyObservers("Your " + type + " is ready for pickup!");
    }
    public void executeCoffeeCommand(Command command) {
        System.out.println("--- Facade: executing request using Command ---");
        command.execute();
    }
    public void brewWithTemplate(CoffeeTemplate template) {
        System.out.println("--- Facade: brewing using Template Method ---");
        template.makeCoffee();
    }
    public void printMenu(MenuIterator iterator) {
        System.out.println("--- Facade: iterating through menu using Iterator ---");
        while (iterator.hasNext()) {
            System.out.println("Menu item: " + iterator.next());
        }
    }
    public void sendStaffMessage(String msg, Object staffMember, CoffeeMediator mediator) {
        System.out.println("--- Facade: relaying message via Mediator ---");
        mediator.sendMessage(msg, staffMember);
    }
    public void saveAndRestoreCoffee(Coffee coffee) {
        System.out.println("--- Facade: saving coffee state using Memento ---");
        CoffeeCaretaker caretaker = new CoffeeCaretaker();

        caretaker.save(coffee.saveToMemento());

        System.out.println("Current state: " + coffee.getSyrup());
        coffee.setSyrup("Changed by mistake");
        System.out.println("Accidental change: " + coffee.getSyrup());

        coffee.restoreFromMemento(caretaker.restore());
        System.out.println("Restored state: " + coffee.getSyrup());
    }
    public void checkResources(CoffeeCheck initialCheck) {
        System.out.println("--- Facade: checking resources using Chain of Responsibility ---");
        initialCheck.check();
    }
    public void makeMixedCoffee(Coffee... coffees) {
        System.out.println("--- Facade: mixing coffees using Visitor ---");
        CoffeeMixer mixer = new CoffeeMixer();

        for (Coffee c : coffees) {
            c.accept(mixer);
        }

        Coffee finalMix = mixer.getFinalMix();
        prepareOrder(finalMix, "Visitor (Mixer)");
    }
    public void interpretCommand(String expression) {
        System.out.println("--- Facade: interpreting command using Interpreter ---");
        CoffeeExpression interpreter = new CoffeeExpression();
        interpreter.interpret(expression);
    }
}
