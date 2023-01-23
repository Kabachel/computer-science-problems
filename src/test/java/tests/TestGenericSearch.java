package tests;

import org.example.chapter1_small_problems.GenericSearch;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestGenericSearch {
    @Test
    public void testLinearSearch() {
        Assert.assertTrue("linearSearch(List.of(1, 5, 15, 15, 15, 15, 20), 5)",
                GenericSearch.linearContains(
                        List.of(1, 5, 15, 15, 15, 15, 20), 5));
        Assert.assertTrue("linearContains(List.of("
                + "\"a\", \"d\", \"e\", \"f\", \"z\"), \"f\")", GenericSearch
                .linearContains(List.of("a", "d", "e", "f", "z"), "f"));
        Assert.assertFalse("linearContains(List.of("
                + "\"john\", \"mark\", \"ronald\", \"sarah\"),"
                + "\"sheila\")", GenericSearch.linearContains(List.of(
                "john", "mark", "ronald", "sarah"), "sheila"));
    }

    @Test
    public void testBinarySearch() {
        Assert.assertTrue("binaryContains(List.of("
                + "1, 5, 15, 15, 15, 15, 20), 5)", GenericSearch.binaryContains(
                List.of(1, 5, 15, 15, 15, 15, 20), 5));
        Assert.assertTrue("binaryContains(List.of(\"a\", \"d\", "
                + "\"e\", \"f\", \"z\"), \"f\")", GenericSearch.binaryContains(
                List.of("a", "d", "e", "f", "z"), "f"));
        Assert.assertFalse("binaryContains(List.of(\"john\", \"mark\","
                + " \"ronald\", \"sarah\"),\"sheila\")", GenericSearch
                .binaryContains(List.of("john", "mark", "ronald", "sarah"),
                        "sheila"));
    }
}
