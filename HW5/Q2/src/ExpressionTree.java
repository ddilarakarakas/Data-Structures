import java.util.Scanner;

public class ExpressionTree<E> extends BinaryTree<E> {
    public ExpressionTree(){
        root = null;
    }
    /**
     * A constructor to initialize the tree structure with the given expression string.
     * @param str The expression string will be given as a parameter to the constructor.
     */
    @SuppressWarnings("unchecked")
    public ExpressionTree(String str){
        Scanner scan = new Scanner(str);
        String [] arr =str.split(" ");
        String [] numberDigit = new String[arr.length];
        if(isOperator(arr[0].charAt(0))){
            int k = 0;
            for(int i=arr.length-1;i>=0;i--){
                numberDigit[k] = arr[i];
                k++;
            }
        }
        else{
            int k = 0;
            for(int i=0;i<arr.length;i++){
                numberDigit[k] = arr[i];
                k++;
            }
        }
        Node [] nodeArray = new Node[100];
        int nodeNumber = 0;
        for(int i=0;i<numberDigit.length;i++){
            if(!(isOperator(numberDigit[i].charAt(0)))){
                Node<Integer> eNode = new Node<>(Integer.parseInt(numberDigit[i]));
                nodeArray[nodeNumber] = eNode;
                nodeNumber++;
            }
            else{
                Node<String> eNode = new Node<>(numberDigit[i]);
                E node1 = (E) nodeArray[nodeNumber-1].data;
                E node2 = (E) nodeArray[nodeNumber-2].data;
                if(isLow(node1,node2)){
                    eNode.right = nodeArray[nodeNumber-2];
                    eNode.left = nodeArray[nodeNumber-1];
                }
                else{
                    eNode.right = nodeArray[nodeNumber-1];
                    eNode.left = nodeArray[nodeNumber-2];
                }
                nodeArray[nodeNumber-1] = null;
                nodeArray[nodeNumber-2] = eNode;
                nodeNumber--;
            }
        }
        root = readBinaryTree(scan).root;
        root = nodeArray[0];
    }
    /**
     * Makes comparisons based on transaction priority.
     * @param c1 compared data1
     * @param c2 compared data2
     * @return true if data1 is low than data2
     */
    public boolean isLow(E c1,E c2){
        if(c1.equals("+") || c1.equals("-"))
            return true;
        else if(c1.equals("%") || c1.equals("/") || c1.equals("*")){
            return !c2.equals("%") && !c2.equals("/") && !c2.equals("*") && !c2.equals("+") && !c2.equals("-");
        }
        else
            return false;
    }
    /**
     * Checks if the character is an arithmetic operator
     * @param c char
     * @return true if the character is an arithmetic operator
     */
    public static boolean isOperator(char c) {
        return c == '+' || c == '-'
                || c == '*' || c == '/'
                || c == '^' || c == '%';
    }
    /**
     * Perform a postOrder traversal.
     * @param node The local root
     * @param depth The depth
     * @param sb The string buffer to save the output
     */
    private void postOrderTraverse(Node<E> node, int depth, StringBuilder sb){
        if(node == null)
            sb.append(" ");
        else{
            postOrderTraverse(node.left, depth+1,sb);
            postOrderTraverse(node.right,depth+1,sb);
            sb.append(node.toString());
            sb.append(" ");
        }
    }
    /**
     * Perform a preOrder traversal (override).
     * @param node The local root
     * @param depth The depth
     * @param sb The string buffer to save the output
     */
    private void preOrderTraverse2(Node<E> node, int depth, StringBuilder sb){
        if(node == null)
            sb.append(" ");
        else{
            sb.append(node.toString());
            sb.append(" ");
            preOrderTraverse2(node.left, depth+1,sb);
            preOrderTraverse2(node.right,depth+1,sb);
        }
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        preOrderTraverse2(root,1,sb);
        return sb.toString();
    }
    public String toString2(){
        StringBuilder sb = new StringBuilder();
        postOrderTraverse(root,1,sb);
        return sb.toString();
    }
    private int eval2(Node<E> eNode){
        if(eNode == null)
            return 0;
        if(eNode.right == null && eNode.left == null)
            return (int) eNode.data;
        int leftValue = eval2(eNode.left);
        int rightValue = eval2(eNode.right);
        if(eNode.data.equals("+"))
            return leftValue + rightValue;
        else if(eNode.data.equals("-"))
            return leftValue - rightValue;
        else if(eNode.data.equals("*"))
            return leftValue * rightValue;
        else if(eNode.data.equals("/"))
            return leftValue / rightValue;
        else
            return leftValue % rightValue;
    }
    public int eval(){
        return eval2(root);
    }
    public static ExpressionTree<String> readBinaryTree(Scanner scan){
        String str = scan.nextLine();
        ExpressionTree<String> tree = new ExpressionTree<>();
        return tree;
    }
}
