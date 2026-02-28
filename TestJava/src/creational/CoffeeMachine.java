package creational;

class State
{
    public void handle(CoffeeMachine context) {}
}

class ReadyState extends State
{
    public void handle(CoffeeMachine context)
    {
        System.out.println("[State]: ready");
        context.setState(new BrewingState());
    }
}

class BrewingState extends State
{
    public void handle(CoffeeMachine context)
    {
        System.out.println("[State]: brewing");
    }
}

public class CoffeeMachine
{
    private static CoffeeMachine coffeeMachine = null;
    private State currentState;
    void setState(State s) { currentState = s; }
    public void pressButton() { currentState.handle(this); }

    private CoffeeMachine() { currentState = new ReadyState(); }

    public static synchronized CoffeeMachine getInstance()
    {
        if(coffeeMachine == null)
        {
            coffeeMachine = new CoffeeMachine();
        }
        return coffeeMachine;
    }
}
