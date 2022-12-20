import org.example.Hanoi;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class TestHanoi {

    @Test
    public void testSolveWith3Disks() {
        Hanoi hanoi = new Hanoi(3);
        hanoi.solve();
        Stack<Integer> stackTest = new Stack<>();

        for (int i = 1; i <= 3; i++) {
            stackTest.push(i);
        }

        Assert.assertEquals("testSolveWith3Disks(3)", stackTest, hanoi.towerC);
    }

    @Test
    public void testSolveWith4Disks() {
        Hanoi hanoi = new Hanoi(4);
        hanoi.solve();
        Stack<Integer> stackTest = new Stack<>();

        for (int i = 1; i <= 4; i++) {
            stackTest.push(i);
        }

        Assert.assertEquals("testSolveWith4Disks(4)", stackTest, hanoi.towerC);
    }

    @Test
    public void testSolveWith10Disks() {
        Hanoi hanoi = new Hanoi(10);
        hanoi.solve();
        Stack<Integer> stackTest = new Stack<>();

        for (int i = 1; i <= 10; i++) {
            stackTest.push(i);
        }

        Assert.assertEquals("testSolveWith4Disks(4)", stackTest, hanoi.towerC);
    }
}
