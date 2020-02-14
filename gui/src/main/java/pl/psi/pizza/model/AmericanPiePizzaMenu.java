package pl.psi.pizza.model;

import java.util.ArrayList;
import java.util.List;

public class AmericanPiePizzaMenu {
    public List<String> getPizzasList() {
        ArrayList<String> pizzas = new ArrayList<>();
        pizzas.add("MARGERITTA          15.50");
        pizzas.add("MARINARA            16.40");
        pizzas.add("NAPOLETANA          18.50");
        pizzas.add("HAWAJSKA            16.40");
        pizzas.add("FUNGHI              16.10");
        pizzas.add("QUATRO STAGIONI     20.20");
        pizzas.add("CAPRICCIOSA         18.80");
        pizzas.add("DINAMITE            17.10");
        return pizzas;
    }
}
