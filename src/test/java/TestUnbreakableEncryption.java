import org.junit.Assert;
import org.junit.Test;

import org.example.UnbreakableEncryption;
import org.example.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TestUnbreakableEncryption {

    KeyPair keyPair;
    KeyPairImages keyPairImages;

    @Test
    public void testUnbreakableEncryption() {
        keyPair = UnbreakableEncryption.encrypt("One Time Pad!");
        Assert.assertEquals("testDecrypt(\"One Time Pad!\")", "One Time Pad!",
                UnbreakableEncryption.decrypt(keyPair));

        keyPair = UnbreakableEncryption.encrypt("SIMPLE TEST");
        Assert.assertEquals("testDecrypt(\"SIMPLE TEST\")",
                "SIMPLE TEST", UnbreakableEncryption.decrypt(keyPair));

        keyPair = UnbreakableEncryption.encrypt(
                "qwertyuiop[[[]\"'\\'lkjhgfdsazxcvbnm,.//\nWERXTCTVUNFMASPQW}}12357S&*FD(*^*(!@#");
        Assert.assertEquals(
                "testDecrypt(\"qwertyuiop[[[]\\\"'\\\\'lkjhgfdsazxcvbnm,.//\\nWERXTCTVUNFMASPQW}}12357S&*FD(*^*(!@#\")",
                "qwertyuiop[[[]\"'\\'lkjhgfdsazxcvbnm,.//\nWERXTCTVUNFMASPQW}}12357S&*FD(*^*(!@#",
                UnbreakableEncryption.decrypt(keyPair));

        keyPair = UnbreakableEncryption.encrypt("");
        Assert.assertEquals("testDecrypt()",
                "", UnbreakableEncryption.decrypt(keyPair));
    }

    @Test
    public void testUnbreakableEncryptionImage() throws IOException {
        String path = "src\\main\\resources\\formula-Bine.png";
        BufferedImage bufferedImage = ImageIO.read(new File(path));

        keyPairImages = UnbreakableEncryption.encryptImage(path);
        UnbreakableEncryption.decryptImage(keyPairImages, path);
        BufferedImage bufferedImageTest = ImageIO.read(new File(path));

        Assert.assertEquals("testDecryptImage()", bufferedImage.getGraphics().toString(), bufferedImageTest.getGraphics().toString());
        Assert.assertEquals("testDecryptImage()", bufferedImage.getData().toString(), bufferedImageTest.getData().toString());
    }

    @Test
    public void testUnbreakableEncryptionImageEncryptWithException() {
        String path = "src\\main\\resources\\formula-Bine.pn";
        Throwable throwable = Assert.assertThrows(IOException.class, () -> UnbreakableEncryption.encryptImage(path));

        Assert.assertNotNull(throwable.getMessage());
    }
}
