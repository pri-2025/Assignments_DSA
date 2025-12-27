package A8_Graph;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Graph obj = new Graph() ;
        int choice ;

        do {
            System.out.println("Enter among following choices");
            System.out.println("1. Create Graph(Adjacency List)");
            System.out.println("2. BFS traversal");
            System.out.println("3. DFS traversal");
            System.out.println("4. Prims Algorithm");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Enter your choice : ");
            choice = input.nextInt() ;
            switch (choice)
            {
                case 1:
                    obj.createAdjacencyList();
                    break ;

                case 2:
                    System.out.print("Enter starting point : ");
                    int str = input.nextInt() ;
                    obj.BFS(str);
                    break ;

                case 3:
                    System.out.print("Enter starting point : ");
                    int dstr = input.nextInt() ;
                    obj.DFS(dstr);
                    break;

                case 4:
                    obj.createAdjacencyMatrix();
                    obj.primsAlgorithm();
                    break;
            }
        }while(choice != 5);
    }
}