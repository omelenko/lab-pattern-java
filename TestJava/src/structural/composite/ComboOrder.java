package structural.composite;

import java.util.ArrayList;
import java.util.List;

public class ComboOrder implements OrderComponent
{
    private List<OrderComponent> children = new ArrayList<>();

    public void add(OrderComponent component) { children.add(component); }

    @Override
    public void showDetails() {
        System.out.println("Combo Order includes:");
        for (OrderComponent child : children) {
            child.showDetails();
        }
    }
}
