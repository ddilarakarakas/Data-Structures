public class Main {
    public static void main(String [] args){
        MyHashTableOpen<Integer,Integer> table = new MyHashTableOpen<>();
        HashTableOpen<Integer,Integer> table1 = new HashTableOpen<>();
        MyHashTableChain<Integer,Integer> tableChain = new MyHashTableChain<>();
        HashTableChain<Integer,Integer> tableChain1 = new HashTableChain<>();
        for(int i=0;i<100000;i++){
            table.put(i,i++);
            table1.put(i+2,i+3);
            tableChain.put(i+3,i+4);
            tableChain1.put(i++,i+6);
        }
        long startTime = 0;
        long endTime = 0;
        long time = 0;
        System.out.println("ADD");
        for(int i=0;i<5;i++) {
            System.out.println(++i + ". TEST");
            startTime = System.nanoTime();
            table.put(245323+i, 5);
            endTime = System.nanoTime();
            time = endTime - startTime;
            System.out.println(time);
            startTime = System.nanoTime();
            table1.put(245343+i, 5);
            endTime = System.nanoTime();
            time = endTime - startTime;
            System.out.println(time);
            startTime = System.nanoTime();
            tableChain.put(2523+i, 5);
            endTime = System.nanoTime();
            time = endTime - startTime;
            System.out.println(+time);
            startTime = System.nanoTime();
            tableChain1.put(243432423+i, 5);
            endTime = System.nanoTime();
            time = endTime - startTime;
            System.out.println(time);
            i--;
        }
        System.out.println("REMOVE");
        for(int i=0;i<5;i++) {
            System.out.println(++i + ". TEST");
            startTime = System.nanoTime();
            table.remove(3+i*5);
            endTime = System.nanoTime();
            time = endTime - startTime;
            System.out.println(time);
            startTime = System.nanoTime();
            table1.remove(3+i*5);
            endTime = System.nanoTime();
            time = endTime - startTime;
            System.out.println(time);
            startTime = System.nanoTime();
            tableChain.remove(3+i*5);
            endTime = System.nanoTime();
            time = endTime - startTime;
            System.out.println(+time);
            startTime = System.nanoTime();
            tableChain1.remove(3+i*5);
            endTime = System.nanoTime();
            time = endTime - startTime;
            System.out.println(time);
            i--;
        }
        System.out.println("GET");
        for(int i=0;i<5;i++) {
            System.out.println(++i + ". TEST");
            startTime = System.nanoTime();
            table.get(2+i*2);
            endTime = System.nanoTime();
            time = endTime - startTime;
            System.out.println(time);
            startTime = System.nanoTime();
            table1.get(2+i*2);
            endTime = System.nanoTime();
            time = endTime - startTime;
            System.out.println(time);
            startTime = System.nanoTime();
            tableChain.get(2+i*2);
            endTime = System.nanoTime();
            time = endTime - startTime;
            System.out.println(+time);
            startTime = System.nanoTime();
            tableChain1.get(2+i*2);
            endTime = System.nanoTime();
            time = endTime - startTime;
            System.out.println(time);
            i--;
        }
        /*table.put(1,1);
        table.put(2,2);
        table.print();
        System.out.println("\n");
        table.put(2,5);
        table.print();
        System.out.println("\n");
        table.put(6,2);
        table.print();
        System.out.println("\n");
        table.put(4,2);
        table.print();
        System.out.println("\n");
        table.put(5,2);
        table.print();
        System.out.println("\n");
        table.put(12,2);
        table.print();
        System.out.println("\n");
        table.put(22,2);
        table.print();
        System.out.println("\n");
        table.put(20,2);
        table.print();
        System.out.println("\n");
        table.put(21,2);
        table.print();
        System.out.println("\n");
        table.put(36,2);
        table.print();
        table.remove(21);
        table.print();
        System.out.println("\n");*/

        /*MyHashTableChain<Integer,Integer> hash = new MyHashTableChain<>();
        hash.put(2,3);
        hash.print();
        hash.put(8,6);
        hash.print();
        hash.put(11,6);
        hash.print();
        hash.put(5,6);
        hash.print();
        hash.put(453,3);
        hash.print();
        hash.remove(8);
        hash.print();*/

    }
}
