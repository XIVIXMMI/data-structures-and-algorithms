/**
 * JUMP GAME II
 *
 * You are given a 0-indexed array of integers nums of length n
 * You are initially positioned at nums[0]
 * Each element nums[i] represents the maximum length of a forward jump from
 * index i
 * In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]
 * The test cases are generated such that you can reach nums[n - 1].
 *
 */

public class Solution {
  public static int jump(int[] nums) {
    int n = nums.length - 1;
    int farthest = 0; // the farthest of step can reach at every index
    int jump = 0; // number of jump step reach to the end of array
    int i = 0;
    int j = 0; // end of the current jump reaches !

    while (i < n) {
      farthest = Math.max(farthest, i + nums[i]);
      if (i == j) {
        jump++;
        j = farthest;
      }
      i++;
    }
    return jump;
  }

  public static void main(String[] args) {
    int[] nums = { 2, 3, 1, 1, 4 };
    System.out.println(jump(nums));
  }
}
