package OrderSystem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class OrderList 
{
    private ArrayList<Order> orderlist = new ArrayList<>() ;
    private OrderData txtDB = new OrderData();
    private String filename = "orderdata.txt" ;
    
    public OrderList() throws IOException
    {
	try 
        {
            orderlist = txtDB.readObject(filename) ;
	}
        catch (IOException e) 
        {
            File myFile = new File("orderdata.txt");
            if (myFile.createNewFile()) 
            {
                System.out.println("File created: " + myFile.getName());
            } 
            else 
            {
                System.out.println("File already exists.");
            }
        }
    }
    
    public ArrayList<Order> getOrderList()
    {
        return this.orderlist ;
    }
    
    public void savefile( ArrayList<Order> neworderlist ) throws IOException
    {
        txtDB.save(filename, neworderlist) ;
    }
    
}

