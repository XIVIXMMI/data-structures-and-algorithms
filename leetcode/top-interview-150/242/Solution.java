import java.util.HashMap;
import java.util.Map;

/**
 * VALID ANAGRAM
 *
 * Given two strings s and t, return true if t is anagram of s
 * and false otherwise.
 */

class Solution {

    public static boolean isAnagram(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        for (int count : map.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));

    }
}
