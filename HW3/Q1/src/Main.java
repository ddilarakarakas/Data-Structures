public class Main {
    public static void main(String [] args){
        System.out.println("************INTEGER TESTING******");
        Integer[] array1 =  new Integer[5];
        for(int i=0;i<4;i++)
            array1[i] = i;
        Integer [] array2 = new Integer[5];
        for(int i=0;i<4;i++)
            array2[i] = i+2;
        Integer [] array3 = new Integer[5];
        for(int i=0;i<2;i++)
            array3[i] = 9+i;
        LinkedArrayList<Integer> list = new LinkedArrayList<>();
        System.out.println("\n******ADDING******\n");
        System.out.println("Array1 Push\n");
        list.pushNode(array1,4);
        list.print();
        System.out.println("\n");
        System.out.println("Array2 Push\n");
        list.pushNode(array2,4);
        list.print();
        System.out.println("\n");
        System.out.println("Array3 Push\n");
        list.pushNode(array3,2);
        list.print();
        System.out.println("\nAdding to 4 (Index: 11)\n");
        list.add(4);
        list.print();
        System.out.println("\n");
        System.out.println("Adding to 9 (Index: 1)\n");
        list.add(1,9);
        list.print();
        System.out.println("\n");
        System.out.println("Adding to 6 (Index: 1)\n");
        list.add(1,6);
        list.print();
        System.out.println("\n");
        System.out.println("Adding to 41 (Index: 15)\n");
        list.add(15,41);
        list.print();
        System.out.println("\n");
        System.out.println("Adding to 6 (Index: 14)\n");
        list.add(14,6);
        list.print();
        System.out.println("\n");
        System.out.println("Adding to 34 (Index: 16)\n");
        list.add(16,34);
        list.print();
        System.out.println("\n");

        System.out.println("\n******REMOVING******\n");
        System.out.println("Removing to 6\n");
        list.removeData(6);
        list.print();
        System.out.println("\n");
        System.out.println("Removing to 2\n");
        list.removeData(2);
        list.print();
        System.out.println("\n");
        System.out.println("Removing to 34\n");
        list.removeData(34);
        list.print();
        System.out.println("\n");
        System.out.println("Removing to 2\n");
        list.removeData(2);
        list.print();
        System.out.println("\n");
        System.out.println("Removing to 3\n");
        list.removeData(3);
        list.print();
        System.out.println("\n");

        System.out.println("\n******GETTING******\n");
        list.print();
        System.out.println("Getting of 6. element (Index: 6)");
        System.out.println("Element : " +list.get(6) + "\n");
        System.out.println("Getting of 2. element (Index: 2)");
        System.out.println("Element : " +list.get(2) + "\n");
        System.out.println("Getting of 5. element (Index: 5)");
        System.out.println("Element : " +list.get(5) + "\n");


        System.out.println("************DOUBLE TESTING******");
        Double[] array4 =  new Double[5];
        array4[0] = 3.4;
        array4[1] = 2.3;
        array4[2] = 1.3;
        array4[3] = 6.4;
        Double [] array5 = new Double[5];
        array5[0] = 3.2;
        array5[1] = 6.3;
        array5[2] = 1.4;
        array5[3] = 6.9;
        Double [] array6 = new Double[5];
        array6[0] = 0.4;
        array6[1] = 9.3;
        LinkedArrayList<Double> list1 = new LinkedArrayList<>();

        System.out.println("\n******ADDING******\n");
        System.out.println("Array4 Push\n");
        list1.pushNode(array4,4);
        list1.print();
        System.out.println("\n");
        System.out.println("Array5 Push\n");
        list1.pushNode(array5,4);
        list1.print();
        System.out.println("\n");
        System.out.println("Array6 Push\n");
        list1.pushNode(array6,2);
        list1.print();
        System.out.println("\nAdding to 4.0 (Index: 11)\n");
        list1.add(4.0);
        list1.print();
        System.out.println("\n");
        System.out.println("Adding to 9.0 (Index: 1)\n");
        list1.add(1,9.0);
        list1.print();
        System.out.println("\n");
        System.out.println("Adding to 6.0 (Index: 1)\n");
        list1.add(1,6.0);
        list1.print();
        System.out.println("\n");
        System.out.println("Adding to 41.0 (Index: 15)\n");
        list1.add(15,41.0);
        list1.print();
        System.out.println("\n");
        System.out.println("Adding to 6.0 (Index: 14)\n");
        list1.add(14,6.0);
        list1.print();
        System.out.println("\n");
        System.out.println("Adding to 34.0 (Index: 16)\n");
        list1.add(16,34.0);
        list1.print();
        System.out.println("\n");

        System.out.println("\n******REMOVING******\n");
        System.out.println("Removing to 6.0\n");
        list1.removeData(6.0);
        list1.print();
        System.out.println("\n");

        System.out.println("Removing to 2.0\n");
        list1.removeData(2.0);
        list1.print();
        System.out.println("\n");

        System.out.println("Removing to 34.0\n");
        list1.removeData(34.0);
        list1.print();
        System.out.println("\n");

        System.out.println("Removing to 6.3\n");
        list1.removeData(6.3);
        list1.print();
        System.out.println("\n");

        System.out.println("\n******GETTING******\n");
        list1.print();
        System.out.println("Getting of 6. element (Index: 6)");
        System.out.println("Element : " +list1.get(6) + "\n");
        System.out.println("Getting of 2. element (Index: 2)");
        System.out.println("Element : " +list1.get(2) + "\n");
        System.out.println("Getting of 5. element (Index: 5)");
        System.out.println("Element : " +list1.get(5) + "\n");

        System.out.println("************STRING TESTING******");
        String[] array7 =  new String[5];
        array7[0] = "Home";
        array7[1] = "Car";
        array7[2] = "Cat";
        array7[3] = "Corona";
        String [] array8 = new String[5];
        array8[0] = "Bike";
        array8[1] = "Jake";
        array8[2] = "Susan";
        array8[3] = "Vegas";
        String [] array9 = new String[5];
        array9[0] = "USA";
        array9[1] = "China";
        LinkedArrayList<String> list2 = new LinkedArrayList<>();

        System.out.println("\n******ADDING******\n");
        System.out.println("Array7 Push\n");
        list2.pushNode(array7,4);
        list2.print();
        System.out.println("\n");
        System.out.println("Array8 Push\n");
        list2.pushNode(array8,4);
        list2.print();
        System.out.println("\n");
        System.out.println("Array9 Push\n");
        list2.pushNode(array9,2);
        list2.print();
        System.out.println("\nAdding to Alex (Index: 11)\n");
        list2.add("Alex");
        list2.print();
        System.out.println("\n");
        System.out.println("Adding to Pink (Index: 1)\n");
        list2.add(1,"Pink");
        list2.print();
        System.out.println("\n");
        System.out.println("Adding to Blue (Index: 1)\n");
        list2.add(1,"Blue");
        list2.print();
        System.out.println("\n");
        System.out.println("Adding to Istanbul (Index: 15)\n");
        list2.add(15,"Istanbul");
        list2.print();
        System.out.println("\n");
        System.out.println("Adding to Car (Index: 14)\n");
        list2.add(14,"Car");
        list2.print();
        System.out.println("\n");
        System.out.println("Adding to Black (Index: 16)\n");
        list2.add(16,"Black");
        list2.print();
        System.out.println("\n");

        System.out.println("\n******REMOVING******\n");
        System.out.println("Removing to Blue\n");
        list2.removeData("Blue");
        list2.print();
        System.out.println("\n");

        System.out.println("Removing to Alex\n");
        list2.removeData("Alex");
        list2.print();
        System.out.println("\n");

        System.out.println("Removing to Black\n");
        list2.removeData("Black");
        list2.print();
        System.out.println("\n");

        System.out.println("Removing to Corona(Good Bay)\n");
        list2.removeData("Corona");
        list2.print();
        System.out.println("\n");

        System.out.println("\n******GETTING******\n");
        list2.print();
        System.out.println("Getting of 6. element (Index: 6)");
        System.out.println("Element : " +list2.get(6) + "\n");
        System.out.println("Getting of 2. element (Index: 2)");
        System.out.println("Element : " +list2.get(2) + "\n");
        System.out.println("Getting of 5. element (Index: 5)");
        System.out.println("Element : " +list2.get(5) + "\n");   
    }
}
