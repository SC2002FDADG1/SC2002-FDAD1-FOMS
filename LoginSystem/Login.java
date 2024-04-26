package LoginSystem;
import java.util.Scanner;
import static main.Main.sc;

public class Login
{
    private LoginUser choice;


    public LoginUser getChoice()
    {
        return this.choice;
    }

    public void setChoice(LoginUser choice)
    {
        this.choice = choice;
    }

    public void login()
    {
        System.out.println("░██╗░░░░░░░██╗███████╗██╗░░░░░░█████╗░░█████╗░███╗░░░███╗███████╗  ████████╗░█████╗░  ███████╗░█████╗░███╗░░░███╗░██████╗\n" +
"░██║░░██╗░░██║██╔════╝██║░░░░░██╔══██╗██╔══██╗████╗░████║██╔════╝  ╚══██╔══╝██╔══██╗  ██╔════╝██╔══██╗████╗░████║██╔════╝\n" +
"░╚██╗████╗██╔╝█████╗░░██║░░░░░██║░░╚═╝██║░░██║██╔████╔██║█████╗░░  ░░░██║░░░██║░░██║  █████╗░░██║░░██║██╔████╔██║╚█████╗░\n" +
"░░████╔═████║░██╔══╝░░██║░░░░░██║░░██╗██║░░██║██║╚██╔╝██║██╔══╝░░  ░░░██║░░░██║░░██║  ██╔══╝░░██║░░██║██║╚██╔╝██║░╚═══██╗\n" +
"░░╚██╔╝░╚██╔╝░███████╗███████╗╚█████╔╝╚█████╔╝██║░╚═╝░██║███████╗  ░░░██║░░░╚█████╔╝  ██║░░░░░╚█████╔╝██║░╚═╝░██║██████╔╝"
                + "\n Select your option: \n [1] Customer \n [2] Staff"); // to be beautified
        int option;
            int validity = 0;
            option = 0;
            while (validity != 1)
            {
                System.out.print("Enter an option: ");
                option = sc.nextInt();
                if (option == 1 || option == 2)
                {
                    validity = 1;
                    break;
                }
                System.out.println("Error! Please enter either [1] or [2]!");
            }

        switch (option)
        {
            case 1: 
                setChoice(LoginUser.CUSTOMER);
                System.out.println("█▀█ █▀▀ █▀▄ █ █▀█ █▀▀ █▀▀ ▀█▀ █ █▄░█ █▀▀   █▄█ █▀█ █░█   ▀█▀ █▀█   ▀█▀ █░█ █▀▀   █▀▀ █░█ █▀ ▀█▀ █▀█ █▀▄▀█ █▀▀ █▀█\n" +
"█▀▄ ██▄ █▄▀ █ █▀▄ ██▄ █▄▄ ░█░ █ █░▀█ █▄█   ░█░ █▄█ █▄█   ░█░ █▄█   ░█░ █▀█ ██▄   █▄▄ █▄█ ▄█ ░█░ █▄█ █░▀░█ ██▄ █▀▄\n" +
"\n" +
"█▀█ █▀█ █▀█ ▀█▀ ▄▀█ █░░ ░ ░ ░\n" +
"█▀▀ █▄█ █▀▄ ░█░ █▀█ █▄▄ ▄ ▄ ▄");
                break ;
            case 2: 
                setChoice(LoginUser.STAFF);
                System.out.println("█▀█ █▀▀ █▀▄ █ █▀█ █▀▀ █▀▀ ▀█▀ █ █▄░█ █▀▀   █▄█ █▀█ █░█   ▀█▀ █▀█   ▀█▀ █░█ █▀▀   █▀ ▀█▀ ▄▀█ █▀▀ █▀▀\n" +
"█▀▄ ██▄ █▄▀ █ █▀▄ ██▄ █▄▄ ░█░ █ █░▀█ █▄█   ░█░ █▄█ █▄█   ░█░ █▄█   ░█░ █▀█ ██▄   ▄█ ░█░ █▀█ █▀░ █▀░\n" +
"\n" +
"█▀█ █▀█ █▀█ ▀█▀ ▄▀█ █░░\n" +
"█▀▀ █▄█ █▀▄ ░█░ █▀█ █▄▄");
        }
    }
}