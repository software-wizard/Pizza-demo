package pl.psi.items;

import pl.psi.items.ingredients.Addon;
import pl.psi.menu.Menu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public class Drink implements Item {
    private final String name;
    private final Menu.Size size;
    private final BigDecimal cost;

    public Drink(String aName, Menu.Size aSize, BigDecimal aCost) {
        name = aName;
        size = aSize;
        cost = aCost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Menu.Size getSize() {
        return size;
    }

    @Override
    public String getCost() {
        return cost.toString();
    }

    @Override
    public Item copy() {
        return this;
    }

    @Override
    public Collection<Addon> getAddons() {
        return new ArrayList<>();
    }

    @Override
    public Collection<Addon> allAddons() {
        return new ArrayList<>();
    }

    @Override
    public void addSpecial(Addon aIngredient) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return name;
    }
}
