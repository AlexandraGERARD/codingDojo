package elephantCarpaccio;

import org.junit.Assert;
import org.junit.Test;

public class ElephantCarpaccioTest {

    @Test
    public void test_build_list_of_recipes_with_one_input() {
        StringBuilder expected = new StringBuilder();
        expected.append("Label1            ");
        expected.append("1          ");
        expected.append("1.0          ");
        expected.append("1.0");

        CashRegisterTicket cashRegisterTicket = new CashRegisterTicket("Label1", 1, 1);

        Recipe recipe = new Recipe();
        recipe.addCashRegisterTicket(cashRegisterTicket);

        String result = recipe.issueListOfRecipes();
        Assert.assertEquals(expected.toString(), result);
    }

    @Test
    public void test_build_list_of_recipes_with_two_inputs() {
        StringBuilder expected = new StringBuilder();
        expected.append("Label1            ");
        expected.append("1          ");
        expected.append("1.0          ");
        expected.append("1.0");
        expected.append(System.lineSeparator());
        expected.append("Label2            ");
        expected.append("2          ");
        expected.append("2.0          ");
        expected.append("4.0");

        CashRegisterTicket cashRegisterTicket1 = new CashRegisterTicket("Label1", 1, 1);
        CashRegisterTicket cashRegisterTicket2 = new CashRegisterTicket("Label2", 2, 2);

        Recipe recipe = new Recipe();
        recipe.addCashRegisterTicket(cashRegisterTicket1);
        recipe.addCashRegisterTicket(cashRegisterTicket2);

        String result = recipe.issueListOfRecipes();
        Assert.assertEquals(expected.toString(), result);
    }

    @Test
    public void test_build_total_without_tax_one_input() {
        StringBuilder expected = new StringBuilder();
        expected.append("Total without taxes");
        expected.append("                             100.0");

        CashRegisterTicket cashRegisterTicket1 = new CashRegisterTicket("Label1", 10, 10);

        Recipe recipe = new Recipe();
        recipe.addCashRegisterTicket(cashRegisterTicket1);

        String result = recipe.issueTotalWithoutTax();
        Assert.assertEquals(expected.toString(), result);
    }

    @Test
    public void test_build_total_without_tax_two_inputs() {
        StringBuilder expected = new StringBuilder();
        expected.append("Total without taxes");
        expected.append("                             500.0");

        CashRegisterTicket cashRegisterTicket1 = new CashRegisterTicket("Label1", 10, 10);
        CashRegisterTicket cashRegisterTicket2 = new CashRegisterTicket("Label2", 20, 20);

        Recipe recipe = new Recipe();
        recipe.addCashRegisterTicket(cashRegisterTicket1);
        recipe.addCashRegisterTicket(cashRegisterTicket2);

        String result = recipe.issueTotalWithoutTax();
        Assert.assertEquals(expected.toString(), result);
    }

    @Test
    public void test_discount_tax_line_for_less_than_1000_is_0() {
        StringBuilder expected = new StringBuilder();
        expected.append("Discount 0%");
        expected.append("                                      -0.0");

        CashRegisterTicket cashRegisterTicket = new CashRegisterTicket("Label1", 10, 10);

        Recipe recipe = new Recipe();
        recipe.addCashRegisterTicket(cashRegisterTicket);

        String result = recipe.issueDiscountTax();
        Assert.assertEquals(expected.toString(), result);
    }

    @Test
    public void test_discount_tax_line_for_more_than_1000_is_3_percent() {
        StringBuilder expected = new StringBuilder();
        expected.append("Discount 3%");
        expected.append("                                     -33.0");

        CashRegisterTicket cashRegisterTicket = new CashRegisterTicket("Label1", 110, 10);

        Recipe recipe = new Recipe();
        recipe.addCashRegisterTicket(cashRegisterTicket);

        String result = recipe.issueDiscountTax();
        Assert.assertEquals(expected.toString(), result);
    }

    @Test
    public void test_discount_tax_line_for_more_than_5000_is_5_percent() {
        StringBuilder expected = new StringBuilder();
        expected.append("Discount 5%");
        expected.append("                                    -300.0");

        CashRegisterTicket cashRegisterTicket = new CashRegisterTicket("Label1", 600, 10);

        Recipe recipe = new Recipe();
        recipe.addCashRegisterTicket(cashRegisterTicket);

        String result = recipe.issueDiscountTax();
        Assert.assertEquals(expected.toString(), result);
    }

    @Test
    public void test_discount_tax_line_for_more_than_7000_is_7_percent() {
        StringBuilder expected = new StringBuilder();
        expected.append("Discount 7%");
        expected.append("                                    -560.0");

        CashRegisterTicket cashRegisterTicket = new CashRegisterTicket("Label1", 800, 10);

        Recipe recipe = new Recipe();
        recipe.addCashRegisterTicket(cashRegisterTicket);

        String result = recipe.issueDiscountTax();
        Assert.assertEquals(expected.toString(), result);
    }

