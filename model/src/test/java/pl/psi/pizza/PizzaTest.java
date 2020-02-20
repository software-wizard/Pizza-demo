package pl.psi.pizza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {

    @Test
    void shouldCalculateCostCorrectlyAfterAddAddition(){
        AbstractPizzaFactory factory = AbstractPizzaFactory.getFactory(AbstractPizzaFactory.PizzaPieType.ITALIAN);
        Pizza pizza = factory.createPizza(Pizza.PizzaNames.CAPRICCIOSA);

        pizza.addCustomerAddition(Addition.PEPPER);
        pizza.addCustomerAddition(Addition.BECON);

        assertEquals(19.7,pizza.getCost());
    }

    @Test
    void shouldCreatePizzaNameCorrectlyAfterAddAddition(){
        AbstractPizzaFactory factory = AbstractPizzaFactory.getFactory(AbstractPizzaFactory.PizzaPieType.ITALIAN);
        Pizza pizza = factory.createPizza(Pizza.PizzaNames.CAPRICCIOSA);

        pizza.addCustomerAddition(Addition.PEPPER);
        pizza.addCustomerAddition(Addition.BECON);

        assertEquals("Capricciosa na cienkim cieście. Dodatkowo: papryka, bekon", pizza.getName());
    }
}