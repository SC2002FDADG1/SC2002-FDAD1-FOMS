package LoginSystem;

import StaffSystem.StaffAccount;
import StaffSystem.StaffAccountList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Staff {
    private String loginIDAttempt;
    private String passwordAttempt;

    public String getLoginIDAttempt(){
        return loginIDAttempt;
    }
    public String getPasswordAttempt(){
        return passwordAttempt;
    }
    public void setLoginIDAttempt(String id_attempt){
        this.loginIDAttempt = id_attempt;
    }
    public void setPasswordAttempt(String pw_attempt){
        this.passwordAttempt = pw_attempt;
    }

    public void inputAttempt(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter login ID: ");
        String id = scanner.nextLine();
        setLoginIDAttempt(id);

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        setPasswordAttempt(password);

        scanner.close();
    }

    public int checkAttempt() throws IOException{ 
        StaffAccountList sal = new StaffAccountList() ;
        ArrayList<StaffAccount> arr = sal.getstaffaccountlist() ;
        for (int i = 0; i < arr.size(); i++)
        {
            if (arr.get(i).getName().equals(getLoginIDAttempt()))
            {
                if (arr.get(i).getPassword().equals(getPasswordAttempt())){
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
