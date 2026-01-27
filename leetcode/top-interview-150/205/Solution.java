import java.util.HashMap;

/**
 * ISOMORPHIC STRINGS
 * Given two strings s and t, determine if they are isomorphic
 * Two strings s and t are isomorphic if the characters in s can be replaced to
 * get t
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters
 * No two characters may map to the same character, but a character may map to
 * its
 */

public class Solution {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (mapST.containsKey(c1)) {
                if (mapST.get(c1) != c2)
                    return false;
            } else {
                if (mapTS.containsKey(c2))
                    return false;
                mapST.put(c1, c2);
                mapTS.put(c2, c1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "paper";
        String t = "title";

        System.out.println(isIsomorphic(s, t));
    }
}
