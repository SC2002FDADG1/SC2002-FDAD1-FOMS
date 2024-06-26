package BranchSystem;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import static main.Main.sc;

public class BranchList {

    private ArrayList<BranchInfo> BranchList = new ArrayList<>() ;
    private BranchData txtDB = new BranchData();
    private String filename = "Branchdb.txt" ;

    public BranchList() throws IOException
    {
        try 
        {
            this.BranchList = txtDB.readObject(filename) ;
	}
        catch (IOException e) 
        {
            File myFile = new File("Branchdb.txt");
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

    
    public void EditBranch(){
        
            int c;
            do {
                System.out.println("1. Open Branch");
                System.out.println("2. Close Branch");
                System.out.println("3. Add a new Branch");
                System.out.println("4. View List of Branches");
                System.out.println("5. Exit");
                System.out.println("Enter your choice (1-5): ");
                
                // to check if input is integer
                while (!sc.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number (1-5): ");
                    sc.next();
                }
                
                c=sc.nextInt();
                sc.nextLine();
                
                switch (c) {
                    case 1:
                        //Call openBranch() method
                        this.openBranch();
                        break;
                    case 2:
                        //Call closeBranch() method
                        this.closeBranch();
                        break;
                    case 3:
                        //Call addBranch() method
                        this.addBranch();
                        break;
                    case 4:
                        // Call viewBranchList() method
                        this.viewBranchList();
                        break;
                    case 5:
                        break;
                    default:
                        //If choice isn't 1,2 or 3
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } while (c!=5);
            //Close the scanner
        
    }
    public BranchInfo findBranch(String branchName){
        for(int i=0;i<BranchList.size();i++){
            if(BranchList.get(i).getBranchName().equals(branchName)){
                return BranchList.get(i);
            }
        }
        return null;
    }
    
    public void openBranch(){
        BranchData D=new BranchData();
        BranchInfo toOpen;
        do{
            System.out.println("Enter the branch name to open: ");
            String openBranchName = sc.nextLine();
            toOpen=findBranch(openBranchName);
            if(toOpen!=null){
                toOpen.setOpen();
            }else{
                System.out.println("Branch do not exist.");
            }
        }while(toOpen==null);
         
        //Save it into txt file
        try {
            D.save("Branchdb.txt", BranchList);
            System.out.println("Opened successfully.");
        } catch (IOException e) { // Catching IOException
            System.err.println("Error saving data: " + e.getMessage());
        }
       
    }

    public void closeBranch()
    {
        BranchData D=new BranchData();
        BranchInfo toClose;
        do{
            System.out.println("Enter the branch name to close: ");
            String closeBranchName = sc.nextLine();
            toClose=findBranch(closeBranchName);
            if(toClose!=null){
                toClose.setClose();
            }else{
                System.out.println("Branch do not exist.");
            }
        }while(toClose==null);
        
        //Save it into txt file
        try {
            D.save("Branchdb.txt", BranchList);
            System.out.println("Closed successfully.");
        } catch (IOException e) { // Catching IOException
            System.err.println("Error saving data: " + e.getMessage());
        }
     
    }

    public void addBranch(){
        BranchData D=new BranchData();
        String addBranchName;

        // Create a new object to add
        BranchInfo toAdd;

        do{
            System.out.println("Enter the branch name to add: ");
            addBranchName=sc.nextLine();
            toAdd=findBranch(addBranchName);
            // To check if branchname already exist in the BranchList
            if(toAdd!=null){
                System.out.println("Branch already exists");
            }
        }while(toAdd!=null);

        // Initiailise a new object to add with the input name
        toAdd=new BranchInfo(addBranchName);

        // Add object to BranchList
        BranchList.add(toAdd);
       
        //Save it into txt file
        try {
            D.save("Branchdb.txt", BranchList);
            System.out.println("Add successfully.");
        } catch (IOException e) { // Catching IOException
            System.err.println("Error saving data: " + e.getMessage());
        }
      
    }

    public void viewBranchList()
    {
        //Print column headers
        System.out.println("Branch Name          Branch Availability");

        //Iterate through the list of branches
        for (int i = 0; i < BranchList.size(); i++) 
        {
            //Get the branch information
            BranchInfo branch = BranchList.get(i);

            //Calculate padding that is needed for alignment
            int padding = 25 - branch.getBranchName().length(); //Adjust based on length of the branch name

            //Print out branch name and availability
            System.out.printf("%s%" + padding + "s%n", branch.getBranchName(), branch.getAvailable());
        }
    }

    
}