package module9.myjavacollectionframework;

import java.util.StringJoiner;

/**
 * Завдання 3 - Queue
 * Написати свій клас MyQueue як аналог класу Queue,
 * який буде працювати за принципом FIFO (first-in-first-out).
 * <p>
 * Можна робити за допомогою Node або використати масив.
 * <p>
 * Методи
 * <p>
 * add(Object value) додає елемент в кінець
 * clear() очищає колекцію
 * size() повертає розмір колекції
 * peek() повертає перший елемент з черги
 * poll() повертає перший елемент з черги і видаляє його з колекції
 */
class MyLinkedQueue<T> implements MyQueue<T> {

    private int size;
    private Node<T> firstNode;
    private Node<T> lastNode;

    private static class Node<N> {
        private N value;
        private Node<N> nextNode;
        private Node<N> prevNode;

        public Node(N value, Node<N> nextNode, Node<N> prevNode) {
            this.value = value;
            this.nextNode = nextNode;
            this.prevNode = prevNode;
        }

        public N getValue() {
            return value;
        }

        public void setValue(N value) {
            this.value = value;
        }

        public Node<N> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<N> nextNode) {
            this.nextNode = nextNode;
        }

        public Node<N> getPrevNode() {
            return prevNode;
        }

        public void setPrevNode(Node<N> prevNode) {
            this.prevNode = prevNode;
        }

        @Override
        public String toString() {
            return "Node{"
                    + value +
                    ", " + (nextNode != null ? "next" : "null") +
                    ", " + (prevNode != null ? "prev" : "null") +
                    '}';
        }
    }

    @Override

    public T peek() {
        if (this.size == 0) return null;
        return this.firstNode.getValue();
    }

    @Override
    public T poll() {
        if (this.size == 0) return null;

        T result = this.firstNode.getValue();
        if (this.firstNode.getNextNode() == null) {
            clear();
        } else {
            this.firstNode.nextNode.setPrevNode(null);
            this.firstNode = this.firstNode.getNextNode();
            size--;
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
            this.firstNode = new Node<>(obj, null, null);
            this.lastNode = this.firstNode;
        } else {
            this.lastNode.setNextNode(new Node<>(obj, null, this.lastNode));
            this.lastNode = lastNode.getNextNode();
        }
        size++;
        return true;
    }

    @Override
    public void clear() {
        this.firstNode = null;
        this.lastNode = null;
        this.size = 0;
    }

    @Override
    public String toString() {
        if (this.size == 0) return "MyLinkedQueue{}";

        StringJoiner stringJoiner = new StringJoiner(", ");
        Node<T> pointer = this.firstNode;
        stringJoiner.add(pointer.getValue().toString());
        while (pointer.getNextNode() != null) {
            pointer = pointer.getNextNode();
            stringJoiner.add(pointer.getValue().toString());
        }
        return "MyLinkedQueue{"
                + stringJoiner
                + '}';
    }
}
