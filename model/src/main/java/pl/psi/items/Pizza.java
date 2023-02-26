package pl.psi.items;

import lombok.Getter;
import pl.psi.items.ingredients.Addon;
import pl.psi.items.ingredients.IngredientEnum;
import pl.psi.items.ingredients.IngredientRepository;
import pl.psi.menu.Menu;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Pizza extends AbstractItem {
    public static final int DOUGH_COST = 10;
    private List<IngredientEnum> ingredients;

    public Pizza(String name, Menu.Size size, List<IngredientEnum> aIngredients) {
        this(name, size, aIngredients, new ArrayList<>());
    }

    public Pizza(String name, Menu.Size size, List<IngredientEnum> aIngredients, List<Addon> addon) {
        super(name, size, addon);
        ingredients = aIngredients;
    }

    @Override
    public String getCost() {
        BigDecimal result =
                BigDecimal.valueOf(DOUGH_COST).add(ingredients.stream().map(ingredientEnum -> IngredientRepository.getIngredient(ingredientEnum, getSize()).getCost()).reduce(BigDecimal::add).orElseThrow());
        return result.add(getAddons().stream().map(Addon::getCost).reduce(BigDecimal::add).orElse(BigDecimal.ZERO)).setScale(2,
                RoundingMode.HALF_DOWN).toString();
    }

    @Override
    public Item copy() {
        return new Pizza(getName(), getSize(), ingredients, getAddons());
    }

    @Override
    public List<Addon> allAddons() {
        return IngredientRepository.getIngredients(getSize());
    }

    @Override
    public void addSpecial(Addon aIngredient) {
        getAddons().add(aIngredient);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pizza ");
        sb.append(getName());
        sb.append(System.lineSeparator());
        ingredients.stream().map(IngredientEnum::getName).forEach(ingredient -> {
            sb.append(ingredient);
            sb.append(", ");
        });
        String result = sb.substring(0, sb.length() - 2);

        if (!getAddons().isEmpty()) {
            final StringBuilder sb2 = new StringBuilder(result);
            sb2.append(System.lineSeparator());
            getAddons().stream().map(Addon::getName).forEach(ingredient -> {
                sb2.append(ingredient);
                sb2.append(", ");
            });
            result = sb2.substring(0, sb2.length() - 2);
        }
        return result;
    }
}
