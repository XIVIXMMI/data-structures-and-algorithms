/**
 * You are given two strings word1 and word2
 * Merge the strings by adding letters in alternating order, starting with word1
 * If a string is longer than the other, append the additional letters onto the
 * end of the merged string
 * Return the merged string.
 **/

public class Solution {
  public static String mergeAlternately(String word1, String word2) {
    StringBuilder result = new StringBuilder();
    int i = 0;
    int j = 0;

    while (i < word1.length() && j < word2.length()) {
      result.append(word1.charAt(i));
      result.append(word2.charAt(j));
      i++;
      j++;
    }

    while (i < word1.length()) {
      result.append(word1.charAt(i));
      i++;
    }

    while (j < word2.length()) {
      result.append(word2.charAt(j));
      j++;
    }
    return result.toString();
  }

  public static void main(String[] args) {
    String str1 = "abcd";
    String str2 = "defgh";

    String result = mergeAlternately(str1, str2);

    System.out.println(result);
  }
}
