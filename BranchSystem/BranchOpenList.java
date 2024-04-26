package BranchSystem;
import java.util.ArrayList;
import java.io.IOException;
public class BranchOpenList 
{ 
    public BranchOpenList() 
    { 
        BranchData D = new BranchData();
        ArrayList<BranchInfo> allBranches = new ArrayList<>();

        try {
            allBranches = D.readObject("Branchdb.txt"); // Read all branches from the file
        } catch (IOException e) {
            System.out.println("Error reading branches: " + e.getMessage());
        }

        // Loop through all branches to find open ones
        for (BranchInfo branch : allBranches) 
        {
            if (branch.getAvailable() == BranchAvailability.OPEN) 
            { // Check if branch is open
                int padding = 25 - branch.getBranchName().length(); //Adjust based on length of the branch name
                //Print out branch name and availability
                System.out.printf("%s%" + padding + "s%n", branch.getBranchName(), branch.getAvailable());
            }
        }
    }

}