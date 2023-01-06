package org.example;

import java.util.Stack;

/**
 * Solving The Towers of Hanoi.
 */
public class Hanoi {
    /**
     * Number of discs.
     */
    private final int numDiscs;

    /**
     * Stack of disks on tower A.
     */
    private final Stack<Integer> towerA = new Stack<>();

    /**
     * Stack of disks on tower B.
     */
    private final Stack<Integer> towerB = new Stack<>();

    /**
     * Stack of disks on tower C.
     */
    private final Stack<Integer> towerC = new Stack<>();

    /**
     * Get a stack of tower A.
     *
     * @return Stack of disks of tower A
     */
    public Stack<Integer> getTowerA() {
        return towerA;
    }

    /**
     * Get a stack of tower B.
     *
     * @return Stack of disks of tower B
     */
    public Stack<Integer> getTowerB() {
        return towerB;
    }

    /**
     * Get a stack of tower C.
     *
     * @return Stack of disks of tower C
     */
    public Stack<Integer> getTowerC() {
        return towerC;
    }

    /**
     * Create The Towers of Hanoi.
     *
     * @param numDiscs number of discs
     */
    public Hanoi(final int numDiscs) {
        this.numDiscs = numDiscs;
        for (int i = 1; i <= numDiscs; i++) {
            towerA.push(i);
        }
    }

    /**
     * Solve The Towers of Hanoi.
     */
    public void solve() {
        move(towerA, towerC, towerB, numDiscs);
    }

    private void move(final Stack<Integer> begin, final Stack<Integer> end,
                      final Stack<Integer> temp, final int n) {
        if (n == 1) {
            end.push(begin.pop());
        } else {
            move(begin, temp, end, n - 1);
            move(begin, end, temp, 1);
            move(temp, end, begin, n - 1);
        }
    }
}
