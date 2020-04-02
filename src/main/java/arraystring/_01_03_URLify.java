package arraystring;

/**
 * Write a method to replace all spaces in a string with '%20'
 * You may assume that the string has sufficient space at the end to hold the additional characters,
 * and that you are given the "true" length of the string.
 * (Note: If implementing in Java,please use a character array so that you can perform this operation in place.)
 * <p>
 * EXAMPLE
 * Input:  "Mr John Smith    ", 13
 * Output: "Mr%20John%20Smith"
 */
class _01_03_URLify {
    char[] urlify(char[] chars, int trueLength) {
        if (trueLength < 1) return chars;
        checkSufficientSpace(chars, trueLength);

        int j = chars.length - 1;
        for (int i = trueLength - 1; i >= 0; i--) {
            char nextChar = chars[i];
            if (nextChar == ' ') {
                chars[j] = '0';
                chars[j - 1] = '2';
                chars[j - 2] = '%';
                j -= 3;
            } else {
                chars[j] = nextChar;
                j--;
            }
        }
        return chars;
    }

    private void checkSufficientSpace(char[] chars, int trueLength) {
        int spacesCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (chars[i] == ' ') spacesCount++;
        }
        int endSpaceCount = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != ' ') break;
            endSpaceCount++;
        }
        if (spacesCount * 2 != endSpaceCount) {
            throw new IllegalArgumentException("Insufficient space");
        }
    }
}
