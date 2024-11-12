package module9.myjavacollectionframework;

import java.util.StringJoiner;

class MyBucketLinkedList<K, V> {

    private int size;
    private Node<K, V> firstNode;
    private Node<K, V> lastNode;

    public V add(K key, V value) {
        Node<K, V> pointer = this.firstNode;
        for (int i = 0; i < this.size; i++) {
            if (pointer.getKey().equals(key)) {
                V result = pointer.getValue();
                pointer.setValue(value);
                return result;
            }
            pointer = pointer.getNextNode();
        }
        attachNewNodeToTheEnd(key, value);
        this.size++;
        return null;
    }

    private void attachNewNodeToTheEnd(K key, V value) {
        if (this.size == 0) {
            this.firstNode = new Node<>(key, value, null);
            this.lastNode = this.firstNode;
        } else {
            this.lastNode.setNextNode(new Node<>(key, value, null));
            this.lastNode = this.lastNode.getNextNode();
        }
    }

    public V get(K key) {
        Node<K, V> pointer = this.firstNode;
        for (int i = 0; i < this.size; i++) {
            if (pointer.getKey().equals(key)) {
                return pointer.getValue();
            }
            pointer = pointer.getNextNode();
        }
        return null;
    }

    public V remove(K key) {
        Node<K, V> pointer = this.firstNode;
        Node<K, V> prevNode = null;

        for (int i = 0; i < this.size; i++) {
            if (pointer.getKey().equals(key)) {
                this.size--;
                return detachNode(pointer, prevNode);
            }
            prevNode = pointer;
            pointer = pointer.getNextNode();
        }
        return null;
    }

    private V detachNode(Node<K, V> nodeToDetach, Node<K, V> prevNode) {
        V result = nodeToDetach.getValue();
        if (prevNode == null) {
            if (nodeToDetach.getNextNode() == null) {
                clear();
            } else {
                this.firstNode = nodeToDetach.getNextNode();
            }
        } else {
            prevNode.setNextNode(nodeToDetach.getNextNode());
        }
        return result;
    }

    private void clear() {
        this.firstNode = null;
        this.lastNode = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public K getFirstKey() {
        if (this.firstNode != null) {
            return this.firstNode.getKey();
        }
        return null;
    }

    private static class Node<K, V> {

        private K key;
        private V value;
        Node<K, V> nextNode;

        public Node(K key, V value, Node<K, V> nextNode) {
            this.key = key;
            this.value = value;
            this.nextNode = nextNode;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Node<K, V> getNextNode() {
            return nextNode;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public void setNextNode(Node<K, V> nextNode) {
            this.nextNode = nextNode;
        }

        @Override
        public String toString() {
            return "Node{" +
                    ", key=" + key +
                    ", value=" + value +
                    ", nextNode=" + (nextNode == null ? "null" : "next") +
                    '}';
        }
    }

    @Override
    public String toString() {
        if (this.size == 0) return "{}";

        Node<K, V> pointer = this.firstNode;

        StringJoiner sj = new StringJoiner(", ");
        sj.add(pointer.getKey() + "=" + pointer.getValue());

        while (pointer.nextNode != null) {
            pointer = pointer.getNextNode();
            sj.add(pointer.getKey() + "=" + pointer.getValue());
        }

        return "{" + sj + '}';
    }
}
