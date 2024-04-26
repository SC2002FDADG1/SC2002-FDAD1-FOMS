package FoodSystem;
import BranchSystem.BranchInfo;

public class Food 
{
    public enum FoodAvailability { YES, NO }
    public enum Category { SIDE, SET_MEAL, BURGER, DRINK }
    
    private String name;
    private double price;
    private BranchInfo branch; 
    private Category category; 
    private FoodAvailability availability; 
    
    public Food(String name2, double price2, BranchInfo branch2, Category category2, FoodAvailability yes) 
    {
        this.name = name2;
        this.price = price2;
        this.branch = branch2;
        this.category = category2;
        this.availability = yes;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getPrice() 
    {
        return price;
    }

    public void setPrice(double price) 
    {
        this.price = price;
    }

    public BranchInfo getBranch() 
    {
        return branch;
    }
    
    public void setBranch(BranchInfo branch) 
    {
        this.branch = branch;
    }

    public Category getCategory() 
    {
        return category;
    }

    public void setCategory(Category category) 
    {
        this.category = category;
    }

    public FoodAvailability getAvailability() 
    {
        return availability;
    }

    public void setAvailability( FoodAvailability availability) 
    {
        this.availability = availability;
    }
    
    // method to check if the food is available
    public boolean isAvailable() 
    {
        return this.availability == FoodAvailability.YES;
    }
    
    @Override
    
    public String toString() {
        // Define field lengths for consistent margins
        int nameWidth = 15; // Width for name
        int priceWidth = 10; // Width for price
        int branchWidth = 15; // Width for branch
        int categoryWidth = 10; // Width for category
        int availabilityWidth = 12; // Width for availability


        // Use formatted strings to align text with consistent margins
        return String.format(
            "%-" + nameWidth + "s %" + priceWidth + ".2f %" + branchWidth + "s %" + categoryWidth + "s %" + availabilityWidth + "s",
            name, // Left align name
            price, // Right align price with 2 decimal places
            branch.getBranchName(), // Left align branch
            category.toString(), // Left align category
            availability.toString() // Left align availability
        );
    }
    
//    public String toString() 
//    {
//        return "Food{" +
//                "name='" + this.name + '\'' +
//                ", price=" + this.price +
//                ", branch=" + (this.branch != null ? this.branch.toString() : "No branch") +
//                ", category=" + this.category +
//                ", availability=" + this.availability +
//                '}';
//    }
}