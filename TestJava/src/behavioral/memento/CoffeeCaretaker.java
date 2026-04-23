package behavioral.memento;

public class CoffeeCaretaker {
    private CoffeeMemento memento;

    public void save(CoffeeMemento m) {
        this.memento = m;
    }

    public CoffeeMemento restore() {
        return memento;
    }
}