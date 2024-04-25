
package StaffSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Admin extends Employee
{
    
    public Admin()
    {
        
    }
    public Admin( String name,  Role role, Gender gender, int age )
    {
        super(name, role, gender, age);
    }
    
    public void prompt() throws IOException
    {
        Scanner s = new Scanner(System.in);
        int c;
        do
        {
            System.out.println("Welcome, Admin! Please select an action: \n"
                    + "[1] Display Staff\n"
                    + "[2] Promote Staff \n"
                    + "[3] Remove Staff \n"
                    + "[4] Edit Payment Methods \n"
                    + "[5] Edit Branch Information \n"
                    + "[6] Transfer Staff \n"
                    + "[7] Edit Staff Account \n"
                    + "[8] Exit Admin Controls \n");
            
            //to check if input is integer
            while(!s.hasNextInt())
            {
                System.out.println("Invalid input. Please enter a number(1-8):");
                s.next();
            }
            
            c=s.nextInt();
            
            switch(c)
            {
                case 1:
                    DisplayStaff S=new DisplayStaff();
                    S.displayStaff();
                    break;
                case 2:
                    PromoteStaff P=new PromoteStaff();
                    P.promoteStaff();
                    break;
                case 3:
                    RemoveStaff R=new RemoveStaff();
                    R.removeStaff();
                    break;
                case 4:
                    EditPayment E=new EditPayment();
                    E.editPayment();
                    break;
                case 5:
                    EditBranch E2=new EditBranch();
                    E2.editBranch();
                    break;
                case 6:
                    TransferStaff T=new TransferStaff();
                    T.transferStaff();
                    break;
                case 7:
                    EditStaffAccount E3=new EditStaffAccount();
                    E3.editStaff( );
                    break;
                    
            }
        } while(c!=8);
        s.close();
    }
}

