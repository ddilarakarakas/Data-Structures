public class Main {
    public static void main(String [] args){
        MaxHeap heap = new MaxHeap();
        System.out.println("*** ADD ***");
        heap.add(new AgeData(10));
        heap.add(new AgeData(5));
        heap.add(new AgeData(70));
        heap.add(new AgeData(10));
        heap.add(new AgeData(50));
        heap.add(new AgeData(5));
        heap.add(new AgeData(15));
        System.out.println(heap.toString());
        System.out.println("*** REMOVE 10 ***");
        heap.remove(new AgeData(10));
        System.out.println(heap.toString());
        System.out.println("*** REMOVE 70 ***");
        heap.remove(new AgeData(70));
        System.out.println(heap.toString());
        System.out.println("*** FIND 10 ***\n" + heap.find(10).toString());
        System.out.println("***YOUNGER THAN 10 ***\n" + heap.youngerThan(10));
        System.out.println("*** OLDER THAN 15 ***\n" + heap.olderThan(15));
    }
}
