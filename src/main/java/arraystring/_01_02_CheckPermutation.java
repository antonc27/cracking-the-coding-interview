package arraystring;

/**
 * Given two strings,write a method to decide if one is a permutation of the other.
 */
class _01_02_CheckPermutation {
    boolean check(String a, String b) {
        if (a.isEmpty() && b.isEmpty()) return true;
        if (a.length() != b.length()) return false;
        char[] aa = a.toCharArray();
        _01_01_IsUnique.mySort(aa);
        char[] bb = b.toCharArray();
        _01_01_IsUnique.mySort(bb);
        for (int i = 0; i < aa.length; i++) {
            if (aa[i] != bb[i]) return false;
        }
        return true;
    }
}
