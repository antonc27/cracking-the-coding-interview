package arraystring;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2b1c5a3.
 * If the "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
class _01_06_StringCompression {
    String compress(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            int count = 1;
            int j = i + 1;
            while (j < s.length() && currChar == s.charAt(j)) {
                count++;
                j++;
            }
            sb.append(currChar);
            sb.append(count);
            i = j - 1;
        }

        return sb.length() < s.length() ? sb.toString() : s;
    }
}
