package pl.psi.pizza;

import pl.psi.menu.MenuFactory;
import pl.psi.order.OrderItemIf;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pizza implements OrderItemIf {
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
        double cost = pieType.getCost() + additives.stream().mapToDouble(Addition::getCost).sum() + customerAdditives.stream().mapToDouble(Addition::getCost).sum();
        return Math.round(cost * 100.0) / 100.0;
    }

    public String getName(){
        return name;
    }

    public String getFullName() {
        StringBuilder sb = new StringBuilder(name);
        if (pieType.equals(AbstractPizzaFactory.PizzaPieType.ITALIAN)){
            sb.append(" na cienkim cieście");
        }else {
            sb.append(" na grubym cieście");
        }
        if (!customerAdditives.isEmpty()){
            sb.append(". Dodatkowo: ");
            sb.append(customerAdditives.stream().map(Addition::getName).collect(Collectors.joining(", ")));
        }

        return sb.toString();
    }

    public void addCustomerAddition(Addition aAddition) {
        customerAdditives.add(aAddition);
    }

    public String getDescription() {
        return additives.stream().map(Addition::getName).collect(Collectors.joining(", "));
    }

    @Override
    public String getExtendedMenuName() {
        return MenuFactory.ADDITIONAL;
    }
}
