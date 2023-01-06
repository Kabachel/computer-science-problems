package tests;

import org.example.Fibonacci;
import org.junit.Assert;
import org.junit.Test;

public class TestFibonacci {

    @Test
    public void testFibonacciSequenceRecursion() {
        Assert.assertEquals("fibRecursive(1)", 1,
                Fibonacci.fibonacciSequenceRecursion(1));
        Assert.assertEquals("fibRecursive(2)", 1,
                Fibonacci.fibonacciSequenceRecursion(2));
        Assert.assertEquals("fibRecursive(5)", 5,
                Fibonacci.fibonacciSequenceRecursion(5));
        Assert.assertEquals("fibRecursive(10)", 55,
                Fibonacci.fibonacciSequenceRecursion(10));
        Assert.assertEquals("fibRecursive(20)", 6765,
                Fibonacci.fibonacciSequenceRecursion(20));
    }

    @Test
    public void testFibonacciSequenceMemoize() {
        Assert.assertEquals("fibMemoize(1)", 1,
                Fibonacci.fibonacciSequenceMemoize(1));
        Assert.assertEquals("fibMemoize(2)", 1,
                Fibonacci.fibonacciSequenceMemoize(2));
        Assert.assertEquals("fibMemoize(5)", 5,
                Fibonacci.fibonacciSequenceMemoize(5));
        Assert.assertEquals("fibMemoize(10)", 55,
                Fibonacci.fibonacciSequenceMemoize(10));
        Assert.assertEquals("fibMemoize(20)", 6765,
                Fibonacci.fibonacciSequenceMemoize(20));
    }

    @Test
    public void testFibonacciSequenceIterative() {
        Assert.assertEquals("fibIterative(1)", 1,
                Fibonacci.fibonacciSequenceIterative(1));
        Assert.assertEquals("fibIterative(2)", 1,
                Fibonacci.fibonacciSequenceIterative(2));
        Assert.assertEquals("fibIterative(5)", 5,
                Fibonacci.fibonacciSequenceIterative(5));
        Assert.assertEquals("fibIterative(10)", 55,
                Fibonacci.fibonacciSequenceIterative(10));
        Assert.assertEquals("fibIterative(20)", 6765,
                Fibonacci.fibonacciSequenceIterative(20));
    }

    @Test
    public void testFibonacciSequenceStream() {
        Assert.assertEquals("fibStream(1)", 1,
                Fibonacci.fibonacciSequenceStream(1));
        Assert.assertEquals("fibStream(2)", 1,
                Fibonacci.fibonacciSequenceStream(2));
        Assert.assertEquals("fibStream(5)", 5,
                Fibonacci.fibonacciSequenceStream(5));
        Assert.assertEquals("fibStream(10)", 55,
                Fibonacci.fibonacciSequenceStream(10));
        Assert.assertEquals("fibStream(20)", 6765,
                Fibonacci.fibonacciSequenceStream(20));
    }

    @Test
    public void testFibonacciSequenceBinet() {
        Assert.assertEquals("fibBinet(1)", 1,
                Fibonacci.fibonacciSequenceBinet(1));
        Assert.assertEquals("fibBinet(2)", 1,
                Fibonacci.fibonacciSequenceBinet(2));
        Assert.assertEquals("fibBinet(5)", 5,
                Fibonacci.fibonacciSequenceBinet(5));
        Assert.assertEquals("fibBinet(10)", 55,
                Fibonacci.fibonacciSequenceBinet(10));
        Assert.assertEquals("fibBinet(20)", 6765,
                Fibonacci.fibonacciSequenceBinet(20));

    }
}
