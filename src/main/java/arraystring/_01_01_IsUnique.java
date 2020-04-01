package arraystring;

import java.util.Arrays;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 */

class _01_01_IsUnique {

    public static void mySortRec(char[] a, int start, int end) {
        if (end - start < 2) return;
        char pivot = a[start];
        int pivotingIdx = start + 1;
        for (int i = start + 1; i < end; i++) {
            char nextChar = a[i];
            if (nextChar <= pivot) {
                a[i] = a[pivotingIdx];
                a[pivotingIdx] = nextChar;
                pivotingIdx++;
            }
        }
        pivotingIdx--;
        a[start] = a[pivotingIdx];
        a[pivotingIdx] = pivot;

        mySortRec(a, start, pivotingIdx);
        mySortRec(a, pivotingIdx + 1, end);
    }

    public static void mySort(char[] a) {
        mySortRec(a, 0, a.length);
    }

    boolean isUnique(String str) {
        if (str.isEmpty()) return true;
        char[] chars = str.toCharArray();
        //Arrays.sort(chars);
        mySort(chars);
        char prevChar = chars[0];
        for (int i = 1; i < chars.length; i++) {
            char currentChar = chars[i];
            if (currentChar == prevChar) return false;
            prevChar = currentChar;
        }
        return true;
    }

}
