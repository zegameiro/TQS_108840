package pt.deti.ua;

import java.util.LinkedList;

public class TqsStack<T> {
    private LinkedList<T> collection;

    public TqsStack() {
        this.collection = new LinkedList<>();
    }

    public T pop() {
        return null;
    }

    public int size() {
        return 0;
    }

    public T peek() {
        return null;
    }

    public void push(T arg) {
        collection.add(arg);
    }

    public boolean isEmpty() {
        return true;
    }
}
