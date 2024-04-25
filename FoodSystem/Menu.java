package FoodSystem;

import java.util.ArrayList;
import BranchSystem.BranchInfo;
private ArrayList<Food> foodList; 

public Menu() {
    this.foodList = new ArrayList<>();
}

public void addFood(Food food) {
    this.foodList.add(food);
}


// Display all food items on the menu
public void displayMenu() {
    for (Food food : foodList) {
        System.out.println(food); // Assuming Food class has a toString override
    }
}

// Display all food items from a specific branch
public void displayMenu(BranchInfo branch) {
    for (Food food : foodList) {
        if (food.isAvailable() && food.getBranch() != null && food.getBranch().getBranchName() != null &&
        food.getBranch().getBranchName().equals(branch.getBranchName())) {
        System.out.println(food);
        }
    }
}

public ArrayList<Food> getFoodList() {
    return foodList;
}

public class Menu {
    
}
