package easy;

import java.util.Map;

public class RomanToInteger {
    private static final Map<Character, Integer> ROMAN_MAP = Map.of(
            'I', 1, 'V', 5, 'X', 10, 'L', 50,
            'C', 100, 'D', 500, 'M', 1000
    );

    public int romanToInt(String s)  {
        int total = 0;
        int prevValue = 0;
        boolean lastOpSum = true;
        int countSameValue = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = ROMAN_MAP.get(s.charAt(i));

            if (currentValue < prevValue) {
                lastOpSum = false;
                countSameValue = 1;
                total -= currentValue;

            } else if (currentValue == prevValue) {
                countSameValue++;

                if (!lastOpSum || countSameValue == 4) {
                    return -1; // That's not a Roman number.
                }

                total += currentValue;

            } else {
                lastOpSum = true;
                countSameValue = 1;
                total += currentValue;
            }

            prevValue = currentValue;
        }

        return total;
    }
}
