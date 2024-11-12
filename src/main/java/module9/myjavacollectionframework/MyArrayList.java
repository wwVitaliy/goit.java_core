package module9.myjavacollectionframework;

import java.util.Arrays;

/**
 * Завдання 1 - ArrayList
 * Напишіть свій клас MyArrayList як аналог класу ArrayList.
 * <p>
 * Можна використовувати 1 масив для зберігання даних.
 * <p>
 * Методи
 * <p>
 * add(Object value) додає елемент в кінець
 * remove(int index) видаляє елемент із вказаним індексом
 * clear() очищає колекцію
 * size() повертає розмір колекції
 * get(int index) повертає елемент за індексом
 */
class MyArrayList<T>
        implements MyList<T> {
    private static final int INIT_SIZE = 2;
    private static final int INCREASE_COEF = 2;


    private Object[] data;
    private int size;

    MyArrayList() {
        data = new Object[INIT_SIZE];
        size = 0;
    }

    @Override
    public T get(int index) {
        try {
            checkIndex(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Wrong index!");
            return null;
        }
        return (T) data[index];
    }

    @Override
    public T remove(int index) {
        try {
            checkIndex(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Wrong index!");
            return null;
        }

        T result = (T) data[index];

        for (int i = index; i < this.size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        this.size--;
        return result;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean add(T obj) {
        if (this.size == data.length) {
            increaseDataCapacity();
        }
        data[size] = obj;
        size++;
        return false;
    }

    @Override
    public void clear() {
        data = new Object[INIT_SIZE];
        size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void increaseDataCapacity() {
        data = Arrays.copyOf(data, data.length * INCREASE_COEF);
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
