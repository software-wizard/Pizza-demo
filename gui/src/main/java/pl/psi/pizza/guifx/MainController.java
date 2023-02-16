package pl.psi.pizza.guifx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import static javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE;

public class MainController {
    @FXML
    private Pane orderPane;
    @FXML
    private TabPane menuTabPane;
    @FXML
    private Runnable refreshGuiFunction = (this::refreshGui);

    @FXML
    private void initialize() {
        refreshGui();
        menuTabPane.setTabClosingPolicy(UNAVAILABLE);
        menuTabPane.getTabs().add(createTab("asdfgh"));
        menuTabPane.getTabs().add(createTab("qwerty"));
    }

    private Tab createTab(String aAA) {
        Tab tab = new Tab(aAA);
        VBox vBox = new VBox();
        vBox.getChildren().add(new Label("1"));
        vBox.getChildren().add(new Label("2"));
        tab.setContent(vBox);
        return tab;
    }

    private void refreshGui() {

    }
}
