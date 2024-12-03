public class ElectronicItem extends Item {
    public ElectronicItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public void displayDetails() {
        System.out.println("Electronic Item: " + getName() + ", Price: PHP " + getPrice() +
                ", Quantity: " + getQuantity());
    }
}
