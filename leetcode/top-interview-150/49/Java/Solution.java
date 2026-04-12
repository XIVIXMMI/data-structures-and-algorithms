import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> result = groupAnagrams(strs);
        System.out.println(result);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String string : strs) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.computeIfAbsent(key, k -> new ArrayList<>());
            list.add(string);
        }
        return new ArrayList<>(map.values());
    }
}
