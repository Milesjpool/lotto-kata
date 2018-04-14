package util;

import java.util.List;

public class StringUtils {
    public static String concat(List<String> winningNumbers, String delimiter) {
        String numbers = "";
        for (String number : winningNumbers) {
            numbers += delimiter + number;
        }
        return numbers.replaceFirst(delimiter,"");
    }
}
