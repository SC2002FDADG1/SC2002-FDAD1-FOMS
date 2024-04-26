package PaymentSystem;

public class PrintReceipt 
{
    public void printReceipt(double price, String payment, int orderid)
    {
        System.out.println("====== Order Receipt ======");
        System.out.println("The Order ID : " + orderid ) ;
        System.out.println("The total price is : " + price ) ;
        System.out.println("Paid by : " + payment ) ;
        System.out.println("==========================");
    }
}
