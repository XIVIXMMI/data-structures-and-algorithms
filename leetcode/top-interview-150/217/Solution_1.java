import java.util.HashSet;
import java.util.Set;

/**
 * CONTAINS DUPLICATE
 * Given an array num, return true if any value appears at least twice in the
 * array
 * and return false if every element is distinct.
 */

public class Solution_1 {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(containsDuplicate(nums));
    }
}
