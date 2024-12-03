# 🌿 GreenCart: A Smarter Choice for Greener Shopping 🛒

## Project Overview 🌍

GreenCart is a Java-based console application designed to demonstrate core Object-Oriented Programming (OOP) principles while promoting environmentally friendly shopping. The program enables users to manage their shopping lists, track items, manage budgets, and receive eco-friendly tips. It leverages OOP concepts such as Encapsulation, Inheritance, Polymorphism, and Abstraction, and aligns with the Sustainable Development Goal (SDG) 12: Responsible Consumption and Production.

GreenCart encourages users to make smarter, sustainable shopping choices by tracking their purchases, offering eco-friendly tips, and rewarding users for buying greener products. The application supports adding both grocery and electronic items, calculating total costs, managing budgets, and awarding reward points based on item quantity.

## OOP Principles Applied 💡

### 1. **Encapsulation** 🔒
- **Encapsulation** is achieved by organizing data (fields) and behavior (methods) into classes, ensuring that the internal details of objects are hidden from outside interference.
- For example, in the `ShoppingCart` class, all shopping list items are encapsulated within private fields. Access to these fields is controlled via public methods like `addItem()`, `removeItem()`, and `viewItems()`.

### 2. **Inheritance**👩🏻‍💻
- **Inheritance** allows the program to create specialized types of items that share common properties from a parent class.
- The `Item` class serves as the base class, and both `GroceryItem` and `ElectronicItem` inherit from it. This allows for code reuse and simplifies the addition of new item types in the future.

### 3. **Polymorphism** 🔄
- **Polymorphism** is implemented through method overloading and method overriding.
- For example, `addItem()` is overloaded to handle different types of items (groceries and electronics). Additionally, methods like `calculateTotal()` are overridden in subclasses to define specific behavior for different item types.

### 4. **Abstraction** 🧩
- **Abstraction** is used to hide the complexity of the implementation from the user while exposing necessary functionalities.
- The `Item` class is abstract, meaning that it provides the structure for its subclasses, but does not provide a full implementation. Specific details like calculating prices are handled in the `GroceryItem` and `ElectronicItem` subclasses.

## 🌱 Sustainable Development Goal (SDG) 12: Responsible Consumption and Production ♻️

GreenCart aligns with **SDG 12**: Responsible Consumption and Production by:
- Encouraging users to make smarter, eco-friendly purchasing decisions.
- Offering tips for reducing waste, such as recommending reusable bags and buying items with minimal packaging.
- Promoting sustainable shopping behaviors that support responsible resource use.

The application strives to make users aware of their consumption patterns, offering tips to reduce waste and consider sustainability when making purchasing decisions. By rewarding users for environmentally responsible actions, GreenCart helps build long-term habits for greener consumption.

## 🚀 Features

### 1. **User Authentication** 🔑:
   - Users can sign up and log in securely.

### 2. **Budget Management** 💰:
   - Users input a budget, and the system helps them keep track of how much they've spent and how much is left.

### 3. **Item Management** 🛍️:
   - Users can add grocery or electronic items to their shopping cart, and the program will automatically calculate the total cost, track the remaining budget, and display eco-friendly tips.

### 4. **Eco-friendly Tips** 🌿:
   - After each item is added, an eco-friendly tip is displayed, encouraging users to make greener choices (e.g., using less packaging, reducing plastic waste).

### 5. **Reward Points** 🏅:
   - Users earn reward points based on the quantity of items added to the cart. The more items purchased, the more points earned, which can be used as a way to motivate users to make sustainable purchases.

### 6. **View Shopping List** 📜:
   - Users can view their shopping list with item details such as name, price, quantity, and total cost.

### 7. **Sustainable Shopping** ♻️:
   - The program helps users make sustainable shopping decisions by offering suggestions for eco-friendly alternatives and rewarding them for responsible purchasing.

## 👩🏻‍💼 Conclusion

GreenCart serves as a practical example of how core OOP principles can be applied to real-world problems while also promoting sustainability. The program helps users make smarter, more eco-friendly shopping choices by tracking their spending, providing tips for responsible consumption, and offering a rewards system for making sustainable purchases.

By demonstrating **Encapsulation**, **Inheritance**, **Polymorphism**, and **Abstraction**, GreenCart not only fulfills the OOP project requirements but also contributes to **SDG 12: Responsible Consumption and Production**. It encourages users to make conscious decisions that help reduce waste, conserve resources, and promote sustainable shopping habits.

---
