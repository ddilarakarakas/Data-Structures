import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main{
     public static void main (String [] args) throws IOException {
         System.out.println("************************** FILE1 TEST ************************");
         System.out.println("************* STRArrayList Test Without Iterator *************");
         STEArrayList list = new STEArrayList();
         System.out.println("*****Read test*****");
         list.readFile("test.txt");
         list.print();
         System.out.println("*****Push test*****");
         System.out.println("Push 'hello '");
         list.push(6,"hello ");
         list.print();
         System.out.println("*****Search test*****");
         System.out.println("Search 'test'");
         System.out.println(list.search("Test"));
         System.out.println("*****Replace test*****");
         System.out.println("Replace 't' and 'e'");
         list.replace('t','e');
         list.print();

         System.out.println("************* STRArrayList Test With Iterator *************");
         STEArrayListWithIterator list1 = new STEArrayListWithIterator();
         System.out.println("*****Read test*****");
         list1.readFile("test.txt");
         list1.print();
         System.out.println("*****Push test*****");
         list1.push(6,"hello ");
         list1.print();
         System.out.println("*****Search test*****");
         System.out.println(list1.search("Test"));
         list1.replace('t','e');
         list1.print();

         System.out.println("************* STRLinkList Test Without Iterator *************");
         STELinkedList list2 = new STELinkedList();
         System.out.println("*****Read test*****");
         list2.readFile("test.txt");
         list2.print();
         System.out.println("*****Push test*****");
         list2.push(6,"hello ");
         list2.print();
         System.out.println("*****Search test*****");
         System.out.println(list2.search("Test"));
         System.out.println("*****Replace test*****");
         list2.replace('t','e');
         list2.print();

         System.out.println("************* STRLinkList Test With Iterator *************");
         STELinkedListWithIterator list3 = new STELinkedListWithIterator();
         System.out.println("*****Read test*****");
         list3.readFile("test.txt");
         list3.print();
         System.out.println("*****Push test*****");
         list3.push(6,"hello ");
         list3.print();
         System.out.println("*****Search test*****");
         System.out.println(list3.search("Test"));
         System.out.println("*****Replace test*****");
         list3.replace('t','e');
         list3.print();

         System.out.println("************************** FILE2 TEST ************************");
         System.out.println("************* STRArrayList Test Without Iterator *************");
         STEArrayList list4 = new STEArrayList();
         System.out.println("*****Read test*****");
         list4.readFile("test2.txt");
         list4.print();
         System.out.println("*****Push test*****");
         System.out.println("Push 'hello '");
         list4.push(6,"hello ");
         list4.print();
         System.out.println("*****Search test*****");
         System.out.println("Search 'test'");
         System.out.println(list4.search("Test"));
         System.out.println("*****Replace test*****");
         System.out.println("Replace 't' and 'e'");
         list4.replace('t','e');
         list4.print();

         System.out.println("************* STRArrayList Test With Iterator *************");
         STEArrayListWithIterator list5 = new STEArrayListWithIterator();
         System.out.println("*****Read test*****");
         list5.readFile("test2.txt");
         list5.print();
         System.out.println("*****Push test*****");
         list5.push(6,"hello ");
         list5.print();
         System.out.println("*****Search test*****");
         System.out.println(list5.search("Test"));
         list5.replace('t','e');
         list5.print();

         System.out.println("************* STRLinkList Test Without Iterator *************");
         STELinkedList list6 = new STELinkedList();
         System.out.println("*****Read test*****");
         list6.readFile("test2.txt");
         list6.print();
         System.out.println("*****Push test*****");
         list6.push(6,"hello ");
         list6.print();
         System.out.println("*****Search test*****");
         System.out.println(list6.search("Test"));
         System.out.println("*****Replace test*****");
         list6.replace('t','e');
         list6.print();

         System.out.println("************* STRLinkList Test With Iterator *************");
         STELinkedListWithIterator list7 = new STELinkedListWithIterator();
         System.out.println("*****Read test*****");
         list7.readFile("test2.txt");
         list7.print();
         System.out.println("*****Push test*****");
         list7.push(6,"hello ");
         list7.print();
         System.out.println("*****Search test*****");
         System.out.println(list7.search("Test"));
         System.out.println("*****Replace test*****");
         list7.replace('t','e');
         list7.print();

         System.out.println("************************** TIME TEST FOR FILE 1************************");
         System.out.println("************* STRArrayList Test Without Iterator *************");
         STEArrayList list8 = new STEArrayList();
         long startTime1 = System.nanoTime();
         list8.readFile("test.txt");
         list8.push(6,"hello ");
         list8.search("Test");
         list8.replace('t','e');
         long endTime1 = System.nanoTime();
         long arrTime1 = endTime1 - startTime1;
         System.out.println(arrTime1);

         System.out.println("************* STRArrayList Test With Iterator *************");
         STEArrayListWithIterator list9 = new STEArrayListWithIterator();
         long startTime2 = System.nanoTime();
         list9.readFile("test.txt");
         list9.push(6,"hello ");
         list9.search("Test");
         list9.replace('t','e');
         long endTime2 = System.nanoTime();
         long arrTime2 = endTime2 - startTime2;
         System.out.println(arrTime2);

         System.out.println("************* STRLinkList Test Without Iterator *************");
         STELinkedList list10 = new STELinkedList();
         long startTime3 = System.nanoTime();
         list10.readFile("test.txt");
         list10.push(6,"hello ");
         list10.search("Test");
         list10.replace('t','e');
         long endTime3 = System.nanoTime();
         long arrTime3 = endTime3 - startTime3;
         System.out.println(arrTime3);

         System.out.println("************* STRLinkList Test With Iterator *************");
         STELinkedListWithIterator list11 = new STELinkedListWithIterator();
         long startTime4 = System.nanoTime();
         list11.readFile("test.txt");
         list11.push(6,"hello ");
         list11.search("Test");
         list11.replace('t','e');
         long endTime4 = System.nanoTime();
         long arrTime4 = endTime4 - startTime4;
         System.out.println(arrTime4);

         System.out.println("************************** TIME TEST FOR FILE 2************************");
         System.out.println("************* STRArrayList Test Without Iterator *************");
         STEArrayList list12 = new STEArrayList();
         long startTime5 = System.nanoTime();
         list12.readFile("test.txt");
         list12.push(6,"hello ");
         list12.search("Test");
         list12.replace('t','e');
         long endTime5 = System.nanoTime();
         long arrTime5 = endTime5 - startTime5;
         System.out.println(arrTime5);

         System.out.println("************* STRArrayList Test With Iterator *************");
         STEArrayListWithIterator list13 = new STEArrayListWithIterator();
         long startTime6 = System.nanoTime();
         list13.readFile("test.txt");
         list13.push(6,"hello ");
         list13.search("Test");
         list13.replace('t','e');
         long endTime6 = System.nanoTime();
         long arrTime6 = endTime6 - startTime6;
         System.out.println(arrTime6);

         System.out.println("************* STRLinkList Test Without Iterator *************");
         STELinkedList list14 = new STELinkedList();
         long startTime7 = System.nanoTime();
         list14.readFile("test.txt");
         list14.push(6,"hello ");
         list14.search("Test");
         list14.replace('t','e');
         long endTime7 = System.nanoTime();
         long arrTime7 = endTime7 - startTime7;
         System.out.println(arrTime7);

         System.out.println("************* STRLinkList Test With Iterator *************");
         STELinkedListWithIterator list15 = new STELinkedListWithIterator();
         long startTime8 = System.nanoTime();
         list15.readFile("test.txt");
         list15.push(6,"hello ");
         list15.search("Test");
         list15.replace('t','e');
         long endTime8 = System.nanoTime();
         long arrTime8 = endTime8 - startTime8;
         System.out.println(arrTime8);
         /**
          * Create Log File for Time
          */
         Logger logger = Logger.getLogger("MyLog");
         FileHandler fh;
         try {
             fh = new FileHandler("MyLogFile.log");
             logger.addHandler(fh);
             SimpleFormatter formatter = new SimpleFormatter();
             fh.setFormatter(formatter);
             logger.info("FILE1 TEST");
             logger.info("STRArrayList Test Without Iterator");
             logger.info(String.valueOf(arrTime1));
             logger.info("STRArrayList Test With Iterator");
             logger.info(String.valueOf(arrTime2));
             logger.info("STRLinkList Test Without Iterator");
             logger.info(String.valueOf(arrTime3));
             logger.info("STRLinkList Test With Iterator");
             logger.info(String.valueOf(arrTime4));
             logger.info("FILE2 TEST");
             logger.info("STRArrayList Test Without Iterator");
             logger.info(String.valueOf(arrTime5));
             logger.info("STRArrayList Test With Iterator");
             logger.info(String.valueOf(arrTime6));
             logger.info("STRLinkList Test Without Iterator");
             logger.info(String.valueOf(arrTime7));
             logger.info("STRLinkList Test With Iterator");
             logger.info(String.valueOf(arrTime8));
         }
         catch (SecurityException | IOException e){
             e.printStackTrace();
         }
    }
}