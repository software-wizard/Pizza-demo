package pl.psi.menu;

import java.util.Iterator;
import java.util.List;

public class Menu {

    private final String name;
    private List<MenuItemIf> menuItems;

    Menu(String aName, List<MenuItemIf> aItems) {
        name = aName;
        menuItems = aItems;
    }

    public Iterator<MenuItemIf> getItemsIterator(){
       return menuItems.iterator();
    }

    public String getName() {
        return name;
    }

    public int getMenuItemSize(){
        return menuItems.size();
    }
}
