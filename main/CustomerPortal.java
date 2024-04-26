package main;

import java.util.List;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collectors;

import FoodSystem.Food;
import FoodSystem.FoodOrder;
import FoodSystem.Menu;
import OrderSystem.Order;
import OrderSystem.OrderData;
import OrderSystem.OrderList;
import BranchSystem.BranchInfo; 
import FoodSystem.MenuData;
import OrderSystem.KindOfPickUp;
import OrderSystem.Status;
import java.util.ArrayList;
import static main.Main.sc;

public class CustomerPortal 
{
    private Menu menu ;
    private static int id = 0 ;
    private Order currentOrder;
    
    public CustomerPortal(){}
    
    public CustomerPortal(BranchInfo branch, KindOfPickUp kindOfPickUp) throws IOException 
    {
        this.menu = new Menu();
        this.currentOrder = new Order( id, kindOfPickUp, Status.PREPARING,  branch)  ;
        id ++ ;
    }

    public void orderRun() throws IOException
    {
        if( placeOrder() == false)
        {
            return ;
        }
        choosePayment();
    }

     public boolean displayMenu() throws IOException{
         //MenuData md = new MenuData();
         System.out.println("\n=== Menu for " + currentOrder.getBranch().getBranchName() + " ===");
         return menu.displayMenu(currentOrder.getBranch() );
     }

    public boolean placeOrder() throws IOException 
    {
        String ordering = "yes";
        OrderList ol = new OrderList() ;
        ArrayList<Order> orderlist = ol.getOrderList() ;
        
        boolean check = displayMenu(); 
        if( check == false )
        {
            return false;
        }

        while ( ordering.equals("yes")) 
        {
            System.out.println("Enter the name of food : ");
            String name = sc.nextLine() ;
            Food food = menu.checkName(name) ;
            if( food == null  )
            {
                System.out.println("This food doesn't exist !!! ");
                continue ;
            }
            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt() ;
            sc.nextLine() ;

            if (quantity > 0) 
            {
                FoodOrder foodOrder = new FoodOrder(food, quantity);
                this.currentOrder.addFoodOrder(foodOrder); 

                System.out.println(quantity + " x " + food.getName() + " added to your order.");
            } 
            else
            {
                System.out.println("Quantity must be greater than zero.");
            }
            
            System.out.println("Continue ordering ? (yes or no) ");
            ordering = sc.nextLine() ;
            
        }

        orderlist.add( this.currentOrder ) ;
        ol.savefile(orderlist) ;
        return true ;
    }

    public void choosePayment() {
        if (currentOrder == null) {
            System.out.println("No order to choose payment for. Please place an order first.");
            return;
        }

        try {
            String paymentMethod = currentOrder.choosePayment(); // Use the Order class method
            System.out.println("Payment method chosen: " + paymentMethod);

            // Print receipt after successful payment
            currentOrder.printReceipt(currentOrder.getTotalPrice(), paymentMethod, this.currentOrder.getOrderID() ); // Call the printReceipt method

        } catch (IOException e) {
            System.out.println("Error while choosing payment method: " + e.getMessage());
        }
    }

    
    public boolean checkOrderStatus(int orderID) throws IOException {
        OrderList ol = new OrderList();
        ArrayList<Order> allOrders = ol.getOrderList() ;
        
        for (Order order : allOrders) {
            if (order.getOrderID() == orderID) {
                System.out.println("The current status is :" + order.getStatus() );
                return true;
            }
        }

        System.out.println("ORDER NOT FOUND!");
        return false;

    }


    }