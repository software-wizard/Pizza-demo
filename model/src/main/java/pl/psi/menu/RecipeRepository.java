package pl.psi.menu;

import java.util.ArrayList;
import java.util.List;

public class RecipeRepository {
    private List<Menu> repository = new ArrayList<>();

    public RecipeRepository() {
        repository.add(new PizzaMenu("Pizza"));
        repository.add(new DrinkMenu());
    }

    public List<Menu> getMenus() {
        return repository;
    }
}
