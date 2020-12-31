import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        CrossWordPuzzle puzzle = new CrossWordPuzzle();
        String word;
        System.out.println("Word enter for add");
        word = input.nextLine();
        puzzle.addWord(word);
        puzzle.print();
        System.out.println("Word enter for add");
        word = input.nextLine();
        puzzle.addWord(word);
        puzzle.print();
        System.out.println("Word enter for add");
        word = input.nextLine();
        puzzle.addWord(word);
        puzzle.print();
        System.out.println("Word enter for removing");
        word = input.nextLine();
        puzzle.removeWord(word);
        puzzle.print();
    }
}
