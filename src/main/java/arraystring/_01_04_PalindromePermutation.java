package arraystring;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards.
 * A permutation is a rearrangement of letters.
 * The palindrome does not need to be limited to just dictionary words.
 * <p>
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat", "atco cta", etc.)
 */
class _01_04_PalindromePermutation {
    boolean check(String s) {
        int bitmask = 0;
        for (char c : s.toCharArray()) {
            if (c < 'a' || c > 'z') continue;
            bitmask ^= 1 << (c - 'a' + 1);
        }
        return bitmask == 0 || ((bitmask - 1) & bitmask) == 0;
    }
}
