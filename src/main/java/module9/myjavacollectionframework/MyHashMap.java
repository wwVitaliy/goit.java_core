package module9.myjavacollectionframework;

import java.util.*;

/**
 * Завдання 5 - HashMap
 * Написати свій клас MyHashMap як аналог класу HashMap.
 * <p>
 * Потрібно робити за допомогою однозв'язної Node.
 * <p>
 * Не може зберігати дві ноди з однаковими ключами.
 * <p>
 * Методи
 * <p>
 * put(Object key, Object value) додає пару ключ + значення
 * remove(Object key) видаляє пару за ключем
 * clear() очищає колекцію
 * size() повертає розмір колекції
 * get(Object key) повертає значення (Object value) за ключем
 */
class MyHashMap<K, V> implements MyMap<K, V> {

    private static final int INIT_BUCKET_QTY = 2;
    private int bucketQty;
    private int size;
    MyBucketLinkedList<K, V>[] buckets;

    public MyHashMap() {
        bucketQty = INIT_BUCKET_QTY;
        this.buckets = createBucketsArray(bucketQty);
        this.size = 0;
    }

    private MyBucketLinkedList<K, V>[] createBucketsArray(int size) {
        MyBucketLinkedList<K, V>[] buckets = new MyBucketLinkedList[size];
        createLists(buckets);
        return buckets;
    }

    private void createLists(MyBucketLinkedList<K, V>[] buckets) {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new MyBucketLinkedList<>();
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        this.bucketQty = INIT_BUCKET_QTY;
        this.buckets = createBucketsArray(this.bucketQty);
        this.size = 0;
    }

    @Override
    public V put(K key, V value) {
        int bucketNumber = getBucketNumber(key);
        if (this.buckets[bucketNumber].size() >= this.bucketQty) {
            redistributeElements();
            return this.put(key, value);
        }
        V result = this.buckets[bucketNumber].add(key, value);
        if (result == null) {
            size++;
        }
        return result;
    }

    private void redistributeElements() {
        MyBucketLinkedList<K, V>[] oldBuckets = this.buckets;

        this.bucketQty *= 2;
        this.buckets = createBucketsArray(this.bucketQty);
        this.size = 0;

        for (int i = 0; i < oldBuckets.length; i++) {
            while (oldBuckets[i].size() != 0) {
                K keyToDistribute = oldBuckets[i].getFirstKey();
                this.put(keyToDistribute, oldBuckets[i].remove(keyToDistribute));
            }
        }
    }

    private int getBucketNumber(K key) {
        return Math.abs(Objects.hash(key) % this.bucketQty);
    }

    @Override
    public V remove(K key) {
        int bucketNumber = getBucketNumber(key);
        int bucketSizeBeforeAdding = this.buckets[bucketNumber].size();
        V result = this.buckets[bucketNumber].remove(key);
        if (this.buckets[bucketNumber].size() < bucketSizeBeforeAdding) size--;
        return result;
    }

    @Override
    public V get(K key) {
        int bucketNumber = getBucketNumber(key);
        return this.buckets[bucketNumber].get(key);
    }

    @Override
    public String toString() {
        return "MyHashMap{"
                + Arrays.toString(buckets)
                + '}';
    }
}
