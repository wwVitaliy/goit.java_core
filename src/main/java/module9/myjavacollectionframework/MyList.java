package module9.myjavacollectionframework;

interface MyList<T> extends MyCollection<T> {
    T get (int index);
    T remove (int index);
}
