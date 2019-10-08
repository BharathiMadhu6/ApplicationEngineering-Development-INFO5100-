package Question3;

import java.util.Vector;

public class Checkout {

    Vector dessertItems = new Vector();

    Checkout() {
    }

    public int numberOfItems() {
        return dessertItems.size();
    }

    public void enterItem(DessertItem item) {
        dessertItems.add(item);
    }

    public void clear() {
        dessertItems.clear();
    }

    public int totalCost() {
        int totCost = 0;
        for (int i = 0; i < dessertItems.size(); i++) {
            DessertItem r = (DessertItem) dessertItems.elementAt(i);
            totCost += r.getCost();
        }
        return totCost;
    }

    public int totalTax() {
        int tax = (int) Math.round(totalCost() * DessertShop.taxRate);
       return tax;
    }

    public String toString() {
        String storeHeader = DessertShop.storeName + "\n---------------------\n\n";
        String receipt = "";

        for (int i = 0; i < dessertItems.size(); i++) {
            int itemDisplayWidth = DessertShop.width;
            DessertItem dessert = (DessertItem) dessertItems.elementAt(i);

            String itemName = dessert.getName();
            String itemPrice = DessertShop.cents2dollarsAndCentsMethod(dessert.getCost());

            String emptyStrings = "";
            int tabWidth = (itemDisplayWidth - itemName.length() + itemPrice.length());
            for (int j = 0; j < tabWidth; j++) {
                emptyStrings += ' ';
            }

            if (dessert instanceof Candy) {
                Candy c = (Candy) dessert;
                String poundDetails = c.getCandyWeight() + " lbs. @ " + c.getPricePerPound() + " /lb";
                receipt += poundDetails + "\n";
                receipt += itemName + emptyStrings + itemPrice + "\n";

            } else if(dessert instanceof Cookie) {
                Cookie c = (Cookie) dessert;
                String dozenPriceDetails = c.getNumber() + " @ " + c.getPricePerDozen()+ " /dz \n";
                receipt += dozenPriceDetails + "\n";
                receipt += itemName + emptyStrings + itemPrice + "\n";
            } else {
                receipt += dessert.getName() + emptyStrings + itemPrice + "\n";
            }
        }

        String taxCostString = "\nTax \t\t\t" + DessertShop.cents2dollarsAndCentsMethod(totalTax()) + "\nTotal Cost\t\t" + DessertShop.cents2dollarsAndCentsMethod(totalCost() + totalTax()) + "\n\n";

        return storeHeader + receipt + taxCostString;
    }
}
