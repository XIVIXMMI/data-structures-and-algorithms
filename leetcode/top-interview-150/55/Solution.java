/**
 * JUMP GAME
 *
 * You are given an integer array nums
 * You are initially positioned at the array's first index, and each element in
 * the array represents your maximum jump length at that position
 * Return true if you can reach the last index, or false otherwise
 */

public class Solution {
  public static boolean canJump(int[] nums) {
    int n = nums.length;
    int farthest = 0;

    for (int i = 0; i < n - 1; i++) {
      if (i <= farthest) {
        farthest = Math.max(farthest, i + nums[i]);
      } else {
        return false; // i > farthest
      }
    }
    return farthest >= n - 1;
  }

  public static void main(String[] args) {
    int[] nums = { 3, 2, 1, 0, 4 };
    System.out.println(canJump(nums));
  }
}
