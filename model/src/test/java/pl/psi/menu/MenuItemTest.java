package pl.psi.menu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuItemTest {

    @Test
    void shouldCreateCorrectStringBySpecificFormat(){
        MenuItemIf menuItem = new MenuItem();

        StringBuilder sb = new StringBuilder();
        sb.append("Capricciosa.....................................................16.80");
        sb.append( System.lineSeparator() );
        sb.append("sos pomidorowy, mozzarella, pieczarki, szynka");
        String expected = sb.toString();

        String result = menuItem.getMenuDisplayText();

        assertEquals(expected,result);
    }
}