
/**
 * LONGEST COMMON PREFIX
 * Write a function to find the longest common prefix string amongst an array of
 * strings
 * If there is no common prefix, return an empty string ""
 */

import java.math.*;

class Solution {
    public static String longestCommonPrefix(String[] strs) {
        String prfx = strs[0];

        for (int i = 0; i < strs.length - 1; i++) {
            String s1 = prfx;
            String s2 = strs[i + 1];

            int limit = Math.min(s1.length(), s2.length());

            if (s1.isEmpty() || s2.isEmpty())
                return "";

            int k = 0;
            while (k < limit) {
                if (s1.charAt(k) == s2.charAt(k)) {
                    k++;
                } else {
                    break;
                }
            }

            if (prfx.isEmpty()) {
                break;
            } else {
                prfx = s1.substring(0, k);
            }
        }
        return prfx;
    }

    public static void main(String[] args) {
        String[] strs = { "flower" };
        String[] strs1 = { "dog", "racecar", "car" };
        String[] strs2 = { "interview", "internet", "internal" };
        String[] strs3 = { "a" };
        String[] strs4 = { "", "abc" };
        System.out.println(longestCommonPrefix(strs)); // -> "fl"
        System.out.println(longestCommonPrefix(strs1)); // -> ""
        System.out.println(longestCommonPrefix(strs2)); // -> "inter"
        System.out.println(longestCommonPrefix(strs3)); // -> "a"
        System.out.println(longestCommonPrefix(strs4)); // -> ""
    }

}
