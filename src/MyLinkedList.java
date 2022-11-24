import Interfaces.MyCollection;


public class MyLinkedList<T> implements MyCollection<T> {
    static class Node<T> {
        public T value;
        public Node<T> next;
        public Node<T> prev;

        public Node(T value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }


    }
    private Node<T> tail;
    private Node<T> head;

    @Override
    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = tail = newNode;
        }else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    public void print() {
        Node <T> temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }

    }

    @Override
    public void remove(int index) {
        if (index == 0) {
            head = head.next;
            head.prev = null;
        } else if (index == size() - 1) {
            tail = tail.prev;
            tail.next = null;
        } else  {
            Node <T> current = head.next;
            for (int i = 1; i < index - 1; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current.next = null;
            current.prev = null;
        }

    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public int size() {
        int result = 0;
        Node<T> temp = head;
        while (temp != null) {
            result++;
            temp = temp.next;
        }
        return result;
    }

    @Override
    public T get(int index) {
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.value;
    }
}
