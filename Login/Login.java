package LoginSystem;
import java.util.Scanner;

public class Login{
    private LoginUser choice;


    public LoginUser getChoice(){
        return this.choice;
    }

    public void setChoice(LoginUser choice){
        this.choice = choice;
    }

    public void login(){
        System.out.println("Welcome! \n Select your option: \n [1] Customer \n [2] Staff"); // to be beautified
        Scanner scanner = new Scanner(System.in);
        int validity = 0;
        int option = 0;
        while (validity != 1){
            System.out.print("Enter an option: ");
            option = scanner.nextInt();
            if (option == 1 || option == 2){
                validity = 1;
                break;
            }
            System.out.println("Error! Please enter either [1] or [2]!");
        }
        scanner.close();

        switch (option){
            case 1: 
                setChoice(LoginUser.CUSTOMER);
                System.out.println("Redirecting you to the customer portal...");
            case 2: 
                setChoice(LoginUser.STAFF);
                System.out.println("Redirecting you to the staff portal...");
        }
    }
}