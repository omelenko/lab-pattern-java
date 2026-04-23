package behavioral.chainOfResponsibility;

public class MilkCheck extends CoffeeCheck {
    @Override
    public void check() {
        System.out.println("[Check]: Checking milk freshness... OK.");
        if (next != null) next.check();
    }
}
