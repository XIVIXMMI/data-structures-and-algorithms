
/**
 * Given a binary array nums and an integer k, return the maximum number of
 * consecutive 1's in the array if you can flip at most k 0's
 */

public class Solution {
  public static int longestOnes(int[] nums, int k) {

    int maxLength = 0, left = 0, right = 0, count = 0;

    for (right = 0; right < nums.length; right++) {
      if (nums[right] == 0) {
        count++;
      }

      while (count > k) {
        if (nums[left] == 0) {
          count--;
        }
        left++;
      }

      maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
  }

  public static void main(String[] args) {
    int[] nums = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
    int k = 3;

    int rs = longestOnes(nums, k);
    System.out.println(rs);
  }
}
