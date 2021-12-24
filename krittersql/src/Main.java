import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {

        bank sampbank = new bank();
        Branch sampbranch = new Branch();
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        char ch = 'y';
        System.out.println("Welcome");

        while (ch == 'y' | ch == 'Y') {
            try {
                int y = random.nextInt(1000);
                System.out.println("Your Verification code is " + y);
                System.out.print("Enter your Verification code :");
                int x = sc.nextInt();
                if (x == y) {
                    int choice;
                    System.out.print("1. BANK OPERATIONS \n2. BRANCH OPERATIONS \nEnter your choice :");
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            int bchoice;
                            System.out.print("1. ADD NEW BANK \n2. PRINT ALL BANKS \n3. EDIT DETAILS\n4. LIST BRANCHES \nEnter your choice :");
                            bchoice = sc.nextInt();
                            switch (bchoice) {
                                case 1:
                                    sampbank.addBank();
                                    break;
                                case 2:
                                    sampbank.printBank();
                                    break;
                                case 3:
                                    sampbank.editdetails();
                                    break;
                                case 4:
                                    sampbank.bankbranch();
                                    break;

                            }
                            break;
                        case 2:
                            int brchoice;
                            System.out.print("1. ADD NEW BRANCH \n2. PRINT ALL BRANCHES \n3. PRINT EMPLOYEE ORDER\nEnter your choice :");
                            brchoice = sc.nextInt();
                            switch (brchoice) {
                                case 1:
                                    sampbranch.addbranch();
                                    break;
                                case 2:
                                    sampbranch.printBranch();
                                    break;
                                case 3:
                                    sampbranch.topemployees();
                                    break;

                            }

                    }
                    //

                }
            } catch (Exception e) {
                System.out.println("Invailid Format............");
            }

            System.out.print("Do you want to continue Main Menu(y/n) :");
            sc.nextLine();
            ch = sc.next().charAt(0);


        }

    }
}
