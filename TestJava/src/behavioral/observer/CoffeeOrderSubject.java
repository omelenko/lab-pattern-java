package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class CoffeeOrderSubject {
    private List<Observer> observers = new ArrayList<>();
    public void addObserver(Observer o) { observers.add(o); }
    public void notifyObservers(String msg) { observers.forEach(o -> o.update(msg)); }
}
