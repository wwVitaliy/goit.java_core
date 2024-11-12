package module9.myjavacollectionframework;

import java.util.Objects;

class MyHashMapTests {
    public static void main(String[] args) {
        System.out.println("=============>   MyHashMap tests");


        System.out.println("\n=======>   new MyHashMap();");
        MyMap<String, Integer> myHashMap = new MyHashMap<>();
        System.out.println("myHashMap = " + myHashMap);


        System.out.println("\n=======>   put(); size();");
        myHashMap.put("first", 1);
        System.out.println("myHashMap = " + myHashMap);
        myHashMap.put("second", 2);
        System.out.println("myHashMap = " + myHashMap);
        myHashMap.put("third", 3);
        System.out.println("myHashMap = " + myHashMap);
        myHashMap.put("fourth", 4);
        System.out.println("myHashMap = " + myHashMap);
        myHashMap.put("fifth", 5);
        System.out.println("myHashMap = " + myHashMap);
        System.out.println("myHashMap.size() = " + myHashMap.size());


        System.out.println("\n=======>   get();");
        System.out.println("myHashMap.get() = " + myHashMap.get("first"));
        System.out.println("myHashMap.size() = " + myHashMap.size());


        System.out.println("\n=======>   remove();");
        System.out.println("myHashMap.size() = " + myHashMap.size());
        System.out.println("myHashMap = " + myHashMap);

        System.out.println("myHashMap.remove() = " + myHashMap.remove("first"));
        System.out.println("myHashMap.size() = " + myHashMap.size());
        System.out.println("myHashMap = " + myHashMap);


        System.out.println("\n=======>   clear();");
        myHashMap.put("first", 1);
        myHashMap.put("second", 2);
        myHashMap.put("third", 3);
        System.out.println("myHashMap = " + myHashMap);
        myHashMap.clear();
        System.out.println("myHashMap = " + myHashMap);


        System.out.println("\n=======>   big amount of data");
        System.out.println("myHashMap.size() = " + myHashMap.size());
        for (int i = 0; i < 1000000; i++) {
            System.out.println("i = " + i);
            myHashMap.put("" + i, i);
        }
        System.out.println("myHashMap.size() = " + myHashMap.size());

    }
}
