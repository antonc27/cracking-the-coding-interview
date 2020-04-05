package arraystring;

/**
 * There are three types of edits that can be performed on strings:
 * insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 * <p>
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 */
class _01_05_OneAway {
    boolean isOneAway(String a, String b) {
        int lengthA = a.length();
        int lengthB = b.length();
        if (Math.abs(a.length() - b.length()) > 1) return false;

        if (lengthA == lengthB) {
            return checkReplace(a, b);
        } else if (lengthA - 1 == lengthB) {
            return checkInsert(b, a);
        }else if (lengthB - 1 == lengthA) {
            return checkInsert(a, b);
        }

        return false;
    }

    private boolean checkInsert(String a, String b) {
        boolean seenDiff = false;
        int j = 0;
        for (int i = 0; i < a.length(); i++) {
            char fromA = a.charAt(i);
            if (j >= b.length()) return false;
            char fromB = b.charAt(j);
            if (fromA != fromB) {
                if (seenDiff) return false;
                seenDiff = true;
                j++;
            }
            j++;
        }
        return true;
    }

    private boolean checkReplace(String a, String b) {
        boolean seenDiff = false;
        for (int i = 0; i < a.length(); i++) {
            char fromA = a.charAt(i);
            char fromB = b.charAt(i);
            if (fromA != fromB) {
                if (seenDiff) return false;
                seenDiff = true;
            }
        }
        return true;
    }
}
