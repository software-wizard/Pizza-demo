package pl.psi.pizza.guifx;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import pl.psi.menu.MenuItemIf;
import pl.psi.order.Order;

public class MenuItemNode extends HBox {

    private final MenuItemIf menuItem;

    MenuItemNode(MenuItemIf aMenuItem, Order order, Runnable refreshGuiFunction){
        menuItem = aMenuItem;
        getChildren().add(new Label(menuItem.getMenuDisplayText()));
        Button button = new Button("+");
        getChildren().add(button);

        button.setOnAction( (e)-> {
            menuItem.addToOrder(order);
            refreshGuiFunction.run();
        } );
    }
}
