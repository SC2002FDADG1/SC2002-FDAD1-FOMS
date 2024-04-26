
package StaffSystem;

import BranchSystem.BranchInfo;
import BranchSystem.BranchList;
import FoodSystem.Food;
import FoodSystem.Food.Category;
import FoodSystem.Menu;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import static main.Main.sc;


public class Manager extends Staff 
{
    public Manager(){}
    public Manager( String name,  Role role, Gender gender, int age , BranchInfo branch )
    {
        super( name, role, gender, age, branch ) ;
    }
    
    public void editMenu() throws IOException
    {
        Menu menu = new Menu() ;
        ArrayList<Food> newmenu = menu.getFoodList() ;
        
        System.out.println("Choose the option ( 1-4 ): \n"
                         + "1.Add new food \n"
                         + "2.Remove food \n"
                         + "3.Change the price \n"
                         + "4.Ending ") ;
        
        int choice = sc.nextInt() ;
        sc.nextLine() ;
        
        if( choice == 4 )
        {
            return ;
        }

        while( choice != 4 )
        {
            switch( choice )
            {
                case 1 :
                    System.out.println("Enter the name: ") ;
                    String name = sc.nextLine() ;
                    
                    if( menu.checkUnique(name) == true ){
                        System.out.println("Item already exists!");
                        break;
                    }
                    
                    System.out.println("Enter the price: ") ;
                    double price = sc.nextDouble() ;
                    sc.nextLine() ;
                    
                    System.out.println("Enter the category: ") ;
                    Category category ;
                    try 
                    {
                        String token = sc.nextLine() ;
                        category = Food.Category.valueOf(token) ;
                    } catch (IllegalArgumentException e) 
                    {
                        System.out.println("Do not have this category !") ;
                        break ;
                    }
                    BranchList bl = new BranchList() ;
                    Food food = new Food( name , price , bl.findBranch(this.branch.getBranchName() ) , category , Food.FoodAvailability.YES ) ;
                    newmenu.add(food) ;
                    System.out.println("Add Successfully !") ;
                    break ;
                case 2 : 
                    System.out.println("Enter the name: ") ;
                    int check = 0 ;
                    String removename = sc.nextLine() ;
                    for( int i = 0 ; i < newmenu.size() ; i++ )
                    {
                        if( newmenu.get(i).getName().equals(removename) )
                        {
                            newmenu.remove(i) ;
                            System.out.println("Remove Successfully");
                            check = 1 ;
                            break ;
                        }
                    }

                    if( check == 0 )
                    {
                        System.out.println("Cannot find this food !");
                    }
                    break ;
                case 3 :
                    System.out.println("Enter the name: ") ;
                    int control = 0 ;
                    String changename = sc.nextLine() ;
                    for( int i = 0 ; i < newmenu.size() ; i++ )
                    {
                        if( newmenu.get(i).getName().equals(changename) )
                        {
                            System.out.println("Enter the new price: ") ;
                            double newprice = sc.nextDouble();
                            sc.nextLine() ;
                            newmenu.get(i).setPrice(newprice) ;
                            System.out.println("Change price Successfully");
                            control = 1 ;
                            break ;
                        }
                    }

                    if( control == 0 )
                    {
                        System.out.println("Cannot find this food !");
                    }
                    break ;
                default :
                    System.out.println("Wrong input ! Try again ! ");

            }
            menu.savefile(newmenu) ;
            
            menu = new Menu() ;
            newmenu = menu.getFoodList() ;
            
            System.out.println("Choose the option ( 1-4 ): \n"
                         + "1.Add new food \n"
                         + "2.Remove food \n"
                         + "3.Change the price \n"
                         + "4.Ending ") ;
            choice = sc.nextInt() ;
            sc.nextLine() ;
        }
    }
    
    public void prompt() throws IOException
    {
        int c;
        do
        {
            System.out.println("Welcome, Manager! Please select an action: \n"
                    + "[1] Edit Menu \n"
                    + "[2] Display Staff List \n"
                    + "[3] View Order List \n"
                    + "[4] Select Order \n"
                    + "[5] Change Password \n"
                    + "[6] Update Order \n"
                    + "[7] Exit Manager Controls");
            
            //to check if input is integer
            while(!sc.hasNextInt())
            {
                System.out.println("Invalid input. Please enter a number(1-6):");
                sc.next();
            }
            
            c=sc.nextInt();
            sc.nextLine() ;
  
            
            switch(c)
            {
                case 1:
                    editMenu();
                    break;
                case 2:
                    StaffList sl = new StaffList() ;
                    sl.displayBranchStaff(this.branch.getBranchName() );
                    break;
                case 3:
                    viewOrderList() ;
                    break;
                case 4:
                    System.out.println("Enter the OrderID :") ;
                    int orderid = sc.nextInt() ;
                    sc.nextLine() ;
                    selectOrder(orderid) ;
                    break;
                case 5:
                    changePassword() ;
                    break;
                    
                case 6:
                    updateOrderStatus();
                    break; 
                    
                case 7:
                    break ;
                 
                default:
                    System.out.println("Wrong input!");
                    return;
            }
            
        } while(c!=7);
    }
}
