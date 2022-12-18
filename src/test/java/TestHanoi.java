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
        stackTest.push(1);
        stackTest.push(2);
        stackTest.push(3);
        Assert.assertEquals("testSolveWith3Disks(3)", stackTest, hanoi.towerC);
    }
}
