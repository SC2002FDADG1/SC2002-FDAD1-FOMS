

import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BranchData{
	public static final String SEPARATOR = "|";

    // an example of reading
    public static ArrayList<BranchInfo> readBranches(String filename) {
      ArrayList<BranchInfo> alr = new ArrayList<>();
      try {
          ArrayList<String> stringArray = (ArrayList<String>) read(filename);
  
          for (int i = 0; i < stringArray.size(); i++) {
              String st = stringArray.get(i);
              StringTokenizer star = new StringTokenizer(st, SEPARATOR);
  
              String branchName = star.nextToken().trim();
              String availability = star.nextToken().trim(); // Assuming availability is stored in the file
  
              // Create BranchInfo object
              BranchInfo branch = new BranchInfo(branchName);
  
              // Set availability
              if (availability.equalsIgnoreCase("OPEN")) {
                  branch.setOpen();
              } else if (availability.equalsIgnoreCase("CLOSE")) {
                  branch.setClose();
              }
  
              alr.add(branch);
          }
          System.out.println("Branches read successfully.");
      } catch (IOException e) {
          System.err.println("Error reading branches: " + e.getMessage());
          e.printStackTrace();
      }
      return alr;
  }

  
  public static ArrayList<BranchInfo> readOpenedBranches(String filename) {
    ArrayList<BranchInfo> alr = new ArrayList<>();
    try {
        ArrayList<String> stringArray = (ArrayList<String>) read(filename);

        for (int i = 0; i < stringArray.size(); i++) {
            String st = stringArray.get(i);
            StringTokenizer star = new StringTokenizer(st, SEPARATOR);

            String branchName = star.nextToken().trim();
            String availability = star.nextToken().trim(); // Assuming availability is stored in the file

            // Check if availability is "OPEN"
            if (availability.equalsIgnoreCase("OPEN")) {
                // Create BranchInfo object
                BranchInfo branch = new BranchInfo(branchName);
                branch.setOpen(); // Set availability to "OPEN"
                alr.add(branch);
            }
        }
        System.out.println("Opened branches read successfully.");
    } catch (IOException e) {
        System.err.println("Error reading opened branches: " + e.getMessage());
        e.printStackTrace();
    }
    return alr;
}

  
  
  public static void saveBranches(String filename, List<BranchInfo> al) {
    List<String> alw = new ArrayList<>();

    for (int i = 0; i < al.size(); i++) {
        BranchInfo branch = al.get(i);
        StringBuilder st = new StringBuilder();
        st.append(branch.getBranchName().trim());
        st.append(SEPARATOR);

        // Get availability string
        String availability = (branch.getAvailable() == Availability.OPEN) ? "OPEN" : "CLOSE";

        st.append(availability);
        alw.add(st.toString());
    }

    try {
        write(filename, alw);
        System.out.println("Branches saved successfully.");
    } catch (IOException e) {
        System.err.println("Error saving branches: " + e.getMessage());
        e.printStackTrace();
    }
}



  /** Write fixed content to the given file. */
  public static void write(String fileName, List<String> data) throws IOException  {
    PrintWriter out = new PrintWriter(new FileWriter(fileName));

    try {
		    for (int i =0; i < data.size() ; i++) {
      	    	out.println((String)data.get(i));
		    }
    }finally {
      out.close();
    }
  }

  /** Read the contents of the given file. */
  public static List<String> read(String fileName) throws IOException {
	List<String> data = new ArrayList<>() ;
    Scanner scanner = new Scanner(new FileInputStream(fileName));
    try {
      while (scanner.hasNextLine()){
        data.add(scanner.nextLine());
      }
    }
    finally{
      scanner.close();
    }
    return data;
  }
}
