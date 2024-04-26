package StaffSystem;
import Filepackage.* ;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StaffAccountData implements ReadFile , ReadObject, Save, Write
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
            StaffAccount staffaccount = ( StaffAccount )al.get(i);
            StringBuilder st =  new StringBuilder() ;
            st.append(staffaccount.getLoginID().trim() );
            st.append(SEPARATOR);
            st.append(staffaccount.getPassword() );
            st.append(SEPARATOR);
            st.append(staffaccount.getName()) ;
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
            String  loginid = star.nextToken().trim();
            String  password = star.nextToken().trim();	
            String  staffname = star.nextToken().trim();	
            
            StaffAccount staffaccount = new StaffAccount( loginid , password , staffname ) ;
            alr.add(staffaccount) ;
        }
        return alr ;
    }
}
