package Java;

import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length()) return false;

        HashMap<Character, String> mapPS = new HashMap<>();
        HashMap<String, Character> mapSP = new HashMap<>();

        for( int i = 0; i < pattern.length(); i++ ){
            char c = pattern.charAt(i);
            String str = words[i];

            if(mapPS.containsKey(c) && mapPS.get(c).equals(str)) return false;
            if(mapSP.containsKey(str) && mapSP.get(str).equals(c)) return false;

            mapPS.put(c, str);
            mapSP.put(str, c);
        }
        return true;
    }
}
