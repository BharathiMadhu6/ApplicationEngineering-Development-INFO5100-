package Question3;

public class IceCream extends DessertItem {

    private double iceCost;

    IceCream(String name, double cost) {

        if(name.length() > DessertShop.maxSize) {
            throw new IllegalArgumentException("The name cannot be of length greater than " + DessertShop.maxSize);
        }

        super.name = name;
        this.iceCost = cost;
    }

    public double getIceCost() {
        return this.iceCost;
    }

    public int getCost() {
        int IceCreamTotal = (int) Math.round(iceCost);
        return IceCreamTotal;
    }
}
