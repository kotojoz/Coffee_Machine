package main.coffeemachine;

import static main.coffeemachine.Input.*;

public class Main {
    public static void main(String[] args) {

        CoffeeMachine machine = new CoffeeMachine();
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
