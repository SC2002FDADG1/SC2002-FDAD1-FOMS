package FoodSystem;
import BranchSystem.BranchInfo;

public class Food {
    private String name;
    private double price;
    private BranchInfo branch; 
    private Category category; 
    private Availability availability; 

    public enum Availability {
        YES, NO
    }
    
    public enum Category {
        SIDE,
        SET_MEAL,
        BURGER,
        DRINK
    }
    
    public Food(String name2, int price2, BranchInfo branch2, Category category2, Availability yes) {
        this.name = name2;
        this.price = price2;
        this.branch = branch2;
        this.category = category2;
        this.availability = yes;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BranchInfo getBranch() {
        return branch;
    }
    
    public void setBranch(BranchInfo branch) {
        this.branch = branch;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    
    // method to check if the food is available
    public boolean isAvailable() {
        return this.availability == Availability.YES;
    }

}
