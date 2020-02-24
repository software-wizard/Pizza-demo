package pl.psi.pizza.guifx;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import pl.psi.menu.Menu;
import pl.psi.menu.MenuFactory;
import pl.psi.menu.MenuItemIf;
import pl.psi.order.Order;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

public class MainController {
    @FXML
    private Pane orderWrapper;
    @FXML
    private Pane menuChooserWrapper;
    @FXML
    private Pane menuWrapper;
    private Runnable refreshGuiFunction = (this::refreshGui);

    private Order order = new Order();
    private Map<String,String> menusMap = new HashMap<>(){{
        put("Piza na cienkim", MenuFactory.ITALIAN_PIZZA);
        put("Pizza na grubym", MenuFactory.AMERICAN_PIZZA);
        put("Dostawa", MenuFactory.DELIVERY);
    }};

    @FXML
    private void initialize() {
        refreshGui();
        initMenuChooser();
    }

    private void refreshGui() {
        refreshOrder();
    }

    private void refreshOrder() {
        orderWrapper.getChildren().clear();
        orderWrapper.getChildren().add(new OrderNode(order));
    }

    private void initMenuChooser() {
        ComboBox<String> menuTypeCombo = new ComboBox<>();
        menuTypeCombo.getItems().addAll(menusMap.keySet());

        menuTypeCombo.valueProperty().addListener((aObs, aOld, aNew) -> {
            refreshMenu(MenuFactory.createMenu(menusMap.get(aNew)));
        });

        menuTypeCombo.setValue("Piza na cienkim");
        menuChooserWrapper.getChildren().add(menuTypeCombo);
    }

    private void refreshMenu(Menu menu){
        menuWrapper.getChildren().clear();
        Iterator<MenuItemIf> iterator = menu.getItemsIterator();
        while (iterator.hasNext()){
            menuWrapper.getChildren().add(new MenuItemNode(iterator.next(), order, refreshGuiFunction));
        }
    }
}
