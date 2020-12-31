public class Main {
    public static void main(String [] args)/*throws Exception*/ {
        FileSystemTree tree = new FileSystemTree("root");
        try{
            System.out.println("***Adding***");
            tree.addDir("root/first_directory");
            tree.addDir("root/second_directory");
            tree.addDir("root/first_directory/new_directory");
            tree.addFile("root/first_directory/new_file.txt");
            tree.addDir("root/second_directory/third_directory");
            tree.addFile("root/second_directory/third_directory/test.txt");
            tree.addFile("root/first_directory/new_directory/new_file.doc");
            System.out.println(tree.toString());
            System.out.println("\n*** Removing 'root/second_directory/third_directory' ***");
            tree.remove("root/second_directory/third_directory/test.txt");
            System.out.println(tree.toString());
            System.out.println("\n*** Removing 'root/second_directory' ***");
            tree.remove("root/second_directory");
            System.out.println(tree.toString());
        }
        catch(Exception e){
            System.out.println("exception");
        }
        System.out.println("\n*** printFileSystem ***");
        tree.printFileSystem();
        System.out.println("\n*** Search 'new' ***");
        tree.search("new");
    }
}
