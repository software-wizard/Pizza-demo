package pl.psi.pizza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AmericanPizzaFactoryTest {

    @Test
    void shouldPrepareCorrectPizza(){
        AbstractPizzaFactory factory = AbstractPizzaFactory.getFactory(AbstractPizzaFactory.PizzaPieType.AMERICAN);

        Pizza ret = factory.createPizza(Pizza.PizzaNames.MARGERITTA);
        assertEquals(15.50, ret.getCost());
        assertEquals("Margeritta na grubym cieście" , ret.getName());

        ret = factory.createPizza(Pizza.PizzaNames.MARINARA);
        assertEquals(16.40, ret.getCost());
        assertEquals("Marinara na grubym cieście" , ret.getName());

        ret = factory.createPizza(Pizza.PizzaNames.NAPOLETANA);
        assertEquals(18.70, ret.getCost());
        assertEquals("Napoleońska na grubym cieście" , ret.getName());

        ret = factory.createPizza(Pizza.PizzaNames.HAWAJSKA);
        assertEquals(16.90, ret.getCost());
        assertEquals("Hawajska na grubym cieście" , ret.getName());

        ret = factory.createPizza(Pizza.PizzaNames.FUNGHI);
        assertEquals(16.60, ret.getCost());
        assertEquals("Funghi na grubym cieście" , ret.getName());

        ret = factory.createPizza(Pizza.PizzaNames.QUATRO);
        assertEquals(20.20, ret.getCost());
        assertEquals("Quatro na grubym cieście" , ret.getName());

        ret = factory.createPizza(Pizza.PizzaNames.CAPRICCIOSA);
        assertEquals(18.80, ret.getCost());
        assertEquals("Capricciosa na grubym cieście" , ret.getName());

        ret = factory.createPizza(Pizza.PizzaNames.DINAMITE);
        assertEquals(17.10, ret.getCost());
        assertEquals("Dynamit na grubym cieście" , ret.getName());
    }
}