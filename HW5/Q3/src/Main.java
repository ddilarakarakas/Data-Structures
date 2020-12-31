public class Main {
    public static void main(String [] args){
        AgeSearchTree tree = new AgeSearchTree();
        System.out.println("***Add***");
        tree.add(new AgeData(10));
        tree.add(new AgeData(20));
        tree.add(new AgeData(5));
        tree.add(new AgeData(15));
        tree.add(new AgeData(10));
        System.out.println(tree.toString());
        System.out.println("***Find 10***");
        System.out.println(tree.find(new AgeData(10)).toString());
        System.out.println("***olderThan 10");
        System.out.println(tree.olderThan(10));
        System.out.println("***youngerThan 10");
        System.out.println(tree.youngerThan(10));
        System.out.println("***Delete 15***");
        tree.delete(new AgeData(15));
        System.out.println(tree.toString());
        System.out.println("***Delete 10***");
        tree.remove(new AgeData(10));
        System.out.println(tree.toString());

    }
}
