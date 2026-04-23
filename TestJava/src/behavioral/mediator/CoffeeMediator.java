package behavioral.mediator;

public class CoffeeMediator
{
    public void sendMessage(String msg, Object sender) {
        System.out.println("[Mediator] Message: " + msg + " from " + sender.getClass().getSimpleName());
    }
}