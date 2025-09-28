/**
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150
 * 
 * 28. Find the Index of the First Occurrence in a String
 * Given two strings needle and haystack, 
 * return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */

class Solution {
    public static int strStr(String haystack, String needle) {
        
        char[] str1 = haystack.toCharArray();
        char[] str2 = needle.toCharArray();

        int i = 0, j = 0;
        int reset = -1;

        while(i < str1.length){

            if(str1[i]!=str2[j]){
                j = 0;
                reset++;
                i = reset;
            } else {
                j++;
            }

            i++;

            if( j == str2.length)
                return i - j;

        }

        return -1;
    }

    public static void main(String[] args) {
        String str1 = "mississippi";
        String str2 = "issip";
        int rs = strStr(str1, str2);
        System.out.println(rs);
    }
}