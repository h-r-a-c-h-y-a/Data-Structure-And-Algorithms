package sorting_algorithms;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class BubbleSortExample {

    public static void bubbleSort(int[] array) {
        int max = 0;
        for (int i = array.length ; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (array[j] > array[j + 1]){
                    max = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = max;
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] arr = IntStream.generate(() -> ThreadLocalRandom.current().nextInt(10000)).limit(100000).toArray();
        long start = System.currentTimeMillis();
        bubbleSort(arr);
        System.out.println(System.currentTimeMillis() - start + ":ms");//18663:ms
//        for (int i = 0; i < arr.length - 1; i++) {
//            System.out.print(arr[i] + " ");
//        }
    }
}
