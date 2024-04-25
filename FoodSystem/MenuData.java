package FoodSystem;

import FilePackage.ReadFile ;
import FilePackage.Save ;
import FilePackage.Write ;
import FoodSystem.Food.Category;
import FilePackage.ReadObject ;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import BranchSystem.BranchList;
import BranchSystem.BranchInfo;

public class MenuData implements ReadFile, Save, Write, ReadObject {
    public static final String SEPARATOR = "|" ;

    //read method
    @Override
    public List<String> read(String fileName) throws IOException 
    {
	List data = new ArrayList() ;
        Scanner scanner = new Scanner(new FileInputStream(fileName)) ;
        try 
        {
            while (scanner.hasNextLine())
            {
                data.add(scanner.nextLine());
            }
        }
        finally
        {
            scanner.close();
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

            st.append(food.branch.getBranch().trim() );
            alw.add(st.toString()) ;
            st.append(SEPARATOR);

            //get branch
            BranchInfo branch =  new BranchInfo() ;
            st.append(branch.getName().trim() );
            st.append(SEPARATOR);

            st.append(food.getCategory());
            st.append(SEPARATOR);

        }
	write(filename,alw);
    }


    @Override
    public void write(String fileName, List data) throws IOException 
    {
        PrintWriter out = new PrintWriter(new FileWriter(fileName) );

        try 
        {
            for (int i =0; i < data.size() ; i++) 
            {
                out.println((String)data.get(i));
            }
        }
        finally 
        {
            out.close() ;
        }
    }

    public ArrayList readObject(String filename) throws IOException 
    {
        List<String> stringArray = read(filename); // Read lines from the file
        ArrayList<Food> foodList = new ArrayList<>(); // To store parsed food objects

        for (String line : stringArray) { // Loop through each line in the file
            if (!line.trim().isEmpty()) { // Skip empty lines
                StringTokenizer tokenizer = new StringTokenizer(line, SEPARATOR); // Use tab as separator
                
                // Ensure we have the expected number of tokens
                if (tokenizer.countTokens() >= 4) {
                    // Extract tokens for food attributes
                    String name = tokenizer.nextToken().trim(); // Food name
                    double price = Double.parseDouble(tokenizer.nextToken().trim()); // Food price
                    String branchName = tokenizer.nextToken().trim(); // Branch name
                    String categoryStr = tokenizer.nextToken().trim(); // Food category
                    
                    // Handle enum conversion and potential errors
                    Food.Category category = Food.Category.valueOf(categoryStr.toUpperCase().replace(" ", "_"));
                    BranchInfo branch = new BranchInfo(branchName);
                    
                    // BranchInfo branch = BranchList.getInstance().getBranch(branchName);
                    
                    // if (branch == null) {
                    //     branch = BranchList.getInstance().addBranch(branchName);
                    // }
                    
                    // Create a new Food object
                    Food food = new Food(name, price, branch, category, Food.Availability.YES);
                    
                    // Add to the food list
                    foodList.add(food);
    }
    
}
