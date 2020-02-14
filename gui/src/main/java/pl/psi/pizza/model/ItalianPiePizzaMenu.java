package pl.psi.pizza.model;

import java.util.ArrayList;
import java.util.List;

public class ItalianPiePizzaMenu {
    public List<String> getPizzasList() {
        ArrayList<String> pizzas = new ArrayList<>();
        pizzas.add("MARGERITTA          13.50");
        pizzas.add("MARINARA            14.40");
        pizzas.add("NAPOLETANA          16.50");
        pizzas.add("HAWAJSKA            14.40");
        pizzas.add("FUNGHI              14.10");
        pizzas.add("QUATRO STAGIONI     18.20");
        pizzas.add("CAPRICCIOSA         16.80");
        pizzas.add("DINAMITE            15.10");
        return pizzas;
    }
}
