package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Fibonacci {
    public static void main(String[] args) {}

    public static int fibonacciSequenceRecursion(int n) {
        if (n < 2) return n;
        return fibonacciSequenceRecursion(n - 1) + fibonacciSequenceRecursion(n - 2);
    }

    private static Map<Integer, Integer> map = new HashMap<>(Map.of(0, 0, 1, 1));

    public static int fibonacciSequenceMemoize(int n) {
        if (!map.containsKey(n)) map.put(n, fibonacciSequenceMemoize(n - 1) + fibonacciSequenceMemoize(n - 2));
        return map.get(n);
    }

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

    private int last = 0;
    private int next = 1;

    public IntStream stream() {
        return IntStream.generate(() -> {
            int oldLast = last;
            last = next;
            next += oldLast;
            return oldLast;
        });
    }

    public static int fibonacciSequenceStream(int n) {
        Fibonacci fibonacci = new Fibonacci();
        int result = (fibonacci.stream().limit(n + 1).max().getAsInt());
        fibonacci.stream().close();
        return result;
    }

    public static void printfFibonacciSequenceStream(int n) {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.stream().limit(n + 1).forEachOrdered(System.out::println);
        fibonacci.stream().close();
    }
}