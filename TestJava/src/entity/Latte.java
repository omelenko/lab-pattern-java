package entity;

public class Latte extends Coffee {
    CoffeeType type = CoffeeType.latte;
    int sugar = 0;
    Boolean milk = true;
    String syrup = "None";
    CupType cupType = CupType.L;

    @Override
    public void setMilk(Boolean milk) {
        this.milk = true;
    }

    @Override
    public void setType(CoffeeType type) { this.type = CoffeeType.latte; }

    @Override
    public void setCupType(CupType cupType) {this.cupType = CupType.L;}
}
