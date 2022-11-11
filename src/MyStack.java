public class MyStack<T> {
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
    private Node<T> bottom;
    private Node<T> top;

    public void print() {
        Node<T> temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }

    }
    public void push(T value){
        Node<T> newNode = new Node<>(value);
        if (top == null) {
            top = bottom = newNode;
        }else {
            bottom.next = newNode;
            newNode.prev = bottom;
            bottom = newNode;
        }
    }
    public void remove(int index) {
        if (index == 0) {
            top = top.next;
            top.prev = null;
        } else if (index == size() - 1) {
            bottom = bottom.prev;
            bottom.next = null;
        } else  {
            Node<T> current = top.next;
            for (int i = 1; i < index - 1; i++) {
                current = current.next;
            }
            current.prev = current.next;
            current.next = current.next.next;
        }

    }
    public int size() {
        int result = 0;
        Node<T> temp = top;
        while (temp != null) {
            result++;
            temp = temp.next;
        }
        return result;
    }
    public void clear() {
        top = null;
    }
    public T peek() {
        return bottom.value;
    }
    public T pop() {
        Node <T> temp = bottom;
        bottom = bottom.prev;
        bottom.next = null;
        return temp.value;
    }
}
