package pl.psi.pizza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {

    @Test
    void shouldCalculateCostCorrectlyAfterAddAddition(){
        AbstractPizzaFactory factory = AbstractPizzaFactory.getFactory(AbstractPizzaFactory.PizzaPieType.ITALIAN);
        Pizza pizza = factory.createPizza(Pizza.PizzaNames.CAPRICCIOSA);

        pizza.addCustomerAddition(Addition.PEPPER);

        assertEquals(17.6,pizza.getCost());
    }
}