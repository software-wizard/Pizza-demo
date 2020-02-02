package pl.psi.pizza.guifx;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class PizzaEntry extends HBox {

    Button addToOrderButton;

    public PizzaEntry(String aText) {
        getChildren().add(new Label(aText));
        addToOrderButton = new Button("+");
        getChildren().add(addToOrderButton);
    }
}
