package pl.psi.order;

import java.util.List;

public class StudentDiscountOrderDecorator extends Order{

    private final Order decorated;



    public StudentDiscountOrderDecorator(Order aDecorated) {
        this.decorated = aDecorated;
    }

    @Override
    public void addItem(OrderItemIf aPizza) {
        decorated.addItem(aPizza);
    }

    @Override
    public List<OrderItemIf> getItems() {
        return decorated.getItems();
    }

    @Override
    public double calculateOrderCost() {
        return decorated.calculateOrderCost() * 0.8;
    }
}
