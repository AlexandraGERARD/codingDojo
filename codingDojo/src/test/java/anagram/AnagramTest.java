package anagram;

import anagram.Anagram;
import org.junit.Assert;
import org.junit.Test;

public class AnagramTest {

    @Test
    public void test_anagram_of_string_null_is_string_null(){
        String input = null;

        String result = Anagram.getAnagram(input);
        Assert.assertEquals(input, result);
    }

    @Test
    public void test_anagram_of_empty_string_is_empty_string(){
        String input = "";

        String result = Anagram.getAnagram(input);
        Assert.assertEquals(input, result);
    }

    @Test
    public void test_anagram_of_A_is_A(){
        String input = "A";

        String result = Anagram.getAnagram(input);
        Assert.assertEquals(input, result);
    }

    @Test
    public void test_anagram_of_B_is_B(){
        String input = "B";

        String result = Anagram.getAnagram(input);
        Assert.assertEquals(input, result);
    }

    @Test
    public void test_anagram_of_AB_is_BA(){
        String input = "AB";
        String expected = "BA";

        String result = Anagram.getAnagram(input);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void test_anagram_of_BC_is_CB(){
        String input = "BC";
        String expected = "CB";

        String result = Anagram.getAnagram(input);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void test_anagram_of_CDE_is_EDC(){
        String input = "CDE";
        String expected = "EDC";

        String result = Anagram.getAnagram(input);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void test_anagram_of_acrobat_is_taborca(){
        String input = "acrobat";
        String expected = "taborca";

        String result = Anagram.getAnagram(input);
        Assert.assertEquals(expected, result);
    }
}
