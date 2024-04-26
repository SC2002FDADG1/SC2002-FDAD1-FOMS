package OrderSystem;
import BranchSystem.BranchInfo;
import java.util.ArrayList;
import FoodSystem.FoodOrder; 
import PaymentSystem.DisplayPayment;
import PaymentSystem.PaymentData;
import PaymentSystem.PaymentList;
import PaymentSystem.PrintReceipt;
import java.io.File;
import java.io.IOException;
import static main.Main.sc;

public class Order
{
    private int orderID;
    private KindOfPickUp kindOfPickUp ;
    private Status status = Status.PREPARING ;
    private float totalPrice ;
    private BranchInfo branch ;
    private ArrayList<FoodOrder> foodOrders = new ArrayList<>(); 

    public Order(){}

    public Order(int orderID, KindOfPickUp kindOfPickUp, Status status, BranchInfo branch) 
    {
        this.orderID = orderID;
        this.kindOfPickUp = kindOfPickUp;
        this.status = status;
        this.branch = branch ;
    }
    
    public Order(int orderID, KindOfPickUp kindOfPickUp, Status status, BranchInfo branch, float price , ArrayList<FoodOrder> foodOrders ) 
    {
        this.orderID = orderID;
        this.kindOfPickUp = kindOfPickUp;
        this.status = status;
        this.branch = branch ;
        this.totalPrice = price ;
        this.foodOrders = foodOrders ;
    }

    public int getOrderID() 
    {
        return orderID;
    }

    public void setOrderID(int orderID) 
    {
        this.orderID = orderID;
    }
    
    public String getBranchname() 
    {
        return branch.getBranchName() ;
    }    
    
    public BranchInfo getBranch()
    {
        return this.branch ;
    }

    public KindOfPickUp getKindOfPickUp() 
    {
        return kindOfPickUp;
    }

    public void setKindOfPickUp(KindOfPickUp kindOfPickUp)
    {
        this.kindOfPickUp = kindOfPickUp;
    }
    
    public ArrayList<FoodOrder> getfoodOrders()
    {
        return this.foodOrders ;
    }

    public Status getStatus() 
    {
        return status;
    }

    public void setStatus(Status status) 
    {
        this.status = status;
    }

    public void calculateTotalPrice() 
    {
        this.totalPrice = 0;
        for (FoodOrder foodOrder : foodOrders) {
            this.totalPrice += foodOrder.getFood().getPrice() * foodOrder.getQuantity();
        }
    }
    
    public float getTotalPrice() 
    {
        return totalPrice;
    }

    public String choosePayment() throws IOException
    {
        // Display the payment
        String filename = "paymentdata.txt" ;
        PaymentList a = new PaymentList() ;
	try 
        {
            PaymentData txtDB = new PaymentData() ;
            a.setPaymentList(txtDB.readObject(filename))  ;
            
            DisplayPayment b = new DisplayPayment() ;
            b.displayPayments( a.getPaymentList() ) ;
	
	}
        catch (IOException e) 
        {
            File myFile = new File("paymentdata.txt");
            if (myFile.createNewFile()) 
            {
                System.out.println("File created: " + myFile.getName());
            } 
            else 
            {
                System.out.println("File already exists.");
            }
        }
        
        System.out.println("Choose the number of the kind of payment that you want: ") ;
        int choice = sc.nextInt() ;
        sc.nextLine() ;
        
        return a.getPaymentList().get(choice - 1 ).getNameOfPayment() ; 
        
    }

    public void viewOrder( int orderid  ) throws IOException 
    {
        OrderList ol = new OrderList() ;
        for( int i = 0 ; i < ol.getOrderList().size() ; i++ )
        {
            if( ol.getOrderList().get(i).getOrderID() == orderid )
            {
                System.out.println(ol.getOrderList().get(i).toString()) ;
                break ;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder();
        orderDetails.append("Order ID: ").append(orderID).append("\n");
        orderDetails.append("Pick-Up Method: ").append(kindOfPickUp).append("\n");
        orderDetails.append("Status: ").append(status).append("\n");
        orderDetails.append("Total Price: $").append(String.format("%.2f", totalPrice)).append("\n");
        orderDetails.append("Order Items:").append("\n");
    
        for (FoodOrder fo : foodOrders) {
            orderDetails.append(" - ").append(fo.getFood().getName())
                         .append(" x ").append(fo.getQuantity())
                         .append(" (").append(String.format("%.2f", fo.getFood().getPrice() * fo.getQuantity()))
                         .append(")\n");
        }
    
        return orderDetails.toString();
    }
    
    public void printReceipt( double price, String payment, int orderid  ) 
    {
        PrintReceipt object = new PrintReceipt() ;
        object.printReceipt(price, payment, orderid);
    }
    
    public void addFoodOrder(FoodOrder foodOrder) {
        if (foodOrder != null) {
            this.foodOrders.add(foodOrder);
            calculateTotalPrice();
        }
    }

    public void removeFoodOrder(int index) {
        if (index >= 0 && index < foodOrders.size()) {
            foodOrders.remove(index);
            calculateTotalPrice();
        } else {
            System.out.println("Invalid index: " + index);
        }
    }
}