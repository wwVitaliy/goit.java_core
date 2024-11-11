package module9.theory.myjavacollectionframework;

import java.util.Arrays;

/**
 * Завдання 4 - Stack
 * Написати свій клас MyStack як аналог класу Stack,
 * який працює за принципом LIFO (last-in-first-out).
 * <p>
 * Можна робити за допомогою Node або використати масив.
 * <p>
 * Методи
 * <p>
 * push(Object value) додає елемент в кінець
 * remove(int index) видаляє елемент за індексом
 * clear() очищає колекцію
 * size() повертає розмір колекції
 * peek() повертає перший елемент стеку
 * pop() повертає перший елемент стеку та видаляє його з колекції
 */
public class MyArrayStack<T> implements MyStack<T> {

    private static final int INIT_ARRAY_SIZE = 2;
    private Object[] data;
    private int size;

    public MyArrayStack() {
        this.data = new Object[INIT_ARRAY_SIZE];
        this.size = 0;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= this.size) return null;

        T result = (T) data[index];

        Object[] newData = new Object[this.data.length];
        for (int i = 0; i < this.size - 1; i++) {
            if (i < index) {
                newData[i] = this.data[i];
            } else if (i >= index) {
                newData[i] = this.data[i + 1];
            }
        }
        this.data = newData;
        this.size--;
        return result;
    }

    @Override
    public boolean push(T obj) {
        return add(obj);
    }

    @Override
    public T peek() {
        if (this.size == 0) return null;
        return (T) this.data[size - 1];
    }

    @Override
    public T pop() {
        if (this.size == 0) return null;
        T peek = peek();
        this.data[this.size - 1] = null;
        this.size--;
        return peek;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean add(T obj) {
        if (this.size == this.data.length) {
            increaseDataCapacity();
        }
        this.data[size] = obj;
        this.size++;
        return true;
    }

    private void increaseDataCapacity() {
        this.data = Arrays.copyOf(this.data, this.data.length * 2);
    }

    @Override
    public void clear() {
        this.data = new Object[INIT_ARRAY_SIZE];
        this.size = 0;
    }

    @Override
    public String toString() {
        return "MyArrayStack{"
                + Arrays.toString(this.data)
                + '}';
    }
}
