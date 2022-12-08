package main.coffeemachine;

import java.util.HashMap;
import java.util.Map;

public class CoffeeMachine {
    private int water = 400;

    private int milk = 540;

    private int coffeeBeans = 120;

    private int disposableCups = 9;

    private int money = 550;
    private final Map<Integer, Drink> drinks;

    public CoffeeMachine() {
        this.drinks = loadDrinks();
    }

    private Map<Integer, Drink> loadDrinks() {
        Map<Integer, Drink> drinks = new HashMap<>();

        drinks.put(1, new Drink("Espresso", 250, 0, 16, 4));
        drinks.put(2, new Drink("Latte", 350, 75, 20, 7));
        drinks.put(3, new Drink("Cappuccino", 200, 100, 12, 6));

        return drinks;
    }

    public void buy(String number) {
        try {
            Drink drink = drinks.get(Integer.parseInt(number));
            if (isEnoughResourcesFor(drink)) {
                water -= drink.WATER();
                milk -= drink.MILK();
                coffeeBeans -= drink.COFFEE_BEANS();
                money += drink.PRICE();
                disposableCups--;
            }
        } catch (RuntimeException ignored) {
        }
    }

    public void fill(int[] resources) {
        this.water += resources[0];
        this.milk += resources[1];
        this.coffeeBeans += resources[2];
        this.disposableCups += resources[3];
    }

    public void takeMoney() {
        System.out.printf("I gave you $%d\n", money);
        money = 0;
    }

    public boolean isEnoughResourcesFor(Drink drink) {
        if (water < drink.WATER()) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (milk < drink.MILK()) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (coffeeBeans < drink.COFFEE_BEANS()) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else if (disposableCups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        }
        return true;
    }

    @Override
    public String toString() {
        return "The coffee machine has:\n" +
                water + " ml of water\n" +
                milk + " ml of milk\n" +
                coffeeBeans + " g of coffee beans\n" +
                disposableCups + " disposable cups\n" +
                "$" + money + " of money\n";
    }
}
