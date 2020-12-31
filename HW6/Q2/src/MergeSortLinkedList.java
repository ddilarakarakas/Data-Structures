import java.util.LinkedList;

public class MergeSortLinkedList {
    /**
     * Sort the LinkedList using the merge sort algorithm.
     * pre: table contains Comparable objects.
     * post: table is sorted.
     * @param table The LinkedList to be sorted
     */
    public static <T extends Comparable<T>> void sort(LinkedList<T> table){
        if(table.size() > 1){
            int halfSize = table.size() / 2;
            LinkedList<T> leftTable =  new LinkedList<>();
            LinkedList<T> rightTable = new LinkedList<>();
            linkedListCopy(table,0,leftTable,halfSize);
            linkedListCopy(table,halfSize,rightTable,table.size()-halfSize);
            sort(leftTable);
            sort(rightTable);
            merge(table,leftTable,rightTable);
        }
    }
    /**
     * Converting arrayCopy function to linked list version.
     * @param source_list The LinkedList to be copied from
     * @param sourcePos Starting position in source LinkedList from where to copy
     * @param dest_list The LinkedList to be copied in
     * @param len Total no. of components to be copied.
     */
    private static <T extends Comparable<T>> void linkedListCopy(LinkedList<T> source_list, int sourcePos,LinkedList<T> dest_list, int len){
        while (len != 0){
            dest_list.add(source_list.get(sourcePos));
            sourcePos++;
            len--;
        }
    }
    /**
     * Merge two sequences.
     * pre: leftSequence and rightSequence are sorted.
     * post: outputSequence is the merge result and is sorted.
     * @param outputSequence The destination
     * @param leftSequence The left input
     * @param rightSequence The right input
     */
    private static <T extends Comparable<T>> void merge(LinkedList<T> outputSequence,LinkedList<T> leftSequence,LinkedList<T> rightSequence){
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < leftSequence.size() && j < rightSequence.size()){
            if(leftSequence.get(i).compareTo(rightSequence.get(j)) < 0)
                outputSequence.set(k++,leftSequence.get(i++));
            else
                outputSequence.set(k++,rightSequence.get(j++));
        }
        while (i < leftSequence.size())
            outputSequence.set(k++,leftSequence.get(i++));
        while (j < rightSequence.size())
            outputSequence.set(k++,rightSequence.get(j++));
    }
}
