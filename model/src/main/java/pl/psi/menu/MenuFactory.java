package pl.psi.menu;

import pl.psi.order.Delivery;
import pl.psi.order.OrderItemIf;
import pl.psi.pizza.AbstractPizzaFactory;
import pl.psi.pizza.Addition;
import pl.psi.pizza.Pizza;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MenuFactory {

    public final static String ITALIAN_PIZZA="ITALIAN_PIZZA";
    public final static String AMERICAN_PIZZA="AMERICAN_PIZZA";
    public final static String DELIVERY = "DELIVERY";
    public final static String ADDITIONAL = "ADDITIONAL";

    public static Menu createMenu(String aMenuType){
        switch (aMenuType) {
            case DELIVERY:
                return create("DOSTAWA", Arrays.asList(Delivery.values()));
            case ITALIAN_PIZZA:
                return create("PIZZA NA CIENKIM", AbstractPizzaFactory.getFactory(AbstractPizzaFactory.PizzaPieType.ITALIAN), Arrays.asList(Pizza.PizzaNames.values()));
            case AMERICAN_PIZZA:
                return create("PIZZA NA GRUBYM", AbstractPizzaFactory.getFactory(AbstractPizzaFactory.PizzaPieType.AMERICAN), Arrays.asList(Pizza.PizzaNames.values()));
            case ADDITIONAL:
                return create("DODATKI", Arrays.asList(Addition.values()));
            default:
                throw new IllegalArgumentException("Cannot recognize menu type: " + aMenuType);
        }

    }

    private static Menu create(String aName, AbstractPizzaFactory factory, List<Pizza.PizzaNames> aValues) {
        return new Menu (aName,aValues.stream().map(p -> new MenuItem(factory.createPizza(p))).collect(Collectors.toList()));
    }

    private static Menu create(String aName, List<OrderItemIf> aValues) {
        return new Menu (aName,aValues.stream().map(MenuItem::new).collect(Collectors.toList()));
    }
}
