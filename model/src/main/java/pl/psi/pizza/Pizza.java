package pl.psi.pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private final String name;
    private final List<Addition> additives;

    public Pizza(PizzaNames aName) {
        name = aName.getName();
        additives = new ArrayList<>();
    }

    void addStandardAddition(Addition aAddition){
        additives.add(aAddition);
    }

    public double getCost() {
        return 10.0 + additives.stream().mapToDouble(Addition::getCost).sum();
    }

    public String getName() {
        return name + " na cienkim cieście";
    }
}
