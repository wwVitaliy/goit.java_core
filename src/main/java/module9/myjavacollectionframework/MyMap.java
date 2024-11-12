package module9.myjavacollectionframework;

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
interface MyMap<K,V> {
    int size();
    void clear();
    V put (K key, V value);
    V remove(K key);
    V get (K key);
}
