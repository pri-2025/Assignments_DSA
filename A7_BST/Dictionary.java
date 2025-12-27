package A7_BST;

import java.util.Scanner;

class Dictionary {
    Scanner sc = new Scanner(System.in);
    Node root;

    Dictionary() {
        root = null;
    }

    // CREATE
    public void create() {
        char ans;
        do {
            System.out.print("Enter a word : ");
            String word = sc.nextLine().toLowerCase(); // Normalize to lowercase
            System.out.print("Enter meaning of the word : ");
            String meaning = sc.nextLine();
            Node temp = new Node(word, meaning);

            if (root == null) {
                root = temp;
                System.out.println("Word added!");
            } else {
                Node ptr = root;
                while (true) {
                    if (word.compareTo(ptr.word) < 0) {
                        if (ptr.left == null) {
                            ptr.left = temp;
                            System.out.println("Word added!");
                            break;
                        } else {
                            ptr = ptr.left;
                        }
                    } else if (word.compareTo(ptr.word) > 0) {
                        if (ptr.right == null) {
                            ptr.right = temp;
                            System.out.println("Word added!");
                            break;
                        } else {
                            ptr = ptr.right;
                        }
                    } else {
                        System.out.println("Word already exists!");
                        break;
                    }
                }
            }
            System.out.println();
            System.out.print("Do you want to add another word (Y/N)? ");
            ans = sc.next().charAt(0);
            sc.nextLine(); // consume newline
            System.out.println();
        } while (ans == 'Y' || ans == 'y');
    }

    // DISPLAY
    public void display(Node temp) {
        if (temp == null) return;
        display(temp.left);
        System.out.println(temp.word + ": " + temp.meaning);
        display(temp.right);
    }

    // SEARCH
    public void search() {
        System.out.print("Enter word: ");
        String s_word = sc.nextLine().toLowerCase(); // normalize input
        Node ptr = root;
        while (ptr != null) {
            if (ptr.word.equals(s_word)) {
                System.out.println("Word found!");
                System.out.println(ptr.word + ": " + ptr.meaning);
                return;
            } else if (ptr.word.compareTo(s_word) > 0) {
                ptr = ptr.left;
            } else {
                ptr = ptr.right;
            }
        }
        System.out.println("This word does not exist in dictionary!");
    }

    // UPDATE
    public void update() {
        System.out.print("Enter word to update: ");
        String s_word = sc.nextLine().toLowerCase(); // normalize input
        Node ptr = root;
        while (ptr != null) {
            if (ptr.word.equals(s_word)) {
                System.out.println("Current meaning: " + ptr.meaning);
                System.out.print("Enter new meaning: ");
                String newMeaning = sc.nextLine();
                ptr.meaning = newMeaning;
                System.out.println("Meaning updated successfully!");
                return;
            } else if (ptr.word.compareTo(s_word) > 0) {
                ptr = ptr.left;
            } else {
                ptr = ptr.right;
            }
        }
        System.out.println("This word does not exist in dictionary!");
    }

    // DELETE
    public void delete() {
        System.out.print("Enter word to delete: ");
        String s_word = sc.nextLine().toLowerCase(); // normalize input
        Node parent = null;
        Node ptr = root;

        while (ptr != null && !ptr.word.equals(s_word)) {
            parent = ptr;
            if (ptr.word.compareTo(s_word) > 0) {
                ptr = ptr.left;
            } else {
                ptr = ptr.right;
            }
        }

        if (ptr == null) {
            System.out.println("This word does not exist in dictionary!");
            return;
        }

        // Node has no children
        if (ptr.left == null && ptr.right == null) {
            if (ptr == root) root = null;
            else if (parent.left == ptr) parent.left = null;
            else parent.right = null;
        }
        // Node has only left child
        else if (ptr.left != null && ptr.right == null) {
            if (ptr == root) root = ptr.left;
            else if (parent.left == ptr) parent.left = ptr.left;
            else parent.right = ptr.left;
        }
        // Node has only right child
        else if (ptr.left == null && ptr.right != null) {
            if (ptr == root) root = ptr.right;
            else if (parent.left == ptr) parent.left = ptr.right;
            else parent.right = ptr.right;
        }
        // Node has both children
        else {
            Node p = ptr.left;
            Node pParent = ptr;
            while (p.right != null) {
                pParent = p;
                p = p.right;
            }
            ptr.word = p.word;
            ptr.meaning = p.meaning;
            if (pParent.left == p) pParent.left = p.left;
            else pParent.right = p.left;
        }

        System.out.println("Word deleted successfully!");
    }
}