    @Test
    public void test_discount_tax_line_for_more_than_10000_is_10_percent() {
        StringBuilder expected = new StringBuilder();
        expected.append("Discount 10%");
        expected.append("                                  -1100.0");

        CashRegisterTicket cashRegisterTicket = new CashRegisterTicket("Label1", 1100, 10);

        Recipe recipe = new Recipe();
        recipe.addCashRegisterTicket(cashRegisterTicket);

        String result = recipe.issueDiscountTax();
        Assert.assertEquals(expected.toString(), result);
    }

    @Test
    public void test_discount_tax_line_tax_for_more_than_50000_is_15_percent() {
        StringBuilder expected = new StringBuilder();
        expected.append("Discount 15%");
        expected.append("                                  -7650.0");

        CashRegisterTicket cashRegisterTicket = new CashRegisterTicket("Label1", 5100, 10);

        Recipe recipe = new Recipe();
        recipe.addCashRegisterTicket(cashRegisterTicket);

        String result = recipe.issueDiscountTax();
        Assert.assertEquals(expected.toString(), result);
    }

    @Test
    public void test_state_tax_line_tax_for_state_UT_is_6_85() {
        StringBuilder expected = new StringBuilder();
        expected.append("Tax 6.85%");
        expected.append("                                       +6.85");

        CashRegisterTicket cashRegisterTicket = new CashRegisterTicket("Label1", 10, 10);

        Recipe recipe = new Recipe();
        recipe.setStateCode(StateTaxEnum.UT_STATE.stateCode);
        recipe.addCashRegisterTicket(cashRegisterTicket);

        String result = recipe.issueStateTax();
        Assert.assertEquals(expected.toString(), result);
    }

    @Test
    public void test_state_tax_line_tax_for_state_NV_is_8() {
        StringBuilder expected = new StringBuilder();
        expected.append("Tax 8.0%");
        expected.append("                                         +8.0");

        CashRegisterTicket cashRegisterTicket = new CashRegisterTicket("Label1", 10, 10);

        Recipe recipe = new Recipe();
        recipe.setStateCode(StateTaxEnum.NV_STATE.stateCode);
        recipe.addCashRegisterTicket(cashRegisterTicket);

        String result = recipe.issueStateTax();
        Assert.assertEquals(expected.toString(), result);
    }

    @Test
    public void test_state_tax_line_tax_for_state_TX_is_6_25() {
        StringBuilder expected = new StringBuilder();
        expected.append("Tax 6.25%");
        expected.append("                                       +6.25");

        CashRegisterTicket cashRegisterTicket = new CashRegisterTicket("Label1", 10, 10);

        Recipe recipe = new Recipe();
        recipe.setStateCode(StateTaxEnum.TX_STATE.stateCode);
        recipe.addCashRegisterTicket(cashRegisterTicket);

        String result = recipe.issueStateTax();
        Assert.assertEquals(expected.toString(), result);
    }

    @Test
    public void test_state_tax_line_tax_for_state_AL_is_4() {
        StringBuilder expected = new StringBuilder();
        expected.append("Tax 4.0%");
        expected.append("                                         +4.0");

        CashRegisterTicket cashRegisterTicket = new CashRegisterTicket("Label1", 10, 10);

        Recipe recipe = new Recipe();
        recipe.setStateCode(StateTaxEnum.AL_STATE.stateCode);
        recipe.addCashRegisterTicket(cashRegisterTicket);

        String result = recipe.issueStateTax();
        Assert.assertEquals(expected.toString(), result);
    }

    @Test
    public void test_state_tax_line_tax_for_state_CA_is_8_25() {
        StringBuilder expected = new StringBuilder();
        expected.append("Tax 8.25%");
        expected.append("                                       +8.25");

        CashRegisterTicket cashRegisterTicket = new CashRegisterTicket("Label1", 10, 10);

        Recipe recipe = new Recipe();
        recipe.setStateCode(StateTaxEnum.CA_STATE.stateCode);
        recipe.addCashRegisterTicket(cashRegisterTicket);

        String result = recipe.issueStateTax();
        Assert.assertEquals(expected.toString(), result);
    }

    @Test
    public void test_calculate_total_price() {
        StringBuilder expected = new StringBuilder();
        expected.append("Total price");
        expected.append("                                    106.85");

        CashRegisterTicket cashRegisterTicket = new CashRegisterTicket("Label1", 10, 10);

        Recipe recipe = new Recipe();
        recipe.setStateCode(StateTaxEnum.UT_STATE.stateCode);
        recipe.addCashRegisterTicket(cashRegisterTicket);

        String result = recipe.issueTotalPrice();
        Assert.assertEquals(expected.toString(), result);
    }

    @Test
    public void test_issue_recipe() {
        CashRegisterTicket cashRegisterTicket1 = new CashRegisterTicket("Label1", 15, 10.5);
        CashRegisterTicket cashRegisterTicket2 = new CashRegisterTicket("Label2", 280, 20.5);

        Recipe recipe = new Recipe();
        recipe.setStateCode(StateTaxEnum.UT_STATE.stateCode);
        recipe.addCashRegisterTicket(cashRegisterTicket1);
        recipe.addCashRegisterTicket(cashRegisterTicket2);

        recipe.issueRecipe();
    }
}