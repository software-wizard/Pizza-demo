package pl.psi.menu;

import pl.psi.order.Order;
import pl.psi.order.OrderItemIf;

public interface MenuItemIf{
    String getMenuDisplayText();
    void addToOrder(Order aOrder);
}
