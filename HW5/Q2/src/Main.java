public class Main {
    public static void main(String [] args){
        ExpressionTree<String> tree = new ExpressionTree<>("10 5 15 * + 20 +");
        System.out.println("POSTFIX EXPRESSION toString1");
        System.out.println(tree.toString());
        System.out.println("\nPOSTFIX EXPRESSION toString2");
        System.out.println(tree.toString2());
        ExpressionTree<String> tree2 = new ExpressionTree<>("+ + 10 * 15 5 20");
        System.out.println("\nPREFIX EXPRESSION toString1");
        System.out.println(tree2.toString());
        System.out.println("\nPREFIX EXPRESSION toString2");
        System.out.println(tree2.toString2());
        System.out.println("\nPOSTFIX EXPRESSION EVAL:" + tree.eval());
        System.out.println("\nPREFIX EXPRESSION EVAL:" + tree2.eval());
    }
}
