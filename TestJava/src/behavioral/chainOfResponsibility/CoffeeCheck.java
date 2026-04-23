package behavioral.chainOfResponsibility;

public abstract class CoffeeCheck {
    protected CoffeeCheck next;
    public void setNext(CoffeeCheck next) { this.next = next; }
    public abstract void check();
}
