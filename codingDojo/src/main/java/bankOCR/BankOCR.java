package bankOCR;

public class BankOCR {
    public static String parseFileIntoAccountNumber(String input) {
        StringBuilder result = new StringBuilder();

        String[][] cellsAsArray = getCellsArrayFromInput(input);

        for (int i = 0; i < 9; i++) {
            String cell1 = cellsAsArray[0][i];
            String cell2 = cellsAsArray[1][i];
            String cell3 = cellsAsArray[2][i];

            for (DigitsEnum d : DigitsEnum.values()) {
                if (cell1.equals(d.cell1) && cell2.equals(d.cell2) && cell3.equals(d.cell3)) {
                    result.append(d.numberValue);
                    break;
                }
            }
        }

        return result.toString();
    }

    private static String[][] getCellsArrayFromInput(String input) {
        String[] cellsAsArrayTemp = input.split(System.lineSeparator());
        String[][] cellsAsArray = new String[3][9];

        for (int i = 0; i < cellsAsArrayTemp.length; i++) {
            String[] cellTemp = cellsAsArrayTemp[i].split("");

            int count = 0;

            for (int j = 0; j < cellTemp.length; j++) {
                boolean isPlaceOfDigitMultipleOf3 = (j + 1) % 3 == 0;

                if (isPlaceOfDigitMultipleOf3) {
                    cellsAsArray[i][count] = buildConcatenatedCell(cellTemp,j);
                    count++;
                }
            }
        }
        return cellsAsArray;
    }

    private static String buildConcatenatedCell(String[] cellArray, int position){
        StringBuilder cell = new StringBuilder(cellArray[position - 2]);
        cell.append(cellArray[position - 1]);
        cell.append(cellArray[position]);

        return cell.toString();
    }

    public static String buildNumbersAsDigits(String value) {
        StringBuilder result = new StringBuilder();
        String[] valueAsArray = value.split("");

        StringBuilder cell1 = new StringBuilder();
        StringBuilder cell2 = new StringBuilder();
        StringBuilder cell3 = new StringBuilder();

        for (String s : valueAsArray) {
            DigitsEnum digit = DigitsEnum.getDigitFromInteger(Integer.valueOf(s));
            cell1.append(digit.cell1);
            cell2.append(digit.cell2);
            cell3.append(digit.cell3);
        }

        result.append(cell1);
        result.append(System.lineSeparator());
        result.append(cell2);
        result.append(System.lineSeparator());
        result.append(cell3);

        return result.toString();
    }

    public static boolean isValidAccountNumber(String value) {
        String[] valueAsArray = value.split("");
        int checksum = 0;

        for(int i = 0; i < valueAsArray.length; i++){
            int cellAsInteger = Integer.valueOf(valueAsArray[i])  ;
            checksum += cellAsInteger*(valueAsArray.length-i);
        }

        return isMultipleOf11(checksum);
    }

    private static boolean isMultipleOf11(int value){
        if(0!=value) {
            return value % 11 == 0;
        }

        return false;
    }
}