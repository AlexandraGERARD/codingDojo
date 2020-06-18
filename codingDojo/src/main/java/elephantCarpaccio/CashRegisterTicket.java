package elephantCarpaccio;

public class CashRegisterTicket {

    private double priceOfItem;
    private int quantityOfItem;
    private String labelOfItem;


    public CashRegisterTicket(String labelOfItem, int quantityOfItem, double priceOfItem) {
        this.labelOfItem = labelOfItem;
        this.quantityOfItem = quantityOfItem;
        this.priceOfItem = priceOfItem;
    }

    public int getQuantityOfItem() {
        return quantityOfItem;
    }

    public void setQuantityOfItem(int quantityOfItem) {
        this.quantityOfItem = quantityOfItem;
    }

    public double getPriceOfItem() {
        return priceOfItem;
    }

    public void setPriceOfItem(double priceOfItem) {
        this.priceOfItem = priceOfItem;
    }

    public String getLabelOfItem() {
        return labelOfItem;
    }

    public void setLabelOfItem(String labelOfItem) {
        this.labelOfItem = labelOfItem;
    }
}
