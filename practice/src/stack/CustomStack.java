package stack;

public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int ptr = -1;

    public CustomStack() {
        this(DEFAULT_SIZE);
    }

    public CustomStack (int size) {
        this.data = new int[size];
    }

    public boolean push(int item) {
        if (isFull()) {
            System.out.println("Stack is full!");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws StackException {
        if (isEmpty()) {
            throw new StackException("Cannot pop from an expty stack!!");
        }
        int removed = data[ptr];
        ptr--;
        return removed;
    }

    public int peek() throws StackException {
        if (isEmpty()) {
            throw new StackException("Cannot peek from an expty stack!!");
        }
        return data[ptr];
    }

    private boolean isFull() {
        return ptr == data.length - 1; // ptr is at last index
    }

    private boolean isEmpty() {
        return ptr == - 1; 
    }

    
}
