import java.util.EmptyStackException;

public class FifoStackExample {

    private final Object[] array;
    private final int length;
    private int firstInserted, lastInserted = 0;
    private static final byte DEFAULT_SIZE = 10;

    public FifoStackExample() {
        array = new Object[length = DEFAULT_SIZE];
    }

    public FifoStackExample(int size) {
        array = new Object[length = size];
    }

    public FifoStackExample(Object[] array) {
        this.array = new Object[length = array.length];
        for (int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
        }
    }

    public void push(Object object) {
        if (lastInserted != array.length) {
            array[lastInserted++] = object;
            return;
        }
        throw new StackOverflowError("Stack is already fulled");
    }

    public Object pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Object obj = array[firstInserted];
        array[firstInserted++] = null;
        return obj;
    }

    public boolean isEmpty() {
        if (firstInserted == lastInserted) {
            firstInserted = lastInserted = 0;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        FifoStackExample numbers = new FifoStackExample(20);
        for (int x = 1; x < 4; x++) {
            System.out.printf("%nCycle %d-rd%n", x);
            for (int i = 0; i < numbers.length; i++) {
                numbers.push(i);
            }
            for (int i = 0; i < numbers.length; i++) {
                System.out.print(numbers.array[i] + " ");
            }
            System.out.println();
            while (!numbers.isEmpty()) {
                System.out.print(numbers.pop() + " ");
            }
            System.out.println();
            for (int i = 0; i < numbers.length; i++) {
                System.out.print(numbers.array[i] + " ");
            }
        }
    }
}
