package pl.psi.pizza.guifx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import pl.psi.pizza.model.AmericanPiePizzaMenu;
import pl.psi.pizza.model.ItalianPiePizzaMenu;

public class MainController {

    @FXML
    private VBox centerBox;
    @FXML
    private Button confirmOrderButton;
    @FXML
    private Label orderPriceLabel;
    @FXML
    private ToggleGroup pieGroup;

    @FXML
    private void initialize() {
        orderPriceLabel.setText(" Tutaj powinny pojawić się zamówione pizze + cena ");
        pieGroup.selectedToggleProperty().addListener( (e) -> refreshMenu());
        refreshMenu();
    }

    private void refreshMenu(){
        centerBox.getChildren().clear();
        String selectedRationText = ((RadioButton) pieGroup.getSelectedToggle()).getText();
        if ("Na cienkim".equals(selectedRationText)) {
            ItalianPiePizzaMenu italianMenu = new ItalianPiePizzaMenu();
            for (String pizza: italianMenu.getPizzasList() ) {
                centerBox.getChildren().add(new PizzaEntry(pizza));
            }
        } else if ("Na grubym".equals(selectedRationText)) {
            AmericanPiePizzaMenu americanMenu = new AmericanPiePizzaMenu();
            for (String pizza: americanMenu.getPizzasList() ) {
                centerBox.getChildren().add(new PizzaEntry(pizza));
            }
        }
    }
}
