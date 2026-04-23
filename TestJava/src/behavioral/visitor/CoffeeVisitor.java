package behavioral.visitor;

import entity.Coffee;
import entity.Espresso;
import entity.Latte;

public interface CoffeeVisitor
{
    void visit(Coffee coffee);
}