
/*
 * VALID PALINDROME
 * 
 * A phrase is a **palindrome** if, after converting all uppercase letters into lowercase
 * letters an removing all non-alphanumeric characters, it reads the same forward and 
 * backward. Alphanumeric characters include letters and numbers.
 * 
 * Given a string a, return true if it is a palindrome, or false otherwise
 * 
 */

class Solution {

    static String convertAndRemove(String s){
        String str = s.toLowerCase();
        str = str.replaceAll("[^a-zA-Z0-9]", "");
        return str;
    }

    public static boolean isPalindrome(String s){
        String str = convertAndRemove(s);
        int i = 0; 
        int j = str.length() - 1;

        while( i <= j) {
            if( str.charAt(i) == str.charAt(j)){
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        boolean rs = isPalindrome(str);
        System.out.println(rs);
    }
}