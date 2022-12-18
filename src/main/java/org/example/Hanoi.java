package org.example;

import java.util.Stack;

/**
 * Solving The Towers of Hanoi
 */
public class Hanoi {
    private final int numDiscs;
    public final Stack<Integer> towerA = new Stack<>();
    public final Stack<Integer> towerB = new Stack<>();
    public final Stack<Integer> towerC = new Stack<>();

    /**
     * Create The Towers of Hanoi
     * @param numDiscs number of discs
     */
    public Hanoi(int numDiscs) {
        this.numDiscs = numDiscs;
        for (int i = 1; i <= numDiscs; i++) towerA.push(i);
    }

    /**
     * Solve The Towers of Hanoi
     */
    public void solve() {
        move(towerA, towerC, towerB, numDiscs);
    }

    private void move(Stack<Integer> begin, Stack<Integer> end, Stack<Integer> temp, int n) {
        if (n == 1) {
            end.push(begin.pop());
        } else {
            move(begin, temp, end, n - 1);
            move(begin, end, temp, 1);
            move(temp, end, begin, n - 1);
        }
    }
}
