package OrderSystem;
import java.util.ArrayList;
import FoodSystem.FoodOrder;

public class OrderData {
    private ArrayList<Order> orderList; // ArrayList to store orders

    public OrderData() {
        this.orderList = new ArrayList<>();
    }

    // Add an order to the list
    public void addOrder(Order order) {
        this.orderList.add(order);
    }

    // Get all orders
    public ArrayList<Order> getOrders() {
        return orderList;
    }

    // Process an order (e.g., mark as prepared)
    public void processOrder(int orderID) {
        for (Order order : orderList) {
            if (order.getOrderID() == orderID) {
                order.checkOutCart(); 
                break;
            }
        }
    }
}
