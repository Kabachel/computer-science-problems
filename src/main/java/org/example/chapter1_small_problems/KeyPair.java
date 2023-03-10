package org.example.chapter1_small_problems;

/**
 * Key pair for UnbreakableEncrypt.
 *
 * @param key1 dummy key
 * @param key2 encrypted key
 */
public record KeyPair(byte[] key1, byte[] key2) {
}
