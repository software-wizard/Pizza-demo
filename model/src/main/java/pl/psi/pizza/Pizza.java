package pl.psi.pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pizza {
    public enum PizzaNames {
        MARGERITTA("Margeritta"),
        MARINARA("Marinara"),
        NAPOLETANA("Napoleońska"),
        HAWAJSKA("Hawajska"),
        FUNGHI("Funghi"),
        QUATRO("Quatro"),
        CAPRICCIOSA("Capricciosa"),
        DINAMITE("Dynamit");


        private String name;
        PizzaNames(String aName) {
            name = aName;
        }

        public String getName() {
            return name;
        }

    }

    private final String name;
    private final List<Addition> additives;
    private final AbstractPizzaFactory.PizzaPieType pieType;
    private final List<Addition> customerAdditives;

    Pizza(String aName, AbstractPizzaFactory.PizzaPieType aPieType) {
        name = aName;
        additives = new ArrayList<>();
        customerAdditives = new ArrayList<>();
        pieType = aPieType;
    }

    void addStandardAddition(Addition aAddition){
        additives.add(aAddition);
    }

    public double getCost() {
        return pieType.getCost() + additives.stream().mapToDouble(Addition::getCost).sum() + customerAdditives.stream().mapToDouble(Addition::getCost).sum();
    }

    public String getName() {
        if (pieType.equals(AbstractPizzaFactory.PizzaPieType.ITALIAN)){
            return name + " na cienkim cieście";
        }else {
            return name + " na grubym cieście";
        }
    }

    public void addCustomerAddition(Addition aAddition) {
        customerAdditives.add(aAddition);
    }

    public String getAdditivesForMenu() {
        return additives.stream().map(Addition::getName).collect(Collectors.joining(", "));
    }
}
