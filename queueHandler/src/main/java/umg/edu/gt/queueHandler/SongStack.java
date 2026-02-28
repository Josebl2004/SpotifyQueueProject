package umg.edu.gt.queueHandler;

public class SongStack {
    private Node top;
    private int size;

    private static class Node {
        Song value;
        Node next;
        Node(Song value) { this.value = value; }
    }

    public void push(Song song) {
        Node n = new Node(song);
        n.next = top;
        top = n;
        size++;
    }

    public int size() {
        return size;
    }
}
	
