package main;

import java.util.List;
import java.io.IOException;
import java.util.Scanner;

import FoodSystem.Food;
import FoodSystem.FoodOrder;
import FoodSystem.Menu;
import FoodSystem.MenuData;
import OrderSystem.Order;
import OrderSystem.OrderData;
import BranchSystem.BranchInfo; 

public class CustomerInterface {
    private MenuData menuData;
    private Menu menu;
    private BranchInfo branch;
    private Order currentOrder;
    private OrderData orderData;
    Scanner scanner;
    
    public CustomerInterface(BranchInfo branch) {
        this.branch = branch;
    }


    public CustomerInterface() {
    }


    public void orderRun(){
        placeOrder();
        choosePayment();
    }

    // public void displayMenu(){
    //     Menu menu = menuData.read("menu_list.txt"); // Load the menu
    //     System.out.println("\n=== Menu for " + branch + " ===");
    //     menu.displayMenu(branch); // Display the menu for the chosen branch
    // }

    public void placeOrder() {
    currentOrder = new Order(); // New order with system-generated ID

    boolean ordering = true;
    while (ordering) {
        System.out.println("\n=== Menu for " + branch.getBranchName() + " ===");
        List<Food> menuItems = menu.getFoodList().stream()
            .filter(food -> food.getBranch().equals(branch)) // Get foods for this branch
            .toList(); // Return as a list

        // Display menu items with numbered choices
        for (int i = 0; i < menuItems.size(); i++) {
            Food food = menuItems.get(i);
            System.out.println((i + 1) + ". " + food.getName() + " - $" + food.getPrice());
        }

        System.out.println("Enter the number of the food item to order (type '0' to finish): ");
        int choice = scanner.nextInt(); // Read the user's choice
        scanner.nextLine(); // Consume newline

        if (choice == 0) {
            ordering = false; // Customer is done ordering
        } else if (choice > 0 && choice <= menuItems.size()) {
            Food selectedFood = menuItems.get(choice - 1); // Get the chosen food

            System.out.print("Enter quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine()); // Read quantity

            if (quantity > 0) {
                FoodOrder foodOrder = new FoodOrder(selectedFood, quantity);
                currentOrder.addFoodOrder(foodOrder); 

                System.out.println(quantity + " x " + selectedFood.getName() + " added to your order.");
            } else {
                System.out.println("Quantity must be greater than zero.");
            }
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
        }
    }

    public void choosePayment() {
        if (currentOrder == null) {
            System.out.println("No order to choose payment for. Please place an order first.");
            return;
        }

        try {
            String paymentMethod = currentOrder.choosePayment(); // Use the Order class method
            System.out.println("Payment method chosen: " + paymentMethod);

            // Print receipt after successful payment
            currentOrder.printReceipt(currentOrder.getTotalPrice(), paymentMethod); // Call the printReceipt method

        } catch (IOException e) {
            System.out.println("Error while choosing payment method: " + e.getMessage());
        }
    }

    
    public boolean checkOrderStatus(int orderID) {
        List<Order> allOrders = orderData.getAllOrders();
        for (Order order : allOrders) {
            if (order.getOrderID() == orderID) {
                order.viewOrder();
                return true;
            }
        }

        System.out.println("ORDER NOT FOUND!");
        return false;

    }


    }
