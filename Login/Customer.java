package LoginSystem;
import BranchSystem.BranchList;
import BranchSystem.BranchInfo;
import java.util.Scanner;

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
        System.out.println("Welcome! \n Select your option: \n [1]Order  \n [2] Check Order Status"); // to be beautified
        Scanner scanner = new Scanner(System.in);
        int validity = 0;
        int option = 0;
        while (validity != 1){
            System.out.print("Enter your choice: ");
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
                setCustomerOption(CustomerType.ORDER);
                System.out.println("Redirecting you to the order portal...");
            case 2: 
                setCustomerOption(CustomerType.CHECK_STATUS);
                System.out.println("Redirecting you to the order status portal...");
        }
        
    }
    
}
