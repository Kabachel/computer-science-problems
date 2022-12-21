import org.example.Gene;
import org.junit.Assert;
import org.junit.Test;

public class TestGene {
    @Test
    public void testGeneLinearSearch() {
        String geneStr = "ACGTGGCTCTCTAACGTACGTACGTACGGGGTTTATATATACCCTAGGACTCCCTTT";

        Gene myGene = new Gene(geneStr);
        Gene.Codon acg = new Gene.Codon("ACG");
        Gene.Codon tgg = new Gene.Codon("TGG");
        Gene.Codon gat = new Gene.Codon("GAT");

        Assert.assertTrue("testGeneLinearSearch(\"ACG\")", myGene.linearContains(acg));
        Assert.assertTrue("testGeneLinearSearch(\"TGG\")", myGene.linearContains(tgg));
        Assert.assertFalse("testGeneLinearSearch(\"GAT\")", myGene.linearContains(gat));
    }
}
