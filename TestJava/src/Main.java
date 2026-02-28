public class Main {
    public static void main(String[] args) {
        CoffeeFacade coffeeMachine = new CoffeeFacade();

        coffeeMachine.makeLatte("M", 2, "None");

        coffeeMachine.makeEspresso("S", 1, "None");
    }
}
