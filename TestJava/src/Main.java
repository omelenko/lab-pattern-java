import behavioral.chainOfResponsibility.CoffeeCheck;
import behavioral.chainOfResponsibility.MilkCheck;
import behavioral.chainOfResponsibility.WaterCheck;
import behavioral.command.Command;
import behavioral.command.MakeCoffeeCommand;
import behavioral.iterator.MenuIterator;
import behavioral.mediator.Barista;
import behavioral.mediator.CoffeeMediator;
import behavioral.observer.Customer;
import behavioral.observer.Observer;
import behavioral.stratergy.CardPayment;
import behavioral.stratergy.CashPayment;
import behavioral.templateMethod.LatteTemplate;
import entity.Coffee;
import entity.CoffeeType;
import structural.CoffeeFacade;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        CoffeeFacade facade = new CoffeeFacade();

        System.out.println("===== КЛІЄНТ ПОЧИНАЄ ЗАМОВЛЕННЯ =====\n");

        // 1
        facade.makeLatteWithBuilder(2, "Caramel");
        facade.makeCoffeeWithFactory(CoffeeType.espresso, 0, "None");
        facade.makeCoffeeWithAbstractFactory(CoffeeType.latte, 1, "Vanilla");
        facade.makeCoffeeWithPrototype(CoffeeType.espresso, 1, "Chocolate");

        // 2
        facade.makeDecoratedLatte(2);
        facade.makeComboOrder();
        facade.makeCoffeeSecurely();
        facade.makePremiumBridgeOrder();
        Coffee secretCoffee = new Coffee();
        secretCoffee.setType(CoffeeType.latte);
        facade.sendOrderToOldSystem(secretCoffee);
        facade.makeCoffeeWithFlyweight("Latte");

        System.out.println("===== ВСІ ЗАМОВЛЕННЯ ВИКОНАНО =====");

        // 3
        System.out.println("===== ПОВЕДІНКОВІ ПАТЕРНИ (BEHAVIORAL) =====\n");

        // strategy: оплата
        facade.processPayment(150, new CardPayment());
        facade.processPayment(50, new CashPayment());

        // observer: клієнт сповіщається про готовність кави
        Observer customer = new Customer("Олексій");
        facade.makeCoffeeWithNotification(CoffeeType.latte, customer);

        // command: команда в виді об'єкту
        Command makeLatte = new MakeCoffeeCommand(facade);
        facade.executeCoffeeCommand(makeLatte);

        // template method: рецепт в виді класу
        facade.brewWithTemplate(new LatteTemplate()); // Наприклад, рецепт Лате

        // iterator: меню
        facade.printMenu(new MenuIterator());

        // mediator: непряма комунікація
        CoffeeMediator mediator = new CoffeeMediator();
        facade.sendStaffMessage("Order #5 is ready!", new Barista(), mediator);

        // memento: збереження, відкат стану
        Coffee myCoffee = new Coffee();
        myCoffee.setSyrup("Caramel");
        facade.saveAndRestoreCoffee(myCoffee);

        // chain of responsibility: перевірка наявності
        CoffeeCheck waterCheck = new WaterCheck();
        CoffeeCheck milkCheck = new MilkCheck();
        waterCheck.setNext(milkCheck);
        facade.checkResources(waterCheck);

        // visitor: мікс кави в більшу чашку
        Coffee espresso = new Coffee();
        espresso.setType(CoffeeType.espresso);
        espresso.setSugar(1);

        Coffee latte = new Coffee();
        latte.setType(CoffeeType.latte);
        latte.setSugar(2);

        facade.makeMixedCoffee(espresso, latte);

        // interpreter: виконання примітивної команди
        facade.interpretCommand("MAKE LATTE SUGAR 2");

        System.out.println("\n===== ВСІ ТЕСТИ ПОВЕДІНКОВИХ ПАТЕРНІВ ЗАВЕРШЕНО =====");

        // 4
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Double> doubles = Arrays.asList(1.5, 2.5, 3.5);
        List<String> strings = Arrays.asList("Apple", "banana", "Cherry", "", "Date", "kiwi");

        System.out.println("1. Непарні числа: " + filterOdd(numbers));
        System.out.println("2. Середнє значення: " + findAverage(doubles));
        System.out.println("3. Сортування (алфавітне): " + sortAlphabetically(strings));
        System.out.println("4. Сума парних чисел: " + sumEvens(numbers));
        System.out.println("5. Факторіал 5: " + calculateFactorial(5));
        System.out.println("6. Множення: " + multiplyAll(numbers) + ", Сума: " + sumAll(numbers));
        System.out.println("7. Квадрати чисел: " + squareNumbers(numbers));
        System.out.println("8. Сортування за довжиною: " + sortByLength(strings));
        System.out.println("9. Кількість слів у реченні: " + countWords("Java Stream API is powerful"));
        System.out.println("10. Перший непорожній рядок: " + findFirstNotEmpty(strings));
        System.out.println("11. Всі з великої літери: " + areAllCapitalized(strings));
        System.out.println("12. Друге за величиною число: " + findSecondLargest(numbers));
        System.out.println("13. Найбільше парне число: " + findMaxEven(numbers));
    }
    // 1.
    public static List<Integer> filterOdd(List<Integer> list) {
        return list.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());
    }

    // 2.
    public static double findAverage(List<Double> list) {
        return list.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

    // 3.
    public static List<String> sortAlphabetically(List<String> list) {
        return list.stream()
                .sorted(String::compareToIgnoreCase)
                .collect(Collectors.toList());
    }

    // 4.
    public static int sumEvens(List<Integer> list) {
        return list.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    // 5.
    public static long calculateFactorial(int n) {
        if (n < 0) return 0;
        return IntStream.rangeClosed(1, n)
                .reduce(1, (a, b) -> a * b);
    }

    // 6.
    public static int multiplyAll(List<Integer> list) {
        return list.stream().reduce(1, (a, b) -> a * b);
    }
    public static int sumAll(List<Integer> list) {
        return list.stream().reduce(0, Integer::sum);
    }

    // 7.
    public static List<Integer> squareNumbers(List<Integer> list) {
        return list.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    // 8.
    public static List<String> sortByLength(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    // 9.
    public static long countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) return 0;
        return Arrays.stream(sentence.trim().split("\\s+"))
                .count();
    }

    // 10.
    public static String findFirstNotEmpty(List<String> list) {
        return list.stream()
                .filter(s -> !s.trim().isEmpty())
                .findFirst()
                .orElse("No non-empty strings found");
    }

    // 11.
    public static boolean areAllCapitalized(List<String> list) {
        return list.stream()
                .filter(s -> !s.isEmpty())
                .allMatch(s -> Character.isUpperCase(s.charAt(0)));
    }

    // 12.
    public static Integer findSecondLargest(List<Integer> list) {
        return list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);
    }

    // 13.
    public static Integer findMaxEven(List<Integer> list) {
        return list.stream()
                .filter(n -> n % 2 == 0)
                .max(Integer::compare)
                .orElse(null);
    }
}
