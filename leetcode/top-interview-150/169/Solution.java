import java.util.HashMap;
import java.util.Map;

/**
 * MAJORITY ELEMENT
 * Given an array nums of size n, return the majority element
 * The majority element is the element that appears more than ⌊n / 2⌋ times
 * You may assume that the majority element always exists in the array
 *
 *
 * Could use Boyer-Moore Majority Vote to sold this problem
 *
 * Use 2 variable:
 * candidate : can be majority
 * count : count the vote ( or the appearences) of the candidate
 *
 * Loop through the `nums`
 * if count == 0, then choose the current element can be the candidate
 * if next element == candidates, then increase the count
 * ortherwise, decrease the count !
 *
 */

public class Solution {
  public static int marjorityElement(int[] nums) {
    int n = nums.length;
    int candidate = 0;
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (count == 0) {
        candidate = i;
      }
      if (nums[candidate] == nums[i]) {
        count++;
      } else {
        count--;
      }
    }
    return nums[candidate];
  }

  public static int marjorityElementHashMap(int[] nums) {
    int majority = 0;
    int n = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() > n / 2) {
        majority = entry.getKey();
      }
    }
    System.out.println(map);
    return majority;

  }

  public static void main(String[] args) {
    int[] nums = { 3, 3, 4 };
    System.out.println(marjorityElement(nums));
    System.out.println(marjorityElementHashMap(nums));
  }
}
