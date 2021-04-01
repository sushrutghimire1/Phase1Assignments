package datastructure.stack;

import java.util.LinkedList;

public class DynamicLinkedListStackImpl implements Stack {

    private final LinkedList<String> stack;

    public DynamicLinkedListStackImpl() {
        stack = new LinkedList<>();
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
}
