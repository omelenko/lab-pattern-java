package behavioral.chainOfResponsibility;

public class WaterCheck extends CoffeeCheck {
    @Override
    public void check() {
        System.out.println("[Check]: Checking water level... OK.");
        if (next != null) next.check();
    }
}

