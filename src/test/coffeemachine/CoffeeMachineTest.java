package test.coffeemachine;

import main.coffeemachine.CoffeeMachine;
import main.coffeemachine.Drink;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeMachineTest {
    public CoffeeMachine machine;

    public String LATTE = "2";

    @BeforeEach
    public void setUp() {
        int WATER = 400;
        int MILK = 540;
        int COFFEE_BEANS = 120;
        int DISPOSABLE_CUPS = 9;
        int MONEY = 550;

        machine = new CoffeeMachine(WATER, MILK, COFFEE_BEANS, DISPOSABLE_CUPS, MONEY);
    }

    @Test
    public void testBuyLatte() {
        machine.buy(LATTE);

        assertEquals(50, machine.getWater());
        assertEquals(465, machine.getMilk());
        assertEquals(100, machine.getCoffeeBeans());
        assertEquals(8, machine.getDisposableCups());
        assertEquals(557, machine.getMoney());
    }

    @Test
    public void testBackFromBuyMenu() {
        String BACK = "back";

        machine.buy(BACK);
        assertEquals(400, machine.getWater());
        assertEquals(540, machine.getMilk());
        assertEquals(120, machine.getCoffeeBeans());
        assertEquals(9, machine.getDisposableCups());
        assertEquals(550, machine.getMoney());
    }

    @Test
    public void testNotEnoughWater() {
        Drink originalDrink = new Drink("Original", 450, 75, 20, 7);

        assertFalse(machine.isEnoughResourcesFor(originalDrink));
    }

    @Test
    public void testNotEnoughMilk() {
        Drink originalDrink = new Drink("Original", 350, 550, 20, 7);

        assertFalse(machine.isEnoughResourcesFor(originalDrink));
    }

    @Test
    public void testNotEnoughCoffeeBeans() {
        Drink originalDrink = new Drink("Original", 350, 75, 130, 7);

        assertFalse(machine.isEnoughResourcesFor(originalDrink));
    }


    @Test
    public void testFillMachine() {
        int[] resources = {300, 125, 100, 20};

        machine.fill(resources);

        assertEquals(700, machine.getWater());
        assertEquals(665, machine.getMilk());
        assertEquals(220, machine.getCoffeeBeans());
        assertEquals(29, machine.getDisposableCups());
    }

    @Test
    public void testTakeMoney() {
        machine.takeMoney();

        assertEquals(0, machine.getMoney());
    }
}