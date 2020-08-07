import java.util.EmptyStackException;

public final class LifoStackExample {

    private final Object[] array;
    private int top = 0;
    private final int length;
    private static final byte DEFAULT_SIZE = 10;

    public LifoStackExample() {
        array = new Object[length = DEFAULT_SIZE];
    }

    public LifoStackExample(int size) {
        array = new Object[length = size];
    }

    public LifoStackExample(Object[] array) {
        this.array = new Object[length = array.length];
        for (int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
        }
    }

    public void push(Object object) {
        if (top != array.length) {
            array[top++] = object;
            return;
        }
        throw new StackOverflowError("Stack is already fulled");
    }

    public Object pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Object obj = array[--top];
        array[top] = null;
        return obj;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public static void main(String[] args) {
        LifoStackExample numbers = new LifoStackExample(20);
        for (int i = 0; i < numbers.length; i++) {
            numbers.push(i);
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers.array[i] + " ");
        }

        System.out.println();

        while (!numbers.isEmpty()) System.out.print(numbers.pop() + " ");

        System.out.println();

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers.array[i] + " ");
        }
    }
}
