package pl.psi.items;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.psi.items.ingredients.Addon;
import pl.psi.menu.Menu;

import java.util.List;

@Getter
@AllArgsConstructor
abstract public class AbstractItem implements Item {

    private String name;
    private Menu.Size size;
    private List<Addon> addons;

    @Override
    public void addSpecial(Addon aIngredient) {
        addons.add(aIngredient);
    }
}
