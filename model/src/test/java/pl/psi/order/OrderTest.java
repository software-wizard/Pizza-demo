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

    @Test
    void shouldCalculateOrderCostCorrectlyAfterStudentDiscount(){
        AbstractPizzaFactory factory = AbstractPizzaFactory.getFactory(AbstractPizzaFactory.PizzaPieType.ITALIAN);
        Order order = new Order();
        order.addItem(factory.createPizza(Pizza.PizzaNames.CAPRICCIOSA));
        order.addItem(factory.createPizza(Pizza.PizzaNames.DINAMITE));
        order = new StudentDiscountOrderDecorator(order);

        assertEquals(25.52, order.calculateOrderCost());
    }

    @Test
    void shouldCalculateOrderCostCorrectlyAfterAddDelivery(){
        AbstractPizzaFactory factory = AbstractPizzaFactory.getFactory(AbstractPizzaFactory.PizzaPieType.ITALIAN);
        Order order = new Order();
        order.addItem(factory.createPizza(Pizza.PizzaNames.CAPRICCIOSA));
        order.addItem(factory.createPizza(Pizza.PizzaNames.DINAMITE));
        order.addItem(Delivery.GRUNWALD);

        assertEquals(35.90, order.calculateOrderCost());
    }

    @Test
    void shouldCalculateOrderCostCorrectlyAfterAddDeliveryAndStudentDiscount(){
        AbstractPizzaFactory factory = AbstractPizzaFactory.getFactory(AbstractPizzaFactory.PizzaPieType.ITALIAN);
        Order order = new Order();
        order.addItem(factory.createPizza(Pizza.PizzaNames.CAPRICCIOSA));
        order.addItem(factory.createPizza(Pizza.PizzaNames.DINAMITE));
        order.addItem(Delivery.GRUNWALD);
        order = new StudentDiscountOrderDecorator(order);

        assertEquals(28.72, order.calculateOrderCost());
    }
}