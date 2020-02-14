package pl.psi.pizza;

public class ItalianPizzaFactory {
    public Pizza createPizza(PizzaNames aName) {
        return new Pizza(aName);
    }
}
