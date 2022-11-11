public class MyQueue<T> {
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

    public void print() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }

    }
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
    public void clear() {
        head = null;
    }

    public int size() {
        int result = 0;
        Node<T> temp = head;
        while (temp != null) {
            result++;
            temp = temp.next;
        }
        return result;
    }
    public T peek() {
        return head.value;
    }
    public T poll() {
        Node <T> temp =  head;
        head = head.next;
        return temp.value;
    }

}
