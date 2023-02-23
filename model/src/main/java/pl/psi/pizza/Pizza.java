package pl.psi.pizza;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class Pizza implements Item {
    public static final int DOUGH_COST = 10;
    private String name;
    private Menu.Size size;
    private List<IngredientEnum> ingredients;
    private List<Addon> addonIngredients;

    @Override
    public String getCost() {
        BigDecimal result =
                BigDecimal.valueOf(DOUGH_COST).add(ingredients.stream().map(ingredientEnum -> IngredientRepository.getIngredient(ingredientEnum, size).getCost()).reduce(BigDecimal::add).orElseThrow());
        return result.add(addonIngredients.stream().map(Addon::getCost).reduce(BigDecimal::add).orElse(BigDecimal.ZERO)).setScale(2,
                RoundingMode.HALF_DOWN).toString();
    }

    @Override
    public Item copy() {
        return new Pizza(name, size, ingredients, addonIngredients);
    }

    @Override
    public void addSpecial(Addon aIngredient) {
        addonIngredients.add(aIngredient);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pizza ");
        sb.append(name);
        sb.append(System.lineSeparator());
        ingredients.stream().map(IngredientEnum::getName).forEach(ingredient -> {
            sb.append(ingredient);
            sb.append(", ");
        });
        String result = sb.substring(0, sb.length() - 2);

        if (!getAddonIngredients().isEmpty()) {
            final StringBuilder sb2 = new StringBuilder(result);
            sb2.append(System.lineSeparator());
            getAddonIngredients().stream().map(Addon::getName).forEach(ingredient -> {
                sb2.append(ingredient);
                sb2.append(", ");
            });
            result = sb2.substring(0, sb2.length() - 2);
        }
        return result;
    }

    public static PizzaBuilder builder() {
        return new CustomPizzaBuilder();
    }

    private static class CustomPizzaBuilder extends PizzaBuilder {
        boolean shouldCreateNewList = true;

        @Override
        public PizzaBuilder addonIngredients(List<Addon> aAddons) {
            shouldCreateNewList = false;
            super.addonIngredients(aAddons);
            return this;
        }

        @Override
        public Pizza build() {
            if (shouldCreateNewList) {
                addonIngredients(new ArrayList<>());
            }
            return super.build();
        }
    }
}
