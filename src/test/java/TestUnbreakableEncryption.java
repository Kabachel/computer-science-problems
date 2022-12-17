import org.junit.Assert;
import org.junit.Test;

import org.example.UnbreakableEncryption;
import org.example.*;

public class TestUnbreakableEncryption {

    KeyPair keyPair;

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
}
