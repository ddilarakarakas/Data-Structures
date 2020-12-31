public class InsertionSort {
    /**
     * Sort the table using insertion sort algorithm.
     * pre: table contains Comparable objects.
     * post: table is sorted.
     * @param table The array to be sorted.
     */
    public static <T extends Comparable<T>> void sort(T [] table){
        for(int nextPos=1;nextPos<table.length;nextPos++){
            insert(table,nextPos);
        }
    }
    /**
     * Insert the element aat nextPos where it belongs in the arrays
     * pre: table[0 . . . nextPos - 1] is sorted.
     * post: table[0 . . . nextPos] is sorted.
     * @param table The array being sorted
     * @param nextPos The position of the element to insert
     */
    private static <T extends Comparable<T>> void insert(T [] table,int nextPos){
        T nextVal = table[nextPos];
        while(nextPos > 0 && nextVal.compareTo(table[nextPos-1]) <0){
            table[nextPos] = table[nextPos-1];
            nextPos--;
        }
        table[nextPos] = nextVal;
    }
}