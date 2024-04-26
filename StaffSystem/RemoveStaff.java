
package StaffSystem;

import java.io.IOException;
import java.util.ArrayList;
import static main.Main.sc;


public class RemoveStaff 
{
    public void removeStaff() throws IOException
    {
        StaffList sl = new StaffList() ;
        ArrayList<Staff> newstafflist = sl.getstafflist() ;
        
        System.out.println("Enter the name that you want to remove:") ;
        String name = sc.nextLine() ;
        int control = 0 ;
        
        for( int i = 0 ; i < newstafflist.size() ; i++ )
        {
            if( newstafflist.get(i).getName().equals(name) )
            {
                newstafflist.remove(i) ;
                System.out.println("Remove Successfully !");
                control = 1;
                break;
            }
        }
        
        if( control == 0 )
        {
            System.out.println("cannot find this staff !");
        }
        
        sl.savefile(newstafflist) ;
    }
}
