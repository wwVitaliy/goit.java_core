package module9.theory.myjavacollectionframework;

interface MyList<T> extends MyCollection<T> {
    T get (int index);
    T remove (int index);
}
