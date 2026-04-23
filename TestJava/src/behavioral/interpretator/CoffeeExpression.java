package behavioral.interpretator;

public class CoffeeExpression
{
    public void interpret(String context) {
        if (context.contains("LATTE")) System.out.println("Interpreted: Making Latte");
        if (context.contains("ESPRESSO")) System.out.println("Interpreted: Making Espresso");
    }
}