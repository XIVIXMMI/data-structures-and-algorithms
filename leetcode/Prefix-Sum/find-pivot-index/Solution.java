
/**
 * Given an array of integers nums, calculate the pivot index of this array
 * The pivot index is the index where the sum of all the numbers strictly to the
 * left of the index is equal to the sum of all the numbers strictly to the
 * index's right
 * If the index is on the left edge of the array, then the left sum is 0 because
 * there are no elements to the left
 * This also applies to the right edge of the array
 * Return the leftmost pivot index
 * If no such index exists, return -1.
 */

public class Solution {
  public static int pivotIndex(int[] nums) {
    int sumLeft = 0, sumRight = 0;
    int totalSum = 0;
    int i = 0;

    for (int num : nums) {
      totalSum += num;
    }

    for (i = 0; i < nums.length; i++) {
      /** tính sumRight trước vì nums[i] hiện tại đang là pivot */
      sumRight = totalSum - sumLeft - nums[i];

      if (sumLeft == sumRight)
        return i;

      /** sau đó gán lại giá trị cho sumLeft để tính vòng lặp sau */
      sumLeft += nums[i];

    }

    return -1;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 7, 3, 6, 5, 6 };
    int result = pivotIndex(nums);
    System.out.println(result);
  }
}
