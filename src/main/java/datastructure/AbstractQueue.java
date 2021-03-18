package datastructure;


import datastructure.exceptions.EmptyQueueException;

public abstract class AbstractQueue implements Queue {
    protected String[] queue;
    protected int back;
    protected int front;

    public AbstractQueue(int capacity) {
        queue = new String[capacity];
    }

    @Override
    public String deque() {
        if (size() == 0)
            throw new EmptyQueueException();

        String element = queue[front];
        queue[front] = null;
        front++;
        if (size() == 0) {
            front = 0;
            back = 0;
        }

        return element;
    }

    @Override
    public String peek() {
        if (size() == 0) {
            throw new EmptyQueueException();
        }

        return queue[front];
    }

    @Override
    public int size() {
        return back - front;
    }

    public void printQueue() {
        for (int i = front; i < back; i++) {
            System.out.println(queue[i]);
        }
    }
}
