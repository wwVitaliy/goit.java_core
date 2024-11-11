package module9.theory.myjavacollectionframework;

/**
 * Завдання 5 - HashMap
 * Написати свій клас MyHashMap як аналог класу HashMap.
 *
 * Потрібно робити за допомогою однозв'язної Node.
 *
 * Не може зберігати дві ноди з однаковими ключами.
 *
 * Методи
 *
 * put(Object key, Object value) додає пару ключ + значення
 * remove(Object key) видаляє пару за ключем
 * clear() очищає колекцію
 * size() повертає розмір колекції
 * get(Object key) повертає значення (Object value) за ключем
 */
class MyHashMap<K, V> implements MyMap<K,V> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean put(K key, V value) {
        return false;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public V get(K key) {
        return null;
    }
}
