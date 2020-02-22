package pl.psi.menu;

import org.junit.jupiter.api.Test;

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
        Menu menu = MenuFactory.createMenu(MenuFactory.ITALIAN_PIZZA);

        MenuItemIf firstMenuItem = menu.getItemsIterator().next();

        assertEquals(expected,firstMenuItem.getMenuDisplayText());
    }

    @Test
    void checkFirstMenuItemInAmericanMenu(){
        StringBuilder sb = new StringBuilder();
        sb.append("Margeritta........................................................15.50");
        sb.append(System.lineSeparator());
        sb.append("sos pomidorowy, mozzarella");
        String expected = sb.toString();
        Menu menu = MenuFactory.createMenu(MenuFactory.AMERICAN_PIZZA);

        MenuItemIf firstMenuItem = menu.getItemsIterator().next();

        assertEquals(expected,firstMenuItem.getMenuDisplayText());
    }

    @Test
    void checkFirstMenuItemFromAdditionalMenu(){
        String expected = "papryka............................................................0.80";
        Menu menu = MenuFactory.createMenu(MenuFactory.ADDITIONAL);

        MenuItemIf firstMenuItem = menu.getItemsIterator().next();

        assertEquals(expected,firstMenuItem.getMenuDisplayText());
    }

    @Test
    void checkFirstMenuItemFromDeliveryMenu(){
        String expected = "Grunwald...........................................................4.00";
        Menu menu = MenuFactory.createMenu(MenuFactory.DELIVERY);

        MenuItemIf firstMenuItem = menu.getItemsIterator().next();

        assertEquals(expected,firstMenuItem.getMenuDisplayText());
    }


}