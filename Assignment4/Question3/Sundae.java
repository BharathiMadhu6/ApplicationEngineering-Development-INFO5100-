package Question3;

public class Sundae extends IceCream {

    private String sundaeName;
    private double sundaeCost;

    Sundae(String name, double cost, String sundaeName, double sundaeCost) {
        super(name, cost);
        this.sundaeName = sundaeName;
        this.sundaeCost = sundaeCost;
    }

    public String getSundaeName() {
        return sundaeName;
    }

    public double getSundaeCost() {
        return sundaeCost;
    }

    public int getCost() {
        double sundaeAndIcecreamTotal = (super.getCost() + sundaeCost);
        int sundaeAndIcecreamTotalCost = (int) Math.round(sundaeAndIcecreamTotal);
        return sundaeAndIcecreamTotalCost;
    }
}
