
package StaffSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class RemoveStaff 
{
    public void removeStaff() throws IOException
    {
        StaffList sl = new StaffList() ;
        ArrayList<Staff> newstafflist = sl.getstafflist() ;
        
        System.out.println("Enter the name that you want to remove:") ;
        Scanner sc = new Scanner( System.in ) ;
        String name = sc.nextLine() ;
        int control = 0 ;
        
        for( int i = 0 ; i < newstafflist.size() ; i++ )
        {
            if( newstafflist.get(i).getName().equals(name) )
            {
                newstafflist.remove(i) ;
                System.out.println("Remove Successfully !");
            }
        }
        
        if( control == 0 )
        {
            System.out.println("cannot find this staff !");
        }
        
        sl.savefile(newstafflist) ;
    }
}
