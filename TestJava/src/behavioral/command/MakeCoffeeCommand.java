package behavioral.command;

import structural.CoffeeFacade;

public class MakeCoffeeCommand implements Command {
    private CoffeeFacade facade;
    public MakeCoffeeCommand(CoffeeFacade f) { this.facade = f; }
    public void execute() { facade.makeLatteWithBuilder(1, "Vanilla"); }
}
