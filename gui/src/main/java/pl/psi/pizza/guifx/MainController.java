package pl.psi.pizza.guifx;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import pl.psi.menu.Menu;
import pl.psi.menu.MenuFactory;
import pl.psi.pizza.model.AmericanPiePizzaMenu;
import pl.psi.pizza.model.ItalianPiePizzaMenu;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    @FXML
    private Pane orderWrapper;
    @FXML
    private Pane MenuChooserWrapper;
    @FXML
    private Pane MenuWrapper;

    private Menu currentMenu;

    @FXML
    private void initialize() {
        orderWrapper.getChildren().add(new Label ("orderWrapper"));
        orderWrapper.getChildren().add(new Label ("orderWrapper2"));

        initMenuChooser();

        MenuWrapper.getChildren().add(new Label ("MenuWrapper"));
        MenuWrapper.getChildren().add(new Label ("MenuWrapper2"));

        refreshMenu();
    }

    private void initMenuChooser() {
        List<Menu> menus = new ArrayList<Menu>();
        menus.add(MenuFactory.createMenu(MenuFactory.ADDITIONAL));
        menus.add(MenuFactory.createMenu(MenuFactory.ITALIAN_PIZZA));
        menus.add(MenuFactory.createMenu(MenuFactory.AMERICAN_PIZZA));
        switch ()
        MenuChooserWrapper.getChildren().add(new Label ("MenuChooserWrapper"));
        ToggleGroup x = new ToggleGroup();
        RadioButton a = new RadioButton(MenuFactory.ADDITIONAL);
        a.setToggleGroup(x);
        a.addEventFilter();
        RadioButton b = new RadioButton(MenuFactory.ITALIAN_PIZZA);
        b.setToggleGroup(x);
        MenuChooserWrapper.getChildren().add(a);
        MenuChooserWrapper.getChildren().add(b);


    }

    private void refreshMenu(){
//        w zależności od klika wziac odpowiednie menu z fabryki
//        centerBox.getChildren().clear();
//        String selectedRationText = ((RadioButton) pieGroup.getSelectedToggle()).getText();
//        if ("Na cienkim".equals(selectedRationText)) {
//            ItalianPiePizzaMenu italianMenu = new ItalianPiePizzaMenu();
//            for (String pizza: italianMenu.getPizzasList() ) {
//                centerBox.getChildren().add(new PizzaEntry(pizza));
//            }
//        } else if ("Na grubym".equals(selectedRationText)) {
//            AmericanPiePizzaMenu americanMenu = new AmericanPiePizzaMenu();
//            for (String pizza: americanMenu.getPizzasList() ) {
//                centerBox.getChildren().add(new PizzaEntry(pizza));
//            }
//        }
    }
}
