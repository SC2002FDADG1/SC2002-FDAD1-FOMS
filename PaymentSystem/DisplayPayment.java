/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.paymentsystem;

import com.mycompany.paymentsystem.PaymentType.Payment_Availability;
import java.util.ArrayList;

/**
 *
 * @author dunglai
 */
public class DisplayPayment 
{
    public void displayPayments( ArrayList<PaymentType> array  )
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
