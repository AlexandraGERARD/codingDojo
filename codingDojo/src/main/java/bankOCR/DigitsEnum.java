package bankOCR;

public enum DigitsEnum {
    DIGIT_0(0, " _ ", "| |", "|_|"),
    DIGIT_1(1, "   ", " | ", " | "),
    DIGIT_2(2, " _ ", " _|", "|_ "),
    DIGIT_3(3, " _ ", " _|", " _|"),
    DIGIT_4(4, "   ", "|_|", "  |"),
    DIGIT_5(5, " _ ", "|_ ", " _|"),
    DIGIT_6(6, " _ ", "|_ ", "|_|"),
    DIGIT_7(7, " _ ", "  |", "  |"),
    DIGIT_8(8, " _ ", "|_|", "|_|"),
    DIGIT_9(9, " _ ", "|_|", " _|");

    int numberValue;
    String cell1;
    String cell2;
    String cell3;

    DigitsEnum(int numberValue, String cell1, String cell2, String cell3) {
        this.numberValue = numberValue;
        this.cell1 = cell1;
        this.cell2 = cell2;
        this.cell3 = cell3;
    }

    public static DigitsEnum getDigitFromInteger(int numberValue){
        for(DigitsEnum digit : DigitsEnum.values()){
            if(digit.numberValue == numberValue){
                return digit;
            }
        }

        return null;
    }
}