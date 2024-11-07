package module9.theory.myjavacollectionframework;


class MyJavaCollectionFrameworkTests {
    public static void main(String[] args) {
        System.out.println("======> MyArrayListTests");


        System.out.println("\n===> new myArrayList(); test:");
        MyList<String> myArrayList = new MyArrayList<>();
        System.out.println("myArrayList = " + myArrayList);
        System.out.println("myArrayList.size() = " + myArrayList.size());

        System.out.println("\n===> Add(); size(); test:");
        myArrayList.add("1");
        System.out.println("myArrayList = " + myArrayList);
        System.out.println("myArrayList.size() = " + myArrayList.size());

        myArrayList.add("2");
        System.out.println("myArrayList = " + myArrayList);
        System.out.println("myArrayList.size() = " + myArrayList.size());

        myArrayList.add("3");
        System.out.println("myArrayList = " + myArrayList);
        System.out.println("myArrayList.size() = " + myArrayList.size());

        myArrayList.add("4");
        System.out.println("myArrayList = " + myArrayList);
        System.out.println("myArrayList.size() = " + myArrayList.size());

        System.out.println("\n===> get(); test:");
        System.out.println("myArrayList.get(0) = " + myArrayList.get(0));
        System.out.println("myArrayList = " + myArrayList);
        System.out.println("myArrayList.get(10) = " + myArrayList.get(10));
        System.out.println("myArrayList = " + myArrayList);

        System.out.println("\n===> remove(); test:");
        System.out.println("myArrayList = " + myArrayList);
        myArrayList.remove(1);
        System.out.println("myArrayList = " + myArrayList);



        System.out.println("\n===> clear(); test:");
        System.out.println("myArrayList = " + myArrayList);
        myArrayList.clear();
        System.out.println("myArrayList = " + myArrayList);
    }

}
