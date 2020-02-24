package pl.psi.menu;

import pl.psi.order.Order;

public interface MenuItemIf{
    String getMenuDisplayText();
    void addToOrder(Order aOrder);
}
