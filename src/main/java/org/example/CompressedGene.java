package org.example;

import java.util.BitSet;

/**
 * Trivial compression of DNA code
 */
public class CompressedGene {

    /**
     * BitSet stores a 2 bit for one char
     */
    private BitSet bitSet;
    /**
     * Length of gene
     */
    private int length;

    /**
     * <p>Compress String of gene in BitSet</p>
     * <p>'A' == 00</p>
     * <p>'C' == 01</p>
     * <p>'G' == 10</p>
     * <p>'T' == 11</p>
     *
     * @param gene String of gene
     */
    public CompressedGene(String gene) {
        compress(gene);
    }

    private void compress(String gene) {
        length = gene.length();
        bitSet = new BitSet(length * 2);
        final String upperGene = gene.toUpperCase();

        for (int i = 0; i < length; i++) {
            final int firstLocation = 2 * i;
            final int secondLocation = 2 * i + 1;

            switch (upperGene.charAt(i)) {
                case 'A' -> {
                    bitSet.set(firstLocation, false);
                    bitSet.set(secondLocation, false);
                }
                case 'C' -> {
                    bitSet.set(firstLocation, false);
                    bitSet.set(secondLocation, true);
                }
                case 'G' -> {
                    bitSet.set(firstLocation, true);
                    bitSet.set(secondLocation, false);
                }
                case 'T' -> {
                    bitSet.set(firstLocation, true);
                    bitSet.set(secondLocation, true);
                }
                default -> throw new IllegalArgumentException("The provided gene String contains\n" +
                        "characters other than ACGT");
            }
        }
    }

    /**
     * <p>Decompress BitSet of DNA code to String</p>
     *
     * @return String from BitSet of DNA code
     */
    public String decompress() {
        if (bitSet == null) return null;

        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < (length * 2); i += 2) {
            final int firstBit = bitSet.get(i) ? 1 : 0;
            final int secondBit = bitSet.get(i + 1) ? 1 : 0;
            final int lastBits = firstBit << 1 | secondBit;

            switch (lastBits) {
                case 0b00 -> builder.append('A');
                case 0b01 -> builder.append('C');
                case 0b10 -> builder.append('G');
                case 0b11 -> builder.append('T');
            }
        }

        return builder.toString();
    }
}
