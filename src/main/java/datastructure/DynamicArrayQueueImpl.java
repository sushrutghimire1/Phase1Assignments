package datastructure;

public class DynamicArrayQueueImpl extends AbstractQueue {


    public DynamicArrayQueueImpl(int capacity) {
        super(capacity);
    }

    @Override
    public void enqueue(String element) {
        if (back == queue.length) {
            String[] newArray = new String[2 * queue.length];
            System.arraycopy(queue, 0, newArray, 0, queue.length);
            queue = newArray;
        }

        queue[back] = element;
        back++;
    }
}
