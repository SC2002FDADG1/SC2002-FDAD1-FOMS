package LoginSystem;

import OrderSystem.Order;
import java.util.ArrayList;

public class OrderIDValidator {
    public Order validate(ArrayList<Order> orderList, int userInput) {
        // Iterate through the orderList
        for (Order order : orderList) {
            // Check if the orderID matches the user input
            if ( order.getOrderID() == userInput ) 
            {
                return order; // Return the order object if found
            }
        }
        // If orderID not found, return null
        return null;
    }
}