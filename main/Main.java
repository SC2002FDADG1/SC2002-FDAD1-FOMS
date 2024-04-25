package main;

import java.util.Scanner;
import FoodSystem.MenuData;
import LoginSystem.Customer;
import LoginSystem.CustomerType;
import LoginSystem.Login;
import LoginSystem.LoginUser;
import BranchSystem.BranchList;
import BranchSystem.BranchInfo;
import OrderSystem.Order;
import OrderSystem.OrderStatus;
import FoodSystem.FoodOrder;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        Customer currentCustomer = new Customer();
        Order order = new Order();

        // Initialize MenuData and BranchList
        MenuData menuData = new MenuData();
        BranchList branchList = new BranchList();
        branchList.viewBranchList();
        BranchInfo B;
        
        
        

        do{
            login.login();
        
            if(login.getChoice() == LoginUser.CUSTOMER){

                do {
                    branchList.viewBranchList();
                    System.out.println("Please enter your current branch:");
                    String branchName = scanner.next(); // Corrected to read a string input
                    B = branchList.findBranch(branchName);
                    if (B == null) {
                        System.out.println("Branch does not exist!");
                    }
                } while (B != null);
                
                CustomerInterface customerInterface = new CustomerInterface(B);
                currentCustomer.run();
                
                if(currentCustomer.getCustomerOption() == CustomerType.ORDER){
                    customerInterface.orderRun();
                }

                else{
                    int orderID;
                    orderID = scanner.nextInt();
                    customerInterface.checkOrderStatus(orderID);
                    }
                }
            }

        scanner.close();

        }while();
    }
    
}
