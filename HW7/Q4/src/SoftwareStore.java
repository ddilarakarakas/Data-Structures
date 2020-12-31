import java.util.Scanner;
/**
 * Implement a menu-driven program for managing a software store.
 * @author dilarakarakas
 */
public class SoftwareStore {
    private SearchTree<Software> store;
    private static int softwareCapacity = 60;
    private String[] softwareName;
    private String adminPassword;
    private int softwareSize;
    /**
     * This implementation use a search tree interface.
     * So, it should be possible to use any data structure implanting search tree interface
     * @param tree data structure implanting search tree interface.
     */
    public SoftwareStore(SearchTree<Software> tree){
        store = tree;
        softwareName = new String[softwareCapacity];
        adminPassword = "123";
        store.add(new Software("Adobe Photoshop 6.0", "150$"));
        store.add(new Software("Adobe Photoshop 6.2", "200$"));
        store.add(new Software("Norton 4.5", "100$"));
        store.add(new Software("Norton 5.5", "150$"));
        store.add(new Software("Adobe Flash 3.3", "300$"));
        store.add(new Software("Adobe Flash 4.0", "320$"));
        softwareName[0] = "Adobe Photoshop 6.0";
        softwareName[1] = "Adobe Photoshop 6.2";
        softwareName[2] = "Norton 4.5";
        softwareName[3] = "Norton 5.5";
        softwareName[4] = "Adobe Flash 3.3";
        softwareName[5] = "Adobe Flash 4.0";
        softwareSize = 6;
    }
    /**
     * Menu-driven for managing
     */
    public void menu(){
        boolean control = true;
        while(control) {
            System.out.println("****WELCOME THE SOFTWARE STORE****");
            System.out.println(store.toString());
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the user, admin or exit ");
            String name = scanner.nextLine();
            switch (name) {
                case "admin":
                    admin();
                    break;
                case "user":
                    user();
                    break;
                case "exit":
                    control = false;
                    break;
                default:
                    System.out.println("WRONG INPUT!!");
                    break;
            }
        }
    }
    /**
     * It requests the admin password. If the password is correct, it can add, sell, search and upload.
     */
    private void admin(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the password (The system identified the password as 123. The admin is assumed to know this.)");
        String password = scanner.nextLine();
        if (password.equals(adminPassword)) {
            boolean controlAdmin = true;
            while (controlAdmin){
                System.out.println(store.toString() + "\n");
                System.out.println("Enter the you want to do (add)(sell)(update)(search)(exit)");
                String work = scanner.nextLine();
                switch (work) {
                    case "add":
                        System.out.println("Enter the software name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter the software price: ");
                        String price = scanner.nextLine();
                        Software newSoftware = new Software(name,price);
                        newSoftware.setQuantity(10);
                        add(newSoftware);
                        break;
                    case "sell":
                        System.out.println("Enter the software name: ");
                        String nameDeleted = scanner.nextLine();
                        Software sell = store.find(new Software(nameDeleted,"100"));
                        if(sell != null){
                            if(sell.getQuantity() == 1)
                                remove(new Software(nameDeleted,"100$"));
                            else {
                                sell.setQuantity((sell.getQuantity() - 1));
                                System.out.println(sell.toString() + "\n");
                            }
                        }
                        else
                            System.out.println("\nWRONG INPUT!!!\n");
                        break;
                    case "update":
                        update();
                        break;
                    case "search":
                        System.out.println("Enter the search item (name)(price)(quantity) : ");
                        String work2 = scanner.nextLine();
                        switch (work2) {
                            case "name":
                                System.out.println("Enter the software name: ");
                                String namePackage = scanner.nextLine();
                                search(new Software(namePackage, "1232"));
                                break;
                            case "price":
                                System.out.println("Enter the software price: ");
                                String tempPrice = scanner.nextLine();
                                searchPrice(tempPrice);
                                break;
                            case "quantity":
                                System.out.println("Enter the software quantity: ");
                                String tempQuantity = scanner.nextLine();
                                searchQuantity(tempQuantity);
                                break;
                            default:
                                System.out.println("WRONG INPUT!!!");
                                break;
                        }
                        break;
                    case "exit":
                        controlAdmin = false;
                        break;
                    default:
                        System.out.println("\nWRONG INPUT!!!\n");
                        break;
                }
            }
        } else
            System.out.println("Wrong password!!");
    }
    /**
     * User can be search.
     */
    private void user(){
        Scanner scanner = new Scanner(System.in);
        boolean controlUser = true;
        while (controlUser){
            System.out.println("Enter you want to do (search)(exit)");
            String work = scanner.nextLine();
            if(work.equals("search")){
                System.out.println("Enter the search item (name)(price)(quantity) : ");
                String work2 = scanner.nextLine();
                switch (work2) {
                    case "name":
                        System.out.println("Enter the software name: ");
                        String namePackage = scanner.nextLine();
                        search(new Software(namePackage, "1232"));
                        break;
                    case "price":
                        System.out.println("Enter the software price: ");
                        String tempPrice = scanner.nextLine();
                        searchPrice(tempPrice);
                        break;
                    case "quantity":
                        System.out.println("Enter the software quantity: ");
                        String tempQuantity = scanner.nextLine();
                        searchQuantity(tempQuantity);
                        break;
                    default:
                        System.out.println("WRONG INPUT!!!");
                        break;
                }
            }
            else if(work.equals("exit"))
                controlUser = false;
            else
                System.out.println("WRONG INPUT!!!");
        }
    }
    private void add(Software item){
        boolean control =  store.add(item);
        if(!control)
            System.out.println("WRONG INPUT!!!");
        System.out.println(store.toString());
        if(softwareName.length > softwareSize) {
            softwareName[softwareSize] = item.getName();
            softwareSize++;
        }
        else{
            softwareCapacity = softwareCapacity * 2;
            String [] newSoftwareName = new String[softwareCapacity];
            System.arraycopy(softwareName, 0, newSoftwareName, 0, softwareSize);
            softwareSize++;
            newSoftwareName[softwareSize] = item.getName();
            softwareName = new String[softwareCapacity];
            System.arraycopy(newSoftwareName,0,softwareName,0,softwareSize);
        }
    }
    /**
     * If the quantity was 0 after the sale of the software, that package is deleted.
     * @param item Deleted package
     */
    private void remove(Software item){
        Software control = store.delete(item);
        if(control == null)
            System.out.println("\nWRONG INPUT!!!\n");
        System.out.println(store.toString());
        int index=0;
        for(int i=0;i<softwareSize;i++) {
            if (softwareName[i].equals(item.getName()))
                index = i;
        }
        if (softwareSize - 1 - index >= 0)
            System.arraycopy(softwareName, index + 1, softwareName, index, softwareSize - 1 - index);
        softwareSize--;
    }
    /**
     * Updates price, name or quantity of the Software.
     */
    private void update(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the package name you want to update: ");
        String namePackage = scanner.nextLine();
        Software tempPackage = store.find(new Software(namePackage,"100"));
        if(tempPackage != null){
            System.out.println("Enter what you want to update (price)(name)(quantity)");
            String work = scanner.nextLine();
            switch (work) {
                case "price":
                    System.out.println("Enter the updated price: ");
                    String priceTemp = scanner.nextLine();
                    tempPackage.setPrice(priceTemp);
                    break;
                case "name":
                    System.out.println("Enter the updated name: ");
                    String nameTemp = scanner.nextLine();
                    tempPackage.setName(nameTemp);
                    break;
                case "quantity":
                    System.out.println("Enter the updated quantity: ");
                    String quantityTemp = scanner.nextLine();
                    tempPackage.setQuantity(Integer.parseInt(quantityTemp));
                    break;
                default:
                    System.out.println("\nWRONG INPUT!!!\n");
                    break;
            }
        }
        else System.out.println("\nWRONG INPUT!!!\n");
    }
    /**
     * Searching for software name.
     * @param item Software to be found
     */
    private void search(Software item){
        Software temp = store.find(item);
        if(temp != null){
            System.out.println("\nPackage included: " + temp.toString() + "\n");
        }
        else
            System.out.println("\nThe package entered was not found!!\n");
    }
    /**
     * Searching for price.
     * @param item price
     */
    private void searchPrice(String item) {
        int k = 1;
        for (int i = 0; i < softwareSize; i++) {
            Software temp = store.find(new Software(softwareName[i], item));
            if (temp.getPrice().equals(item)) {
                System.out.println(k + ") " + temp.toString() + "\n");
                k++;
            }
        }
    }
    /**
     * Searching for quantity.
     * @param item quantity
     */
    private void searchQuantity(String item){
        int k = 1;
        int itemInt = Integer.parseInt(item);
        for(int i=0;i<softwareSize;i++){
            Software temp = store.find(new Software(softwareName[i],item));
            if(temp.getQuantity() == itemInt) {
                System.out.println(k + ") " + temp.toString() + "\n");
                k++;
            }
        }
    }
    public String toString(){
        return store.toString();
    }
}