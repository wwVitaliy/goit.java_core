package module9.myjavacollectionframework;

import java.util.Arrays;
import java.util.Objects;

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

    private static final int INIT_BUCKET_QTY = 3;
    private int bucketQty;
    private int size;
    MyBucketLinkedList<K, V>[] buckets;

    public MyHashMap() {
        bucketQty = INIT_BUCKET_QTY;
        this.buckets = new MyBucketLinkedList[bucketQty];
        createBuckets(this.buckets);
        this.size = 0;
    }

    private void createBuckets(MyBucketLinkedList<K, V>[] buckets) {
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
        this.buckets = new MyBucketLinkedList[this.bucketQty];
        createBuckets(this.buckets);
        this.size = 0;
    }

    @Override
    public V put(K key, V value) {
        int bucketNumber = getBucketNumber(key);
        int bucketSizeBeforeAdding = this.buckets[bucketNumber].size();
        V result = this.buckets[bucketNumber].add(key, value);
        if (this.buckets[bucketNumber].size() > bucketSizeBeforeAdding) {
            size++;
            if (this.buckets[bucketNumber].size() > bucketQty) {
                increaseBuckets();
            }
        }
        return result;
    }

    private void increaseBuckets() {
        MyBucketLinkedList<K, V>[] newBuckets = createNewBuckets();
        updateBuckets(buckets, newBuckets);

    }

    private void updateBuckets(MyBucketLinkedList<K, V>[] buckets, MyBucketLinkedList<K, V>[] newBuckets) {
        this.buckets = newBuckets;
        this.size = 0;
        this.bucketQty = buckets.length;

        for (int i = 0; i < buckets.length; i++) {
            while (buckets[i].size() != 0) {
                K key = buckets[i].getFirstKey();
                this.put(key, buckets[i].get(key));
                buckets[i].remove(key);
            }

        }
    }

    private MyBucketLinkedList<K, V>[] createNewBuckets() {
        MyBucketLinkedList<K, V>[] newBuckets = new MyBucketLinkedList[this.size * 2];
        createBuckets(newBuckets);
        return newBuckets;
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
