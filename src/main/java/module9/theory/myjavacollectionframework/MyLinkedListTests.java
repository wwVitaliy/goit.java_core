package module9.theory.myjavacollectionframework;

class MyLinkedListTests {
    public static void main(String[] args) {
        System.out.println("======> MyLinkedListTests");
        System.out.println("\n===> new myLinkedList(); test:");

        System.out.println("\n===> Add(); size(); test:");
        MyList<String> myLinkedList = new MyLinkedList<>();
        System.out.println("myLinkedList = " + myLinkedList);
        System.out.println("myLinkedList.size() = " + myLinkedList.size());

        myLinkedList.add("1");
        System.out.println("myLinkedList = " + myLinkedList);
        System.out.println("myLinkedList.size() = " + myLinkedList.size());
        myLinkedList.add("2");
        System.out.println("myLinkedList = " + myLinkedList);
        System.out.println("myLinkedList.size() = " + myLinkedList.size());

        myLinkedList.add("3");
        System.out.println("myLinkedList = " + myLinkedList);
        System.out.println("myLinkedList.size() = " + myLinkedList.size());


        System.out.println("\n===> get(); test:");
        System.out.println("myLinkedList.get(0) = " + myLinkedList.get(0));
        System.out.println("myLinkedList.get(1) = " + myLinkedList.get(1));
        System.out.println("myLinkedList.get(2) = " + myLinkedList.get(2));
        System.out.println("myLinkedList.get(3) = " + myLinkedList.get(3));

        System.out.println("\n===> remove(); test:");
        myLinkedList.add("a");
        myLinkedList.add("b");
        myLinkedList.add("c");
        myLinkedList.add("d");
        System.out.println("myLinkedList = " + myLinkedList);

        System.out.println("myLinkedList.remove(3) = " + myLinkedList.remove(3));
        System.out.println("myLinkedList = " + myLinkedList);
        System.out.println("myLinkedList.remove(1) = " + myLinkedList.remove(1));
        System.out.println("myLinkedList = " + myLinkedList);
        System.out.println("myLinkedList.remove(0) = " + myLinkedList.remove(0));
        System.out.println("myLinkedList = " + myLinkedList);
        System.out.println("myLinkedList.remove(0) = " + myLinkedList.remove(0));
        System.out.println("myLinkedList = " + myLinkedList);

        System.out.println("myLinkedList.remove(myLinkedList.size()) = " + myLinkedList.remove(myLinkedList.size()));
        System.out.println("myLinkedList.remove(myLinkedList.size() - 1) = " + myLinkedList.remove(myLinkedList.size() - 1));
        System.out.println("myLinkedList = " + myLinkedList);

        System.out.println("\n===> clear(); test:");
        System.out.println("myLinkedList = " + myLinkedList);
        myLinkedList.clear();
        System.out.println("myLinkedList = " + myLinkedList);

        System.out.println("\n===> big size test:");
        for (int i = 0; i < 1000000; i++) {
            myLinkedList.add("" + i);
        }
        System.out.println("myLinkedList.size() = " + myLinkedList.size());
        System.out.println("myLinkedList.get(0) = " + myLinkedList.get(0));
        System.out.println("myLinkedList.get(10000) = " + myLinkedList.get(10000));
        System.out.println("myLinkedList.get(1000000 - 1) = " + myLinkedList.get(1000000 - 1));


    }
}
