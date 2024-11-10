package module9.theory.myjavacollectionframework;

import java.util.StringJoiner;

/**
 * Завдання 2 - LinkedList
 * Напишіть свій клас MyLinkedList як аналог класу LinkedList.
 * <p>
 * Не можна використовувати масив.
 * Кожний елемент повинен бути окремим об'єктом-посередником (Node - нода),
 * що зберігає посилання на попередній та наступний елемент колекції (двозв'язний список).
 * <p>
 * Методи
 * <p>
 * add(Object value) додає елемент в кінець
 * remove(int index) видаляє елемент із вказаним індексом
 * clear() очищає колекцію
 * size() повертає розмір колекції
 * get(int index) повертає елемент за індексом
 */
class MyLinkedList<T> implements MyList<T> {

    private static final String WRONG_INDEX_MESSAGE = "Wrong index!";
    private int size;
    private Node<T> firstNode;
    private Node<T> lastNode;

    private static class Node<N> {
        private N value;
        private Node<N> next;
        private Node<N> prev;

        public Node(N value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }

        public Node(N value, Node<N> next, Node<N> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public N getValue() {
            return value;
        }

        public void setValue(N value) {
            this.value = value;
        }

        public Node<N> getNext() {
            return next;
        }

        public void setNext(Node<N> next) {
            this.next = next;
        }

        public Node<N> getPrev() {
            return prev;
        }

        public void setPrev(Node<N> prev) {
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "Node{" +
                    value +
                    ", " + (next == null ? "null" : "next") +
                    ", " + (prev == null ? "null" : "prev") +
                    '}';
        }
    }


    @Override
    public T get(int index) {
        try {
            if (isWrongIndex(index)) throw new IndexOutOfBoundsException(WRONG_INDEX_MESSAGE);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
            return null;
        }

        if (index == 0) return this.firstNode.getValue();
        if (index == this.size - 1) return this.lastNode.getValue();

        Node<T> pointer = this.firstNode;
        for (int i = 0; i < index; i++) {
            pointer = pointer.getNext();
        }

        return pointer.getValue();
    }

    private boolean isWrongIndex(int index) {
        return index < 0 || index > this.size - 1;
    }

    @Override
    public T remove(int index) {
        try {
            if (isWrongIndex(index)) throw new IndexOutOfBoundsException(WRONG_INDEX_MESSAGE);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
            return null;
        }
        T result;
        if (this.size == 1) {
            result = this.firstNode.getValue();
            clear();
        } else if (index == 0) {
            result = this.firstNode.getValue();
            this.firstNode = this.firstNode.getNext();
            this.firstNode.setPrev(null);
        } else if (index == this.size - 1) {
            result = this.lastNode.getValue();
            this.lastNode = lastNode.getPrev();
            this.lastNode.setNext(null);
        } else {
            Node<T> pointer = firstNode;
            for (int i = 0; i < index; i++) {
                pointer = pointer.getNext();
            }
            result = pointer.getValue();
            pointer.getNext().setPrev(pointer.getPrev());
            pointer.getPrev().setNext(pointer.getNext());

        }
        return result;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean add(T obj) {
        if (this.firstNode == null) {
            this.firstNode = new Node<>(obj);
            this.lastNode = this.firstNode;
        } else {
            Node<T> nodeToAdd = new Node<>(obj, null, this.lastNode);
            this.lastNode.setNext(nodeToAdd);
            this.lastNode = nodeToAdd;
        }
        size++;
        return false;
    }

    @Override
    public void clear() {
        this.firstNode = null;
        this.lastNode = null;
        this.size = 0;
    }

    @Override
    public String toString() {
        if (this.firstNode == null) return "MyLinkedList{}";

        StringJoiner stringJoiner = new StringJoiner(", ");

        Node<T> pointer = this.firstNode;
        stringJoiner.add(pointer.getValue().toString());

        while (pointer.getNext() != null) {
            pointer = pointer.getNext();
            stringJoiner.add(pointer.getValue().toString());
        }

        return "MyLinkedList{" +
                stringJoiner +
                '}';
    }
}
