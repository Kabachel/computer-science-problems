package tests;

import org.example.PiCalculator;
import org.junit.Assert;
import org.junit.Test;

public class TestPiCalculator {

    boolean compare;

    @Test
    public void testCalculatePi() {
        compare = Math.abs(PiCalculator.calculatePi(1) - 4.0) < 1e-6;
        Assert.assertTrue("testCalculatePi(1)", compare);

        compare = Math.abs(PiCalculator.calculatePi(2) - 2.666666) < 1e-6;
        Assert.assertTrue("testCalculatePi(2)", compare);

        compare = Math.abs(PiCalculator.calculatePi(5) - 3.339682) < 1e-6;
        Assert.assertTrue("testCalculatePi(5)", compare);

        compare = Math.abs(PiCalculator.calculatePi(100) - 3.131592) < 1e-6;
        Assert.assertTrue("testCalculatePi(100)", compare);

        compare = Math.abs(PiCalculator.calculatePi(1000000) - 3.141591) < 1e-6;
        Assert.assertTrue("testCalculatePi(1000000)", compare);
    }
}
