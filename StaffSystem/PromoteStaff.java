
package StaffSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class PromoteStaff 
{
    public void promoteStaff() throws IOException
    {
        StaffList sl = new StaffList() ;
        ArrayList<Staff> newstafflist = sl.getstafflist() ;
        
        System.out.println("Enter the name that you want to promote:") ;
        Scanner sc = new Scanner( System.in ) ;
        String name = sc.nextLine() ;
        int control = 0 ;
        
        for( int i = 0 ; i < newstafflist.size() ; i++ )
        {
            if( newstafflist.get(i).getName().equals(name) )
            {
                if( newstafflist.get(i).getRole() == Role.MANAGER )
                {
                    System.out.println("Cannot promote this manager any further ! ");
                    control = 1 ;
                    break ;
                }
                else
                {
                    newstafflist.get(i).setRole(Role.MANAGER) ; 
                    System.out.println("Promote Successfully !");
                    control = 1 ;
                    break ;
                }
            }
        }
        
        if( control == 0 )
        {
            System.out.println("cannot find this staff !");
        }
        
        sl.savefile(newstafflist) ;

    }
}
