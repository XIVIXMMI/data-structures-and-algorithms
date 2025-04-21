import java.util.*;

/**
 * Two strings are considered close if you can attain one from the other using
 * the following operations:
 * Operation 1: Swap any two existing characters
 * For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into
 * another existing character, and do the same with the other character
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into
 * a's)
 * You can use the operations on either string as many times as necessary
 * Given two strings, word1 and word2, return true if word1 and word2 are close,
 * and false otherwise.
 */
public class Solution {
  public static boolean closeString(String word1, String word2) {

    // if the length are different return false
    if (word1.length() != word2.length()) {
      return false;
    }

    HashMap<Character, Integer> map1 = new HashMap<>();
    HashMap<Character, Integer> map2 = new HashMap<>();

    for (int i = 0; i < word1.length(); i++) {
      map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0) + 1);
    }

    for (int i = 0; i < word2.length(); i++) {
      map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0) + 1);
    }

    // check if 2 map have the same set of key
    if (!map1.keySet().equals(map2.keySet())) {
      return false;
    }

    // get sorted list of frequency counts
    List<Integer> counts1 = new ArrayList<>(map1.values());
    List<Integer> counts2 = new ArrayList<>(map2.values());

    Collections.sort(counts1);
    Collections.sort(counts2);

    return counts1.equals(counts2);

  }

  public static void main(String[] args) {
    String word1 = "cabbba";
    String word2 = "abbccc";
    System.out.println(closeString(word1, word2));
  }
}
