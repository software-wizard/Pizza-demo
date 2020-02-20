package pl.psi.menu;

import org.junit.jupiter.api.Test;
import pl.psi.pizza.AbstractPizzaFactory;
import pl.psi.pizza.Pizza;

import static org.junit.jupiter.api.Assertions.*;

class MenuItemTest {

    @Test
    void shouldCreateCorrectStringBySpecificFormat(){
        AbstractPizzaFactory factory = AbstractPizzaFactory.getFactory(AbstractPizzaFactory.PizzaPieType.ITALIAN);
        Pizza pizza = factory.createPizza(Pizza.PizzaNames.CAPRICCIOSA);
        MenuItemIf menuItem = new MenuItem(pizza);

        StringBuilder sb = new StringBuilder();
        sb.append("Capricciosa.......................................................16.80");
        sb.append( System.lineSeparator() );
        sb.append("sos pomidorowy, mozzarella, pieczarki, szynka");
        String expected = sb.toString();

        String result = menuItem.getMenuDisplayText();

        assertEquals(expected,result);

        //--------------------------------------------------------------------

        pizza = factory.createPizza(Pizza.PizzaNames.DINAMITE);
        menuItem = new MenuItem(pizza);

        sb = new StringBuilder();
        sb.append("Dynamit...........................................................15.10");
        sb.append( System.lineSeparator() );
        sb.append("sos pomidorowy, mozzarella, salami");
        expected = sb.toString();

        result = menuItem.getMenuDisplayText();

        assertEquals(expected,result);
    }


}