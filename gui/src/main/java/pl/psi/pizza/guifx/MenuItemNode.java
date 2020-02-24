package pl.psi.pizza.guifx;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import pl.psi.menu.MenuItemIf;

public class MenuItemNode extends HBox {

    private final MenuItemIf menuItem;

    MenuItemNode(MenuItemIf aMenuItem){
        menuItem = aMenuItem;
        getChildren().add(new Label(menuItem.getMenuDisplayText()));
        Button button = new Button("+");
        getChildren().add(button);

        button.setOnAction( (e)->{System.out.println(menuItem.getMenuDisplayText());});
    }
}
