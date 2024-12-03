import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class GreenCartApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static Map<String, String> users = new HashMap<>();
    private static boolean isLoggedIn = false;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nWelcome to GreenCart: A Smarter Choice for Greener Shopping!");
            System.out.println("1. Sign Up");
            System.out.println("2. Log In");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    signUp();
                    break;
                case 2:
                    if (logIn()) {
                        manageShoppingList();
                        logOut();
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using GreenCart! Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void signUp() {
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();
        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please choose a different one.");
            return;
        }
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        users.put(username, password);
        System.out.println("Sign-up successful! You can now log in.");
    }

    private static boolean logIn() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("Login successful!");
            isLoggedIn = true;
            return true;
        } else {
            System.out.println("Incorrect username or password. Please try again.");
            return false;
        }
    }

    private static void logOut() {
        isLoggedIn = false;
        System.out.println("You have successfully logged out.");
    }

    private static void manageShoppingList() {
        System.out.print("Enter your budget in PHP: ");
        double budget = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        ShoppingList shoppingList = new ShoppingList(budget);

        while (true) {
            System.out.println("\n1. Add Grocery Item");
            System.out.println("2. Add Electronic Item");
            System.out.println("3. View Shopping List");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addItemToShoppingList(shoppingList, "grocery");
                    break;
                case 2:
                    addItemToShoppingList(shoppingList, "electronic");
                    break;
                case 3:
                    shoppingList.displayListDetails();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addItemToShoppingList(ShoppingList shoppingList, String itemType) {
        try {
            System.out.print("Enter item name: ");
            String name = scanner.nextLine();
            System.out.print("Enter price per unit: ");
            double price = scanner.nextDouble();
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Item item = null;
            if ("grocery".equals(itemType)) {
                item = new GroceryItem(name, price, quantity);
            } else if ("electronic".equals(itemType)) {
                item = new ElectronicItem(name, price, quantity);
            }

            if (item != null) {
                shoppingList.addItem(item);
                shoppingList.suggestEcoFriendlyTip(item);
                System.out.println("Item added successfully!");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter correct data types for each field.");
            scanner.nextLine(); // Clear buffer
        }
    }
}
