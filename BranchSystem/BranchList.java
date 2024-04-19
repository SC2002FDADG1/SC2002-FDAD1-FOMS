import java.util.ArrayList;
import java.util.Scanner;

public class BranchList {
    // Create an ArrayList to store BranchInfo objects
    private ArrayList<BranchInfo> BranchList;

    public BranchList(){
        BranchList = BranchData.readBranches("Branchdb.txt");
    }

    
    public void EditBranch(){
        Scanner sc = new Scanner(System.in);
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
        
        sc.close(); //Close the scanner
        
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
        Scanner sc=new Scanner(System.in);
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
    
        BranchData.saveBranches("Branchdb.txt", BranchList);
        System.out.println("Opened Successfully");
       
    }

    public void closeBranch(){
        Scanner sc=new Scanner(System.in);
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
      
        BranchData.saveBranches("Branchdb.txt", BranchList);
        System.out.println("Closed Successfully"); 
     
    }

    public void addBranch(){
        Scanner sc=new Scanner(System.in);
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
        
        BranchData.saveBranches("/Users/jl01/Desktop/Branch System/Branchdb.txt", BranchList);
        System.out.println("Added Successfully");
      
    }

    public void viewBranchList(){
    //Print column headers
    System.out.println("Branch Name          Branch Availability");

    //Iterate through the list of branches
    for (int i = 0; i < BranchList.size(); i++) {
        //Get the branch information
        BranchInfo branch = BranchList.get(i);

        //Calculate padding that is needed for alignment
        int padding = 25 - branch.getBranchName().length(); //Adjust based on length of the branch name

        //Print out branch name and availability
        System.out.printf("%s%" + padding + "s%n", branch.getBranchName(), branch.getAvailable());
    }
    }

    
}
