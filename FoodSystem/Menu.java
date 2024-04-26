package FoodSystem;

import BranchSystem.BranchAvailability;
import java.util.ArrayList;
import BranchSystem.BranchInfo;
import java.io.File;
import java.io.IOException;

public class Menu 
{
    protected ArrayList<Food> foodList =  new ArrayList<>(); 
    private MenuData txtDB = new MenuData() ;
    private String filename = "menudata.txt" ;

    public Menu() throws IOException 
    {
        try 
        {
            foodList = txtDB.readObject(filename) ;
	}
        catch (IOException e) 
        {
            File myFile = new File("menudata.txt");
            if (myFile.createNewFile()) 
            {
                System.out.println("File created: " + myFile.getName());
            } 
            else 
            {
                System.out.println("File already exists.");
            }
        }
    }

    public void displayMenu() 
    {
        for (Food food : foodList) 
        {
            System.out.println(food); // Assuming Food class has a toString override
        }
    }

    // Display all food items from a specific branch
    public boolean displayMenu(BranchInfo branch) 
    {
        boolean checkamount = false ;
        for (Food food : foodList)
        {
            if ( food.isAvailable() && 
                 food.getBranch() != null &&
                 food.getBranch().getBranchName().equals(branch.getBranchName() ) &&
                 food.getBranch().getAvailable() == BranchAvailability.OPEN ) 
            {
                System.out.println(food);
                checkamount = true ;
            }
        }
        
        if( checkamount == false )
        {
            System.out.println("There is no food here !!") ;
            return false ;
        }
        return true ;
    }

    public ArrayList<Food> getFoodList() 
    {
        return foodList;
    }
    
    public void savefile( ArrayList<Food> newmenu ) throws IOException
    {
        txtDB.save(filename, newmenu) ;
    }
    
    public boolean checkUnique(String name)
    {
        for (Food food : foodList)
        {
            if ( food.getName().equals(name) ) 
            {
                return true;
            }
        }
        return false;
    }
    
    public Food checkName(String name)
    {
        for (Food food : foodList)
        {
            if ( food.getName().equals(name) ) 
            {
                return food;
            }
        }
        return null;
    }
    
}