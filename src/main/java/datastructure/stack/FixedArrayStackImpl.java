package datastructure.stack;


import datastructure.exceptions.StackOverFlowException;

public class FixedArrayStackImpl extends AbstractStack {

    public FixedArrayStackImpl(int capacity) {
        super(capacity);
    }

    @Override
    public void push(String element) {
        if (top == stack.length)
            throw new StackOverFlowException();
        stack[top++] = element;
    }
}
