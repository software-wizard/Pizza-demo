package pl.psi.items;

import pl.psi.items.ingredients.Addon;
import pl.psi.menu.Menu;

import java.util.Collection;

public interface Item {
    String getName();
    Menu.Size getSize();
    String getCost();
    Item copy();
    Collection<Addon> getAddons();
    Collection<Addon> allAddons();

    void addSpecial(Addon aIngredient);
}
