package pl.psi.menu;

import pl.psi.order.OrderItemIf;

public class MenuItem implements MenuItemIf {

    private final OrderItemIf item;

    MenuItem(OrderItemIf aItem) {
        item = aItem;
    }

    @Override
    public String getMenuDisplayText() {
        //TODO should be 70 char in first line
        int dotCount = 70 - item.getName().toString().length() - String.valueOf(item.getCost()).length();

        StringBuilder sb = new StringBuilder();
        sb.append(item.getName());
        for (int i=0;  i<dotCount ; i++ ) {
            sb.append(".");
        }
        sb.append(String.format("%.2f",item.getCost()));
        if (!item.getDescription().isEmpty()){
            sb.append( System.lineSeparator() );
            sb.append(item.getDescription());
        }
        return sb.toString();
    }

}
