package LoginSystem;

import StaffSystem.StaffAccount;
import StaffSystem.StaffAccountList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import static main.Main.sc;


public class StaffLogin {
    private String loginIDAttempt;
    private String passwordAttempt;

    public String getLoginIDAttempt(){
        return this.loginIDAttempt;
    }
    public String getPasswordAttempt(){
        return this.passwordAttempt;
    }
    public void setLoginIDAttempt(String id_attempt){
        this.loginIDAttempt = id_attempt;
    }
    public void setPasswordAttempt(String pw_attempt){
        this.passwordAttempt = pw_attempt;
    }

    public void inputAttempt(){

        System.out.print("Enter login ID: ");
        sc.nextLine() ;
        String id = sc.nextLine();
        setLoginIDAttempt(id);

        System.out.print("Enter password: ");
        String password = sc.nextLine();
        setPasswordAttempt(password) ;
    }

    public int checkAttempt() throws IOException{ 
        StaffAccountList sal = new StaffAccountList() ;
        ArrayList<StaffAccount> arr = sal.getstaffaccountlist() ;
        
        for (int i = 0; i < arr.size(); i++)
        {
            if (arr.get(i).getLoginID().equals( this.loginIDAttempt ))
            {
                if (arr.get(i).getPassword().equals( this.passwordAttempt)){
                    System.out.println("Login successfully !");
                    return 1;
                }
                else{
                    System.out.println("Incorrect Password!");
                    return 0;
                }
            }
        }
        System.out.println("Login ID not found!");
        return 0;
    }
}