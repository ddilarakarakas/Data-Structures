public class HeapSort {
    /**
     * Sort the array using heapsort algorithm.
     * pre: table contains Comparable items.
     * post: table is sorted.
     * @param table The array to be sorted
     */
    public static <T extends Comparable<T>> void sort(T[] table){
        System.out.print("\n");
        buildHeap(table);
        shrinkHeap(table);
    }
    /**
     * buildHeap transforms the table into a heap.
     * pre: The array contains at least one item.
     * post: All items in the array are in heap order.
     * @param table The array to be transformed into a heap
     */
    private static <T extends Comparable<T>> void buildHeap(T[] table){
        int n = 1;
        while (n < table.length){
            n++;
            int child = n - 1;
            int parent = (child - 1) / 2;
            while (parent >= 0 && table[parent].compareTo(table[child]) <0){
                swap(table,parent,child);
                child = parent;
                parent = (child - 1) /  2;
            }
        }
    }
    /**
     * shrinkHeap transforms a heap into a sorted array.
     * pre: All items in the array are in heap order.
     * post: The array is sorted.
     * @param table The array to be sorted
     */
    private static <T extends Comparable<T>> void shrinkHeap(T[] table){
        int n = table.length;
        while (n > 0){
            n--;
            swap(table,0,n);
            int parent = 0;
            while (true){
                int leftChild = 2*parent + 1;
                if(leftChild >= n)
                    break;
                int rightChild = leftChild + 1;
                int maxChild = leftChild;
                if(rightChild<n && table[leftChild].compareTo(table[rightChild]) < 0){
                    maxChild = rightChild;
                }
                if(table[parent].compareTo(table[maxChild]) < 0){
                    swap(table,parent,maxChild);
                    parent = maxChild;
                }
                else
                    break;
            }
        }
    }
    /**
     * Swap the items in table[i] and table[j].
     * @param table The array that contains the items
     * @param i The index of one item
     * @param j The index of the other item
     */
    private static <T extends Comparable<T>> void swap(T[] table,int i,int j){
        T temp = table[i];
        table[i] = table[j];
        table[j] = temp;
    }
}