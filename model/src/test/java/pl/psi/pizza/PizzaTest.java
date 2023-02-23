package pl.psi.pizza;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PizzaTest {

    @BeforeAll
    static void setUp() {
        new IngredientRepository();
    }

    @ParameterizedTest
    @MethodSource("shouldReturnCorrectToStringValues")
    void shouldReturnCorrectCost(Pizza aPizza, String aResult) {
        assertThat(aPizza.toString()).isEqualTo(aResult);
    }

    private static Stream<Arguments> shouldReturnCorrectToStringValues() {
        PizzaMenu menu = new PizzaMenu("aNameMenu");
        return Stream.of(
                Arguments.of(menu.createPizza(PizzaMenu.Name.MARGERITTA, Menu.Size.S), "Pizza Margaritta\r\nSos pomidorowy, Mozzarella"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.MARINARA, Menu.Size.S), "Pizza Marinara\r\nSos pomidorowy, Mozzarella, Czosnek"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.NAPOLETANA, Menu.Size.S), "Pizza Napoleońska\r\nSos pomidorowy, Mozzarella, Czarne oliwki"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.HAWAJSKA, Menu.Size.S), "Pizza Hawajska\r\nSos pomidorowy, Mozzarella, Szynka, Ananas"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.FUNGHI, Menu.Size.S), "Pizza Fungi\r\nSos pomidorowy, Mozzarella, Pieczarki"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.CAPRICCIOSA, Menu.Size.S), "Pizza Capricciosa\r\nSos pomidorowy, Mozzarella, Szynka, Pieczarki"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.DINAMITE, Menu.Size.S), "Pizza Dynamit\r\nSos pomidorowy, Mozzarella, Salami")
        );
    }

    @ParameterizedTest
    @MethodSource("shouldReturnCorrectCostValues")
    void shouldReturnCorrectToString(Pizza aPizza, String aResult) {
        assertThat(aPizza.getCost()).isEqualTo(aResult);
    }

    private static Stream<Arguments> shouldReturnCorrectCostValues() {
        PizzaMenu menu = new PizzaMenu("aNameMenu");
        return Stream.of(
                Arguments.of(menu.createPizza(PizzaMenu.Name.MARGERITTA, Menu.Size.S), "15.00"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.MARINARA, Menu.Size.S), "15.60"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.NAPOLETANA, Menu.Size.S), "17.00"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.HAWAJSKA, Menu.Size.S), "20.00"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.FUNGHI, Menu.Size.S), "17.00"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.CAPRICCIOSA, Menu.Size.S), "20.00"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.DINAMITE, Menu.Size.S), "18.50"),

                Arguments.of(menu.createPizza(PizzaMenu.Name.MARGERITTA, Menu.Size.M), "18.00"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.MARINARA, Menu.Size.M), "19.00"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.NAPOLETANA, Menu.Size.M), "20.30"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.HAWAJSKA, Menu.Size.M), "25.30"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.FUNGHI, Menu.Size.M), "21.00"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.CAPRICCIOSA, Menu.Size.M), "25.30"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.DINAMITE, Menu.Size.M), "23.00"),

                Arguments.of(menu.createPizza(PizzaMenu.Name.MARGERITTA, Menu.Size.L), "21.70"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.MARINARA, Menu.Size.L), "23.20"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.NAPOLETANA, Menu.Size.L), "24.40"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.HAWAJSKA, Menu.Size.L), "32.40"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.FUNGHI, Menu.Size.L), "25.70"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.CAPRICCIOSA, Menu.Size.L), "31.40"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.DINAMITE, Menu.Size.L), "28.30"),

                Arguments.of(menu.createPizza(PizzaMenu.Name.MARGERITTA, Menu.Size.XL), "25.10"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.MARINARA, Menu.Size.XL), "27.20"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.NAPOLETANA, Menu.Size.XL), "28.30"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.HAWAJSKA, Menu.Size.XL), "39.50"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.FUNGHI, Menu.Size.XL), "30.10"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.CAPRICCIOSA, Menu.Size.XL), "37.50"),
                Arguments.of(menu.createPizza(PizzaMenu.Name.DINAMITE, Menu.Size.XL), "33.40")
        );
    }

    @ParameterizedTest
    @MethodSource("shouldReturnCorrectPizzaWithAddonsValues")
    void shouldReturnCorrectPizzaWithAddons(Pizza aPizza, String aToString, String aCost) {
        assertThat(aPizza.toString()).isEqualTo(aToString);
        assertThat(aPizza.getCost()).isEqualTo(aCost);
    }

    private static Stream<Arguments> shouldReturnCorrectPizzaWithAddonsValues() {
        PizzaMenu menu = new PizzaMenu("aNameMenu");
        return Stream.of(
                Arguments.of(preparePizza(menu, PizzaMenu.Name.MARGERITTA, Menu.Size.S), "Pizza Margaritta\r\nSos pomidorowy, Mozzarella\r\na, b", "17.50"),
                Arguments.of(preparePizza(menu, PizzaMenu.Name.MARINARA, Menu.Size.M), "Pizza Marinara\r\nSos pomidorowy, Mozzarella, Czosnek\r\na, b", "21.50"),
                Arguments.of(preparePizza(menu, PizzaMenu.Name.NAPOLETANA, Menu.Size.L), "Pizza Napoleońska\r\nSos pomidorowy, Mozzarella, Czarne oliwki\r\na, b", "26.90")
                );
    }

    private static Pizza preparePizza(PizzaMenu aMenu, PizzaMenu.Name aPizzaName, Menu.Size aSize) {
        Pizza pizza = aMenu.createPizza(aPizzaName, aSize);
        pizza.addSpecial(new Ingredient("a", aSize, BigDecimal.valueOf(1.2)));
        pizza.addSpecial(new Ingredient("b", aSize, BigDecimal.valueOf(1.3)));
        return pizza;
    }
}