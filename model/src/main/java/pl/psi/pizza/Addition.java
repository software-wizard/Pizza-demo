package pl.psi.pizza;

import pl.psi.order.OrderItemIf;

public enum Addition implements OrderItemIf {

    PEPPER("papryka", 0.80),
    GARLIC("czosnek", 0.90),
    CHAMPIGNON("pieczarki", 1.10),
    PINEAPPLE ("ananas", 1.40),
    MOZZARELLA("mozzarella", 1.50),
    SALAMI ("salami", 1.60),
    ARTICHOCKE("karczoch", 1.70),
    CORN ("kukurydza", 1.90),
    TOMATO_SAUSE("sos pomidorowy", 2.00),
    BECON ("bekon", 2.10),
    HAM ("szynka", 2.20),
    GARLIC_SAUSE("sos czosnkowy", 2.50),
    OLIVE_OIL("oliwa z oliwek", 3.00),
    BLACK_OIL("czarne oliwki", 3.20);

    private final String name;
    private final double cost;

    Addition(String aName, double aCost) {
        name = aName;
        cost = aCost;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String getFullName() {
        return "";
    }

    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return "";
    }
}
