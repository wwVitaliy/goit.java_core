package module9.theory.myjavacollectionframework;

interface MyStack<T> extends MyCollection<T> {
    T remove(int index);

    boolean push(T obj);

    T peek();

    T pop();
}
