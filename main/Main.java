package main;

import BranchSystem.BranchAvailability;
import java.util.Scanner;
import LoginSystem.Customer;
import LoginSystem.CustomerType;
import LoginSystem.Login;
import LoginSystem.LoginUser;
import BranchSystem.BranchList;
import BranchSystem.BranchInfo;
import BranchSystem.BranchOpenList;
import OrderSystem.Order;
import LoginSystem.StaffLogin;
import OrderSystem.KindOfPickUp;
import java.io.IOException;

public class Main 
{
    public static final Scanner sc = new Scanner(System.in) ;
    public static void main(String[] args) throws IOException 
    {
        
            Login login = new Login();
            
            
            Customer currentCustomer = new Customer();
            Order order = new Order();
            
            // Initialize MenuData and BranchList
            BranchList branchList = new BranchList();
            BranchInfo B;
            
            System.out.println("Continue to use app ? (yes-no)");
            // yes and no
            String choice = sc.nextLine() ;
            
            while( choice.equals("yes") )
            {
                login.login(); 
                
                // Customer
                if(login.getChoice() == LoginUser.CUSTOMER)
                {
                    do 
                    {
                        BranchOpenList openbranchlist = new BranchOpenList() ;
                        System.out.println("Please enter your current branch:");
                        String branchName = sc.next(); // Corrected to read a string input
                        B = branchList.findBranch(branchName);
                        if (B == null)
                        {
                            System.out.println("Branch does not exist!");
                        }
                    } while (B == null) ;
                    currentCustomer.run();
                    CustomerPortal customerportal ;
                    
                    if( currentCustomer.getCustomerOption() == CustomerType.ORDER )
                    {
                        System.out.println("Please enter kind of pick up: \n"
                                + "[1] DINE IN \n"
                                + "[2] TAKE OUT");

                        int selection = sc.nextInt() ;
                        sc.nextLine() ;
                        switch( selection )
                        {
                            case 1 :
                                customerportal = new CustomerPortal(B , KindOfPickUp.DINE_IN);
                                break ;
                            case 2 :
                                customerportal = new CustomerPortal(B , KindOfPickUp.TAKE_OUT);
                                break ;
                            default :
                                System.out.println("Error Input !!! Bye !") ;
                                return ;
                        }

                        customerportal.orderRun();
                    }
                    else
                    {
                        customerportal = new CustomerPortal() ;
                        int orderID;
                        System.out.println("Enter the order ID: ") ;
                        orderID = sc.nextInt();
                        sc.nextLine();
                        customerportal.checkOrderStatus(orderID);
                    }
                    
                }
                
                // Employee
                
                else
                {
                    StaffLogin sl = new StaffLogin() ;
                    sl.inputAttempt() ;
                    if( sl.checkAttempt() == 0 )
                    {
                        System.out.println("Continue to use app ?(yes-no)");
                        // yes and no
                        choice = sc.nextLine() ;
                        continue ;
                    }
                    
                    String staffid = sl.getLoginIDAttempt() ;
                    String staffpw = sl.getPasswordAttempt() ;
                    
                    StaffPortal sp = new StaffPortal( staffid ,  staffpw ) ;
                    sp.run() ;
                }
                
                System.out.println("Continue to use app ?(yes-no)");
                // yes and no
                choice = sc.nextLine() ;
            }
    }
}