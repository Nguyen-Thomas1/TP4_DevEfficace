package Liste_chainée;

import java.util.EmptyStackException;

public class MaPile<T> {

    private static class Node<T> {
        private final T data;
        private final Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> top;
    private int size;

    public MaPile() {
        this.top = null;
        this.size = 0;
    }

   
    public T push(T item) {
        top = new Node<>(item, top);
        size++;
        return item;
    }


     */
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    
    public boolean isEmpty() {
        return top == null;
    }

   
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = top;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
