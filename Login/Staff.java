package LoginSystem;
package StaffSystem.StaffAccountController;
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

    public int checkAttempt(){ // returns 1 if authentication passed, 0 if failed
        for (int i = 0; i < StaffSystem.StaffAccountController.StaffAccount.size(); i++){
            String current = StaffSystem.StaffAccountController.StaffAccount.get(i);
            if (current.equals(getLoginIDAttempt())){
                if (current.equals(getPasswordAttempt())){
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
