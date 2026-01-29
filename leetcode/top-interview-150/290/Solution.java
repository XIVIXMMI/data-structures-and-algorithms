import java.util.HashMap;
import java.util.Map;

/**
 *
 * WORD PATTERN
 * Given a pattern and a string s, find if s follows the same pattern
 * Here follow means a full match,
 * such that there is a bijection between a letter in pattern and a non-empty
 * word in s. Specifically:
 * Each letter in pattern maps to exactly one unique word in s.
 * Each unique word in s maps to exactly one letter in pattern.
 * No two letters map to the same word, and no two words map to the same letter
 */

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length)
            return false;

        Map<Character, String> p2w = new HashMap<>();
        Map<String, Character> w2p = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            if (p2w.containsKey(c) && !p2w.get(c).equals(w)) {
                return false;
            } else {
                p2w.put(c, w);
            }
            if (w2p.containsKey(w) && w2p.get(w) != c) {
                return false;
            } else {
                w2p.put(w, c);
            }
        }
        return true;
    }
}
