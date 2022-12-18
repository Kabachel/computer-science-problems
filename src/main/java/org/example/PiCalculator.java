package org.example;

/**
 * Calculating number Pi via Leibniz formula
 */
public class PiCalculator {
    /**
     * Calculate number Pi with a certain numbers of terms
     *
     * @param nTerms number of terms
     * @return number Pi
     */
    public static double calculatePi(int nTerms) {
        final double numeration = 4.0;
        double denomination = 1.0;
        double operation = 1.0;
        double pi = 0.0;

        for (int i = 0; i < nTerms; i++) {
            pi += operation * (numeration / denomination);
            denomination += 2.0;
            operation *= -1.0;
        }

        return pi;
    }
}
