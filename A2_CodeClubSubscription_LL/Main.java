package A2_CodeClubSubscription_LL;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CodeClub Cc = new CodeClub();
        int choice;

        do {
            System.out.println("-------- Code Club Menu ---------");
            System.out.println("1. Insert / Create Member");
            System.out.println("2. Display Members");
            System.out.println("3. Delete Member");
            System.out.println("4. Update Member");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    Cc.insert_record();   
                    System.out.println();
                    break;

                case 2:
                    Cc.display_record();
                    System.out.println();
                    break;

                case 3:
                    Cc.delete_record();
                    System.out.println();
                    break;

                case 4:
                    Cc.update_record();
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    System.out.println();
                    break;

                default:
                    System.out.println("Enter a valid option!");
                    System.out.println();
            }

        } while (choice != 5);
    }
}
