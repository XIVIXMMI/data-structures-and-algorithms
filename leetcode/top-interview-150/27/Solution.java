/**
 * REMOVE ELEMENT
 * Given an integer array nums and an integer val, remove all occurrences of val
 * in nums in-place The order of the elements may be changed
 * Then return the number of elements in nums which are not equal to val
 * Consider the number of elements in nums which are not equal to val be k, to
 * get accepted, you need to do the following things:
 * Change the array nums such that the first k elements of nums contain the
 * elements which are not equal to val
 * The remaining elements of nums are not important as well as the size of nums
 */

public class Solution {
  public static int removeElement(int[] nums, int val) {
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[j] = nums[i];
        j++;
      }
    }

    for (int num : nums) {
      System.out.println(num);
    }
    return j;
  }

  public static void main(String[] args) {
    int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
    int val = 2;
    int result = removeElement(nums, val);
    System.out.println(result);
  }
}
