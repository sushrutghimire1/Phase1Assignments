package datastructure.queue;

public interface Queue {
    void enqueue(String element);

    String deque();

    String peek();

    int size();
}
