package Question3;

public abstract class DessertItem {

    String name;

    DessertItem() {
    }

    DessertItem (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract int getCost();
}
