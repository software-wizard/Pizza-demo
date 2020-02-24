package pl.psi.pizza.guifx;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import pl.psi.order.Order;

public class OrderNode extends VBox {

    private final Order order;

    OrderNode(Order aOrder) {
        order = aOrder;
        getChildren().add(new Label("Zamówienie:"));

        this.order.getItems().forEach(i ->
                getChildren().add(new Label(i.getFullName() + ", " + i.getCost()))
        );
    }
}
