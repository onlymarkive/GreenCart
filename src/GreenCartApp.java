import java.util.ArrayList;
import java.util.Scanner;

public class GreenCartApp {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Item> shoppingList = new ArrayList<>();
    private static double budget;
    private static double remainingBudget;
    private static int totalRewardPoints;

    public static void main(String[] args) {
        System.out.println("Welcome to GreenCart!");

        while (true) {
            System.out.println("1. Sign Up");
            System.out.println("2. Log In");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> signUp();
                case 2 -> logIn();
                case 3 -> {
                    System.out.println("Thank you for using GreenCart!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void signUp() {
        System.out.println("\n--- Sign Up ---");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        String password;
        while (true) {
            System.out.print("Enter your password (minimum 8 characters): ");
            password = scanner.nextLine();
            if (password.length() >= 8) {
                break;
            } else {
                System.out.println("Password must be at least 8 characters long. Please try again.");
            }
        }

        System.out.println("Account successfully created! Please log in to continue.\n");
    }

    private static void logIn() {
        System.out.println("\n--- Log In ---");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        System.out.println("Login successful! Welcome, " + username + ".");

        System.out.print("\nEnter your budget (PHP): ");
        budget = scanner.nextDouble();
        remainingBudget = budget;
        System.out.printf("Budget set to PHP %.2f.\n\n", budget);

        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add an Item");
            System.out.println("2. View Shopping List");
            System.out.println("3. View Remaining Budget");
            System.out.println("4. Log Out");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addItem();
                case 2 -> viewShoppingList();
                case 3 -> viewRemainingBudget();
                case 4 -> {
                    System.out.println("Logging out... Thank you for using GreenCart!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addItem() {
        System.out.println("\n--- Add an Item ---");
        int typeChoice = 0;
        // Input validation for item type selection
        while (true) {
            System.out.println("Choose item type:");
            System.out.println("1. Grocery");
            System.out.println("2. Electronic");
            System.out.println("3. Clothing");
            System.out.println("4. Household");
            System.out.println("5. Stationery");
            System.out.print("Enter your choice (1-5): ");
            
            if (scanner.hasNextInt()) {
                typeChoice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (typeChoice >= 1 && typeChoice <= 5) {
                    break; // valid input, break the loop
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number between 1 and 5.");
                scanner.nextLine(); // consume invalid input
            }
        }

        // Input item details
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        double price = 0;
        int quantity = 0;

        // Input validation for price
        while (true) {
            System.out.print("Enter item price (PHP): ");
            if (scanner.hasNextDouble()) {
                price = scanner.nextDouble();
                if (price > 0) {
                    break;
                } else {
                    System.out.println("Price must be greater than zero. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid price.");
                scanner.nextLine(); // consume invalid input
            }
        }

        // Input validation for quantity
        while (true) {
            System.out.print("Enter quantity: ");
            if (scanner.hasNextInt()) {
                quantity = scanner.nextInt();
                if (quantity > 0) {
                    break;
                } else {
                    System.out.println("Quantity must be greater than zero. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid quantity.");
                scanner.nextLine(); // consume invalid input
            }
        }

        // Calculate total cost
        double totalCost = price * quantity;
        if (totalCost > remainingBudget) {
            System.out.println("Insufficient budget. Item not added.");
            return;
        }

        // Add the item to the shopping list based on the user's choice
        Item item = null;
        switch (typeChoice) {
            case 1:
                item = new GroceryItem(name, price, quantity);
                break;
            case 2:
                item = new ElectronicItem(name, price, quantity);
                break;
            case 3:
                item = new ClothingItem(name, price, quantity);
                break;
            case 4:
                item = new HouseholdItem(name, price, quantity);
                break;
            case 5:
                item = new StationeryItem(name, price, quantity);
                break;
            default:
                System.out.println("Invalid choice. Item not added.");
                return;
        }

        // Add the item to the shopping list
        shoppingList.add(item);
        remainingBudget -= totalCost;
        totalRewardPoints += quantity;

        // Display eco-friendly tip and item details
        System.out.println("\nEco-friendly Tip: " + item.getEcoFriendlyTip());
        System.out.println("Item added successfully!");
        System.out.printf("Total Cost: PHP %.2f\n", totalCost);
        System.out.printf("Remaining Budget: PHP %.2f\n", remainingBudget);
        System.out.println("Reward Points Earned: " + quantity);
    }

    private static void viewShoppingList() {
        System.out.println("\n--- Shopping List ---");
        if (shoppingList.isEmpty()) {
            System.out.println("Your shopping list is empty.");
            return;
        }
    
        double grandTotal = 0;
        for (int i = 0; i < shoppingList.size(); i++) {
            Item item = shoppingList.get(i);
            double totalCost = item.getPrice() * item.getQuantity();
            grandTotal += totalCost;
            String itemType = (item instanceof GroceryItem) ? "Grocery" :
                               (item instanceof ElectronicItem) ? "Electronic" :
                               (item instanceof ClothingItem) ? "Clothing" :
                               (item instanceof HouseholdItem) ? "Household" : "Stationery";
            
            System.out.printf("%d. %s (x%d) - PHP %.2f each [%s]\n   Total: PHP %.2f\n",
                i + 1, item.getName(), item.getQuantity(), item.getPrice(), itemType, totalCost);
        }
        System.out.println("-------------------------------------");
        System.out.printf("Grand Total: PHP %.2f\n", grandTotal);
        System.out.println("Reward Points: " + totalRewardPoints);
    }
    
    private static void viewRemainingBudget() {
        System.out.printf("\nRemaining Budget: PHP %.2f\n", remainingBudget);
    }
}
