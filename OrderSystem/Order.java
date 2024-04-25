package OrderSystem;
import java.util.ArrayList;
import FoodSystem.FoodOrder; // Import the FoodOrder class from the FoodSystem package

public class Order {
    private int orderID;
    private KindOfPickUp kindOfPickUp;
    private Status status;
    private float totalPrice;
    private ArrayList<FoodOrder> foodOrders; // List to store multiple FoodOrder objects

    // Constructor initializes an empty list for FoodOrders
    public Order() {
        this.foodOrders = new ArrayList<>();
    }

    public Order(int orderID, KindOfPickUp kindOfPickUp, Status status) {
        this();
        this.orderID = orderID;
        this.kindOfPickUp = kindOfPickUp;
        this.status = status;
    }
    

    // Add a FoodOrder to the list and update the total price
    public void addFoodOrder(FoodOrder foodOrder) {
        this.foodOrders.add(foodOrder);
        this.totalPrice += foodOrder.getFood().getPrice() * foodOrder.getQuantity();
    }

    // Getters and setters for Order attributes
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public KindOfPickUp getKindOfPickUp() {
        return kindOfPickUp;
    }

    public void setKindOfPickUp(KindOfPickUp kindOfPickUp) {
        this.kindOfPickUp = kindOfPickUp;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void recalculateTotalPrice() {
        this.totalPrice = 0;
        for (FoodOrder foodOrder : foodOrders) {
            this.totalPrice += foodOrder.getFood().getPrice() * foodOrder.getQuantity();
        }
    }
    
    public float getTotalPrice() {
        return totalPrice;
    }

    // Methods to manage the order lifecycle
    public void checkOutCart() {
        // Implement the checkout logic, e.g., setting status, confirming payment
        setStatus(Status.PREPARING);
    }

    public void choosePayment() {
        // Implement logic for choosing a payment method
    }

    public void viewOrder() {
        // Implement logic to display the order details
        System.out.println(this); // Assuming a toString() method is implemented
    }

    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder();
        orderDetails.append("Order ID: ").append(orderID).append("\n");
        orderDetails.append("Pick-Up Method: ").append(kindOfPickUp).append("\n");
        orderDetails.append("Status: ").append(status).append("\n");
        orderDetails.append("Total Price: $").append(String.format("%.2f", totalPrice)).append("\n");
        orderDetails.append("Order Items:").append("\n");
    
        for (FoodOrder fo : foodOrders) {
            orderDetails.append(" - ").append(fo.getFood().getName())
                         .append(" x ").append(fo.getQuantity())
                         .append(" (").append(String.format("%.2f", fo.getFood().getPrice() * fo.getQuantity()))
                         .append(")\n");
        }
    
        return orderDetails.toString();
    }
    
    public void printReceipt() {
        System.out.println("====== Order Receipt ======");
        System.out.println(this);
        System.out.println("==========================");
    }

    public void removeFoodOrder(int index) {
        if (index < 0 || index >= foodOrders.size()) {
            throw new IndexOutOfBoundsException("Invalid index.");
        }
        FoodOrder removed = foodOrders.remove(index);
        this.totalPrice -= removed.getFood().getPrice() * removed.getQuantity();
    }
    
}
