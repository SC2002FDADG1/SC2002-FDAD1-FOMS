package StaffSystem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class StaffAccountList 
{
    private ArrayList<StaffAccount> staffAccountList = new ArrayList<>() ;
    private StaffAccountData txtDB = new StaffAccountData() ;
    private String filename = "staffaccountlist.txt" ;
    
    public StaffAccountList() throws IOException
    {
	try 
        {
            staffAccountList = txtDB.readObject(filename) ;
	}
        catch (IOException e) 
        {
            File myFile = new File("staffaccountlist.txt");
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
    
    public ArrayList<StaffAccount> getstaffaccountlist()
    {
        return this.staffAccountList ;
    }
    
    public void savefile( ArrayList<StaffAccount> newstaffAccountList ) throws IOException
    {
        txtDB.save(filename, newstaffAccountList) ;
    }
    
    public String findemployee( String staffid , String staffpw )
    {
        for( int i = 0 ; i <  staffAccountList.size() ; i++ )
        {
            if( staffAccountList.get(i).getLoginID().equals(staffid) &&
                staffAccountList.get(i).getPassword().equals( staffpw )  )
            {
                return staffAccountList.get(i).getName() ;
            }
        }
        
        return null ;
    }
}
