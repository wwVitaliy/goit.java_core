package module9.theory.myjavacollectionframework;

class MyLinkedQueueTests {
    public static void main(String[] args) {
        System.out.println("=============>   MyLinkedQueue tests");

        System.out.println("\n=======>   new MyLinkedQueue();");
        MyQueue<String> myLinkedQueue = new MyLinkedQueue<>();
        System.out.println("myLinkedQueue = " + myLinkedQueue);

        System.out.println("\n=======>   add(); size();");
        myLinkedQueue.add("first");
        myLinkedQueue.add("second");
        myLinkedQueue.add("third");
        System.out.println("myLinkedQueue = " + myLinkedQueue);
        System.out.println("myLinkedQueue.size() = " + myLinkedQueue.size());

        System.out.println("\n=======>   peek();");
        System.out.println("myLinkedQueue.peek() = " + myLinkedQueue.peek());
        System.out.println("myLinkedQueue.size() = " + myLinkedQueue.size());

        System.out.println("\n=======>   poll();");
        System.out.println("myLinkedQueue.size() = " + myLinkedQueue.size());
        System.out.println("myLinkedQueue.poll() = " + myLinkedQueue.poll());
        System.out.println("myLinkedQueue.size() = " + myLinkedQueue.size());
        System.out.println("myLinkedQueue.poll() = " + myLinkedQueue.poll());
        System.out.println("myLinkedQueue.size() = " + myLinkedQueue.size());
        System.out.println("myLinkedQueue.poll() = " + myLinkedQueue.poll());
        System.out.println("myLinkedQueue.size() = " + myLinkedQueue.size());


        System.out.println("\n=======>   clear();");
        myLinkedQueue.add("1");
        myLinkedQueue.add("2");
        myLinkedQueue.add("3");
        System.out.println("myLinkedQueue = " + myLinkedQueue);
        myLinkedQueue.clear();
        System.out.println("myLinkedQueue = " + myLinkedQueue);

        System.out.println("\n=======>   big amount of data");
        System.out.println("myLinkedQueue.size() = " + myLinkedQueue.size());
        for (int i = 0; i < 1000000; i++) {
            myLinkedQueue.add("" + i);
        }
        System.out.println("myLinkedQueue.size() = " + myLinkedQueue.size());
        while (myLinkedQueue.peek() != null){
            myLinkedQueue.poll();
        }
        System.out.println("myLinkedQueue.size() = " + myLinkedQueue.size());

    }
}
