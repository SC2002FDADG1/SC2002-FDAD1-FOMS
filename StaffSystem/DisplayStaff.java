
package StaffSystem;

import java.io.IOException;
import java.util.ArrayList;


public class DisplayStaff {
    public void displayStaff() throws IOException
    {
        StaffList sl = new StaffList() ;
        ArrayList<Staff> newstafflist = sl.getstafflist() ;

        int index = 1 ;
        for( int i = 0 ; i < newstafflist.size() ; i++ )
        {
            System.out.println( index + ".) " +  newstafflist.get(i).toString() ) ;
            index ++ ;
        }
        if (index == 1)
        {
            System.out.println("No Staff In This Branch");
        }
    }
}
