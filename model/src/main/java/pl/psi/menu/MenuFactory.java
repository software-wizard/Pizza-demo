package pl.psi.menu;

import pl.psi.pizza.AbstractPizzaFactory;
import pl.psi.pizza.Pizza;

import java.util.ArrayList;
import java.util.List;

public class MenuFactory {

    public Menu create(String aName, AbstractPizzaFactory factory, List<Pizza.PizzaNames> values) {
        List<MenuItemIf> ret = new ArrayList<>();
        values.forEach(p ->  ret.add(new MenuItem(factory.createPizza(p))));
        return new Menu (aName,ret);
    }
}
