import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class PriorityQueueExample<T extends Comparable<T>> {
    private final T[] array;
    private int top = 0;
    private final int length;
    private static final byte DEFAULT_SIZE = 10;

    @SuppressWarnings("unchecked")
    public PriorityQueueExample(Class<T> clazz) {
        array = (T[]) Array.newInstance(clazz, length = DEFAULT_SIZE);
    }

    @SuppressWarnings("unchecked")
    public PriorityQueueExample(Class<T> clazz, int size) {
        array = (T[]) Array.newInstance(clazz, length = size);
    }

    @SuppressWarnings("unchecked")
    public PriorityQueueExample(Class<T> clazz, T[] array) {
        this.array = (T[]) Array.newInstance(clazz, length = array.length);
        System.arraycopy(array, 0, this.array, 0, array.length);
    }

    public void add(T object) {
        System.out.print(object + " ");
        if (top != array.length) {
            if (top == 0) {
                array[top++] = object;
                return;
            }
            for (int i = top; i > 0; i--) {
                if (array[i - 1].compareTo(object) > 0) {
                    array[i] = array[i - 1];
                    array[i - 1] = object;
                    if (i == 1) top++;
                    continue;
                }
                if (i != top) {
                    top++;
                    break;
                }
                array[i] = object;
                top++;
                break;
            }
            return;
        }
        throw new StackOverflowError("Stack is already fulled");
    }

    public T poll() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T obj = array[length - top];
        array[length - top--] = null;
        return obj;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public static void main(String[] args) {
        PriorityQueueExample<Integer> numbers = new PriorityQueueExample<>(Integer.class, 10);
        for (int i = 0; i < numbers.length; i++) {
            numbers.add(ThreadLocalRandom.current().nextInt(20));
        }
        System.out.println();
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers.array[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers.poll() + " ");
        }
    }
}

class QuickSort {
    public void quickSort(int[] A) {
        quickSort(A, 0, A.length - 1);
    }

    private void quickSort(int[] A, int low, int high) {
        if (low < high + 1) {
            int p = partition(A, low, high);
            quickSort(A, low, p - 1);
            quickSort(A, p + 1, high);
        }
    }

    private void swap(int[] A, int index1, int index2) {
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }

    // returns random pivot index between low and high inclusive.
    private int getPivot(int low, int high) {
        Random rand = new Random();
        return rand.nextInt((high - low) + 1) + low;
    }

    // moves all n < pivot to left of pivot and all n > pivot
    // to right of pivot, then returns pivot index.
    private int partition(int[] A, int low, int high) {
        swap(A, low, getPivot(low, high));
        int border = low + 1;
        for (int i = border; i <= high; i++) {
            if (A[i] < A[low]) {
                swap(A, i, border++);
            }
        }
        swap(A, low, border - 1);
        return border - 1;
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] arr = IntStream.generate(() -> ThreadLocalRandom.current().nextInt(100000)).limit(100000).toArray();
        long start = System.currentTimeMillis();
//        for (int i = 0; i <= arr.length - 1; i++) {
//            System.out.print(arr[i] + " ");
//        }
        System.out.println();
        qs.quickSort(arr);
        System.out.println(System.currentTimeMillis() - start + ":ms");//24:ms
//        for (int i = 0; i <= arr.length - 1; i++) {
//            System.out.print(arr[i] + " ");
//        }


    }
}
