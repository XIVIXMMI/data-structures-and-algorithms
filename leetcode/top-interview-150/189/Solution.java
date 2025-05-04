/**
 * ROTATE ARRAY
 * Given an integer array nums, rotate the array to the right by k steps, where
 * k is non-negative.
 *
 */

public class Solution {
  public static void rotate(int[] nums, int k) {
    int n = nums.length;
    k = k % n;
    int[] rotateElements = new int[k];
    int j = k;

    for (int i = 0; i < k; i++) {
      rotateElements[i] = nums[n - k + i];
    }

    for (int i = n - 1; i >= k; i--) {
      nums[i] = nums[i - k];
    }

    for (int i = 0; i < k; i++) {
      nums[i] = rotateElements[i];
    }

    for (int num : nums) {
      System.out.println(num);
    }
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
    int k = 3;
    rotate(nums, k);
  }
}
