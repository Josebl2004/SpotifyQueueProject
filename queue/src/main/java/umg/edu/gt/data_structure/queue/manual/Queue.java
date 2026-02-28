package umg.edu.gt.data_structure.queue.manual;

public class Queue<T> {

    private Node<T> head; // primero en salir
    private Node<T> tail; // ultimo en entrar
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // O(1)
    public void enqueue(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }

        Node<T> node = new Node<>(item);

        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

        size++;
    }

    // O(1) + excepción controlada
    public T dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Cannot dequeue from an empty queue");
        }

        T value = head.value;
        head = head.next;
        size--;

        if (head == null) {
            tail = null;
        }

        return value;
    }

    public T peek() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Cannot peek from an empty queue");
        }
        return head.value;
    }
}
