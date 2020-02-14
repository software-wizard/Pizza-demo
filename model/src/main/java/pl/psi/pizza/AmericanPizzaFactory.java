package pl.psi.pizza;

public class AmericanPizzaFactory extends AbstractPizzaFactory{
    @Override
    protected Pizza createPizzaInstance(String aName) {
        final Pizza pizza = new Pizza(aName, PizzaPieType.AMERICAN);
        return pizza;
    }
}
