import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        MyTree obj = new MyTree();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the string you want to search: ");
        String datum = scan.nextLine();
        System.out.println("--------------BFS ALGORITHM--------------");
        obj.BFS(datum);
        System.out.println("--------------DFS ALGORITHM--------------");
        obj.DFS(datum);
        System.out.println("--------------POSTORDER TRAVERSAL--------------");
        obj.PostOrderTraversal(datum);

        System.out.println("----------------MOVE----------------");
        System.out.println("Enter the path you want to move to another path : ");
        String path = scan.nextLine();
        System.out.println("Enter the path you want to place the node you have moved.");
        String path2 = scan.nextLine();
        obj.MoveNode(path, path2);
    }
}