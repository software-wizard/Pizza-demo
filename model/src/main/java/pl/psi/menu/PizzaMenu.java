package pl.psi.menu;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import lombok.Getter;
import pl.psi.items.Item;
import pl.psi.items.Pizza;
import pl.psi.items.ingredients.Addon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static pl.psi.items.ingredients.IngredientEnum.*;
import static pl.psi.menu.PizzaMenu.Name.*;

@Getter
public class PizzaMenu implements Menu {

    public enum Name {
        MARGERITTA("Margaritta"),
        MARINARA("Marinara"),
        NAPOLETANA("Napoleońska"),
        HAWAJSKA("Hawajska"),
        FUNGHI("Fungi"),
        CAPRICCIOSA("Capricciosa"),
        DINAMITE("Dynamit");


        @Getter
        private final String name;

        Name(String aName) {
            name = aName;
        }
    }

    private final String menuName;
    private Multimap<String, Item> items = ArrayListMultimap.create();

    public PizzaMenu(String aMenuName) {
        menuName = aMenuName;
        items.put("", new PizzaMenuHeader(Size.S));
        items.put("", new PizzaMenuHeader(Size.M));
        items.put("", new PizzaMenuHeader(Size.L));
        items.put("", new PizzaMenuHeader(Size.XL));

        Stream.of(Name.values()).forEach(name -> {
            items.put(name.getName(), createPizza(name, Size.S));
            items.put(name.getName(), createPizza(name, Size.M));
            items.put(name.getName(), createPizza(name, Size.L));
            items.put(name.getName(), createPizza(name, Size.XL));
        });
    }

    public Pizza createPizza(Name aName, Size aSize) {
        switch (aName) {
            case MARGERITTA:
                return new Pizza(MARGERITTA.getName(), aSize, List.of(TOMATO_SAUSE,
                        MOZZARELLA));
            case MARINARA:
                return new Pizza(MARINARA.getName(), aSize, List.of(TOMATO_SAUSE,
                        MOZZARELLA, GARLIC));
            case NAPOLETANA:
                return new Pizza(NAPOLETANA.getName(), aSize, List.of(TOMATO_SAUSE,
                        MOZZARELLA, BLACK_OIL));
            case HAWAJSKA:
                return new Pizza(HAWAJSKA.getName(), aSize, List.of(TOMATO_SAUSE,
                        MOZZARELLA, HAM, PINEAPPLE));
            case FUNGHI:
                return new Pizza(FUNGHI.getName(), aSize, List.of(TOMATO_SAUSE,
                        MOZZARELLA, CHAMPIGNON));
            case CAPRICCIOSA:
                return new Pizza(CAPRICCIOSA.getName(), aSize, List.of(TOMATO_SAUSE,
                        MOZZARELLA, HAM, CHAMPIGNON));
            case DINAMITE:
                return new Pizza(DINAMITE.getName(), aSize, List.of(TOMATO_SAUSE,
                        MOZZARELLA, SALAMI));
            default:
                throw new IllegalArgumentException("Unrecognized pizza :(" + aName + ")");
        }
    }


    private final static class PizzaMenuHeader implements Item {

        @Getter
        private Size size;

        PizzaMenuHeader(Size aSize) {
            size = aSize;
        }

        @Override
        public String getName() {
            return "";
        }

        @Override
        public String toString() {
            return "";
        }

        @Override
        public String getCost() {
            if (size.equals(Menu.Size.S)) {
                return "   S   ";
            } else if (size.equals(Menu.Size.M)) {
                return "   M   ";
            } else if (size.equals(Menu.Size.L)) {
                return "   L   ";
            } else if (size.equals(Menu.Size.XL)) {
                return "   XL   ";
            } else {
                return "";
            }
        }

        @Override
        public Item copy() {
            throw new UnsupportedOperationException();
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
    }
}
