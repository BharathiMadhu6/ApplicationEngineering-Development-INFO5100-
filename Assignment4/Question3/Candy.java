package Question3;

public class Candy extends DessertItem {

    private double candyWeight;
    private double pricePerPound;

    Candy(String name, double candyWeight, double pricePerPound) {

        if(name.length() > DessertShop.maxSize) {
            throw new IllegalArgumentException("The name cannot be of length greater than " + DessertShop.maxSize);
        }

        super.name = name;
        this.candyWeight = candyWeight;
        this.pricePerPound = pricePerPound;
    }

    public double getCandyWeight() {
        return this.candyWeight;
    }

    public double getPricePerPound() {
        return this.pricePerPound / 100.0;
    }

    public int getCost() {
        double candyTotal = candyWeight * pricePerPound;
        int candyTotalCost = (int) (Math.round(candyTotal));
        return candyTotalCost;
    }
}
