public class Main {
    public static void main(String[] args){
        SkipList<Integer> list = new SkipList<>();
        System.out.println("** ADD 1 **");
        list.add(1);
        System.out.println(list.toString());
        System.out.println("** ADD 4 **");
        list.add(4);
        System.out.println(list.toString());
        System.out.println("** ADD 2 **");
        list.add(2);
        System.out.println(list.toString());
        System.out.println("** ADD 20 **");
        list.add(20);
        System.out.println(list.toString());
        System.out.println("** ADD 24 **");
        list.add(24);
        System.out.println(list.toString());
        System.out.println("** ADD 26 **");
        list.add(26);
        System.out.println(list.toString());
        System.out.println("** ADD 25 **");
        list.add(25);
        System.out.println(list.toString());
        System.out.println("** ADD 28 **");
        list.add(28);
        System.out.println(list.toString());
        System.out.println("** ADD 27 **");
        list.add(27);
        System.out.println(list.toString());
        System.out.println("** ADD 273 **");
        list.add(273);
        System.out.println(list.toString());
        System.out.println("** FIND 20 **");
        System.out.println(list.find(20));
        System.out.println("** FIND 200 **");
        System.out.println(list.find(205));
        System.out.println("** REMOVE 273 **");
        list.remove(273);
        System.out.println(list.toString());
        System.out.println("** REMOVE 27 **");
        list.remove(27);
        System.out.println(list.toString());
        System.out.println("** REMOVE 28 **");
        list.remove(28);
        System.out.println(list.toString());

    }
}
