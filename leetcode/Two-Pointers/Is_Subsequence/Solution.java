
/**
 * Given two strings s and t, return true if s is a subsequence of t, or false
 * otherwise
 * A subsequence of a string is a new string that is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters
 * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */
public class Solution {
  private static boolean isSubsequence(String s, String t) {
    int i = 0;
    int j = 0;
    int m = s.length();
    int n = t.length();

    for (i = 0; i < n; i++) {
      if (j < m && t.charAt(i) == s.charAt(j)) {
        j++;
      }
    }
    return j == m;
  }

  public static void main(String[] args) {
    String s = "abc";
    String t = "ahbgdc";
    boolean result = isSubsequence(s, t);
    System.out.println(result);
  }
}
