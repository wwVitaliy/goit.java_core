package module9.myjavacollectionframework;

class MyArrayStackTests {
    public static void main(String[] args) {
        System.out.println("=============>   MyArrayStack tests");

        System.out.println("\n=======>   new MyArrayStack();");
        MyStack<String> myArrayStack = new MyArrayStack<>();
        System.out.println("myArrayStack = " + myArrayStack);

        System.out.println("\n=======>   push(); size();");
        myArrayStack.push("first");
        myArrayStack.push("second");
        myArrayStack.push("third");
        System.out.println("myArrayStack = " + myArrayStack);
        System.out.println("myArrayStack.size() = " + myArrayStack.size());

        System.out.println("\n=======>   peek();");
        System.out.println("myArrayStack.peek() = " + myArrayStack.peek());
        System.out.println("myArrayStack.size() = " + myArrayStack.size());

        System.out.println("\n=======>   pop();");
        System.out.println("myArrayStack.size() = " + myArrayStack.size());
        System.out.println("myArrayStack = " + myArrayStack);
        System.out.println("myArrayStack.pop() = " + myArrayStack.pop());
        System.out.println("myArrayStack.size() = " + myArrayStack.size());
        System.out.println("myArrayStack = " + myArrayStack);
        System.out.println("myArrayStack.pop() = " + myArrayStack.pop());
        System.out.println("myArrayStack.size() = " + myArrayStack.size());
        System.out.println("myArrayStack = " + myArrayStack);
        System.out.println("myArrayStack.pop() = " + myArrayStack.pop());
        System.out.println("myArrayStack.size() = " + myArrayStack.size());
        System.out.println("myArrayStack = " + myArrayStack);

        System.out.println("\n=======>   remove();");
        System.out.println("myArrayStack = " + myArrayStack);
        System.out.println("myArrayStack.size() = " + myArrayStack.size());
        System.out.println("myArrayStack.remove(0) = " + myArrayStack.remove(0));
        System.out.println("myArrayStack = " + myArrayStack);
        System.out.println("myArrayStack.size() = " + myArrayStack.size());

        System.out.println("\n=======>   clear();");
        myArrayStack.push("1");
        myArrayStack.push("2");
        myArrayStack.push("3");
        System.out.println("myArrayStack = " + myArrayStack);
        myArrayStack.clear();
        System.out.println("myArrayStack = " + myArrayStack);

        System.out.println("\n=======>   big amount of data");
        System.out.println("myArrayStack.size() = " + myArrayStack.size());
        for (int i = 0; i < 1000000; i++) {
            myArrayStack.push("" + i);
        }
        System.out.println("myArrayStack.size() = " + myArrayStack.size());
        while (myArrayStack.peek() != null){
            myArrayStack.pop();
        }
        System.out.println("myArrayStack.size() = " + myArrayStack.size());
    }
}
