package main;

import BranchSystem.BranchAvailability;
import BranchSystem.BranchInfo;
import StaffSystem.Admin;
import StaffSystem.Gender;
import StaffSystem.Manager;
import StaffSystem.Role;
import StaffSystem.Staff;
import StaffSystem.StaffAccountList;
import StaffSystem.StaffList;
import java.io.IOException;


public class StaffPortal 
{
    private Role role ;
    private Staff staff ;
            
    public StaffPortal( String staffid , String  staffpw ) throws IOException
    {
        StaffAccountList sal = new StaffAccountList() ;
        String name = sal.findemployee(staffid, staffpw) ;
        
        if ( name.equals("Boss") )
        {
            role = Role.ADMIN ;
        }
        else
        {
            StaffList sl = new StaffList() ;
            for( int i = 0 ; i < sl.getstafflist().size() ; i++ )
            {
                if( sl.getstafflist().get(i).getName().equals(name) )
                {
                    role = sl.getstafflist().get(i).getRole() ;
                    staff = sl.getstafflist().get(i) ;   
                }
            }
        }
    }
    
    public void run() throws IOException
    {
        switch( this.role )
        {
            case ADMIN :
                Admin a = new Admin("Boss" , Role.ADMIN ,  Gender.FEMALE , 62 ) ;
                a.prompt() ;
                break ;
            case MANAGER :
                Manager m =  new Manager( staff.getName() , staff.getRole() , staff.getGender() , staff.getAge() , staff.getBranch() ) ;
                m.prompt() ;
                break ;
            case STAFF :
                Staff s = staff ;
                s.prompt();
                break ;   
        }
    }
}
