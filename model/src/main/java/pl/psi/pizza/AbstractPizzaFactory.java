package pl.psi.pizza;

public abstract class AbstractPizzaFactory {

    public enum PizzaPieType
    {
        ITALIAN(10.0),
        AMERICAN(12.0);

        private final double cost;
        PizzaPieType(double aCost) {
            cost = aCost;
        }

        public double getCost() {
            return cost;
        }
    };

    public Pizza createPizza(Pizza.PizzaNames aPizza){
        final Pizza pizza= createPizzaInstance(aPizza.getName());
        switch (aPizza){
            case MARGERITTA:
                pizza.addStandardAddition(Addition.TOMATO_SAUSE);
                pizza.addStandardAddition(Addition.MOZZERELLA);
                break;
            case MARINARA:
                pizza.addStandardAddition(Addition.TOMATO_SAUSE);
                pizza.addStandardAddition(Addition.MOZZERELLA);
                pizza.addStandardAddition(Addition.GARLIC);
                break;
            case NAPOLETANA:
                pizza.addStandardAddition(Addition.TOMATO_SAUSE);
                pizza.addStandardAddition(Addition.MOZZERELLA);
                pizza.addStandardAddition(Addition.BLACK_OIL);
                break;
            case HAWAJSKA:
                pizza.addStandardAddition(Addition.TOMATO_SAUSE);
                pizza.addStandardAddition(Addition.MOZZERELLA);
                pizza.addStandardAddition(Addition.PINEAPPLE);
                break;
            case FUNGHI:
                pizza.addStandardAddition(Addition.TOMATO_SAUSE);
                pizza.addStandardAddition(Addition.MOZZERELLA);
                pizza.addStandardAddition(Addition.CHAMPIGNON);
                break;
            case QUATRO:
                pizza.addStandardAddition(Addition.TOMATO_SAUSE);
                pizza.addStandardAddition(Addition.MOZZERELLA);
                pizza.addStandardAddition(Addition.ARTICHOCKE);
                pizza.addStandardAddition(Addition.PEPPER);
                pizza.addStandardAddition(Addition.HAM);
                break;
            case CAPRICCIOSA:
                pizza.addStandardAddition(Addition.TOMATO_SAUSE);
                pizza.addStandardAddition(Addition.MOZZERELLA);
                pizza.addStandardAddition(Addition.CHAMPIGNON);
                pizza.addStandardAddition(Addition.HAM);
                break;
            case DINAMITE:
                pizza.addStandardAddition(Addition.TOMATO_SAUSE);
                pizza.addStandardAddition(Addition.MOZZERELLA);
                pizza.addStandardAddition(Addition.SALAMI);
                break;
            default:
                throw new IllegalArgumentException("Unrecognized pizza :(");
        }
        return pizza;
    }

    protected abstract Pizza createPizzaInstance(String aName);

}
