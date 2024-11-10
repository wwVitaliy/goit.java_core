package module9.theory.myjavacollectionframework;

/**
 * Завдання 3 - Queue
 * Написати свій клас MyQueue як аналог класу Queue,
 * який буде працювати за принципом FIFO (first-in-first-out).
 *
 * Можна робити за допомогою Node або використати масив.
 *
 * Методи
 *
 * add(Object value) додає елемент в кінець
 * clear() очищає колекцію
 * size() повертає розмір колекції
 * peek() повертає перший елемент з черги
 * poll() повертає перший елемент з черги і видаляє його з колекції
 */
class MyLinkedQueue<T> implements MyQueue<T> {
    @Override
    public T peek() {
        return null;
    }

    @Override
    public T poll() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean add(T obj) {
        return false;
    }

    @Override
    public void clear() {

    }
}
