import java.util.HashMap;
import java.util.Map;

/**
 * CONTAINS DUPLICATE
 * Given an array num, return true if any value appears at least twice in the
 * array
 * and return false if every element is distinct.
 */

public class Solution {

    public static boolean containsDuplicate(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 }; // false
        System.out.println(containsDuplicate(nums));
    }
}
