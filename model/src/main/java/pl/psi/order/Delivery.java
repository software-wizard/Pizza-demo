package pl.psi.order;

public enum Delivery implements OrderItemIf{

    GRUNWALD("Grunwald",4.0),
    STARE_MIASTO("Stare miasto",5.0),
    WILDA("Wilda",5.0),
    JEZYCE("Jeżyce",5.0),
    NOWE_MIASTO("Nowe miasto",6.0);

    private final String districtName;
    private final double deliveryCost;

    Delivery(String aDistrictName, double aDeliveryCost) {
        deliveryCost=aDeliveryCost;
        districtName=aDistrictName;
    }

    public double getCost() {
        return deliveryCost;
    }

    public String getName(){
        return districtName;
    }

    public String getFullName() {
        return "Dostawa dzielnica: " + districtName;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getExtendedMenuName() {
        return null;
    }

}




