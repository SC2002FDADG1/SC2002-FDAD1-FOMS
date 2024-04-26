package OrderSystem;

import BranchSystem.BranchAvailability;
import BranchSystem.BranchInfo;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import Filepackage.*;
import FoodSystem.FoodOrder;
import FoodSystem.Menu;

public class OrderData implements ReadFile, Save, Write, ReadObject {
    public static final String SEPARATOR = "|";

    @Override
    public List<String> read(String fileName) throws IOException {
        List<String> data = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream(fileName))) 
        {
            while (scanner.hasNextLine()) 
            {
                data.add(scanner.nextLine());
            }
        }


        return data;
    }

    @Override
    public void save(String filename, List al) throws IOException {
        List alw = new ArrayList() ;

        for (int i = 0 ; i < al.size() ; i++) {
            Order order = ( Order )al.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append(order.getOrderID()).append(SEPARATOR);
            //sb.append(order.getBranchName()).append(SEPARATOR);
            sb.append(order.getKindOfPickUp()).append(SEPARATOR);
            sb.append(order.getStatus()).append(SEPARATOR);
            sb.append(order.getBranchname()).append(SEPARATOR);
            sb.append(order.getBranch().getAvailable()).append(SEPARATOR);
            sb.append(order.getTotalPrice()).append(SEPARATOR);
            sb.append(order.getfoodOrders().size()).append(SEPARATOR);
            for( int j = 0 ; j < order.getfoodOrders().size() ; j++ )
            {
                sb.append(order.getfoodOrders().get(j).getFood().getName()).append(SEPARATOR);
                sb.append(order.getfoodOrders().get(j).getQuantity() ).append(SEPARATOR);
            }
            alw.add(sb.toString());
        }
        write(filename, alw);
    }

    @Override
    public void write(String fileName, List data) throws IOException 
    {
        PrintWriter out = new PrintWriter(new FileWriter(fileName) );

        try 
        {
            for (int i =0; i < data.size() ; i++) 
            {
                out.println((String)data.get(i));
            }
        }
        finally 
        {
            out.close() ;
        }
    }


    @Override
    public ArrayList<Order> readObject(String filename) throws IOException {
        ArrayList stringArray = (ArrayList)read(filename);
        ArrayList alr = new ArrayList() ;
        for (int i = 0 ; i < stringArray.size() ; i++)        
        {
            String st = (String)stringArray.get(i);
            StringTokenizer star = new StringTokenizer(st , SEPARATOR);	
            
            int orderID = -1 ;
            if (star.hasMoreTokens()) 
            {
                try 
                {
                    String token = star.nextToken().trim();
                    orderID = Integer.valueOf(token);
                } 
                catch (IllegalArgumentException e) 
                {
                    orderID = -1; 
                }
            }


            KindOfPickUp kindOfPickUp=KindOfPickUp.DINE_IN;;
            if (star.hasMoreTokens()) 
            {
                try 
                {
                    String token = star.nextToken().trim();
                    kindOfPickUp = KindOfPickUp.valueOf(token);
                } 
                catch (IllegalArgumentException e) 
                {
                    kindOfPickUp = KindOfPickUp.DINE_IN;
                }
            }


            Status status = Status.PREPARING;
            if (star.hasMoreTokens()) 
            {
                try 
                {
                    String token = star.nextToken().trim();
                    status = Status.valueOf(token);
                } 
                catch (IllegalArgumentException e) 
                {
                    status = Status.PREPARING; 
                }
            }

            String  branchname = null;
            if (star.hasMoreTokens()) 
            {
                try 
                {
                    branchname = star.nextToken().trim();
                } 
                catch (IllegalArgumentException e) 
                {
                    branchname = null ;
                }
            }

            BranchAvailability available = BranchAvailability.CLOSE;
            if (star.hasMoreTokens()) 
            {
                try 
                {
                    String token = star.nextToken().trim();
                    available = BranchAvailability.valueOf(token);
                } 
                catch (IllegalArgumentException e) 
                {
                    available = BranchAvailability.CLOSE ; 
                }
            }
            
            float totalprice = -1 ;
            if (star.hasMoreTokens()) 
            {
                try 
                {
                    String token = star.nextToken().trim();
                    totalprice = Float.valueOf(token);
                } 
                catch (IllegalArgumentException e) 
                {
                    totalprice = -1 ; 
                }
            }
            
            ArrayList<FoodOrder> foodOrders = new ArrayList<>() ; 
            
            int size = -1 ;
            if (star.hasMoreTokens()) 
            {
                try 
                {
                    String token = star.nextToken().trim();
                    size = Integer.valueOf(token);
                } 
                catch (IllegalArgumentException e) 
                {
                    size = -1 ; 
                }
            }
            
            for( int k = 0 ; k < size ; k ++ )
            {
                String foodname = null ;
                if (star.hasMoreTokens()) 
                {
                    try 
                    {
                        foodname = star.nextToken().trim();
                    } 
                    catch (IllegalArgumentException e) 
                    {
                        foodname = null ;
                    }
                }
                
                int quantity = -1 ;
                if (star.hasMoreTokens()) 
                {
                    try 
                    {
                        String token = star.nextToken().trim();
                        quantity = Integer.valueOf(token);
                    } 
                    catch (IllegalArgumentException e) 
                    {
                        quantity = -1 ; 
                    }
                }
                
                Menu menu = new Menu() ;
                if( (menu.checkName(foodname)) == null )
                {
                    continue ;
                }
                FoodOrder foodorder = new FoodOrder( (menu.checkName(foodname)) , quantity) ;
                foodOrders.add(foodorder) ;    
            }

            BranchInfo temp_branch = new BranchInfo( branchname , available ) ;


            Order order = new Order( orderID , kindOfPickUp, status, temp_branch, totalprice, foodOrders) ;
            // add to Professors list
            alr.add(order) ;
        }
        return alr ;
    }
    
}
