
package StaffSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import static main.Main.sc;


public class EditStaffAccount 
{
    public void editStaff() throws IOException
    {
        StaffAccountList sl = new StaffAccountList() ;
        ArrayList<StaffAccount> newstaffaccountlist = sl.getstaffaccountlist() ;
        
        System.out.println("Enter the name that you want to edit account:") ;
        String name = sc.nextLine() ;
        int control = 0 ;
        
        for( int i = 0 ; i < newstaffaccountlist.size() ; i++ )
        {
            if( newstaffaccountlist.get(i).getName().equals(name) )
            {
                System.out.println("Enter the choice :\n"
                        + "1. Change the LoginID \n"
                        + "2. Change the password") ;
                int choice = sc.nextInt() ;
                sc.nextLine();
                
                switch( choice )
                {
                    case 1 :
                        System.out.println("Enter the new LoginID:");
                        String loginid = sc.nextLine() ;
                        newstaffaccountlist.get(i).setLoginID(loginid);
                        System.out.println("Successfully change LoginID !");
                        sl.savefile(newstaffaccountlist) ;
                        return  ;
                    case 2 :
                        System.out.println("Enter the new password:");
                        String password = sc.nextLine() ;
                        newstaffaccountlist.get(i).setPassword(password);
                        System.out.println("Successfully change password !");
                        sl.savefile(newstaffaccountlist) ;
                        return  ;
                    default :
                        System.out.println("Error !!! ");
                        return ;
                }
            }
        }
        
        if( control == 0 )
        {
            System.out.println("cannot find this staff !");
        }
    }
}
