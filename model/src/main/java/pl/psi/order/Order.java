package pl.psi.order;

import java.util.ArrayList;
import java.util.List;

public class Order {

    List<OrderItemIf> items;

    public Order(){
        items = new ArrayList<>();
    }

    public void addItem(OrderItemIf aPizza) {
        items.add(aPizza);
    }

    public List<OrderItemIf> getItems() {
        return items;
    }

    public double calculateOrderCost(){
        return items.stream().mapToDouble(OrderItemIf::getCost).sum();
    }
}
