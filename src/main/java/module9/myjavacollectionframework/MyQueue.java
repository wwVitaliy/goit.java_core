package module9.myjavacollectionframework;

interface MyQueue<T> extends MyCollection<T> {
    T peek();
    T poll();
}
