
/**
 * Removing Stars from a String
 * You are given a string s, which contains stars *
 * In one operation, you can:
 * Choose a star in s
 * Remove the closest non-star character to its left, as well as remove the star
 * itself
 * Return the string after all stars have been removed
 * Note:
 * The input will be generated such that the operation is always possible
 * It can be shown that the resulting string will always be unique
 */

public class Solution {
  public static String removingStars(String s) {

    char[] chars = new char[s.length()];
    int nextIndex = 0;
    for (char c : s.toCharArray()) {
      if (c == '*') {
        if (nextIndex > 0) {
          nextIndex--;
        }
      } else {
        chars[nextIndex] = c;
        nextIndex++;
      }
    }

    return new String(chars, 0, nextIndex);
  }

  public static void main(String[] args) {
    String s = "leet**code*";
    String result = removingStars(s);
    System.out.println(result);
  }
}
