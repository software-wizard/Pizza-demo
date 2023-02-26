package pl.psi.items.ingredients;

import pl.psi.menu.Menu;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class IngredientRepository {
    private final static Set<Ingredient> ingredients;

    static {
        ingredients = new HashSet<>();
        String csvFile = IngredientRepository.class.getClassLoader().getResource("ingredients.csv").getFile();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(csvFile)))) {
            br.lines().forEach(IngredientRepository::addToRepository);
        } catch (FileNotFoundException aE) {
            aE.printStackTrace();
        } catch (IOException aE) {
            aE.printStackTrace();
        }
    }

    private static void addToRepository(String aLine) {
        if (aLine.equals("name;S;M;L;XL")) {
            return;
        }
        String[] line = aLine.split(";");
        ingredients.add(createIngredient(line, Menu.Size.S));
        ingredients.add(createIngredient(line, Menu.Size.M));
        ingredients.add(createIngredient(line, Menu.Size.L));
        ingredients.add(createIngredient(line, Menu.Size.XL));
    }

    private static Ingredient createIngredient(String[] aLine, Menu.Size aSize) {
        return Ingredient.builder().name(aLine[0]).size(aSize).cost(BigDecimal.valueOf(Double.parseDouble(aLine[aSize.getColumnNumber()]))).build();
    }

    public static Ingredient getIngredient(IngredientEnum ingredientEnum, Menu.Size aSize) {
        return ingredients.stream().filter(ingredient -> ingredient.getSize().equals(aSize) && ingredient.getName().equals(ingredientEnum.getName())).findAny().orElseThrow();
    }

    public static List<Addon> getIngredients(Menu.Size aSize) {
        return ingredients.stream().filter(ingredient -> ingredient.getSize().equals(aSize)).collect(Collectors.toList());
    }
}
