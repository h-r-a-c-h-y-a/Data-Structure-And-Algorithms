package sorting_algorithms;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class SelectionSortExample {

    public static void selectionSort(int[] array){
        int min;
        for (int i = 0; i < array.length - 1;) {
            min = array[i];
            for (int j = i; j < array.length - 1; j++) {
                if (min > array[j]) {
                    int num = min;
                    min = array[j];
                    array[j] = num;
                }
            }
            array[i++] = min;
        }
    }

    public static void main(String[] args) {
        int [] arr = IntStream.generate(() -> ThreadLocalRandom.current().nextInt(10000)).limit(100000).toArray();
        long start = System.currentTimeMillis();
        selectionSort(arr);
        System.out.println(System.currentTimeMillis() - start + ":ms");//6671:ms
//        for (int i = 0; i < arr.length - 1; i++) {
//            System.out.print(arr[i] + " ");
//        }
    }
}
