package pl.psi.order;

import org.junit.jupiter.api.Test;
import pl.psi.pizza.AbstractPizzaFactory;
import pl.psi.pizza.Pizza;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void shouldCalculateOrderCostCorrectly(){
        AbstractPizzaFactory factory = AbstractPizzaFactory.getFactory(AbstractPizzaFactory.PizzaPieType.ITALIAN);
        Order order = new Order();
        order.addItem(factory.createPizza(Pizza.PizzaNames.CAPRICCIOSA));
        order.addItem(factory.createPizza(Pizza.PizzaNames.DINAMITE));

        assertEquals(31.90, order.calculateOrderCost());
    }
}