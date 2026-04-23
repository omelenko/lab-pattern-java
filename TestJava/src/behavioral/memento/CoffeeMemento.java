package behavioral.memento;

public class CoffeeMemento
{
    private final String state;
    public CoffeeMemento(String state) { this.state = state; }
    public String getState() { return state; }
}