package main.coffeemachine;

import static main.coffeemachine.Input.*;

public class Main {

    public static void main(String[] args) {

        int COFFEE_BEANS = 120;
        int MILK = 540;
        int WATER = 400;
        int DISPOSABLE_CUPS = 9;
        int MONEY = 550;

        CoffeeMachine machine = new CoffeeMachine(WATER, MILK, COFFEE_BEANS, DISPOSABLE_CUPS, MONEY);
        boolean isWorking = true;

        while (isWorking) {
            String action = enterAction();

            switch (action) {
                case "buy" -> machine.buy(makeOrder());
                case "fill" -> machine.fill(enterResources());
                case "take" -> machine.takeMoney();
                case "remaining" -> System.out.println(machine);
                case "exit" -> isWorking = false;
            }
        }
    }
}
