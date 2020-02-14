package pl.psi.pizza;

public class Pizza {

    private final String name;

    public Pizza(PizzaNames aName) {
        name = aName.getName();
    }

    public double getCost() {
        return 13.50;
    }

    public String getName() {
        return name + " na cienkim cieście";
    }
}
