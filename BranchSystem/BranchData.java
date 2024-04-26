package BranchSystem;

import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import Filepackage.* ;

public class BranchData implements ReadFile , ReadObject , Save , Write
{
    public static final String SEPARATOR = "|";
    
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
    public ArrayList readObject(String filename) throws IOException 
    {
    ArrayList<BranchInfo> alr = new ArrayList<>();
        try 
        {
            ArrayList<String> stringArray = (ArrayList<String>) read(filename);
  
            for (int i = 0; i < stringArray.size(); i++) 
            {
                String st = stringArray.get(i);
                StringTokenizer star = new StringTokenizer(st, SEPARATOR);
  
                String branchName = star.nextToken().trim();
                String availability = star.nextToken().trim(); // Assuming availability is stored in the file

                // Create BranchInfo object
                BranchInfo branch = new BranchInfo(branchName);

                // Set availability
                if (availability.equalsIgnoreCase("OPEN")) 
                {
                    branch.setOpen();
                } else if (availability.equalsIgnoreCase("CLOSE")) 
                {
                    branch.setClose();
                }

                alr.add(branch);
            }
        } 
        catch (IOException e) 
        {
            System.err.println("Error reading branches: " + e.getMessage());
            e.printStackTrace();
        }
        return alr;
  }

    @Override
    public void save(String filename, List al) throws IOException 
    {
        List alw = new ArrayList();

        for (int i = 0; i < al.size(); i++) 
        {
            BranchInfo branch = ( BranchInfo ) al.get(i);
            StringBuilder st = new StringBuilder();
            st.append(branch.getBranchName().trim());
            st.append(SEPARATOR);
            
            // Get availability string
            String availability = (branch.getAvailable() == BranchAvailability.OPEN) ? "OPEN" : "CLOSE";

            st.append(availability);
            alw.add(st.toString() );
        }

        try 
        {
            write(filename, alw);
            System.out.println("Branches saved successfully.");
        } 
        catch (IOException e) 
        {
            System.err.println("Error saving branches: " + e.getMessage());
            e.printStackTrace();
        }
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


}