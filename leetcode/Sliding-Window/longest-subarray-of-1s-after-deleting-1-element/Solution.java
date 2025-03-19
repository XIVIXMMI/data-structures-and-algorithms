
/**
 * Given a binary array nums, you should delete one element from it
 * Return the size of the longest non-empty subarray containing only 1's in the
 * resulting array
 * Return 0 if there is no such subarray.
 */

public class Solution {
  public static int longestSubarray(int[] nums) {
    int left = 0, count = 0, max = 0;
    for (int right = 0; right < nums.length; right++) {
      if (nums[right] == 0) {
        count++;
      }
      while (count > 1) { // If we have more than 1 zero, shrink the window ultil count = 0
        if (nums[left] == 0) { // util the next ZERO values
          count--; // We remove a 0 from the window
        }
        left++; // Move left to shrink the window
      }
      max = Math.max(max, right - left);
    }
    return max;
  }

  public static void main(String[] args) {
    int[] nums = { 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1 }; // output = 7;
    int rs = longestSubarray(nums);
    System.out.println(rs);
  }
}
