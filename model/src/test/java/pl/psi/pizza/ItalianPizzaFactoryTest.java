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

        ret = factory.createPizza(PizzaNames.CAPRICCIOSA);
        assertEquals(13.50, ret.getCost());
        assertEquals("Capricciosa na cienkim cieście" , ret.getName());

        ret = factory.createPizza(PizzaNames.DINAMITE);
        assertEquals(13.50, ret.getCost());
        assertEquals("Dynamit na cienkim cieście" , ret.getName());

        ret = factory.createPizza(PizzaNames.FUNGHI);
        assertEquals(13.50, ret.getCost());
        assertEquals("Funghi na cienkim cieście" , ret.getName());

        ret = factory.createPizza(PizzaNames.HAWAJSKA);
        assertEquals(13.50, ret.getCost());
        assertEquals("Hawajska na cienkim cieście" , ret.getName());

        ret = factory.createPizza(PizzaNames.NAPOLETANA);
        assertEquals(13.50, ret.getCost());
        assertEquals("Napoleońska na cienkim cieście" , ret.getName());

        ret = factory.createPizza(PizzaNames.QUATRO);
        assertEquals(13.50, ret.getCost());
        assertEquals("Cztery sery na cienkim cieście" , ret.getName());

        ret = factory.createPizza(PizzaNames.MARINARA);
        assertEquals(13.50, ret.getCost());
        assertEquals("Marinara na cienkim cieście" , ret.getName());
    }

}