package creational;

import entity.Coffee;
import entity.CoffeeType;
import entity.CupType;

public class CoffeeBuilder
{
    private final Coffee coffee;
    public CoffeeBuilder() { coffee = new Coffee(); }
    public CoffeeBuilder setType(CoffeeType t) { coffee.setType(t); return this; }
    public CoffeeBuilder addSugar(int s) { coffee.setSugar(s); return this; }
    public CoffeeBuilder setCup(CupType c) { coffee.setCupType(c); return this; }
    public CoffeeBuilder addMilk() { coffee.setMilk(true); return this; }
    public CoffeeBuilder addSyrup(String s) {coffee.setSyrup(s); return this; }
    public Coffee build() {return coffee;}
}
