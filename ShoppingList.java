import java.util.ArrayList;

public class ShoppingList {
    private ArrayList<Item> items;
    private double budget;
    private double totalCost;
    private int totalRewardPoints;

    public ShoppingList(double budget) {
        this.budget = budget;
        this.totalCost = 0.0;
        this.items = new ArrayList<>();
        this.totalRewardPoints = 0;
    }

    public void addItem(Item item) {
        items.add(item);
        totalCost += item.getPrice() * item.getQuantity();
        totalRewardPoints += item.getQuantity();  // Reward points are based on quantity
    }

    public void displayListDetails() {
        System.out.println("\nYour Shopping List:");
        for (Item item : items) {
            item.displayDetails();
        }
        System.out.printf("Total Cost: PHP %.2f\n", totalCost);
        System.out.printf("Remaining Budget: PHP %.2f\n", budget - totalCost);
        System.out.println("Total Reward Points: " + totalRewardPoints);
    }

    public void suggestEcoFriendlyTip(Item item) {
        System.out.println("\nEco-friendly Tip:");
        if (item instanceof GroceryItem) {
            System.out.println("Consider buying items with minimal packaging or bringing your own reusable bags.");
        } else if (item instanceof ElectronicItem) {
            System.out.println("Recycle old electronics responsibly and consider energy-efficient options.");
        } else {
            System.out.println("Choose products with sustainable materials or minimal environmental impact.");
        }
    }
}
