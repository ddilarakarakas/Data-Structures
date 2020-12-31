import java.util.Stack;

public class Question3 {
    public static void printReverseString(String [] arrWord,int index){
        if(index == -1){
            return;
        }else{
            System.out.print(arrWord[index] + " ");
            printReverseString(arrWord,--index);
        }
    }
    public static void reverseString(String str){
        String [] arrWord = str.split(" ");
        int index = arrWord.length - 1;
        printReverseString(arrWord,index);
    }
    public static boolean elfishWord(String word){
        return elfish(word,false,false,false);
    }
    /**
     * Control Elfish word
     * @param word string word
     * @param controlL control l
     * @param controlE control e
     * @param controlF control f
     * @return if word contain l, f and e , return true
     */
    public static boolean elfish(String word,boolean controlL, boolean controlE,boolean controlF){
        if(word == null || word.isEmpty()) {
            return controlE && controlF && controlL;
        }
        else{
            if(word.charAt(0) == 'e')
                controlE = true;
            if(word.charAt(0) == 'l')
                controlL = true;
            if(word.charAt(0) == 'f')
                controlF = true;
           return elfish(word.substring(1),controlL,controlE,controlF);
        }
    }
    public static void sortedSelection(int [] arr){
        sorted(arr,0,0,arr.length);
    }
    /**
     * Selection sorted
     * @param arr single array
     * @param i arr[i]
     * @param j arr[j]
     * @param size array size
     */
    public static void sorted(int [] arr, int i, int j, int size){
        boolean control = true;
        if(i == size-1)
            return;
        else{
            if(j == size) {
                i++;
                j = i;
                control = false;
            }
            if(control){
                if(arr[j] < arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
            sorted(arr,i,++j,size);
        }
    }
    /**
     * Print single array
     */
    public static void printArray(int [] arr, int index, int lenght){
        if(index == lenght){
            return;
        }else{
            System.out.print(arr[index] + " ");
            printArray(arr,++index,lenght);
        }
    }
    public static int postfix(String str){
        Stack<Integer> stack = new Stack<>();
        return postfixExpression(str,stack);
    }
    /**
     * Evaluating postfix expression with stack
     */
    public static int postfixExpression(String str,Stack<Integer> stack){
        if(str == null || str.isEmpty()) {
            return stack.pop();        }
        else{
            char c = str.charAt(0);
            if(Character.isDigit(c))
                stack.push(c - '0');
            else
            {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if(c == '+')
                    stack.push(num2 + num1);
                if(c == '-')
                    stack.push(num2 - num1);
                if(c == '/')
                    stack.push(num2 / num1);
                if(c == '*')
                    stack.push(num2 * num1);
            }
            return postfixExpression(str.substring(1),stack);
        }
    }
    public static int prefix(String str){
        Stack<Integer> stack = new Stack<>();
        int index = str.length() - 1;
        return prefixExpression(str,stack,index);
    }
    /**
     * Evaluating prefix expression with stack
     */
    public static int prefixExpression(String str,Stack<Integer> stack, int index){
        if(index == -1) {
            return stack.pop();        }
        else{
            char c = str.charAt(index);
            if(Character.isDigit(c))
                stack.push(c - '0');
            else
            {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if(c == '+')
                    stack.push(num1 + num2);
                if(c == '-')
                    stack.push(num1 - num2);
                if(c == '/')
                    stack.push(num1 / num2);
                if(c == '*')
                    stack.push(num1 * num2);
            }
            return prefixExpression(str,stack,--index);
        }
    }
    /**
     * Print double array
     * @param arr double array
     * @param x x coordinate
     * @param y y coordinate
     */
    public static void printDoubleArray(int [][] arr,int x,int y){
        boolean control = true;
        if(x == arr.length)
            return;
        else{
           if(y == arr[x].length){
               ++x;
               y = 0;
               System.out.print("\n");
               control = false;
           }
           if(control){
               System.out.print(arr[x][y] + "  ");
               ++y;
           }
            printDoubleArray(arr,x,y);
        }
    }
    public static void spiral(int [][] arr){
        spiralPrint(arr,0,0,"right",1,0);
    }
    /**
     * @param arr Double array
     * @param x x coordinate
     * @param y y coordinate
     * @param direction right, left, down or up
     * @param shell cycle number
     * @param print number of data print
     */
    public static void spiralPrint(int [][] arr,int x, int y, String direction, int shell, int print){
        switch (direction) {
            case "right":
                if (y <= arr[0].length - shell) {
                    System.out.print(arr[x][y] + " ");
                    spiralPrint(arr, x, ++y, direction, shell, ++print);
                } else {
                    if (print < arr.length * arr[0].length) {
                        --y;
                        direction = "down";
                        spiralPrint(arr, ++x, y, direction, shell, print);
                    }
                    else
                        return;
                }
                break;
            case "down":
                if (x <= arr.length - shell) {
                    System.out.print(arr[x][y] + " ");
                    spiralPrint(arr, ++x, y, direction, shell, ++print);
                } else {
                    if (print < arr.length * arr[0].length) {
                        --x;
                        direction = "left";
                        spiralPrint(arr, x, --y, direction, shell, print);
                    }
                    else
                        return;
                }
                break;
            case "left":
                if (y >= shell - 1) {
                    System.out.print(arr[x][y] + " ");
                    spiralPrint(arr, x, --y, direction, shell, ++print);
                } else {
                    if (print < arr.length * arr[0].length) {
                        ++y;
                        direction = "up";
                        spiralPrint(arr, --x, y, direction, shell, print);
                    }
                    else
                        return;
                }
                break;
            case "up":
                if (x >= shell) {
                    System.out.print(arr[x][y] + " ");
                    spiralPrint(arr, --x, y, direction, shell, ++print);
                } else {
                    if (print < arr.length * arr[0].length) {
                        ++x;
                        direction = "right";
                        ++shell;
                        spiralPrint(arr, x, ++y, direction, shell, print);

                    }
                    else
                        return;
                }
                break;
        }
    }
}