package main.coffeemachine;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static int[] enterResources() {
        int[] resources = new int[4];

        System.out.println("Write how many ml of water you want to add: ");
        resources[0] = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        resources[1] = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        resources[2] = scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add: ");
        resources[3] = scanner.nextInt();

        return resources;
    }

    public static String makeOrder() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu");
        return scanner.next();
    }

    public static String enterAction() {
        System.out.println("buy, fill, take, remaining, exit): ");
        return scanner.next();
    }
}
