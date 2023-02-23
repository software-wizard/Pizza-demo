package pl.psi.pizza;

import lombok.Getter;

public enum IngredientEnum {
    PEPPER("Papryka"),
    GARLIC("Czosnek"),
    CHAMPIGNON("Pieczarki"),
    PINEAPPLE("Ananas"),
    MOZZARELLA("Mozzarella"),
    SALAMI("Salami"),
    ARTICHOCKE("Karczoch"),
    CORN("Kukurydza"),
    TOMATO_SAUSE("Sos pomidorowy"),
    BECON("Bekon"),
    HAM("Szynka"),
    GARLIC_SAUSE("Sos czosnkowy"),
    OLIVE_OIL("Oliwa z oliwek"),
    BLACK_OIL("Czarne oliwki");

    @Getter
    private final String name;

    IngredientEnum(String aName) {
        name = aName;
    }
}
