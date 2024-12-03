public class GroceryItem extends Item {
    public GroceryItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public void displayDetails() {
        System.out.println("Grocery Item: " + getName() + ", Price: PHP " + getPrice() +
                ", Quantity: " + getQuantity());
    }
}
