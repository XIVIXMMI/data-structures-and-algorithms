import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 GROUP ANAGRAM
 Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 
 Example 1:
 
 Input: strs = ["eat","tea","tan","ate","nat","bat"]
 Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 
 Explanation:
 
 There is no string in strs that can be rearranged to form "bat".
 The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 Example 2:
 
 Input: strs = [""]
 Output: [[""]]
 
 Example 3:
 
 Input: strs = ["a"]
 Output: [["a"]]
*/

class Solution{
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> group = new HashMap<>();
        
        // loops throught string[] and creating key
        for( String str : strs){
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String sorted = new String(cs);
            List<String> list = group.computeIfAbsent(sorted, k -> new ArrayList<>());           
            list.add(str);
        }
        
        return new ArrayList<>(group.values());
        
    }
    
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println(result);
    }
}