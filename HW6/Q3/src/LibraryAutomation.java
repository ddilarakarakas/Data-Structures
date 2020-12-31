import java.util.*;

public class LibraryAutomation {
    private Map<String, Map<String, Set<Map<String,String>>>> library;
    private String adminPassword;
    public LibraryAutomation(){
        library = new HashMap<String, Map<String, Set<Map<String, String>>>>();
        adminPassword = "123";
    }
    /**
     * It requests the admin password. If the password is correct, it can add, remove and upload.
     */
    public void admin(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the password (The system identified the password as 123. The admin is assumed to know this.)");
        String password = scanner.nextLine();
        if (password.equals(adminPassword)) {
            boolean controlAdmin = true;
            while (controlAdmin){
                System.out.println("Enter the you want to do (add)(remove)(update)(exit)");
                String work = scanner.nextLine();
                switch (work) {
                    case "add": {
                        System.out.println("Author name: ");
                        String author = scanner.nextLine();
                        System.out.println("Book name: ");
                        String book = scanner.nextLine();
                        addBook(author, book);
                        System.out.println(library);
                        break;
                    }
                    case "remove": {
                        System.out.println("Author name: ");
                        String author = scanner.nextLine();
                        System.out.println("Book name: ");
                        String book = scanner.nextLine();
                        removeBooks(author, book);
                        System.out.println(library);
                        break;
                    }
                    case "update": {
                        System.out.println("Author name: ");
                        String author = scanner.nextLine();
                        System.out.println("Book name: ");
                        String book = scanner.nextLine();
                        System.out.println("Location: ");
                        String location = scanner.nextLine();
                        update(author, book, location);
                        System.out.println(library);
                        break;
                    }
                    case "exit":
                        controlAdmin = false;
                        break;
                    default:
                        System.out.println("WRONG INPUT!!!");
                        break;
                }
            }
        } else
            System.out.println("Wrong password!!");
    }
    /**
     * Updates from the status of the book.
     * @param author The author of the book
     * @param book The book title of the book
     * @param location The location of the book
     * @throws NoSuchElementException if it is not available
     */
    private void update(String author, String book, String location){
        if(library.containsKey(author)){
            Map<String,Set<Map<String,String>>> bookMap = library.get(author);
            if(bookMap.containsKey(book)){
                Set<Map<String,String>> locationSet = bookMap.get(book);
                if(locationSet.size() > 1){
                    for (Map<String, String> temp : locationSet) {
                        if (temp.containsKey(location)) {
                            System.out.println("Status : " + temp.values());
                            Scanner scanner = new Scanner(System.in);
                            System.out.println("Enter the new status : ");
                            String newStatus = scanner.nextLine();
                            temp.remove(location);
                            temp.put(location, newStatus);
                        }
                    }
                }
                else if(locationSet.size() == 1){
                    locationSet.clear();
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter the new status : ");
                    String newStatus = scanner.nextLine();
                    Map<String,String> temp = new HashMap<>();
                    temp.put(location,newStatus);
                    locationSet.add(temp);
                }
                else
                    throw new NoSuchElementException();
            }
            else
                throw new NoSuchElementException();
        }
        else
            throw new NoSuchElementException();
    }
    /**
     * Deletes the given book.
     * @param author The author of the book
     * @param book The book title of the book
     * @throws NoSuchElementException if it is not available
     */
    private void removeBooks(String author, String book){
        if(library.containsKey(author)){
            Map<String,Set<Map<String,String>>> bookMap = library.get(author);
            if(bookMap.containsKey(book)){
                Set<Map<String,String>> locationSet = bookMap.get(book);
                if(locationSet.size() > 1){
                    System.out.println(locationSet.toString());
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter the location you want to delete : ");
                    String locationDelete = scanner.nextLine();
                    Iterator<Map<String,String>> iter = locationSet.iterator();
                    while(iter.hasNext()){
                        Map<String,String> temp = iter.next();
                        if(temp.containsKey(locationDelete)){
                            if(temp.get(locationDelete).equals("reserved"))
                                System.out.println("This book is reserved. So you cannot delete!!");
                            else {
                                iter.remove();
                            }
                        }
                    }
                }
                else if(locationSet.size() == 1){
                    Object [] maps =  locationSet.toArray();
                    String mapTo = maps[0].toString();
                    boolean stringEquals = true;
                    boolean controlString = true;
                    int k = 0;
                    for(int i=0;i<mapTo.length();i++){
                        if(mapTo.charAt(i) == 'r'){
                             k = i;
                            break;
                        }
                    }
                    for(int j=0;j<"reserved".length();j++){
                        if(mapTo.charAt(k) != "reserved".charAt(j)){
                            stringEquals = false;
                            break;
                        }
                        k++;
                    }
                    if(stringEquals)
                        System.out.println("This book is reserved. So you cannot delete!!");
                    else
                        bookMap.remove(book);
                }
                else
                    throw new NoSuchElementException();
            }
            else{
                System.out.println("throw");
                throw new NoSuchElementException();
            }

        }
        else
            throw new NoSuchElementException();
    }
    /**
     * Add the given book.
     * @param author The author of the book
     * @param book The book title of the book
     * @throws NoSuchElementException if it is not available
     */
    private void addBook(String author, String book){
        if(library.containsKey(author)){
            Map<String,Set<Map<String,String>>> bookMap = library.get(author);
            if(bookMap.containsKey(book)){
                Map<String,String> locationMap = new HashMap<>();
                String location = setLocation();
                String status = setStatus();
                locationMap.put(location,status);
                Set<Map<String,String>> locationSet = bookMap.get(book);
                locationSet.add(locationMap);
            }
            else{
                Map<String,String> locationMap = new HashMap<>();
                String location = setLocation();
                String status = setStatus();
                locationMap.put(location,status);
                Set<Map<String,String>> locationSet = new HashSet<Map<String, String>>();
                locationSet.add(locationMap);
                bookMap.put(book,locationSet);
            }
        }
        else{
            String location = setLocation();
            Map<String,Set<Map<String,String>>> bookMap = new HashMap<String,Set<Map<String,String>>>();
            Map<String,String> locationMap = new HashMap<>();
            String status = setStatus();
            locationMap.put(location,status);
            Set<Map<String,String>> locationSet = new HashSet<Map<String ,String>>();
            locationSet.add(locationMap);
            bookMap.put(book,locationSet);
            library.put(author,bookMap);
        }

    }
    /**
     * Gets location from user when adding books.
     * @return new location
     */
    private String setLocation(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the location: ");
        return scanner.nextLine();
    }
    /**
     * Gets status from user when adding books.
     * @return new status
     */
    private String setStatus(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the status: ");
        return scanner.nextLine();
    }
    /**
     * When searching by author name, all books of the author in the library will be listed on the screen.
     *
     * @param author The author of the book
     * @return The book name
     */
    private String searchAuthor2(String author){
        if(library.size() == 0)
            return  "THERE IS NO BOOK AT THE LIBRARY!!";
        else{
            if(library.containsKey(author))
                return library.get(author).keySet().toString();
            else
                return "THIS AUTHOR NOT AVAILABLE";
        }
    }
    /**
     * When searching by author name, all books of the author in the library will be listed on the screen.
     * Then, whichever book the user chooses, the location(s) of that book will be displayed.
     * @param author The author of the book
     */
    public void searchAuthor(String author){
        System.out.println(searchAuthor2(author));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the title of the book you want to view : ");
        String book = scanner.nextLine();
        if(library.size() == 0){
            System.out.println("\"THERE IS NO BOOK AT THE LIBRARY!!\"");
        }
        else{
            Set<Map.Entry<String,Map<String,Set<Map<String ,String >>>>> temp = library.entrySet();
            for (Map.Entry<String, Map<String, Set<Map<String, String>>>> tempAuthor : temp) {
                if(tempAuthor.getKey().equals(author)){
                    Map<String, Set<Map<String, String>>> tempBook = tempAuthor.getValue();
                    if (tempBook.containsKey(book)) {
                        Set<Map<String, String>> tempSetlocation = tempBook.get(book);
                        for (Map<String, String> tempMapLocation : tempSetlocation) {
                            if (tempMapLocation.size() != 0) {
                                System.out.println("Location and Status :  " + tempMapLocation.toString());
                            }
                        }
                    }
                }
            }
        }
    }
    /**
     * When searching by book title, author name, location and status will be shown.
     * @param book The book title of the book
     */
    public void searchBook(String book){
        if(library.size() == 0){
            System.out.println("\"THERE IS NO BOOK AT THE LIBRARY!!\"");
        }
        else{
            Set<Map.Entry<String,Map<String,Set<Map<String ,String >>>>> temp = library.entrySet();
            for (Map.Entry<String, Map<String, Set<Map<String, String>>>> tempAuthor : temp) {
                Map<String, Set<Map<String, String>>> tempBook = tempAuthor.getValue();
                if (tempBook.containsKey(book)) {
                    System.out.println("Author : " + tempAuthor.getKey());
                    Set<Map<String, String>> tempSetlocation = tempBook.get(book);
                    for (Map<String, String> tempMapLocation : tempSetlocation) {
                        if (tempMapLocation.size() != 0) {
                            System.out.println("Location and Status :  " + tempMapLocation.toString());
                        }
                    }
                }
            }
        }
    }
}