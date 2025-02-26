import java.util.Set;
import java.util.HashSet;

/**
 * Given a string s, reverse only all the vowels in the string and return it
 * The vowels are 'a', 'e', 'i', 'o', and 'u',
 * and they can appear in both lower and upper cases, more than once.
 */

public class Solution {
  public static String reverseVowels(String s) {

    Set<Character> vowels = new HashSet<>();

    for (char c : "ueoaiUEOAI".toCharArray()) {
      vowels.add(c);
    }

    char[] characters = s.toCharArray();

    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
      while (left < right && !vowels.contains(characters[left])) {
        left++;
      }
      while (left < right && !vowels.contains(characters[right])) {
        right--;
      }

      char temp = characters[left];
      characters[left] = characters[right];
      characters[right] = temp;

      left++;
      right--;
    }
    return new String(characters);
  }

  public static void main(String[] args) {
    System.out.println(reverseVowels("leetcode"));
    System.out.println(reverseVowels("Helloworld"));
    System.out.println(reverseVowels("AaOo"));
  }
}
