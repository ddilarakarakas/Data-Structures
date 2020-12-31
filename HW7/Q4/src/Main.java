public class Main {
    public static void main(String [] args){
        BinarySearchTree<Software> storeTree = new BinarySearchTree<>();
        SoftwareStore store = new SoftwareStore(storeTree);
        store.menu();
    }
}
