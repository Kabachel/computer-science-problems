package org.example;

import java.util.Random;

/**
 * Unbreakable encryption with one-time cipher
 */
public class UnbreakableEncryption {

    /**
     * Generate a random key for encrypt message
     *
     * @param length length of random key
     * @return byte array of random key
     */
    private static byte[] generateRandomKey(int length) {
        byte[] dummy = new byte[length];
        Random random = new Random();
        random.nextBytes(dummy);
        return dummy;
    }

    /**
     * String encryption to key pair
     *
     * @param original string to be encrypted
     * @return key pair with dummy and encrypted keys
     */
    public static KeyPair encrypt(String original) {
        byte[] originalBytes = original.getBytes();
        byte[] dummyKey = generateRandomKey(originalBytes.length);
        byte[] encryptedKey = new byte[originalBytes.length];

        for (int i = 0; i < originalBytes.length; i++) encryptedKey[i] = (byte) (originalBytes[i] ^ dummyKey[i]);

        return new KeyPair(dummyKey, encryptedKey);
    }

    /**
     * Decryption key pair to string
     *
     * @param keyPair key pair with dummy and encrypted keys
     * @return string decrypted from key pair
     */
    public static String decrypt(KeyPair keyPair) {
        byte[] decrypted = new byte[keyPair.key1().length];

        for (int i = 0; i < keyPair.key1().length; i++) decrypted[i] = (byte) (keyPair.key1()[i] ^ keyPair.key2()[i]);

        return new String(decrypted);
    }
}
