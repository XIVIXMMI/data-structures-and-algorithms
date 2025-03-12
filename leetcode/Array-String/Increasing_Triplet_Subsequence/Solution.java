/**
 * Given an integer array nums, return true if there exists a triple of indices
 * (i, j, k)
 * such that i < j < k and nums[i] < nums[j] < nums[k]
 * If no such indices exists, return false.
 */

public class Solution {

  public static boolean increasingTriplet(int[] nums) {
    int n = nums.length;
    int[] leftMin = new int[n];
    int[] rigthMax = new int[n];
    if (n < 3) {
      return false;
    }

    leftMin[0] = nums[0];
    rigthMax[n - 1] = nums[n - 1];

    // find minimum value
    for (int i = 1; i < n; i++) {
      leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
    }

    // find maximum value
    for (int i = n - 2; i >= 0; i--) {
      rigthMax[i] = Math.max(rigthMax[i + 1], nums[i]);
    }

    for (int i = 0; i < n; i++) {
      if (leftMin[i] < nums[i] && nums[i] < rigthMax[i]) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 4, 5 };
    System.out.println(increasingTriplet(nums));
  }
}
