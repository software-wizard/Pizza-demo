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

        ret = factory.createPizza(PizzaNames.MARINARA);
        assertEquals(14.40, ret.getCost());
        assertEquals("Marinara na cienkim cieście" , ret.getName());

        ret = factory.createPizza(PizzaNames.NAPOLETANA);
        assertEquals(16.70, ret.getCost());
        assertEquals("Napoleońska na cienkim cieście" , ret.getName());

        ret = factory.createPizza(PizzaNames.HAWAJSKA);
        assertEquals(14.90, ret.getCost());
        assertEquals("Hawajska na cienkim cieście" , ret.getName());

        ret = factory.createPizza(PizzaNames.FUNGHI);
        assertEquals(14.60, ret.getCost());
        assertEquals("Funghi na cienkim cieście" , ret.getName());

        ret = factory.createPizza(PizzaNames.QUATRO);
        assertEquals(18.20, ret.getCost());
        assertEquals("Quatro na cienkim cieście" , ret.getName());

        ret = factory.createPizza(PizzaNames.CAPRICCIOSA);
        assertEquals(16.80, ret.getCost());
        assertEquals("Capricciosa na cienkim cieście" , ret.getName());

        ret = factory.createPizza(PizzaNames.DINAMITE);
        assertEquals(15.10, ret.getCost());
        assertEquals("Dynamit na cienkim cieście" , ret.getName());
    }

}