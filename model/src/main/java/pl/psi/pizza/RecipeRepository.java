package pl.psi.pizza;

import java.util.ArrayList;
import java.util.List;

public class RecipeRepository {
    private List<Menu> repository = new ArrayList<>();

    public RecipeRepository() {
        repository.add(new PizzaMenu("test"));
    }

    public List<Menu> getMenus() {
        return repository;
    }
}
