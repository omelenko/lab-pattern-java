package entity;

import creational.CoffeePrototype;

public class Coffee implements CoffeePrototype
{
    CoffeeType type;
    int sugar = 0;
    Boolean milk = false;
    String syrup = "None";
    CupType cupType = CupType.M;

    public void info() {
        System.out.println("Coffee type: " + type);
        System.out.println("Sugar: " + sugar);
        System.out.println("Milk: " + milk);
        System.out.println("Syrup: " + syrup);
        System.out.println("Cup size: " + cupType);
    }

    public void setCupType(CupType cupType) {this.cupType = cupType;}
    public void setSugar(int sugar) {this.sugar = sugar;}
    public void setMilk(Boolean milk) {this.milk = milk;}
    public void setSyrup(String syrup) {this.syrup = syrup;}
    public void setType(CoffeeType type) {this.type = type;}

//    public String getType() {return type;}
//    public int getSugar() {return sugar;}
//    public Boolean getMilk() {return milk;}
//    public String getSyrup() {return syrup;}
//    public mainClasses.CupType getCupType() {return cupType;}


    @Override
    public CoffeePrototype doClone() {
        Coffee clone = new Coffee();
        clone.setType(type);
        clone.setSugar(sugar);
        clone.setMilk(milk);
        clone.setSyrup(syrup);
        clone.setCupType(cupType);
        return clone;
    }
}
