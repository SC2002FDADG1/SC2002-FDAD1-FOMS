
package StaffSystem;
import BranchSystem.BranchList ;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TransferStaff 
{
    public void transferStaff() throws IOException
    {
        StaffList sl = new StaffList() ;
        ArrayList<Staff> newstafflist = sl.getstafflist() ;
        
        System.out.println("Enter the name that you want to transfer:") ;
        Scanner sc = new Scanner( System.in ) ;
        String name = sc.nextLine() ;
        int control = 0 ;
        
        BranchList bl = new BranchList() ;
        String branchname ;
        
        for( int i = 0 ; i < newstafflist.size() ; i++ )
        {
            if( newstafflist.get(i).getName().equals(name) )
            {
                do{
                System.out.println("Enter the branch that you want to transfer to:") ;
                branchname = sc.nextLine() ;
                }
                while ( bl.findBranch( branchname ) == null ) ;
                
                newstafflist.get(i).setBranch( bl.findBranch( branchname ) ) ;
                control = 1 ;
            }
        }
        
        if( control == 0 )
        {
            System.out.println("cannot find this staff !");
        }
        
        sl.savefile(newstafflist) ;

    }
}
