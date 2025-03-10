import java.util.Arrays;

/**
 * You are given an integer array nums and an integer
 * In one operation, you can pick two numbers from the array whose sum equals k
 * and remove them from the array
 * Return the maximum number of operations you can perform on the array.
 */

public class Solution {
  private static int maxOperation(int[] nums, int k) {
    Arrays.sort(nums);
    int count = 0;
    int left = 0, right = nums.length - 1;

    while (left < right) {

      int sum = nums[right] + nums[left];
      if (sum == k) {
        count++;
        left++;
        right--;
      } else if (k < sum) {
        left++;
      } else {
        right--;
      }

    }

    return count;
  }

  public static void main(String[] args) {
    int[] nums = { 2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2 };
    int k = 3;
    int result = maxOperation(nums, k);
    System.out.println(result);
  }
}
