package sorting_algorithms;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class InsertionSortExample {

    public static void recursiveInsertionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                swap(array, i, i + 1);
            }
        }
    }

    public static void swap(int[] arr, int left, int right) {
        if (arr[left] > arr[right]) {
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            if (left == 0) return;
            swap(arr, left - 1, left);
        }
    }

    public static void main(String[] args) {
        int[] arr = IntStream.generate(() -> ThreadLocalRandom.current().nextInt(100000)).limit(100000).toArray();
        long start = System.currentTimeMillis();
        for (int i = 0; i <= arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
//        recursiveInsertionSort(arr);
        insertionSort(arr);
        System.out.println(System.currentTimeMillis() - start + ":ms");//Recursive -> 9967:ms
        for (int i = 0; i <= arr.length - 1; i++) {                  //Sequentially -> 2782:ms
            System.out.print(arr[i] + " ");
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i + 1];
                array[i + 1] = array[i];
                array[i] = temp;
                if (i == 0) continue;
                for (int j = i; j > 0; j--) {
                    if (array[j] < array[j - 1]) {
                        temp = array[j - 1];
                        array[j - 1] = array[j];
                        array[j] = temp;
                        continue;
                    }
                    break;
                }
            }
        }
    }
}
