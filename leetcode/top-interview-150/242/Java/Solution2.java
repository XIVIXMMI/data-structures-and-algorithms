import java.util.HashMap;

class Solution2 {
    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i)))
                return false;

            map.put(t.charAt(i), map.get(t.charAt(i)) - 1);

            if (map.get(t.charAt(i)) < 0)
                return false;
        }

        return true;
    }

    public static boolean isAnagramOptimized(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] count = new int[26];

        for( int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
        }

        for( int i = 0; i < t.length(); i++){
            count[t.charAt(i) - 'a']--;
        }

        for (int i : count) {
            if( i > 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        isAnagramOptimized(s, t);
        // isAnagram(s, t);
    }
}