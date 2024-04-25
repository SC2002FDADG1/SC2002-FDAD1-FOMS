package FoodSystem;

public class FoodOrder {
    private Food food; // Reference to the specific food item being ordered
    private int quantity; // Quantity of the food item ordered

    public FoodOrder(){

    }
    
    public FoodOrder(Food food, int quantity) {
        setFood(food);
        setQuantity(quantity);
    }


    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        if (food != null) {
            this.food = food;
        } else {
            throw new IllegalArgumentException("Food cannot be null.");
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
    }

    @Override
    public String toString() {
        return "Order: " + food.getName() + ", Price: " + food.getPrice() + ", Quantity: " + quantity;
    }

}
