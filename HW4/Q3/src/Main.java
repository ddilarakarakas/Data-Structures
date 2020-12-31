public class Main {
    public static void main(String [] args){
        String str = "this function writes the sentence in reverse";
        String str1 = "no ***ish";
        String str2 = "yes elfish";
        String str3 = "5712*-1/+6+31/-";
        String str4 = "-++5/-7*1216/31";
        int [] arr = new int[4];
        arr[0] = 4;
        arr[1] = 5;
        arr[2] = 9;
        arr[3] = 1;
        int[][] array2D = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}
        };
        int[][] array2D2 = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[][] array2D3 = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println("Reverse Before");
        System.out.println(str);
        System.out.println("Reverse After");
        Question3.reverseString(str);
        System.out.println("\nElfish Control");
        System.out.println(str2);
        System.out.println(Question3.elfishWord(str2));
        System.out.println(str1);
        System.out.println(Question3.elfishWord(str1));
        System.out.println("Sorted Before");
        Question3.printArray(arr,0,arr.length);
        System.out.println("\nSorted After");
        Question3.sortedSelection(arr);
        Question3.printArray(arr,0,arr.length);
        System.out.println("\nPostfix Control\n" + str3);
        System.out.println(Question3.postfix(str3));
        System.out.println("Prefix Control\n" + str4);
        System.out.println(Question3.prefix(str4));
        System.out.println("Spiral Test");
        Question3.printDoubleArray(array2D,0,0);
        System.out.println("\n");
        Question3.spiral(array2D);
        System.out.println("\n\n");
        Question3.printDoubleArray(array2D2,0,0);
        Question3.spiral(array2D2);
        System.out.println("\n\n");
        Question3.printDoubleArray(array2D3,0,0);
        Question3.spiral(array2D3);
    }
}