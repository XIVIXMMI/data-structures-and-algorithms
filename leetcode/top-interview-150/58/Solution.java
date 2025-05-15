/**
 *
 * LENGTH OF LAST WORD
 *
 * Given a string s consisting of words and space,
 * return length of the last word in the string
 *
 * A word is maximal substring consisting of non-space character only.
 *
 */

public class Solution {
  public static int lengthOfLastWord(String s) {
    int n = s.length() - 1;
    int count = 0;
    // ignore space in the end of String
    while (n >= 0 && s.charAt(n) == ' ') {
      n--;
    }
    while (n >= 0 && s.charAt(n) != ' ') {
      count++;
      n--;
    }
    return count;
  }

  public static void main(String[] args) {
    String s = "   fly me   to   the moon  ";
    System.out.println(lengthOfLastWord(s));
  }
}
