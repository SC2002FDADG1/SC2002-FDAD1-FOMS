import java.util.ArrayList;
import java.io.IOException;
public class BranchOpenList {
    public ArrayList<BranchInfo> openedBranches; // Instance variable to hold open branches

    public BranchOpenList() { // Constructor to initialize the open branch list
        BranchData D = new BranchData();
        ArrayList<BranchInfo> allBranches = new ArrayList<>();

        try {
            allBranches = D.readObject("Branchdb.txt"); // Read all branches from the file
        } catch (IOException e) {
            System.out.println("Error reading branches: " + e.getMessage());
        }

        // Initialize the list to hold only open branches
        openedBranches = new ArrayList<>();

        // Loop through all branches to find open ones
        for (BranchInfo branch : allBranches) {
            if (branch.getAvailable() == BranchAvailability.OPEN) { // Check if branch is open
                openedBranches.add(branch); // Add to the open branch list
            }
        }
    }

}
