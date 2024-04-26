package FoodSystem;

import BranchSystem.BranchAvailability;
import Filepackage.* ;
import FoodSystem.Food.Category ;
import FoodSystem.Food.FoodAvailability ;
import BranchSystem.BranchInfo;


import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MenuData implements ReadFile, Save, Write, ReadObject 
{
    public static final String SEPARATOR = "|" ;

    //read method
    @Override
    public List<String> read(String fileName) throws IOException 
    {
	List data = new ArrayList() ;
        try 
        (Scanner scanner = new Scanner(new FileInputStream(fileName))) {
            while (scanner.hasNextLine())
            {
                data.add(scanner.nextLine());
            }
        }
        return data;
    }


    @Override
    public void save(String filename, List al) throws IOException 
    {
    //  Name | Avaiability
	List alw = new ArrayList() ;

        for (int i = 0 ; i < al.size() ; i++) 
        {
            Food food = ( Food )al.get(i);

            StringBuilder st =  new StringBuilder() ;
            
            st.append(food.getName().trim() );
            st.append(SEPARATOR);
            
            double price = food.getPrice() ;
            st.append( String.valueOf(price) ) ;
            st.append(SEPARATOR);

            st.append(food.getBranch().getBranchName().trim() );
            st.append(SEPARATOR);
            
            String availability_branch = ( food.getBranch().getAvailable() == BranchAvailability.OPEN) ? "OPEN" : "CLOSE" ; 
            st.append(availability_branch );
            st.append(SEPARATOR);
            
            st.append(food.getCategory() );
            st.append(SEPARATOR);
            
            String availability_food = ( food.getAvailability() == FoodAvailability.YES) ? "YES" : "NO" ; 
            st.append(availability_food );
            st.append(SEPARATOR);
            
            alw.add( st.toString() ) ;

        }
	write(filename,alw);
    }


    @Override
    public void write(String fileName, List data) throws IOException 
    {
        try 
        (PrintWriter out = new PrintWriter(new FileWriter(fileName) )) {
            for (int i =0; i < data.size() ; i++) 
            {
                out.println((String)data.get(i));
            }
        }
    }

    @Override
    public ArrayList readObject(String filename) throws IOException 
    {
        ArrayList<String> stringArray = (ArrayList<String>) read(filename); // Read lines from the file
        ArrayList<Food> foodList = new ArrayList<>(); // To store parsed food objects
        
        for (int i = 0; i < stringArray.size(); i++) {
    String st = stringArray.get(i);
    StringTokenizer star = new StringTokenizer(st, SEPARATOR);
    
    String foodname = "";
    if (star.hasMoreTokens()) {
        foodname = star.nextToken().trim();
    } else {
        // Handle the case where there are no tokens (perhaps continue to the next iteration or log an error)
        continue; // Skip this iteration as there's no data to process
    }

    double price = 0;
    if (star.hasMoreTokens()) {
        try {
            String token = star.nextToken().trim();
            price = Double.valueOf(token);
        } catch (IllegalArgumentException e) {
            price = 0; // Default value or handle error
        }
    }

    String branchname = star.hasMoreTokens() ? star.nextToken().trim() : "";
    BranchAvailability branchavailability = null;
    if (star.hasMoreTokens()) {
        try {
            String token = star.nextToken().trim();
            branchavailability = BranchAvailability.valueOf(token);
        } catch (IllegalArgumentException e) {
            branchavailability = null; // Default value or handle error
        }
    }
    
    Category category = null;
    if (star.hasMoreTokens()) {
        try {
            String token = star.nextToken().trim();
            category = Category.valueOf(token);
        } catch (IllegalArgumentException e) {
            category = null; // Default value or handle error
        }
    }

    FoodAvailability foodavailability = null;
    if (star.hasMoreTokens()) {
        try {
            String token = star.nextToken().trim();
            foodavailability = FoodAvailability.valueOf(token);
        } catch (IllegalArgumentException e) {
            foodavailability = null; // Default value or handle error
        }
    }
    
    BranchInfo branch = new BranchInfo(branchname, branchavailability);
    Food food = new Food(foodname, price, branch, category, foodavailability);
    
    foodList.add(food);
}

        return foodList ;
    }
}