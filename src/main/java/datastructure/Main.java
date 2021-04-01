package datastructure;

import datastructure.queue.DynamicArrayQueueImpl;
import datastructure.queue.FixedArrayQueueImpl;
import datastructure.stack.DynamicArrayStackImpl;
import datastructure.stack.FixedArrayStackImpl;

public class Main {

    public static void main(String[] args) {

        System.out.println("###Fixed stack###");
        FixedArrayStackImpl stack = new FixedArrayStackImpl(10);
        for (int i = 0; i < 10; i++)
            stack.push(Integer.toString(i));
        System.out.println("Peeked stack:" + stack.peek());
        System.out.println("Popped stack:" + stack.pop());
        System.out.println("Size:" + stack.size());
        System.out.println("Stack Traversal:");
        stack.printStack();

        System.out.println("###Dynamic stack###");
        DynamicArrayStackImpl dynamicArrayStack = new DynamicArrayStackImpl(10);
        for (int i = 0; i < 11; i++)
            dynamicArrayStack.push(Integer.toString(i));
        System.out.println("Peeked stack:" + dynamicArrayStack.peek());
        System.out.println("Popped stack:" + dynamicArrayStack.pop());
        System.out.println("Size:" + dynamicArrayStack.size());
        System.out.println("Stack Traversal:");
        dynamicArrayStack.printStack();

        System.out.println("###Dynamic Queue###");
        DynamicArrayQueueImpl queue= new DynamicArrayQueueImpl(10);
        for (int i = 0; i < 11; i++)
            queue.enqueue(Integer.toString(i));
        System.out.println("Peeked stack:" + queue.peek());
        System.out.println("Popped stack:" + queue.deque());
        System.out.println("Size:" + queue.size());
        System.out.println("Stack Traversal:");
        queue.printQueue();

        System.out.println("###Fixed Queue###");
        FixedArrayQueueImpl fixedArrayQueue= new FixedArrayQueueImpl(10);
        for (int i = 0; i < 10; i++)
            fixedArrayQueue.enqueue(Integer.toString(i));
        System.out.println("Peeked stack:" + fixedArrayQueue.peek());
        System.out.println("Popped stack:" + fixedArrayQueue.deque());
        System.out.println("Size:" + fixedArrayQueue.size());
        System.out.println("Stack Traversal:");
        fixedArrayQueue.printQueue();
    }
}
