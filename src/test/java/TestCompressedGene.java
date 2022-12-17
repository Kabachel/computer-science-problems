import org.junit.Assert;
import org.junit.Test;
import org.example.CompressedGene;

public class TestCompressedGene {
    @Test
    public void testCompressDecompress() {
        Assert.assertEquals("testCompress(\"ACGT\")", "ACGT", new CompressedGene("ACGT").decompress());
        Assert.assertEquals(
                "testCompress(\"TAGGGATTAACCGTTATATATATATAGCCATGGATCGATTATATATATATAGCCATGGATCGATTAT\")",
                "TAGGGATTAACCGTTATATATATATAGCCATGGATCGATTATATATATATAGCCATGGATCGATTAT",
                new CompressedGene("TAGGGATTAACCGTTATATATATATAGCCATGGATCGATTATATATATATAGCCATGGATCGATTAT").decompress());
    }

    @Test
    public void testCompressDecompressWithException() {
        Throwable throwable = Assert.assertThrows(IllegalArgumentException.class, () -> {
            new CompressedGene("Q");
        });

        Assert.assertNotNull(throwable.getMessage());
    }
}
