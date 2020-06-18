package bankOCR;

import org.junit.Assert;
import org.junit.Test;

public class BankOCRTest {

    @Test
    public void test_user_story1_000000000() {
        String stringToTest = "000000000";

        String input = BankOCR.buildNumbersAsDigits(stringToTest);

        Assert.assertEquals(stringToTest, BankOCR.parseFileIntoAccountNumber(input));
    }

    @Test
    public void test_user_story1_111111111() {
        String stringToTest = "111111111";

        String input = BankOCR.buildNumbersAsDigits(stringToTest);

        Assert.assertEquals(stringToTest, BankOCR.parseFileIntoAccountNumber(input));
    }

    @Test
    public void test_user_story1_222222222() {
        String stringToTest = "222222222";

        String input = BankOCR.buildNumbersAsDigits(stringToTest);

        Assert.assertEquals(stringToTest, BankOCR.parseFileIntoAccountNumber(input));
    }

    @Test
    public void test_user_story1_333333333() {
        String stringToTest = "333333333";

        String input = BankOCR.buildNumbersAsDigits(stringToTest);

        Assert.assertEquals(stringToTest, BankOCR.parseFileIntoAccountNumber(input));
    }

    @Test
    public void test_user_story1_444444444() {
        String stringToTest = "444444444";

        String input = BankOCR.buildNumbersAsDigits(stringToTest);

        Assert.assertEquals(stringToTest, BankOCR.parseFileIntoAccountNumber(input));
    }

    @Test
    public void test_user_story1_555555555() {
        String stringToTest = "555555555";

        String input = BankOCR.buildNumbersAsDigits(stringToTest);

        Assert.assertEquals(stringToTest, BankOCR.parseFileIntoAccountNumber(input));
    }

    @Test
    public void test_user_story1_666666666() {
        String stringToTest = "666666666";

        String input = BankOCR.buildNumbersAsDigits(stringToTest);

        Assert.assertEquals(stringToTest, BankOCR.parseFileIntoAccountNumber(input));
    }

    @Test
    public void test_user_story1_777777777() {
        String stringToTest = "777777777";

        String input = BankOCR.buildNumbersAsDigits(stringToTest);

        Assert.assertEquals(stringToTest, BankOCR.parseFileIntoAccountNumber(input));
    }

    @Test
    public void test_user_story1_888888888() {
        String stringToTest = "888888888";

        String input = BankOCR.buildNumbersAsDigits(stringToTest);

        Assert.assertEquals(stringToTest, BankOCR.parseFileIntoAccountNumber(input));
    }

    @Test
    public void test_user_story_999999999() {
        String stringToTest = "999999999";

        String input = BankOCR.buildNumbersAsDigits(stringToTest);

        Assert.assertEquals(stringToTest, BankOCR.parseFileIntoAccountNumber(input));
    }

    @Test
    public void test_user_story1_123456789() {
        String stringToTest = "123456789";

        String input = BankOCR.buildNumbersAsDigits(stringToTest);

        Assert.assertEquals(stringToTest, BankOCR.parseFileIntoAccountNumber(input));
    }

    @Test
    public void test_user_story2_true_if_multiple_of_11() {
        String stringToTest = "345882865";

        boolean result = BankOCR.isValidAccountNumber(stringToTest);

        Assert.assertTrue(result);
    }

    @Test
    public void test_user_story2_false_if_not_multiple_of_11() {
        String stringToTest = "000000000";

        boolean result = BankOCR.isValidAccountNumber(stringToTest);

        Assert.assertFalse(result);
    }
}
