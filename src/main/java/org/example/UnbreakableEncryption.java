package org.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Unbreakable encryption with one-time cipher.
 */
public class UnbreakableEncryption {
    /**
     * One pixel contains 4 value, for this class takes 3.
     */
    private static final int PIXEL_SIZE = 3;

    /**
     * Generate a random key for encrypt message.
     *
     * @param length length of random key
     * @return byte array of random key
     */
    private static byte[] generateRandomKey(final int length) {
        byte[] dummy = new byte[length];
        Random random = new Random();
        random.nextBytes(dummy);
        return dummy;
    }

    /**
     * String encryption to KeyPair.
     *
     * @param original string to be encrypted
     * @return key pair with dummy and encrypted keys
     */
    public static KeyPair encrypt(final String original) {
        byte[] originalBytes = original.getBytes();
        byte[] dummyKey = generateRandomKey(originalBytes.length);
        byte[] encryptedKey = new byte[originalBytes.length];

        for (int i = 0; i < originalBytes.length; i++) {
            encryptedKey[i] = (byte) (originalBytes[i] ^ dummyKey[i]);
        }

        return new KeyPair(dummyKey, encryptedKey);
    }

    /**
     * Decryption KeyPair to original string.
     *
     * @param keyPair key pair with dummy and encrypted keys
     * @return string decrypted from key pair
     */
    public static String decrypt(final KeyPair keyPair) {
        byte[] decrypted = new byte[keyPair.key1().length];

        for (int i = 0; i < keyPair.key1().length; i++) {
            decrypted[i] = (byte) (keyPair.key1()[i] ^ keyPair.key2()[i]);
        }

        return new String(decrypted);
    }

    /**
     * Image encryption to KeyPairImage.
     *
     * @param original path to the image
     * @return key pair with BufferedImage and dummy key
     * @throws IOException if file from 'path' doesn't exist
     */
    public static KeyPairImages encryptImage(final String original)
            throws IOException {
        File file = new File(original);
        BufferedImage image;

        try {
            image = ImageIO.read(file);
        } catch (IOException exception) {
            throw new IOException("file doesn't exist");
        }

        WritableRaster raster = image.getRaster();

        byte[][] dummyKey = new byte[raster.getHeight()][raster.getWidth()];
        for (int i = 0; i < raster.getHeight(); i++) {
            dummyKey[i] = generateRandomKey(raster.getWidth());
        }

        for (int i = 0; i < raster.getHeight(); i++) {
            for (int j = 0; j < raster.getWidth(); j++) {
                int[] pixels = raster.getPixel(j, i, new int[PIXEL_SIZE]);
                pixels[0] ^= dummyKey[i][j];
                pixels[1] ^= 2 * dummyKey[i][j];
                pixels[2] ^= PIXEL_SIZE * dummyKey[i][j];
                raster.setPixel(j, i, pixels);
            }
        }

        image.setData(raster);
        ImageIO.write(image, "png", new File(original));

        return new KeyPairImages(image, dummyKey);
    }

    /**
     * Decryption KeyPairImage to original image.
     *
     * @param keyPair key pair with dummy and encrypted keys
     * @param path    path to the image
     */
    public static void decryptImage(final KeyPairImages keyPair,
                                    final String path) throws IOException {
        BufferedImage image = keyPair.image();

        WritableRaster raster = image.getRaster();

        for (int i = 0; i < raster.getHeight(); i++) {
            for (int j = 0; j < raster.getWidth(); j++) {
                int[] pixels = raster.getPixel(j, i, new int[PIXEL_SIZE]);
                pixels[0] ^= keyPair.bytes()[i][j];
                pixels[1] ^= 2 * keyPair.bytes()[i][j];
                pixels[2] ^= PIXEL_SIZE * keyPair.bytes()[i][j];
                raster.setPixel(j, i, pixels);
            }
        }
        image.setData(raster);
        ImageIO.write(image, "png", new File(path));
    }
}
