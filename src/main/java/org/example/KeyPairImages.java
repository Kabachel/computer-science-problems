package org.example;

import java.awt.image.BufferedImage;

/**
 * Key pair for image UnbreakableEncrypt
 *
 * @param image encrypted image
 * @param bytes dummy key for decryption
 */
public record KeyPairImages(BufferedImage image, byte[][] bytes) {
}
