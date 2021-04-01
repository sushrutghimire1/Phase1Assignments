package datastructure.stack;

public class DynamicArrayStackImpl extends AbstractStack {

    public DynamicArrayStackImpl(int capacity) {
        super(capacity);
    }

    @Override
    public void push(String element) {
        if (top == stack.length) {
            String[] newArray = new String[2 * stack.length];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
        }
        stack[top++] = element;
    }
}
