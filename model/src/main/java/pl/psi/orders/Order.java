package pl.psi.orders;

import lombok.Getter;
import pl.psi.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Order {
    @Getter
    List<Item> items = new ArrayList<>();

    void add(Item aItem) {
        items.add(aItem);
    }
}
