
/**
 * LONGEST COMMON PREFIX
 * Write a function to find the longest common prefix string amongst an array of
 * strings
 * If there is no common prefix, return an empty string ""
 */

import java.math.*;

class Solution {
    public static String longestCommonPrefix(String[] strs) {
        int i = 0;

        String prfx = strs[i];

        while (i < strs.length - 1) {
            String s1 = prfx;
            String s2 = strs[i + 1];

            int limit = Math.min(s1.length(), s2.length());

            if (s1.length() == 0 || s2.length() == 0)
                return "";

            int k = 0;
            while (k < limit) {
                if (s1.charAt(k) == s2.charAt(k)) {
                    k++;
                } else {
                    break;
                }
            }

            prfx = s1.substring(0, k);

            i++;

        }
        return prfx;
    }

    public static void main(String[] args) {
        String[] strs = { "flower" };
        String rs = longestCommonPrefix(strs);
        System.out.println(rs);
    }

}
