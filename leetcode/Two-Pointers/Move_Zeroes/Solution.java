
/**
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements
 * Note that you must do this in-place without making a copy of the array
 */

public class Solution {
  private static void moveZeroes(int[] nums) {
    int n = nums.length;
    int j = 0;

    // move elements != 0 forward in front of array
    for (int i = 0; i < n; i++) {
      if (nums[i] != 0) {
        nums[j] = nums[i];
        j++;
      }
    }
    // place 0 in the rest of array
    while (j < n) {
      nums[j] = 0;
      j++;
    }
  }

  public static void main(String[] args) {
    int[] nums = { 0, 1, 0, 2, 3, 4 };
    moveZeroes(nums);
    for (int n : nums) {
      System.out.println(n);
    }
  }
}
