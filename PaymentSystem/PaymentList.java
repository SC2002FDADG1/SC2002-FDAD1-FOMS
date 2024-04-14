package com.mycompany.paymentsystem;
import com.mycompany.paymentsystem.PaymentType.Payment_Availability;
import java.util.ArrayList;
import java.util.Scanner;

public class PaymentList 
{
    protected ArrayList< PaymentType > paymentList = new ArrayList<>() ;
    Scanner sc = new Scanner(System.in) ;
    
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
                    paymentList.get(i).unused() ;
                    System.out.println("Open unused successfully !") ;
                }
                return ;
            }
        }
        
        System.out.println("Cannot found this name !") ;
    }
    
    
    // Just use Asking()
    public void Asking()
    {
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
        
        Asking() ;
    }
}
