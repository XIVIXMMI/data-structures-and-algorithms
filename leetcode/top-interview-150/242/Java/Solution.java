import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String s = "a";
        String t = "ab";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if( s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int n = s.length();
        while (i < n) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            i++;
        }
        while (j < n) {
            if (map.containsKey(t.charAt(j))) {
                map.put(t.charAt(j), map.getOrDefault(t.charAt(j), 0) - 1);
            }
            j++;
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() > 0){
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagramOptimize(String s, String t){
        if(s.length() != t.length()) return false;
        int[] count = new int[26];
        for( int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
        }
        for( int i = 0; i < t.length(); i++){
            count[t.charAt(i) - 'a']--;
            if(count[t.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
