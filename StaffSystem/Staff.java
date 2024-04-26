package StaffSystem;

import BranchSystem.BranchInfo;
import OrderSystem.Order;
import OrderSystem.OrderList;
import OrderSystem.Status;
import java.io.IOException;
import java.util.ArrayList;
import static main.Main.sc;

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
    
    public void viewOrderList() throws IOException
    {
        OrderList data = new OrderList() ;
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
    
    public void selectOrder( int orderid ) throws IOException
    {
        OrderList data = new OrderList() ;
        ArrayList < Order > arr = data.getOrderList() ;
        
        for( int i = 0 ; i < arr.size() ; i++ )
        {
            if( arr.get(i).getOrderID() == orderid )
            {
               arr.get(i).viewOrder( orderid ) ;
               return ;
            }
        }
        System.out.println("No order found!");
    }
    
    public void changePassword() throws IOException
    {
        System.out.println("Enter the new password: ");
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
    
    public void updateOrderStatus() throws IOException 
    {
        OrderList data = new OrderList() ;
        ArrayList < Order > arr = data.getOrderList() ;
        

        if (arr.isEmpty()) 
        {
        System.out.println("No orders are present to update.");
        return;
        }

        System.out.println("Enter the orderID to change status:");
        int orderID = sc.nextInt();
        sc.nextLine();

        // Verify if the orderID is valid
        boolean found = false;
        for (Order order : arr) {
            if (order.getOrderID() == orderID) {
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Invalid order ID. No order found with the given ID.");
            return;
        }



        System.out.println("Enter new status:\n"
                + "[1]PREPARING\n"
                + "[2]READY_TO_PICK_UP\n"
                + "[3]COMPLETED");
        int choice = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0 ; i < arr.size() ; i++ ) 
        {
            if (arr.get(i).getOrderID() == orderID) 
            {
                switch(choice)
                {
                    case 1:
                        arr.get(i).setStatus(Status.PREPARING);
                        break;
                    
                    case 2:
                        arr.get(i).setStatus(Status.READY_TO_PICK_UP);
                        break;
                    
                    case 3:
                        arr.get(i).setStatus(Status.COMPLETED);
                        break;
                    
                    default:
                       System.out.println("Wrong input!");
                       return;
                }
                
            }
        }
        data.savefile(arr) ;
    }
    

    
    public void prompt() throws IOException
    {
        int c;
        do
        {
            System.out.println("Welcome, Staff ! Please select an action: \n"
                    + "[1] View Order List \n"
                    + "[2] Select Order \n"
                    + "[3] Change Password \n"
                    + "[4] Update Order Status \n"
                    + "[5] Exit Staff Controls");
            
            //to check if input is integer
            while(!sc.hasNextInt())
            {
                System.out.println("Invalid input. Please enter a number(1-6):");
                sc.next();
            }
            
            c=sc.nextInt();
            sc.nextLine();
            
            switch(c)
            {
                case 1:
                    viewOrderList() ;
                    break;
                case 2:
                    System.out.println("Enther the OrderID :") ;
                    int orderid = sc.nextInt() ;
                    sc.nextLine(); 
                    selectOrder(orderid) ;
                    break;
                case 3:
                    changePassword() ;
                    break;
                    
                case 4:
                    updateOrderStatus();
                    break;
                    
                case 5:
                    break ;
                    
                default:
                    System.out.println("Wrong input!");
                    return;
                    
            }
        } while(c!=5);
    }
    
    
    @Override
    public String toString() 
    {
        return super.toString() + ", Branch: " + this.branch.getBranchName();
    }

    
    
    
    
    
    
}
