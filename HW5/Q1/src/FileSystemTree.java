import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FileSystemTree{
    private FileNode root;
    private int sizeNode;
    private int sizeFile;
    public FileSystemTree(String name){
        root = new FileNode(name);
        sizeNode = 1;
        sizeFile = 0;
    }
    /**
     * remove method to remove a directory (or a file) from the file system.
     * The path of the directory (or the file) will be given as a parameter to the method. T
     * he method will warn the user if the path cannot be found.
     * If the directory includes some other directories (or files),
     * method will list the contents and ask the user whether to remove or not.
     * @param input The object deleted from the tree
     * @throws Exception if does not match the input path entered.
     */
    public void remove(String input)throws Exception{
        FileNode temp;
        boolean controlPath = false;
        boolean controlFile = false;
        String [] arr = input.split("/");
        for(int i=0;i<arr[arr.length-1].length();i++){
            char c = arr[arr.length-1].charAt(i);
            if (c == '.')
                controlFile = true;

        }
        if(controlFile){
            if(arr[0].equals(root.name)){
                if(arr.length == 2){
                    if(root.nodes.get(0).getName().equals(arr[1])){
                        root.nodes.remove(0);
                        sizeFile--;
                    }
                    else
                        throw new Exception();
                }
                else{
                    temp = root;
                    for(int i=1;i<arr.length-1;i++){
                        int index = 0;
                        for(int j=0;j<temp.nodes.size();j++){
                            if(temp.nodes.get(j).name.equals(arr[i])){
                                index = j;
                                controlPath = true;
                                break;
                            }
                        }
                        if(controlPath){
                            temp = temp.nodes.get(index);
                        }
                        else{
                            throw new Exception();
                        }
                    }
                    if(temp.nodes.size() == 1)
                        temp.nodes.remove(0);
                    else{
                        int removeIndex = 0;
                        for(int i=0;i<temp.nodes.size();i++){
                            if(temp.nodes.get(i).getName().equals(arr[arr.length-1])){
                                removeIndex = i;
                                break;
                            }
                        }
                        temp.nodes.remove(removeIndex);
                    }
                    sizeFile--;
                }
            }
            else{
                throw new Exception();
            }
        }
        else{
            if(arr[0].equals(root.name)){
                if(arr.length == 2){
                    boolean control = false;
                    for(int i=0;i<root.nodes.size();i++){
                        if(root.nodes.get(i).getName().equals(arr[1])) {
                            control = true;
                        }
                    }
                    if(control)
                        temp = root;
                    else
                        throw new Exception();
                }
                else{
                    temp = root;
                    for(int i=1;i<arr.length-1;i++){
                        int index = 0;
                        for(int j=0;j<temp.nodes.size();j++){
                            if(temp.nodes.get(j).name.equals(arr[i])){
                                index = j;
                                controlPath = true;
                                break;
                            }
                        }
                        if(controlPath){
                            temp = temp.nodes.get(index);
                        }
                        else{
                            throw new Exception();
                        }
                    }
                }
                if(temp.nodes.size() == 1)
                    if(root.nodes.get(0).getName().equals(arr[1])) {
                        temp.nodes.remove(0);
                        sizeNode--;
                    }
                    else
                        throw new Exception();
                else{
                    boolean controlYes = false;
                    for(int i=0;i<temp.nodes.size();i++){
                        if(temp.nodes.get(i).getName().equals(arr[arr.length-1])){
                            if(temp.nodes.get(i).nodes.size() != 0 ){
                                System.out.println(arr[arr.length-1] + " includes:");
                                System.out.println(temp.nodes.get(i).toString());
                                controlYes = true;
                                break;
                            }
                            else{
                                int removeIndex = 0;
                                for(int k=0;k<temp.nodes.size();k++){
                                    if(temp.nodes.get(k).getName().equals(arr[arr.length-1])){
                                        removeIndex = k;
                                        break;
                                    }
                                }
                                temp.nodes.remove(removeIndex);
                                sizeNode--;
                                break;
                            }
                        }
                    }
                    if(controlYes){
                        System.out.println("Are you sure you want to delete (yes or no)");
                        Scanner scan = new Scanner(System.in);
                        if(scan.nextLine().equals("yes")){
                            int removeIndex = 0;
                            for(int i=0;i<temp.nodes.size();i++){
                                if(temp.nodes.get(i).getName().equals(arr[arr.length-1])){
                                    removeIndex = i;
                                    break;
                                }
                            }
                            temp.nodes.remove(removeIndex);
                            sizeNode--;
                        }
                    }

                }
            }
            else{
                throw new Exception();
            }
        }
    }
    /**
     * addFile methods to add files to the file system.
     * @param input The object being inserted
     * @throws Exception if input includes that  there is a file before, no added file and no file given
     */
    public void addFile(String input)throws Exception{
        FileNode  temp;
        boolean controlNode = false;
        boolean controlFile = false;
        String [] arr = input.split("/");
        for(int j=0;j<arr.length-1;j++){
            for(int i=0;i<arr.length-1;i++){
                char c = arr[arr.length-1].charAt(i);
                if (c == '.')
                    throw new Exception();
            }
        }
        for(int i=0;i<arr[arr.length-1].length();i++){
            char c = arr[arr.length-1].charAt(i);
            if (c == '.')
               controlFile = true;

        }
        if(!controlFile)
            throw new Exception();
        if(arr[0].equals(root.name)){
            if(arr.length == 2){
                root.addNode_Name(arr[1],input);
            }
            else{
                temp = root;
                for(int i=1;i<arr.length-1;i++){
                    int index = 0;
                    for(int j=0;j<temp.nodes.size();j++){
                        if(temp.nodes.get(j).name.equals(arr[i])){
                            index = j;
                            controlNode = true;
                            break;
                        }
                    }
                    if(controlNode){
                        temp = temp.nodes.get(index);
                    }
                    else{
                        throw new Exception();
                    }
                }
                FileNode newNode = new FileNode(arr[arr.length-1],input);
                temp.nodes.add(newNode);
                sizeFile++;
            }
        }
        else{
            throw new Exception();
        }
    }
    /**
     * addDir methods to add directory to the file system.
     * @param input The object being inserted
     * @throws Exception if input includes  there is a file name and no file given
     */
    public void addDir(String input)throws Exception{
        FileNode temp;
        boolean controlNode = false;
        String [] arr = input.split("/");
        for (String s : arr) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '.')
                    throw new Exception();
            }
        }
        if(arr[0].equals(root.name)){
            if(arr.length == 2){
                root.addNode_Name(arr[1],input);
            }
            else{
                temp = root;
                for(int i=1;i<arr.length-1;i++){
                    int index = 0;
                    for(int j=0;j<temp.nodes.size();j++){
                        if(temp.nodes.get(j).name.equals(arr[i])){
                            index = j;
                            controlNode = true;
                            break;
                        }
                    }
                    if(controlNode){
                        temp = temp.nodes.get(index);
                    }
                    else{
                        throw new Exception();
                    }
                }
                FileNode newNode = new FileNode(arr[arr.length-1],input);
                temp.nodes.add(newNode);
                sizeNode++;
            }
        }
        else{
            throw new Exception();
        }
    }
    /**
     * search method to search the entire file system for a directory or a file including
     * the given search characters in its name.
     * @param input The Comparable object being sought
     */
    public void search(String input){
        if(root == null)
            return;
        Queue<FileNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                FileNode p = queue.peek();
                queue.remove();
                System.out.println(p.toString2(input));
                for (int i = 0; i < p.nodes.size(); i++)
                    queue.add(p.nodes.get(i));
                size--;
            }
            System.out.println();
        }
    }
    /**
     * printFileSystem method to print the whole tree.
     */
    public void printFileSystem(){
        levelOrderTraversal(root);
    }
    /**
     * Standard level order traversal code using queue
     */
    public void levelOrderTraversal(FileNode root){
        if(root == null)
            return;
        Queue<FileNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                FileNode p = queue.peek();
                queue.remove();
                System.out.print(p.getName() + " ");
                for (int i = 0; i < p.nodes.size(); i++)
                    queue.add(p.nodes.get(i));
                size--;
            }
            System.out.println();
        }
    }
    @Override
    public String toString() {
        return root.toString();
    }
    /**
     * Static inner class node
     */
    private static class FileNode{
        private ArrayList<FileNode> nodes;
        private String name;
        private String type;
        private String path;
        public FileNode(String name_){
            boolean control = true;
            nodes = new ArrayList<>();
            name = name_;
            for(int i=0;i<name_.length();i++){
                char c = name_.charAt(i);
                if (c == '.') {
                    control = false;
                    break;
                }
            }
            if(control)
                type = "directory";
            else
                type = "file";
            path = null;
        }
        public FileNode(String name_,String input){
            boolean control = true;
            nodes = new ArrayList<>();
            name = name_;
            for(int i=0;i<name_.length();i++){
                char c = name_.charAt(i);
                if (c == '.') {
                    control = false;
                    break;
                }
            }
            if(control)
                type = "directory";
            else
                type = "file";
            path = input;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public void setType(String type) {
            this.type = type;
        }
        public String getType() {
            return type;
        }
        public void addNode_Name(String nameNode, String path_){
            boolean control = true;
            FileNode newNode= new FileNode(nameNode);
            for(int i=0;i<nameNode.length();i++){
                char c = nameNode.charAt(i);
                if (c == '.') {
                    control = false;
                    break;
                }
            }
            if(control)
                newNode.type = "directory";
            else
                newNode.type = "file";
            newNode.path = path_;
            nodes.add(newNode);
        }
        public void addNode_Node(FileNode node){
            nodes.add(node);
        }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(nodes.toString());
            return sb.toString();
        }
        /**
         * checks if there are words in their children
         * @param word The Comparable object being sought
         * @return String the path if it finds the searched word
         */
        public String toString2(String word){
            StringBuilder sb = new StringBuilder();
            for (FileNode node : nodes) {
                int temp = 0;
                boolean control = false;
                boolean control2 = true;
                for(int i=0;i<word.length();i++){
                    for(int j=0;j<node.getName().length();j++){
                        if(word.charAt(i) == node.getName().charAt(j)){
                            control = true;
                            temp = i;
                            break;
                        }
                    }
                    if(control){
                        for(int k=temp;k<word.length();k++){
                            if(word.charAt(k) != node.getName().charAt(k))
                                control2 = false;
                        }
                    }
                    if(control && control2){
                        sb.append(node.type);
                        sb.append(" - ");
                        sb.append(node.path);
                        sb.append("\n");
                        break;
                    }
                }
            }
            return sb.toString();
        }
    }
}