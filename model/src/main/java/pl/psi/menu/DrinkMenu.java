package pl.psi.menu;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import pl.psi.items.Drink;
import pl.psi.items.Item;

import java.math.BigDecimal;

public class DrinkMenu implements Menu {
    @Override
    public String getMenuName() {
        return "Napoje";
    }

    @Override
    public Multimap<String, Item> getItems() {
        Multimap<String, Item> items = ArrayListMultimap.create();
        items.put("Pepsi", new Drink("Pepsi", Size.S, BigDecimal.valueOf(3.50)));
        items.put("Pepsi", new Drink("Pepsi", Size.L, BigDecimal.valueOf(5.50)));
        items.put("Woda", new Drink("Woda", Size.S, BigDecimal.valueOf(2.50)));
        items.put("Woda", new Drink("Woda", Size.L, BigDecimal.valueOf(4.50)));
        return items;
    }
}
