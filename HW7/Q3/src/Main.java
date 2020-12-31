import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class Main {
    public static void main(String [] args){
        Random rand = new Random();
        long startTime = 0;
        long endTime = 0;
        long time = 0;
        /*System.out.println("**** ADD ****");
        System.out.println("Binary Search tree (book) Time: ");
        for(int k=0;k<10;k++){
            BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
            startTime = System.currentTimeMillis();
            for(int i=0;i<80000;i++){
                binarySearchTree.add(rand.nextInt(1000));
            }
            endTime = System.currentTimeMillis();
            time = endTime - startTime;
            System.out.println(time);
        }
        System.out.println("Red Black Tree (book) Time: ");
        for(int k=0;k<10;k++){
            RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
            startTime = System.currentTimeMillis();
            for(int i=0;i<80000;i++){
                redBlackTree.add(rand.nextInt(1000));
            }
            endTime = System.currentTimeMillis();
            time = endTime - startTime;
            System.out.println(time);
        }
        System.out.println("Red Black Tree (java) Time: ");
        for(int k=0;k<10;k++){
            TreeSet<Integer> treeSet = new TreeSet<>();
            startTime = System.currentTimeMillis();
            for(int i=0;i<80000;i++){
                treeSet.add(rand.nextInt(1000));
            }
            endTime = System.currentTimeMillis();
            time = endTime - startTime;
            System.out.println(time);
        }
        System.out.println("B-Tree (book) Time: ");
        for(int k=0;k<10;k++){
            BTree<Integer> bTree = new BTree<>(3);
            startTime = System.currentTimeMillis();
            for(int i=0;i<80000;i++){
                bTree.add(rand.nextInt(1000));
            }
            endTime = System.currentTimeMillis();
            time = endTime - startTime;
            System.out.println(time);
        }
        System.out.println("Skip List (book) Time: ");
        for(int k=0;k<10;k++){
            SkipList<Integer> skipList = new SkipList<>();
            startTime = System.currentTimeMillis();
            for(int i=0;i<80000;i++){
                skipList.add(rand.nextInt(1000));
            }
            endTime = System.currentTimeMillis();
            time = endTime - startTime;
            System.out.println(time);
        }
        System.out.println("Skip List (java) Time: ");
        for(int k=0;k<10;k++){
            ConcurrentSkipListSet<Integer> skipList = new ConcurrentSkipListSet<>();
            startTime = System.currentTimeMillis();
            for(int i=0;i<80000;i++){
                skipList.add(rand.nextInt(1000));
            }
            endTime = System.currentTimeMillis();
            time = endTime - startTime;
            System.out.println(time);
        }
        System.out.println("My Skip List  Time: ");
        for(int k=0;k<10;k++){
            MySkipList<Integer> skipList = new MySkipList<>();
            startTime = System.currentTimeMillis();
            for(int i=0;i<80000;i++){
                skipList.add(rand.nextInt(1000));
            }
            endTime = System.currentTimeMillis();
            time = endTime - startTime;
            System.out.println(time);
        }*/

        System.out.println("*** REMOVE ***");

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        for(int i=0;i<10000;i++){
            binarySearchTree.add(rand.nextInt(1000));
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i=0;i<10000;i++){
            treeSet.add(rand.nextInt(1000));
        }
        SkipList<Integer> skipList = new SkipList<>();
        for(int i=0;i<10000;i++){
            skipList.add(rand.nextInt(1000));
        }
        ConcurrentSkipListSet<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>();
        for(int i=0;i<10000;i++){
            concurrentSkipListSet.add(rand.nextInt(1000));
        }
        MySkipList<Integer> mySkipList = new MySkipList<>();
        for(int i=0;i<10000;i++){
            mySkipList.add(rand.nextInt(1000));
        }
        System.out.println("Binary Search tree (book) Time: ");
        for(int k=0;k<10;k++){
            startTime = System.nanoTime();
            binarySearchTree.remove(rand.nextInt(1000));
            endTime = System.nanoTime();
            time = endTime - startTime;
            System.out.println(time);
        }
        System.out.println("Red Black Tree (java) Time: ");
        for(int k=0;k<10;k++){
            startTime = System.nanoTime();
            treeSet.remove(rand.nextInt(1000));
            endTime = System.nanoTime();
            time = endTime - startTime;
            System.out.println(time);
        }
        System.out.println("Skip List (book) Time: ");
        for(int k=0;k<10;k++){
            startTime = System.nanoTime();
            skipList.remove(rand.nextInt(1000));
            endTime = System.nanoTime();
            time = endTime - startTime;
            System.out.println(time);
        }
        System.out.println("Skip List (java) Time: ");
        for(int k=0;k<10;k++){
            startTime = System.nanoTime();
            concurrentSkipListSet.remove(rand.nextInt(1000));
            endTime = System.nanoTime();
            time = endTime - startTime;
            System.out.println(time);
        }
        System.out.println("My Skip List Time: ");
        for(int k=0;k<10;k++){
            startTime = System.nanoTime();
            mySkipList.remove(rand.nextInt(1000));
            endTime = System.nanoTime();
            time = endTime - startTime;
            System.out.println(time);
        }
    }
}
