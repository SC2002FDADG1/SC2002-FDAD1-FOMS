package PaymentSystem;


import Filepackage.*;
import PaymentSystem.PaymentType.Payment_Availability;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PaymentData implements ReadFile, Save, Write, ReadObject
{
    public static final String SEPARATOR = "|" ;

    @Override
    public List<String> read(String fileName) throws IOException 
    {
	List data = new ArrayList() ;
        Scanner scanner = new Scanner(new FileInputStream(fileName)) ;
        try 
        {
            while (scanner.hasNextLine())
            {
                data.add(scanner.nextLine());
            }
        }
        finally
        {
            scanner.close();
        }
        return data;
    }

    @Override
    public void save(String filename, List al) throws IOException 
    {
        //  Name | Avaiability
	List alw = new ArrayList() ;

        for (int i = 0 ; i < al.size() ; i++) 
        {
            PaymentType payment = ( PaymentType )al.get(i);
            StringBuilder st =  new StringBuilder() ;
            st.append(payment.getNameOfPayment().trim() );
            st.append(SEPARATOR);
            st.append(payment.getAvailabilityOfPayment() );
            alw.add(st.toString()) ;
        }
	write(filename,alw);
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
    public ArrayList readObject(String filename) throws IOException 
    {
	// read String from text file
	ArrayList stringArray = (ArrayList)read(filename);
	ArrayList alr = new ArrayList() ;// to store Professors data

        for (int i = 0 ; i < stringArray.size() ; i++) 
        {
	    String st = (String)stringArray.get(i);
            // get individual 'fields' of the string separated by SEPARATOR
            StringTokenizer star = new StringTokenizer(st , SEPARATOR);	
            // pass in the string to the string tokenizer using delimiter ","
            String  name = star.nextToken().trim();	// first token
            Payment_Availability availability;
            try 
            {
                String token = star.nextToken().trim();
                availability = Payment_Availability.valueOf(token);
            } catch (IllegalArgumentException e) 
            {
                // Handle the case where the token does not match any enum constant
                availability = null; // Or set a default value, or handle the error as appropriate
            }// second token
            
            // create Payment object from file data
            PaymentType payment = new PaymentType( name , availability) ;
            // add to Professors list
            alr.add(payment) ;
        }
        return alr ;
    }
}
