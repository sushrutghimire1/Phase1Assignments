package datastructure;

import org.junit.Test;

public class StackOperationsTest {

    @Test
    public void benchmarkForDynamicArrayStackImpl() {
        int size = 10;
        DynamicArrayStackImpl stack = new DynamicArrayStackImpl(size);
        for (int i = 0; i < size; i++) {
            stack.push(String.valueOf(i));
        }
        for (int i = 0; i < size; i++) {
            stack.pop();
        }
    }

    @Test
    public void benchmarkForLinkedListStackImpl() {
        int size = 10;
        DynamicLinkedListStackImpl stack = new DynamicLinkedListStackImpl();
        for (int i = 0; i < size; i++) {
            stack.push(String.valueOf(i));
        }
        for (int i = 0; i < size; i++) {
            stack.pop();
        }
    }

}
