package datastructure;

import java.util.LinkedList;

public class DynamicLinkedListStackImpl implements Stack {

    private final LinkedList<String> stack;

    public DynamicLinkedListStackImpl() {
        stack = new LinkedList<String>();
    }

    @Override
    public void push(String element) {
        stack.push(element);
    }

    @Override
    public String pop() {
        return stack.pop();
    }

    @Override
    public String peek() {
        return stack.peek();
    }

    @Override
    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void printStack() {
        for (String s : stack) {
            System.out.println(s);
        }
    }
}
