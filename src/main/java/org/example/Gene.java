package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * DNA Search
 */
public class Gene {
    private final ArrayList<Codon> codons = new ArrayList<>();

    /**
     * Convert gene String into a Gene
     *
     * @param geneStr gene String
     */
    public Gene(String geneStr) {
        for (int i = 0; i < geneStr.length() - 3; i += 3) codons.add(new Codon(geneStr.substring(i, i + 3)));
    }

    /**
     * Nucleotide enum
     */
    public enum Nucleotide {
        A, C, G, T
    }

    /**
     * Codon from 3 nucleotide
     */
    public static class Codon implements Comparable<Codon> {
        /**
         * Three nucleotides for one codon
         */
        public final Nucleotide first, second, third;

        private final Comparator<Codon> comparator = Comparator.comparing((Codon c) -> c.first)
                .thenComparing((Codon c) -> c.second)
                .thenComparing((Codon c) -> c.third);

        /**
         * Convert codon String into a nucleotide sequence
         *
         * @param codonStr codon String
         */
        public Codon(String codonStr) {
            first = Nucleotide.valueOf(codonStr.substring(0, 1));
            second = Nucleotide.valueOf(codonStr.substring(1, 2));
            third = Nucleotide.valueOf(codonStr.substring(2, 3));
        }

        /**
         * Compare two codons
         *
         * @param other the object to be compared.
         * @return equals -> 0, first is more -> num > 0, second is more -> num < 0
         */
        @Override
        public int compareTo(Codon other) {
            // first is compared first, then second, etc.
            // IOW first takes precedence over second
            // and second over third
            return comparator.compare(this, other);
        }
    }

    /**
     * Find a specific codon in a codon sequence via linear search
     *
     * @param key search codon
     * @return if find -> true, else -> false
     */
    public boolean linearContains(Codon key) {
        for (Codon codon : codons) {
            if (codon.compareTo(key) == 0) return true;
        }
        return false;
    }

    /**
     * Find a specific codon in a codon sequence via binary search after sorting
     *
     * @param key search codon
     * @return if find -> true, else -> false
     */
    public boolean binaryContains(Codon key) {
        ArrayList<Codon> sortedCodon = new ArrayList<>(codons);
        Collections.sort(sortedCodon);

        int low = 0;
        int high = sortedCodon.size() - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            int comparison = sortedCodon.get(middle).compareTo(key);
            if (comparison < 0) {
                low = middle + 1;
            } else if (comparison > 0) {
                high = middle - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
