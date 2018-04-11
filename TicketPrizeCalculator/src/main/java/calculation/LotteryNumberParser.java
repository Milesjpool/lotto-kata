package calculation;

public class LotteryNumberParser {

    private static final String DELIMITER = ",";

    int[] getNumbers(String csv) {
        String[] segments = csv.split(DELIMITER);
        int[] numbers = new int[segments.length];

        for (int i = 0; i < segments.length; i++) {
            numbers[i] = parseString(segments[i]);
        }

        return numbers;
    }

    private int parseString(String segment) {
        return Integer.parseInt(segment.trim());
    }
}