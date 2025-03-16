
/**
 * Given a string s and an integer k, return the maximum number of vowel letters
 * in any substring of s with length k
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 */

public class Solution {
  public static int maxVowels(String s, int k) {

    String vowels = "aiueo";

    int count = 0, maxCount = 0;

    for (int i = 0; i < k; i++) {
      if (vowels.indexOf(s.charAt(i)) != -1)
        count++;
    }

    maxCount = count;

    for (int i = k; i < s.length(); i++) {
      if (vowels.indexOf(s.charAt(i)) != -1)
        count++;
      if (vowels.indexOf(s.charAt(i - k)) != -1)
        count--;
      maxCount = Math.max(maxCount, count);
    }

    return maxCount;
  }

  public static void main(String[] args) {
    String s = "iloveyousomuch";
    int k = 3;
    int result = maxVowels(s, k);
    System.out.println(result);
  }
}
