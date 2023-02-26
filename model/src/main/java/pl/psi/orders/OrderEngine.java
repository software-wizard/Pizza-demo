package pl.psi.orders;

import pl.psi.items.Item;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class OrderEngine {
    private Order currentOrder;

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public OrderEngine() {
        currentOrder = new Order();
    }

    public void newOrder() {
        Order newOrder = new Order();
        support.firePropertyChange("new Order", currentOrder, newOrder);
        currentOrder = newOrder;
    }

    public List<Item> getItems() {
        return currentOrder.getItems();
    }

    public void addItem(Item aItem) {
        currentOrder.add(aItem.copy());
        support.firePropertyChange("addItem", null, aItem);
    }

    public void addObserver(PropertyChangeListener aListener) {
        support.addPropertyChangeListener(aListener);
    }
}
