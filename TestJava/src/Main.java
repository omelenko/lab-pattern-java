import entity.Coffee;
import entity.CoffeeType;
import structural.CoffeeFacade;

public class Main {
    public static void main(String[] args) {
        CoffeeFacade facade = new CoffeeFacade();

        System.out.println("===== КЛІЄНТ ПОЧИНАЄ ЗАМОВЛЕННЯ =====\n");

        // 1
        facade.makeLatteWithBuilder(2, "Caramel");
        facade.makeCoffeeWithFactory(CoffeeType.espresso, 0, "None");
        facade.makeCoffeeWithAbstractFactory(CoffeeType.latte, 1, "Vanilla");
        facade.makeCoffeeWithPrototype(CoffeeType.espresso, 1, "Chocolate");

        // 2
        facade.makeDecoratedLatte(2);
        facade.makeComboOrder();
        facade.makeCoffeeSecurely();
        facade.makePremiumBridgeOrder();
        Coffee secretCoffee = new Coffee();
        secretCoffee.setType(CoffeeType.latte);
        facade.sendOrderToOldSystem(secretCoffee);

        System.out.println("===== ВСІ ЗАМОВЛЕННЯ ВИКОНАНО =====");
    }
}
