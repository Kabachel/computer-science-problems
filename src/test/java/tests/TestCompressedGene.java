package tests;

import org.junit.Assert;
import org.junit.Test;
import org.example.chapter1_small_problems.CompressedGene;

public class TestCompressedGene {
    @Test
    public void testCompressDecompress() {
        Assert.assertEquals("testCompress(\"ACGT\")", "ACGT",
                new CompressedGene("ACGT").decompress());
        Assert.assertEquals(
                "testCompress(\"TAGGGATTAACCGTTATATATATATAGCCATGG"
                        + "ATCGATTATATATATATAGCCATGGATCGATTAT\")",
                "TAGGGATTAACCGTTATATATATATAGCCATGGATCGATTATATATATATA"
                        + "GCCATGGATCGATTAT",
                new CompressedGene("TAGGGATTAACCGTTATATATATATAGCCATGGATCGA"
                        + "TTATATATATATAGCCATGGATCGATTAT").decompress());
    }

    @Test
    public void testCompressDecompressWithException() {
        Throwable throwable = Assert.assertThrows(
                IllegalArgumentException.class, () -> {
                    new CompressedGene("Q");
                });

        Assert.assertNotNull(throwable.getMessage());
    }
}
