package A2_CodeClubSubscription_LL;

import java.util.Scanner;

public class CodeClub {

    Member head = null, tail = null;
    Scanner sc = new Scanner(System.in);

    public void insert_record() {
        char ans;

        do {
            sc.nextLine();
            System.out.print("Enter name of the member : ");
            String m_name = sc.nextLine();
            System.out.print("Enter ID of the member : ");
            int m_id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter position of the member : ");
            String post = sc.nextLine();
            System.out.print("Enter academic details of the member : ");
            String acad_dets = sc.nextLine();

            Member Mem = new Member(m_id, m_name, post, acad_dets);

            if (head == null) {
                head = Mem;
            } else {
                Member temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = Mem;
                Mem.prev = temp;
            }
            System.out.println("\nMember inserted successfully!\n");
            System.out.println();

            System.out.print("Do you want to add another member? (Y/N): ");
            ans = sc.next().charAt(0);
            System.out.println();

        } while (ans == 'Y' || ans == 'y');
    }

    public void display_record() {

        if (head == null) {  
            System.out.println("No records found!");
            return;
        }

        Member temp = head;

        while (temp != null) {
            System.out.println("Name : " + temp.m_name);
            System.out.println("ID : " + temp.m_id);
            System.out.println("Position : " + temp.pos);
            System.out.println("Academic Details : " + temp.acad_dets);
            System.out.println();
            temp = temp.next;
        }
    }

    public void delete_record() {

        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        System.out.print("Enter ID to delete: ");
        int key_id = sc.nextInt();

        Member temp = head;

        while (temp != null) {

            if (temp.m_id == key_id) {

                if (temp == head) {   
                    head = head.next;
                    if (head != null)
                        head.prev = null;
                }
                else if (temp.next == null) { 
                    temp.prev.next = null;
                }
                else { 
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                System.out.println("Record deleted!");
                return;
            }
            temp = temp.next;
        }
        System.out.println("ID not found!");
    }

    public void update_record() {

        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        System.out.print("Enter ID to update: ");
        int key_id = sc.nextInt();
        sc.nextLine();

        Member temp = head;

        while (temp != null) {

            if (temp.m_id == key_id) {
                System.out.print("Enter new Name: ");
                temp.m_name = sc.nextLine();
                System.out.print("Enter new Position: ");
                temp.pos = sc.nextLine();
                System.out.print("Enter new Academic details: ");
                temp.acad_dets = sc.nextLine();
                System.out.println("Record updated!");
                return;
            }
            temp = temp.next;
        }
        System.out.println("ID not found!");
    }
}
