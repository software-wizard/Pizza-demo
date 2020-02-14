package pl.psi.pizza;


public class ItalianPizzaFactory {
    public Pizza createPizza(PizzaNames aName) {
        final Pizza pizza = new Pizza(aName);
        switch (aName){
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
}
