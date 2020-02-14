package pl.psi.pizza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItalianPizzaFactoryTest {

    @Test
    void shouldPrepareCorrectPizza(){
        AbstractPizzaFactory factory = AbstractPizzaFactory.getFactory(AbstractPizzaFactory.PizzaPieType.ITALIAN);

        Pizza ret = factory.createPizza(Pizza.PizzaNames.MARGERITTA);
        assertEquals(13.50, ret.getCost());
        assertEquals("Margeritta na cienkim cieście" , ret.getName());

        ret = factory.createPizza(Pizza.PizzaNames.MARINARA);
        assertEquals(14.40, ret.getCost());
        assertEquals("Marinara na cienkim cieście" , ret.getName());

        ret = factory.createPizza(Pizza.PizzaNames.NAPOLETANA);
        assertEquals(16.70, ret.getCost());
        assertEquals("Napoleońska na cienkim cieście" , ret.getName());

        ret = factory.createPizza(Pizza.PizzaNames.HAWAJSKA);
        assertEquals(14.90, ret.getCost());
        assertEquals("Hawajska na cienkim cieście" , ret.getName());

        ret = factory.createPizza(Pizza.PizzaNames.FUNGHI);
        assertEquals(14.60, ret.getCost());
        assertEquals("Funghi na cienkim cieście" , ret.getName());

        ret = factory.createPizza(Pizza.PizzaNames.QUATRO);
        assertEquals(18.20, ret.getCost());
        assertEquals("Quatro na cienkim cieście" , ret.getName());

        ret = factory.createPizza(Pizza.PizzaNames.CAPRICCIOSA);
        assertEquals(16.80, ret.getCost());
        assertEquals("Capricciosa na cienkim cieście" , ret.getName());

        ret = factory.createPizza(Pizza.PizzaNames.DINAMITE);
        assertEquals(15.10, ret.getCost());
        assertEquals("Dynamit na cienkim cieście" , ret.getName());
    }

}