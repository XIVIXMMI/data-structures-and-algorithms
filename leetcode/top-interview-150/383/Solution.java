import java.util.HashMap;

/**
 * Given two strings ransomNote and magazine,
 * return true if ransomNote can be constructed by using the letters from
 * magazine and false otherwise
 * Each letter in magazine can only be used once in ransomNote.
 */

public class Solution {

  public static boolean canConstruct(String ransomNote, String magazine) {

    HashMap<Character, Integer> map = new HashMap<>();

    char[] character = ransomNote.toCharArray();
    char[] magazineChar = magazine.toCharArray();

    for (char c : character) {
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }

    }

    for (char c : magazineChar) {
      if (map.containsKey(c)) {
        map.put(c, map.get(c) - 1);
        if (map.get(c) == 0) {
          map.remove(c);
        }
      }
    }

    return map.isEmpty();
  }

  public static void main(String[] args) {
    String ransomNote = "aa";
    String magazine = "aab";
    System.out.println(canConstruct(ransomNote, magazine));
  }
}
