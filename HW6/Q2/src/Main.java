import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
      Integer[] temp = new Integer[100000];
        long startTime = 0;
        long endTime = 0;
        long time = 0;
        /*for(int j = 0 ; j < 10000 ; j++) {
            temp[j] = rand.nextInt(1000);
        }*/
		/*for(int i = 0 ; i < 100000 ; i++) {
		    temp[i] = i;
		}*/

		/*startTime = System.currentTimeMillis();
		SelectionSort.sort(temp);
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println(time);*/

		/*startTime = System.currentTimeMillis();
		BubbleSort.sort(temp);
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println(time);*/


		/*startTime = System.currentTimeMillis();
		InsertionSort.sort(temp);
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println(time);*/

		/*startTime = System.currentTimeMillis();
		ShellSort.sort(temp);
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println(time);*/

        /*for(int i=0;i<20;i++){
            for(int j = 0 ; j < 180000 ; j++) {
                temp[j] = rand.nextInt(1000);
            }
            startTime = System.currentTimeMillis();
            MergeSort.sort(temp);
            endTime = System.currentTimeMillis();
            time = endTime - startTime;
            System.out.println(time);
        }*/

        /*for(int i=0;i<20;i++){
            for(int j = 0 ; j < 180000 ; j++) {
                temp[j] = rand.nextInt(1000);
            }
            startTime = System.currentTimeMillis();
            HeapSort.sort(temp);
            endTime = System.currentTimeMillis();
            time = endTime - startTime;
            System.out.print(time);
        }*/

        /*for(int i=0;i<20;i++){
            for(int j = 0 ; j < 180000 ; j++) {
                temp[j] = rand.nextInt(1000);
            }
            startTime = System.currentTimeMillis();
            QuickSort.sort(temp);
            endTime = System.currentTimeMillis();
            time = endTime - startTime;
            System.out.println(time);
           }*/


		LinkedList<Integer> temp1 = new LinkedList<Integer>();
		/*for(int j = 0 ; j < 10000 ; j++) {
			temp1.add(rand.nextInt());
		}

		for(int j = 0 ; j < 40000 ; j++) {
			temp1.add(j);
		}*/

        /*for(int i=0;i<20;i++){
            LinkedList<Integer> temp1 = new LinkedList<Integer>();
            for(int j = 0 ; j < 180000 ; j++) {
			    temp1.add(rand.nextInt());
		    }
            startTime = System.currentTimeMillis();
            MergeSortLinkedList.sort(temp1);
            endTime = System.currentTimeMillis();
            time = endTime - startTime;
            System.out.println(time);
        }*/
		/*startTime = System.currentTimeMillis();
		MergeSortLinkedList.sort(temp1);
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println(time);*/

        /*for(int i=0;i<20;i++){
            LinkedList<Integer> temp1 = new LinkedList<Integer>();
		    for(int j = 0 ; j < 180000 ; j++) {
			    temp1.add(rand.nextInt());
		    }
            startTime = System.currentTimeMillis();
            QuickSortLinkedList.sort(temp1);
            endTime = System.currentTimeMillis();
            time = endTime - startTime;
            System.out.println(time);
        }*/
        /*startTime = System.currentTimeMillis();
        QuickSortLinkedList.sort(temp1);
        endTime = System.currentTimeMillis();
        time = endTime - startTime;
        System.out.println(time);*/
    }

}