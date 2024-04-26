package StaffSystem;
import BranchSystem.BranchAvailability;
import BranchSystem.BranchInfo;
import Filepackage.*;

import StaffSystem.Role;
import StaffSystem.Gender;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StaffData implements ReadFile, ReadObject, Save, Write {

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
            Staff staff = ( Staff )al.get(i);
            StringBuilder st =  new StringBuilder() ;
            st.append(staff.getName().trim() );
            st.append(SEPARATOR);
            st.append(staff.getRole().toString());
            st.append(SEPARATOR);
            st.append(staff.getGender().toString());
            st.append(SEPARATOR);
            st.append(staff.getAge());
            st.append(SEPARATOR);
            st.append(staff.getBranch().getBranchName().toString());
            st.append(SEPARATOR);
            st.append(staff.getBranch().getAvailable().toString());
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
            Role role;
            try 
            {
                String token = star.nextToken().trim();
                role = Role.valueOf(token);
            } catch (IllegalArgumentException e) 
            {
                // Handle the case where the token does not match any enum constant
                role = Role.STAFF; // Or set a default value, or handle the error as appropriate
            }// second token
            
            Gender gender;
            try 
            {
                String token = star.nextToken().trim();
                gender = Gender.valueOf(token);
            } catch (IllegalArgumentException e) 
            {
                // Handle the case where the token does not match any enum constant
                gender = Gender.MALE; // Or set a default value, or handle the error as appropriate
            }// third token
            
            int age;
            try 
            {
                String token = star.nextToken().trim();
                age = Integer.valueOf(token);
            } catch (IllegalArgumentException e) 
            {
                // Handle the case where the token does not match any enum constant
                age = 0 ; // Or set a default value, or handle the error as appropriate
            }// fourth token
            
            String  branchname = star.nextToken().trim() ;
            
            BranchAvailability available;
            try 
            {
                String token = star.nextToken().trim();
                available = BranchAvailability.valueOf(token);
            } catch (IllegalArgumentException e) 
            {
                // Handle the case where the token does not match any enum constant
                available = BranchAvailability.CLOSE ; // Or set a default value, or handle the error as appropriate
            }// sixth token
            
            BranchInfo temp_branch = new BranchInfo( branchname , available ) ;
            
            // create Payment object from file data
            Staff staff = new Staff( name , role, gender, age, temp_branch ) ;
            // add to Professors list
            alr.add(staff) ;
        }
        return alr ;
    }
    
}
