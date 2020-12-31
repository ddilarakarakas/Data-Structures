import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name: ");
        String name = scanner.nextLine();
        Maze maze = new Maze(name);
        maze.path();
       // maze.isReachable(0,23);
    }


}
