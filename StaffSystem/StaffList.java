package StaffSystem;

import BranchSystem.BranchInfo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class StaffList 
{
    private ArrayList<Staff> staffList = new ArrayList<>() ;
    private StaffData txtDB = new StaffData();
    private String filename = "stafflist.txt" ;
    
    public StaffList() throws IOException
    {
	try 
        {
            staffList = txtDB.readObject(filename) ;
	}
        catch (IOException e) 
        {
            File myFile = new File("stafflist.txt");
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
    
    public int countBranchStaff( String branchname )
    {
        int count = 0 ;
        for( int i = 0 ; i < staffList.size() ; i++ )
        {
            if( staffList.get(i).getBranch().getBranchName().equals(branchname) )
            {
                count ++ ;
            }
        }
        
        return count ;
    }
    
    public void displayBranchStaff(  String branchname )
    {
        int index = 1 ;
        for( int i = 0 ; i < staffList.size() ; i++ )
        {
            if( staffList.get(i).getBranch().getBranchName().equals(branchname) )
            {
                System.out.println( index + ".) " +  staffList.get(i).getName() ) ;
                index ++ ;
            }
        }
        if (index == 1)
        {
            System.out.println("No Staff In This Branch");
        }
    }
    
    public ArrayList<Staff> getstafflist()
    {
        return this.staffList ;
    }
    
    public void savefile( ArrayList<Staff> newstafflist ) throws IOException
    {
        txtDB.save(filename, newstafflist) ;
    }
    
}
