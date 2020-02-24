package pl.psi.pizza.guifx;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.psi.order.Order;

public class OrderNode extends VBox {

    private final Order order;

    OrderNode(Order aOrder) {
        order = aOrder;
        getChildren().add(new Label("Zamówienie:"));

        this.order.getItems().forEach(i -> {
                    if (i.getExtendedMenuName() != null) {
                        HBox hbox = new HBox();
                        getChildren().add(hbox);
                        hbox.getChildren().add(new Label(i.getFullName() + ", " + i.getCost()));
                        Button button = new Button("PERSONALIZUJ");
                        button.setOnMouseClicked((e) -> {
                            Stage dialog = new Stage();
                            dialog.initOwner(getScene().getWindow());
                            dialog.initModality(Modality.APPLICATION_MODAL);
                            dialog.showAndWait();
                            VBox pane = new VBox();
                            pane.getChildren().add(MenuNode(new PizzaOrderAdapter(i)));
                            dialog.setScene(new Scene(pane, 50, 50));
                        });
                        hbox.getChildren().add(button);
                    } else {
                        getChildren().add(new Label(i.getFullName() + ", " + i.getCost()));
                    }
                }
        );

        getChildren().add(new Label("W sumie: " + order.calculateOrderCost()));
    }
}
