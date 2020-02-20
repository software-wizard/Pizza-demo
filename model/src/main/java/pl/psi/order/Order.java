package pl.psi.order;

import pl.psi.pizza.Pizza;

import java.util.ArrayList;
import java.util.List;

public class Order {

    List<Pizza> items;

    public Order(){
        items = new ArrayList<>();
    }

    public void addItem(Pizza aPizza) {
        items.add(aPizza);
    }

    public List<Pizza> getItems() {
        return items;
    }

    public double calculateOrderCost(){
        return items.stream().mapToDouble(Pizza::getCost).sum();
    }
}
