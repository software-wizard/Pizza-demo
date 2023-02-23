package pl.psi.pizza;

public interface Item {
    String getName();
    Menu.Size getSize();
    String getCost();
    Item copy();

    void addSpecial(Addon aIngredient);
}
