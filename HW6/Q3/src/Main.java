import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        LibraryAutomation libraryA = new LibraryAutomation();
        boolean control = true;
        while(control) {
            System.out.println("****WELCOME THE NED STARK LIBRARY****");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the user, admin or exit ");
            String name = scanner.nextLine();
            if (name.equals("admin")) {
                libraryA.admin();
            }
            else if(name.equals("user")){
                boolean controlUser = true;
                while (controlUser){
                    System.out.println("Enter you want to do (search author)(search book)(exit)");
                    String work = scanner.nextLine();
                    if(work.equals("search author")){
                        System.out.println("Enter the author name: ");
                        String author = scanner.nextLine();
                        libraryA.searchAuthor(author);
                    }
                    else if(work.equals("search book")){
                        System.out.println("Enter the book name: ");
                        String book = scanner.nextLine();
                        libraryA.searchBook(book);
                    }
                    else if(work.equals("exit"))
                        controlUser = false;
                    else
                        System.out.println("WRONG INPUT!!!");
                }
            }
            else if(name.equals("exit"))
                control = false;
            else
                System.out.println("WRONG INPUT!!");
        }
    }
}