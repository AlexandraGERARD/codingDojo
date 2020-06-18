package elephantCarpaccio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Recipe {

    private List<CashRegisterTicket> cashRegisterTicketList = new ArrayList<>();
    private String stateCode;

    private String issueRecipeLabelOfItem(CashRegisterTicket ticket) {
        String label = ticket.getLabelOfItem();
        return buildStringWithSpacesAfter(label, 18);
    }

    private String issueRecipeQuantityOfItem(CashRegisterTicket ticket) {
        String quantity = String.valueOf(ticket.getQuantityOfItem());
        return buildStringWithSpacesAfter(quantity, 11);
    }

    private String issueRecipePriceOfItem(CashRegisterTicket ticket) {
        String unitPrice = String.valueOf(ticket.getPriceOfItem());
        return buildStringWithSpacesAfter(unitPrice, 13);
    }

    private String buildStringWithSpacesAfter(String element, int length) {
        StringBuilder result = new StringBuilder(element);
        result.append(" ".repeat(length - element.length()));

        return result.toString();
    }

    private String buildStringWithSpacesBefore(String element, int length) {
        StringBuilder result = new StringBuilder(" ".repeat(length - element.length()));
        result.append(element);

        return result.toString();
    }

    private String issueRecipeTotalPrice(CashRegisterTicket ticket) {
        double unitPrice = ticket.getPriceOfItem();
        int quantity = ticket.getQuantityOfItem();
        double totalPrice = unitPrice * quantity;
        return String.valueOf(totalPrice);
    }

    public String issueListOfRecipes() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < cashRegisterTicketList.size(); i++) {
            CashRegisterTicket ticket = cashRegisterTicketList.get(i);

            String lineForOneRecipe = issueRecipeOneRecipe(ticket);

            result.append(lineForOneRecipe);

            if (i < cashRegisterTicketList.size() - 1) {
                result.append(System.lineSeparator());
            }
        }

        return result.toString();
    }

    private String issueRecipeOneRecipe(CashRegisterTicket ticket) {
        StringBuilder result = new StringBuilder();

        String labelString = issueRecipeLabelOfItem(ticket);
        String quantityString = issueRecipeQuantityOfItem(ticket);
        String priceString = issueRecipePriceOfItem(ticket);
        String totalString = issueRecipeTotalPrice(ticket);

        result.append(labelString);
        result.append(quantityString);
        result.append(priceString);
        result.append(totalString);

        return result.toString();
    }

    public void addCashRegisterTicket(CashRegisterTicket cashRegisterTicket) {
        cashRegisterTicketList.add(cashRegisterTicket);
    }

    public String issueTotalWithoutTax() {
        StringBuilder result = new StringBuilder();
        result.append("Total without taxes");

        double total = calculateTotalWithoutTax();

        String totalAsString = String.valueOf(total);
        result.append(buildStringWithSpacesBefore(totalAsString, 34));

        return result.toString();
    }

    private double calculateTotalWithoutTaxForOneTicket(CashRegisterTicket ticket) {
        int quantity = ticket.getQuantityOfItem();
        double price = ticket.getPriceOfItem();

        return quantity * price;
    }

    private double calculateTotalWithoutTax() {
        double total = 0;

        for (CashRegisterTicket ticket : cashRegisterTicketList) {
            total += calculateTotalWithoutTaxForOneTicket(ticket);
        }

        return total;
    }

    private int calculateDiscountTax() {
        double total = calculateTotalWithoutTax();

        if (total > 50000.0) {
            return 15;
        }

        if (total > 10000.0) {
            return 10;
        }

        if (total > 7000.0) {
            return 7;
        }

        if (total > 5000.0) {
            return 5;
        }

        if (total > 1000.0) {
            return 3;
        }
        return 0;
    }

    public String issueDiscountTax() {
        int discountTaxInPercent = calculateDiscountTax();
        double discountTaxInAmount = calculateDiscountTaxInAmount();

        String discountTaxInPercentString = "Discount " + discountTaxInPercent + "%";
        String discountTaxInAmountString = "-" + discountTaxInAmount;
        int numberOfSpaces = 53 - discountTaxInPercentString.length() - discountTaxInAmountString.length();

        StringBuilder result = new StringBuilder(discountTaxInPercentString);
        result.append(" ".repeat(numberOfSpaces));
        result.append(discountTaxInAmountString);

        return result.toString();
    }

    private double calculateDiscountTaxInAmount() {
        int discountTaxInPercent = calculateDiscountTax();
        double totalWithoutTax = calculateTotalWithoutTax();

        Double discountTaxInAmount = Double.valueOf((totalWithoutTax * discountTaxInPercent) / 100);

        Double truncatedDouble = BigDecimal.valueOf(discountTaxInAmount)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();

        return truncatedDouble.doubleValue();
    }

    private double calculateStateTax() {
        for (StateTaxEnum stateTax : StateTaxEnum.values()) {
            if (stateCode.equals(stateTax.stateCode)) {
                return stateTax.tax;
            }
        }

        return 0;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String issueStateTax() {
        double stateTaxInPercent = calculateStateTax();
        double stateTaxInAmount = calculateStateTaxInAmount();

        String stateTaxInPercentString = "Tax " + stateTaxInPercent + "%";
        String stateTaxInAmountString = "+" + stateTaxInAmount;
        int numberOfSpaces = 53 - stateTaxInPercentString.length() - stateTaxInAmountString.length();

        StringBuilder result = new StringBuilder(stateTaxInPercentString);
        result.append(" ".repeat(numberOfSpaces));
        result.append(stateTaxInAmountString);

        return result.toString();

    }

    private double calculateStateTaxInAmount() {
        double stateTaxInPercent = calculateStateTax();
        double totalWithoutTax = calculateTotalWithoutTax();

        Double stateTaxInAmount = Double.valueOf((totalWithoutTax * stateTaxInPercent) / 100);

        Double truncatedDouble = BigDecimal.valueOf(stateTaxInAmount)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();

        return truncatedDouble.doubleValue();
    }

    public String issueTotalPrice() {
        double totalPrice = calculateTotalPrice();

        StringBuilder result = new StringBuilder();
        result.append("Total price");
        result.append(buildStringWithSpacesBefore(String.valueOf(totalPrice), 42));

        return result.toString();
    }

    private double calculateTotalPrice() {
        double totalWithoutTax = calculateTotalWithoutTax();
        double discountTax = calculateDiscountTaxInAmount();
        double stateTax = calculateStateTaxInAmount();

        return totalWithoutTax - discountTax + stateTax;
    }

    public String issueRecipe() {
        StringBuilder result = new StringBuilder();
        result.append(issueListOfRecipes()).append(System.lineSeparator());
        result.append("-----------------------------------------------------").append(System.lineSeparator());
        result.append(issueTotalWithoutTax()).append(System.lineSeparator());
        result.append(issueDiscountTax()).append(System.lineSeparator());
        result.append(issueStateTax()).append(System.lineSeparator());
        result.append("-----------------------------------------------------").append(System.lineSeparator());
        result.append(issueTotalPrice());

        System.out.println(result.toString());

        return result.toString();
    }
}