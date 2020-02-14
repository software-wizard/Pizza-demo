package pl.psi.pizza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItalianPizzaFactoryTest {

    @Test
    void shouldPrepareCorrectPizza(){
        ItalianPizzaFactory factory = new ItalianPizzaFactory();

        Pizza ret = factory.createPizza(PizzaNames.MARGERITTA);

        assertEquals(13.50, ret.getCost());
        assertEquals("Margeritta na cienkim cieście" , ret.getName());
    }

}