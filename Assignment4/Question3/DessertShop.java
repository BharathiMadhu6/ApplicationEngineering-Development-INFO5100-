package Question3;

public class DessertShop {

    public static final String storeName = "M & M Dessert Shop";
    public static double taxRate = 0.065;
    public static int maxSize = 25;
    public static int width = 30;

    public static String cents2dollarsAndCentsMethod(int cents) {
        // cents to dollars
        double dollarsAndCents = cents * 1.0 / 100;
        return Double.toString(dollarsAndCents);
    }
}
