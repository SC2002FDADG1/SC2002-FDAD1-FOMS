package main;

import BranchSystem.BranchList;
import FoodSystem.Food;
import FoodSystem.Menu;
import PaymentSystem.PaymentList;
import PaymentSystem.PaymentType;
import StaffSystem.Manager;
import StaffSystem.Staff;
import StaffSystem.StaffAccount;
import StaffSystem.StaffAccountList;
import StaffSystem.StaffList;
import java.io.IOException;
import java.util.ArrayList;

public class test 
{
    public static void main(String[] args) throws IOException 
    {
        StaffList a = new StaffList();
        ArrayList<Manager> a1 = a.getstafflist();
        for (Staff a11 : a1) {
            System.out.println( a11.toString() ) ;
                    }
    }
}
