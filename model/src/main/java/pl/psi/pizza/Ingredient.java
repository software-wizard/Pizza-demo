package pl.psi.pizza;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class Ingredient implements Addon{
    private final String name;
    private final Menu.Size size;
    private final BigDecimal cost;

    Ingredient(String aName, Menu.Size aSize, BigDecimal aCost) {
        name = aName;
        size = aSize;
        cost = aCost;
        cost.setScale(2);
    }
}
