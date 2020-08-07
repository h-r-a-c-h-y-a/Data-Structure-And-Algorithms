import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Prime {

    static boolean isPrime(int n) {
        boolean prime = true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }

    static int demo(int[] arr) {
        int x = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length - 1; j++) {
                x = arr[i] + arr[j];
            }
        }
        return  x;
    }

    public static void main(String[] args) {
//        int count = 0;
//        int number = 2;
//        while (count < 10000){
//            if (isPrime(number)){
//                System.out.println(number);
//                count++;
//            }
//            number++;
//        }

        int[] array = IntStream.range(0, 100).toArray();
        int sum = demo(array);
        System.out.println(sum);
    }
}
