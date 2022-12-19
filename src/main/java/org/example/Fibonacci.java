package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Functions of various ways to find the Fibonacci number
 */
public class Fibonacci {

    /**
     * The private Map storing cached values for fibonacciSequenceMemoize
     */
    private final static Map<Integer, Integer> map = new HashMap<>(Map.of(0, 0, 1, 1));

    /**
     * <p>Finding the Fibonacci number using recursion</p>
     *
     * @param n Fibonacci sequence number
     * @return integer value of the number 'n' from the fibonacci series
     */
    public static int fibonacciSequenceRecursion(int n) {
        if (n < 2) return n;
        return fibonacciSequenceRecursion(n - 1) + fibonacciSequenceRecursion(n - 2);
    }

    /**
     * <p>Finding the Fibonacci number using memoization via Map</p>
     *
     * @param n Fibonacci sequence number
     * @return integer value of the number 'n' from the fibonacci series
     */
    public static int fibonacciSequenceMemoize(int n) {
        if (!map.containsKey(n)) map.put(n, fibonacciSequenceMemoize(n - 1) + fibonacciSequenceMemoize(n - 2));
        return map.get(n);
    }

    /**
     * <p>Finding the Fibonacci number iterative</p>
     *
     * @param n Fibonacci sequence number
     * @return integer value of the number 'n' from the fibonacci series
     */
    public static int fibonacciSequenceIterative(int n) {
        int last = 0;
        int next = 1;

        for (int i = 0; i < n; i++) {
            int oldLast = last;
            last = next;
            next += oldLast;
        }

        return last;
    }

    /**
     * <p>Finding the Fibonacci number using Binet's formula</p>
     * <img src="https://raw.githubusercontent.com/Kabachel/computer-science-problems/develop/docs/resources/formula-Bine.png" />
     *
     * @param n Fibonacci sequence number
     * @return integer value of the number 'n' from the fibonacci series
     */
    public static int fibonacciSequenceBinet(int n) {
        double index = Math.sqrt(5);

        double left = (1 + index) / 2;
        double right = (1 - index) / 2;

        return (int) Math.round((Math.pow(left, n) - Math.pow(right, n)) / index);
    }

    /**
     * Generate stream of fibonacci numbers
     *
     * @return stream of fibonacci numbers
     */
    private IntStream stream() {
        final int[] next = {1};
        final int[] last = {0};
        return IntStream.generate(() -> {
            int oldLast = last[0];
            last[0] = next[0];
            next[0] += oldLast;
            return oldLast;
        });
    }

    /**
     * <p>Finding the Fibonacci number using stream</p>
     *
     * @param n Fibonacci sequence number
     * @return integer value of the number 'n' from the fibonacci series
     */
    public static int fibonacciSequenceStream(int n) {
        Fibonacci fibonacci = new Fibonacci();
        int result = (fibonacci.stream().limit(n + 1).max().getAsInt());
        fibonacci.stream().close();
        return result;
    }

    /**
     * <p>Prints fibonacci series up to 'n' number</p>
     *
     * @param n Fibonacci sequence number
     */
    public static void printfFibonacciSequenceStream(int n) {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.stream().limit(n + 1).forEachOrdered(System.out::println);
        fibonacci.stream().close();
    }
}