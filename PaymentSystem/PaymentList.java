package PaymentSystem;

import PaymentSystem.PaymentType.Payment_Availability;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import static main.Main.sc;

public class PaymentList 
{
    private ArrayList< PaymentType > paymentList = new ArrayList<>() ;
    private PaymentData txtDB = new PaymentData();
    private String filename = "paymentdata.txt" ;
    
    public PaymentList() throws IOException
    {
        try 
        {
            paymentList = txtDB.readObject(filename) ;
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
    }
    
    public void setPaymentList( ArrayList< PaymentType > arr )
    {
        paymentList = arr ;
    }
    
    public ArrayList< PaymentType > getPaymentList()
    {
        return this.paymentList ;
    }
    
    public void addPayment()
    {
        System.out.println("Please enter the new payment name: ") ;
        sc.nextLine() ;
        String name = sc.nextLine() ;
        
        for( int i = 0 ; i < paymentList.size() ; i++ )
        {
            if( paymentList.get(i).getNameOfPayment().equals(name)  )
            {
                System.out.println("This name already exists !") ;
                return ;
            }
        }
        
        PaymentType newpayment = new PaymentType( name ) ;
        paymentList.add(newpayment) ;
        System.out.println("Add successfully !") ;    
    }
    
    public void UnusedPayment()
    {
        System.out.println("Please enter the ununsed payment name: ") ;
        sc.nextLine() ;
        String name = sc.nextLine() ;
        
        for( int i = 0 ; i < paymentList.size() ; i++ )
        {
            if( paymentList.get(i).getNameOfPayment().equals(name)  )
            {
                if( paymentList.get(i).getAvailabilityOfPayment() == Payment_Availability.UN_USED )
                {
                    System.out.println("This payment is already unused. ") ;
                }
                else
                {
                    paymentList.get(i).unused() ;
                    System.out.println("Unused successfully ! ") ;
                }
                return ;
            }
        }
        
        System.out.println("Cannot found this name !") ;
    }
    
    public void UsedPayment()
    {
        System.out.println("Please enter the open unused payment name: ") ;
        sc.nextLine() ;
        String name = sc.nextLine() ;
        
        for( int i = 0 ; i < paymentList.size() ; i++ )
        {
            if( paymentList.get(i).getNameOfPayment().equals(name)  )
            {
                if( paymentList.get(i).getAvailabilityOfPayment() == Payment_Availability.USED )
                {
                    System.out.println("This payment can still be used. ") ;
                }
                else
                {
                    paymentList.get(i).used() ;
                    System.out.println("Open unused successfully !") ;
                }
                return ;
            }
        }
        
        System.out.println("Cannot found this name !") ;
    }
    
    public void savefile( ArrayList<PaymentType> newpaymentlist ) throws IOException
    {
        txtDB.save(filename, newpaymentlist) ;
    }
    
    
    // Just use Asking()
    public void Asking() throws IOException
    {
        paymentList = txtDB.readObject(filename) ;
        
        DisplayPayment b = new DisplayPayment() ;
        b.displayPayments( paymentList ) ;
        
        System.out.println("Choose the option ( 1-4 ): \n"
                         + "1.Add new Payemnt \n"
                         + "2.Unused the Payment \n"
                         + "3.Open unused Payment \n"
                         + "4.Ending ") ;
        
        int choice = sc.nextInt() ;
        
        if( choice == 4 )
        {
            return ;
        }
        
        switch( choice )
        {
            case 1: 
                addPayment() ;
                break ;
            case 2:
                UnusedPayment() ;
                break ;
            case 3:
                UsedPayment() ;
                break ;
            default:
                System.out.println("Wrong Input ! Try again !") ;
        }     
        
        savefile(paymentList) ;
        
        Asking() ;
    }
}
