package pl.psi.menu;

import com.google.common.collect.Multimap;
import lombok.Getter;
import pl.psi.items.Item;

public interface Menu {
    enum Size {
        S(1), M(2), L(3), XL(4);
        @Getter
        private final int columnNumber;

        Size(int aColumnNumber) {
            columnNumber = aColumnNumber;
        }
    }

    String getMenuName();

    Multimap<String, Item> getItems();
}
