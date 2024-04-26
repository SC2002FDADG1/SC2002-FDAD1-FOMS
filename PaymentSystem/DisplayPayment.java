package PaymentSystem;

import PaymentSystem.PaymentType.Payment_Availability;
import java.io.IOException;
import java.util.ArrayList;

public class DisplayPayment extends PaymentData
{
    public void displayPayments(ArrayList<PaymentType> array)
    {
        ArrayList<PaymentType> copy = copyarraylist( array ) ;
        System.out.println("This is the list of avaiable payments: ") ;
        int count = 1 ;
        for( int i = 0 ; i < copy.size() ; i++ )
        {
            if( copy.get(i).getAvailabilityOfPayment() == Payment_Availability.USED )
            {
                System.out.println(count + ". " + copy.get(i).getNameOfPayment() ) ;
                count ++ ;
            }
        }
    }
    
    public void displayPayments() throws IOException
    {
        ArrayList<PaymentType> array = readObject("paymentdata.txt") ;
        ArrayList<PaymentType> copy = copyarraylist( array ) ;
        System.out.println("This is the list of avaiable payments: ") ;
        int count = 1 ;
        for( int i = 0 ; i < copy.size() ; i++ )
        {
            if( copy.get(i).getAvailabilityOfPayment() == Payment_Availability.USED )
            {
                System.out.println(count + ". " + copy.get(i).getNameOfPayment() ) ;
                count ++ ;
            }
        }
    }
    
    
    public ArrayList<PaymentType> copyarraylist( ArrayList<PaymentType> array )
    {
        ArrayList<PaymentType> copy = new ArrayList() ;
        for( int i = 0 ; i < array.size() ; i++ )
        {
            copy.add( array.get(i) ) ;
        }
        
        return copy ;
    }
    
}
