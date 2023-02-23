package pl.psi.pizza;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import lombok.Getter;

import java.util.List;
import java.util.stream.Stream;

import static pl.psi.pizza.IngredientEnum.*;
import static pl.psi.pizza.PizzaMenu.Name.*;

@Getter
public class PizzaMenu implements Menu {

    enum Name {
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

    PizzaMenu(String aMenuName) {
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
                return Pizza.builder().name(MARGERITTA.getName()).size(aSize).ingredients(List.of(TOMATO_SAUSE, MOZZARELLA)).build();
            case MARINARA:
                return Pizza.builder().name(MARINARA.getName()).size(aSize).ingredients(List.of(TOMATO_SAUSE, MOZZARELLA, GARLIC)).build();
            case NAPOLETANA:
                return Pizza.builder().name(NAPOLETANA.getName()).size(aSize).ingredients(List.of(TOMATO_SAUSE, MOZZARELLA, BLACK_OIL)).build();
            case HAWAJSKA:
                return Pizza.builder().name(HAWAJSKA.getName()).size(aSize).ingredients(List.of(TOMATO_SAUSE, MOZZARELLA, HAM, PINEAPPLE)).build();
            case FUNGHI:
                return Pizza.builder().name(FUNGHI.getName()).size(aSize).ingredients(List.of(TOMATO_SAUSE, MOZZARELLA, CHAMPIGNON)).build();
            case CAPRICCIOSA:
                return Pizza.builder().name(CAPRICCIOSA.getName()).size(aSize).ingredients(List.of(TOMATO_SAUSE, MOZZARELLA, HAM, CHAMPIGNON)).build();
            case DINAMITE:
                return Pizza.builder().name(DINAMITE.getName()).size(aSize).ingredients(List.of(TOMATO_SAUSE, MOZZARELLA, SALAMI)).build();
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
        public void addSpecial(Addon aIngredient) {
            throw new UnsupportedOperationException();
        }
    }
}
