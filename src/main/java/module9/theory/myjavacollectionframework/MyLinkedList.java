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

    private static final String WRONG_INDEX_EX_TEXT = "Wrong index: ";
    private int size;
    private Node<T> firstNode;
    private Node<T> lastNode;

    public Node<T> getFirstNode() {
        return firstNode;
    }

    public Node<T> getLastNode() {
        return lastNode;
    }

    static class Node<P> {
        private P value;
        private Node<P> next;
        private Node<P> prev;

        public Node(P value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        public Node(P value, Node<P> nextNode, Node<P> prevNode) {
            this.value = value;
            this.next = nextNode;
            this.prev = prevNode;
        }

        public P getValue() {
            return value;
        }

        public void setValue(P value) {
            this.value = value;
        }

        public Node<P> getNext() {
            return next;
        }

        public void setNext(Node<P> next) {
            this.next = next;
        }

        public Node<P> getPrev() {
            return prev;
        }

        public void setPrev(Node<P> prev) {
            this.prev = prev;
        }
    }

    @Override
    public boolean add(T value) {
        Node<T> nodeToAdd = new Node<>(value);

        if (this.firstNode == null) {
            this.firstNode = nodeToAdd;
        } else if (this.lastNode == null) {
            this.lastNode = nodeToAdd;
            this.firstNode.setNext(this.lastNode);
            this.lastNode.setPrev(firstNode);
        } else {
            this.lastNode.setNext(nodeToAdd);
            nodeToAdd.setPrev(lastNode);
        }
        size++;

        return true;
    }

    @Override
    public T get(int index) {
        try {
            if (!isIndexInBound(index)) throw new IndexOutOfBoundsException(WRONG_INDEX_EX_TEXT + index);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            return null;
        }

        Node<T> pointer = firstNode;
        for (int i = 0; i < index; i++) {
            pointer = pointer.getNext();
        }

        return pointer.getValue();
    }

    private boolean isIndexInBound(int index) {
        return index >= 0 && index < this.size();
    }

    @Override
    public T remove(int index) {
        try {
            if (!isIndexInBound(index)) throw new IndexOutOfBoundsException(WRONG_INDEX_EX_TEXT + index);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            return null;
        }

        if (size == 1) {
            clear();
        }
        T result;
        if (index == 0) {
            result = firstNode.getValue();
            firstNode = firstNode.getNext();
            firstNode.setPrev(null);
        } else if (index == size - 1) {
            result = lastNode.getValue();
            lastNode = lastNode.getPrev();
            lastNode.setNext(null);
        } else {
            Node<T> pointer = firstNode;
            for (int i = 0; i < index; i++) {
                pointer = pointer.getNext();
            }
            result = pointer.getValue();
            pointer.getPrev().setNext(pointer.getNext());
            pointer.getNext().setPrev(pointer.getPrev());
        }
        size--;
        return result;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    @Override
    public String toString() {
        if (firstNode == null) return "MyLinkedList{}";

        StringJoiner sj = new StringJoiner(", ");
        Node<T> lastNode = firstNode;
        sj.add(lastNode.getValue().toString());
        while (lastNode.getNext() != null) {
            lastNode = lastNode.getNext();
            sj.add(lastNode.getValue().toString());
        }
        return "MyLinkedList{"
                + sj
                + '}';
    }
}
