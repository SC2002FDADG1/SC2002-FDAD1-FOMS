package StaffSystem;

import BranchSystem.BranchInfo;
import OrderSystem.Order;
import OrderSystem.OrderData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Staff extends Employee
{
    protected BranchInfo branch ;
    
    public Staff() {}
    
    public Staff( String name,  Role role, Gender gender, int age , BranchInfo branch )
    {
        super( name,  role, gender, age ) ;
        this.branch = branch ;
    }
    
    public void setBranch(BranchInfo branch){
        this.branch = branch;
    }
    public BranchInfo getBranch()
    {
        return this.branch;
    }
    
    public void viewOrderList()
    {
        OrderData data = new OrderData() ;
        ArrayList < Order > arr = data.getOrderList() ;
        int check = 0 ;
        
        for( int i = 0 ; i < arr.size() ; i++ )
        {
            if( arr.get(i).getBranchname().equals( this.branch.getBranchName() ) )
            {
                System.out.println("Order ID: " + arr.get(i).getOrderID() );
                check = 1 ;
            }
        }
        
        if( check == 0 )
        {
            System.out.println("No orders !!!" );
        }
    }
    
    public void selectOrder( int orderid )
    {
        OrderData data = new OrderData() ;
        ArrayList < Order > arr = data.getOrderList() ;
        
        for( int i = 0 ; i < arr.size() ; i++ )
        {
            if( arr.get(i).getOrderID() == orderid )
            {
               arr.get(i).viewOrder() ;
               return ;
            }
        }
    }
    
    public void changePassword() throws IOException
    {
        System.out.println("Enter the new password: ");
        Scanner sc = new Scanner( System.in ) ;
        String newpw = sc.nextLine() ;
        StaffAccountList sal = new StaffAccountList() ;
        ArrayList< StaffAccount > arr = sal.getstaffaccountlist() ;
        for( int i = 0 ; i < arr.size(); i++ )
        {
            if( arr.get(i).getName().equals( this.name ) )
            {
                arr.get(i).setPassword(newpw) ;
                System.out.println("Change Successfully ! ") ;
                sal.savefile(arr);
                return ;
            }
        }
    }
    
    @Override
    public String toString() 
    {
        return super.toString() + ", Branch: " + this.branch;
    }

    
    
    
    
    
    
}
