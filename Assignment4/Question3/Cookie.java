package Question3;

public class Cookie extends DessertItem {

    private int number;
    private double pricePerDozen;

    Cookie(String name, int number, double pricePerDozen) {

        if(name.length() > DessertShop.maxSize) {
            throw new IllegalArgumentException("The name cannot be of length greater than " + DessertShop.maxSize);
        }

        super.name = name;
        this.number = number;
        this.pricePerDozen = pricePerDozen;
    }

    public int getNumber() {
        return this.number;
    }

    public double getPricePerDozen() {
        return this.pricePerDozen;
    }

    public int getCost() {
        double cookieTotal = (number * pricePerDozen);
        int cookieTotalCost = (int) cookieTotal / 12;
        return cookieTotalCost;
    }
}
