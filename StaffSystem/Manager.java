
package StaffSystem;

import BranchSystem.BranchInfo;
import FoodSystem.Food;
import FoodSystem.Menu;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


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
        
        Scanner sc = new Scanner( System.in ) ;
        int choice = sc.nextInt() ;
        
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
                    System.out.println("Enter the price: ") ;
                    double price = sc.nextDouble() ;
                    System.out.println("Enter the name: ") ;
                    sc.nextLine() ;
                    Food.Category category ;
                    try 
                    {
                        String token = sc.nextLine() ;
                        category = Food.Category.valueOf(token) ;
                    } catch (IllegalArgumentException e) 
                    {
                        System.out.println("Do not have this category !") ;
                        break ;
                    }
                    Food food = new Food( name , price , this.branch , category , Food.FoodAvailability.YES ) ;
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
                            Double newprice = sc.nextDouble();
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
            
            System.out.println("Choose the option ( 1-4 ): \n"
                         + "1.Add new food \n"
                         + "2.Remove food \n"
                         + "3.Change the price \n"
                         + "4.Ending ") ;
            choice = sc.nextInt() ;
        }
        
        menu.savefile(newmenu) ;
    }
}
