package com.mycompany.paymentsystem;

public class PaymentType 
{
    public enum Payment_Availability { USED , UN_USED } ;
    
    private String nameOfPayment ;
    private Payment_Availability availabilityOfPayment ;
            
    public PaymentType(){}
    
    public PaymentType( String nameOfPayment )
    {
        this.nameOfPayment = nameOfPayment ;
        this.availabilityOfPayment = Payment_Availability.USED ;
    }
    
    public PaymentType( String nameOfPayment , Payment_Availability availabilityOfPayment )
    {
        this.nameOfPayment = nameOfPayment ;
        this.availabilityOfPayment = availabilityOfPayment ;
    }
    
    public String getNameOfPayment()
    {
        return this.nameOfPayment ;
    }
    
    public void setNameOfPayment( String newname )
    {
        this.nameOfPayment = newname ;
    }
    
    public Payment_Availability getAvailabilityOfPayment()
    {
        return this.availabilityOfPayment ;
    }
    
    public void unused()
    {
        this.availabilityOfPayment = Payment_Availability.UN_USED ;
    }
    
    public void used()
    {
        this.availabilityOfPayment = Payment_Availability.USED ;
    }
}
