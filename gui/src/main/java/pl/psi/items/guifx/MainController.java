package pl.psi.items.guifx;

import com.google.common.collect.Multimap;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.psi.items.Item;
import pl.psi.menu.RecipeRepository;
import pl.psi.items.ingredients.IngredientRepository;
import pl.psi.menu.Menu;
import pl.psi.orders.OrderEngine;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE;

public class MainController implements PropertyChangeListener {
    @FXML
    private Pane orderPane;
    @FXML
    private TabPane menuTabPane;

    private OrderEngine orderEngine;

    @FXML
    private void initialize() {
        RecipeRepository repository = new RecipeRepository();
        new IngredientRepository();
        repository.getMenus().forEach(this::addMenuTab);
        menuTabPane.setTabClosingPolicy(UNAVAILABLE);
        orderEngine = new OrderEngine();
        orderEngine.addObserver(this);
    }

    private void addMenuTab(Menu aMenu) {
        menuTabPane.getTabs().add(createTab(aMenu));
    }

    private Tab createTab(Menu aMenu) {
        Tab tab = new Tab(aMenu.getMenuName());
        VBox mainBox = new VBox();
        Multimap<String, Item> items = aMenu.getItems();
        items.asMap().entrySet().forEach(entry ->
        {
            HBox oneItemBox = new HBox();
            oneItemBox.setAlignment(Pos.CENTER_RIGHT);
            addNameLabel(entry.getValue().stream().findAny().orElseThrow().toString(), oneItemBox);
            addButtons(entry.getValue(), oneItemBox);

            mainBox.getChildren().add(oneItemBox);
        });


        tab.setContent(mainBox);
        return tab;
    }

    private void addNameLabel(String aName, HBox aOneItemBox) {
        AnchorPane apLeft = new AnchorPane();
        aOneItemBox.getChildren().add(apLeft);
        HBox.setHgrow(apLeft, Priority.ALWAYS);
        HBox name = new HBox();
        name.getChildren().add(new Label(aName));
        apLeft.getChildren().add(name);
    }

    private void addButtons(Collection<Item> items, HBox aOneItemBox) {
        HBox buttons = new HBox();
        aOneItemBox.getChildren().add(buttons);
        buttons.getChildren().addAll(createButtons(items));
    }

    private List<Node> createButtons(Collection<Item> aItems) {
        List<Node> toReturn = new ArrayList<>();
        aItems.forEach(item -> {
            if (item.getCost().contains(" ")) {
                toReturn.add(new Label(item.getCost()));
            } else {
                Button button = new Button(item.getCost());
                button.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> orderEngine.addItem(item));
                toReturn.add(button);
            }
        });
        return toReturn;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        orderPane.getChildren().clear();
        Separator separator = new Separator();
        separator.setMinHeight(40);
        orderPane.getChildren().add(separator);
        orderPane.getChildren().addAll(covertToOrderNode(orderEngine.getItems()));
    }

    private List<Node> covertToOrderNode(List<Item> aItems) {
        return aItems.stream().map(item -> {
            HBox oneItemBox = new HBox();
            AnchorPane apLeft = new AnchorPane();
            oneItemBox.getChildren().add(apLeft);
            HBox.setHgrow(apLeft, Priority.ALWAYS);
            HBox name = new HBox();
            name.getChildren().add(new Label(item.toString()));
            apLeft.getChildren().add(name);

            oneItemBox.getChildren().add(new Label(item.getCost()));
            if (!item.allAddons().isEmpty()) {
                Button personalizeButton = new Button("Personalizuj");
                personalizeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> openPersonalizeView(item));
                oneItemBox.getChildren().add(personalizeButton);
            }
            return oneItemBox;
        }).collect(Collectors.toList());
    }

    private void openPersonalizeView(Item aItem) {
        VBox mainPane = new VBox();

        aItem.allAddons().forEach(ingredient -> {
            HBox oneItemBox = new HBox();
            AnchorPane apLeft = new AnchorPane();
            oneItemBox.getChildren().add(apLeft);
            HBox.setHgrow(apLeft, Priority.ALWAYS);
            oneItemBox.getChildren().add(new Label(ingredient.getName()));
            Button addonButton = new Button(ingredient.getCost().toString());
            addonButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
                aItem.addSpecial(ingredient);
                propertyChange(null);
            });
            oneItemBox.getChildren().add(addonButton);
            mainPane.getChildren().add(oneItemBox);
        });

        Stage dialog = new Stage();
        Scene scene = new Scene(mainPane);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("application.css").toExternalForm());
        dialog.setScene(scene);
        dialog.initOwner(orderPane.getScene().getWindow());
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.showAndWait();
    }

}
