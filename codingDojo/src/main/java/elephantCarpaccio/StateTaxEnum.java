package elephantCarpaccio;

public enum StateTaxEnum {

    UT_STATE("UT", 6.85),
    NV_STATE("NV", 8),
    TX_STATE("TX", 6.25),
    AL_STATE("AL", 4),
    CA_STATE("CA", 8.25);

    double tax;
    String stateCode;

    StateTaxEnum(String stateCode, double tax) {
        this.stateCode = stateCode;
        this.tax = tax;
    }

}
