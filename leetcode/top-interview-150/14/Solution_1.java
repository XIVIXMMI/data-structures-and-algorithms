
/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * If there is no common prefix, return an empty string "".
 */

class Solution {
    public static String longestCommonPrefix(String[] strs) {

        String prefix = strs[0];
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < prefix.length(); j++) {
            for (int i = 1; i < strs.length; i++) {
                if (j >= strs[i].length()) {
                    return result.toString();
                }
                if (strs[i].charAt(j) != prefix.charAt(j)) {
                    return result.toString();
                }

            }
            result.append(prefix.charAt(j));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(strs));
    }
}
