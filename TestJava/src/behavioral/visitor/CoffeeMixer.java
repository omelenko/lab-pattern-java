package behavioral.visitor;

import entity.Coffee;
import entity.CupType;

public class CoffeeMixer implements CoffeeVisitor {
    private int totalSugar = 0;
    private StringBuilder mixDescription = new StringBuilder("Mixed: ");

    public Coffee getFinalMix() {
        Coffee mix = new Coffee();
        mix.setType(null);
        mix.setSugar(totalSugar);
        mix.setCupType(CupType.XL);
        mix.setSyrup(mixDescription.toString().trim());
        return mix;
    }

    @Override
    public void visit(Coffee coffee) {

        totalSugar += coffee.getSugar();
        mixDescription.append("Latte ");
        mixDescription.append("Espresso ");
    }
}
