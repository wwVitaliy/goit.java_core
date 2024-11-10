package module9.theory.myjavacollectionframework;

interface MyQueue<T> extends MyCollection<T> {
    T peek();
    T poll();
}
