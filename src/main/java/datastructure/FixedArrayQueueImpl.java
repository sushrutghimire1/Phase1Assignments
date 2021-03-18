package datastructure;


import datastructure.exceptions.QueueOverflowException;

public class FixedArrayQueueImpl extends AbstractQueue {


    public FixedArrayQueueImpl(int capacity) {
        super(capacity);
    }

    @Override
    public void enqueue(String element) {
        if (back == queue.length) {
            throw new QueueOverflowException();
        }
        queue[back] = element;
        back++;
    }


}
