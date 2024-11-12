package module9.myjavacollectionframework;

interface MyMap<K,V> {
    int size();
    void clear();
    V put (K key, V value);
    V remove(K key);
    V get (K key);
}
