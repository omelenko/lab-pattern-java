package entity;

public class Espresso extends Coffee
{
    CoffeeType type = CoffeeType.espresso;
    int sugar = 0;
    Boolean milk = false;
    String syrup = "None";
    CupType cupType = CupType.S;

    @Override
    public void setMilk(Boolean milk) { this.milk = false; }

    @Override
    public void setType(CoffeeType type) { this.type = CoffeeType.espresso; }

    @Override
    public void setCupType(CupType cupType) { this.cupType = CupType.S; }
}
