package pl.psi.menu;

import pl.psi.order.OrderItemIf;
import pl.psi.pizza.AbstractPizzaFactory;
import pl.psi.pizza.Pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MenuFactory {

    public Menu create(String aName, AbstractPizzaFactory factory, List<Pizza.PizzaNames> aValues) {
        return new Menu (aName,aValues.stream().map(p -> new MenuItem(factory.createPizza(p))).collect(Collectors.toList()));
    }

    public Menu create(String aName, List<OrderItemIf> aValues) {
        return new Menu (aName,aValues.stream().map(MenuItem::new).collect(Collectors.toList()));
    }
}
