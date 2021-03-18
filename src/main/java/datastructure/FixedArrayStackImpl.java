package datastructure;


import datastructure.exceptions.StackOverFlowException;
import datastructure.exceptions.StackUnderFlowException;

public class FixedArrayStackImpl implements Stack {

    private final String[] stack;
    private int top;

    public FixedArrayStackImpl(int capacity) {
        stack = new String[capacity];
    }

    @Override
    public void push(String element) {
        if (top == stack.length)
            throw new StackOverFlowException();
        stack[top++] = element;
    }

    @Override
    public String pop() {
        if (isEmpty())
            throw new StackUnderFlowException();
        String element = stack[top - 1];
        stack[--top] = null;
        return element;
    }

    @Override
    public String peek() {
        if (isEmpty())
            throw new StackUnderFlowException();
        return stack[top - 1];
    }

    @Override
    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void printStack() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
