package LoginSystem;
import BranchSystem.BranchInfo;
import java.util.Scanner;
import static main.Main.sc;

public class Customer{
    private CustomerType customerOption;
    private BranchInfo branch;


    public void setBranch(BranchInfo branch){
        this.branch = branch;
    }
    public BranchInfo getBranch(){
        return this.branch;
    }

    public CustomerType getCustomerOption(){
        return this.customerOption;
    }

    public void setCustomerOption(CustomerType option){
        this.customerOption = option;
    }

    public void run(){
        System.out.println("Welcome! \n Select your option: \n [1] Order  \n [2] Check Order Status"); // to be beautified
        int option;
            int validity = 0;
            option = 0;
            while (validity != 1){
                System.out.print("Enter your choice: ");
                option = sc.nextInt();
                sc.nextLine() ;
                if (option == 1 || option == 2){
                    validity = 1;
                    break;
                }
                System.out.println("Error! Please enter either [1] or [2]!");
            }

        switch (option){
            case 1: 
                setCustomerOption(CustomerType.ORDER);
                System.out.println("█▀█ █▀▀ █▀▄ █ █▀█ █▀▀ █▀▀ ▀█▀ █ █▄░█ █▀▀   █▄█ █▀█ █░█   ▀█▀ █▀█   ▀█▀ █░█ █▀▀   █▀█ █▀█ █▀▄ █▀▀ █▀█\n" +
"█▀▄ ██▄ █▄▀ █ █▀▄ ██▄ █▄▄ ░█░ █ █░▀█ █▄█   ░█░ █▄█ █▄█   ░█░ █▄█   ░█░ █▀█ ██▄   █▄█ █▀▄ █▄▀ ██▄ █▀▄\n" +
"\n" +
"█▀█ █▀█ █▀█ ▀█▀ ▄▀█ █░░\n" +
"█▀▀ █▄█ █▀▄ ░█░ █▀█ █▄▄");
                break;
            case 2: 
                setCustomerOption(CustomerType.CHECK_STATUS);
                System.out.println("▒█▀▀█ █▀▀ █▀▀▄ ░▀░ █▀▀█ █▀▀ █▀▀ ▀▀█▀▀ ░▀░ █▀▀▄ █▀▀▀ 　 █░░█ █▀▀█ █░░█ 　 ▀▀█▀▀ █▀▀█ 　 ▀▀█▀▀ █░░█ █▀▀ \n" +
"▒█▄▄▀ █▀▀ █░░█ ▀█▀ █▄▄▀ █▀▀ █░░ ░░█░░ ▀█▀ █░░█ █░▀█ 　 █▄▄█ █░░█ █░░█ 　 ░░█░░ █░░█ 　 ░░█░░ █▀▀█ █▀▀ \n" +
"▒█░▒█ ▀▀▀ ▀▀▀░ ▀▀▀ ▀░▀▀ ▀▀▀ ▀▀▀ ░░▀░░ ▀▀▀ ▀░░▀ ▀▀▀▀ 　 ▄▄▄█ ▀▀▀▀ ░▀▀▀ 　 ░░▀░░ ▀▀▀▀ 　 ░░▀░░ ▀░░▀ ▀▀▀ \n" +
"\n" +
"█▀▀█ █▀▀█ █▀▀▄ █▀▀ █▀▀█ 　 █▀▀ ▀▀█▀▀ █▀▀█ ▀▀█▀▀ █░░█ █▀▀ 　 █▀▀█ █▀▀█ █▀▀█ ▀▀█▀▀ █▀▀█ █░░ \n" +
"█░░█ █▄▄▀ █░░█ █▀▀ █▄▄▀ 　 ▀▀█ ░░█░░ █▄▄█ ░░█░░ █░░█ ▀▀█ 　 █░░█ █░░█ █▄▄▀ ░░█░░ █▄▄█ █░░ \n" +
"▀▀▀▀ ▀░▀▀ ▀▀▀░ ▀▀▀ ▀░▀▀ 　 ▀▀▀ ░░▀░░ ▀░░▀ ░░▀░░ ░▀▀▀ ▀▀▀ 　 █▀▀▀ ▀▀▀▀ ▀░▀▀ ░░▀░░ ▀░░▀ ▀▀▀");
                break;
        }
        
    }
    
}