package pl.psi.menu;

import org.junit.jupiter.api.Test;
import pl.psi.pizza.AbstractPizzaFactory;
import pl.psi.pizza.Addition;
import pl.psi.pizza.Pizza;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MenuFactoryTest {

    @Test
    void checkFirstMenuItemInItalianMenu(){
        MenuFactory factory = new MenuFactory();
        StringBuilder sb = new StringBuilder();
        sb.append("Margeritta........................................................13.50");
        sb.append(System.lineSeparator());
        sb.append("sos pomidorowy, mozzarella");
        String expected = sb.toString();

        Menu menu = factory.create("PIZZA NA CIENKIM", AbstractPizzaFactory.getFactory(AbstractPizzaFactory.PizzaPieType.ITALIAN), Arrays.asList(Pizza.PizzaNames.values()));
        MenuItemIf firstMenuItem = menu.getItemsIterator().next();

        assertEquals(expected,firstMenuItem.getMenuDisplayText());
    }

    @Test
    void checkFirstMenuItemInAmericanMenu(){
        MenuFactory factory = new MenuFactory();
        StringBuilder sb = new StringBuilder();
        sb.append("Margeritta........................................................15.50");
        sb.append(System.lineSeparator());
        sb.append("sos pomidorowy, mozzarella");
        String expected = sb.toString();

        Menu menu = factory.create("PIZZA NA GRUBYM", AbstractPizzaFactory.getFactory(AbstractPizzaFactory.PizzaPieType.AMERICAN), Arrays.asList(Pizza.PizzaNames.values()));
        MenuItemIf firstMenuItem = menu.getItemsIterator().next();

        assertEquals(expected,firstMenuItem.getMenuDisplayText());
    }

    @Test
    void checkFirstMenuItemFromAdditionalMenu(){
        MenuFactory factory = new MenuFactory();
        String expected = "papryka............................................................0.80";

        Menu menu = factory.create("DODATKI", Arrays.asList(Addition.values()));
        MenuItemIf firstMenuItem = menu.getItemsIterator().next();

        assertEquals(expected,firstMenuItem.getMenuDisplayText());
    }


}