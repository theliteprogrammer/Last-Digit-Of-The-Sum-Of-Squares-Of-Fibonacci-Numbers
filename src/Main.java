import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    private static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;
        long previous = 0;
        long current  = 1;
        long sum      = 1;
        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current * current;
        }

        return sum % 10;
    }

    /**
     *
     * @param n - The last nth term of the sequence
     * @return Last Digit of The Sum Of Squares Of Fibonacci Numbers
     */
    private static BigInteger getFibonacciSumSquaresFast(long n){
        if(n <= 1){
            return BigInteger.valueOf(n);
        } else {
            // create 1D array
            BigInteger[] array = new BigInteger[(int)n + 1];
            array[0] = BigInteger.valueOf(0);
            array[1] = BigInteger.valueOf(1);
            BigInteger sum = BigInteger.valueOf(1); // array[0] + array[1]
            // iterate through each term and calculate the fibonacci number
            for(int i = 2; i < array.length; i++){
                array[i] = array[i - 2].add(array[i - 1]);
                sum = sum.add(array[i].pow(2));
            }
            return sum.mod(BigInteger.valueOf(10));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        BigInteger s = getFibonacciSumSquaresFast(n);
        System.out.println(s);
    }
}