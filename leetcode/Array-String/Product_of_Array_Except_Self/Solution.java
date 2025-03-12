
/**
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i]
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer
 * You must write an algorithm that runs in O(n) time and without using the
 * division operation
 */

public class Solution {
  public static int productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] answer = new int[n];
    // caculating result in left array
    int left[] = new int[n];
    left[0] = 1; // there are no element in left side of num[0] declare left[0] = 1 because 1
                 // easy to multiplies
    for (int i = 1; i < n; i++) {
      left[i] = left[i - 1] * nums[i - 1];
    }

    // caculating result in right array
    int right[] = new int[n];
    right[n - 1] = 1; // there are no elements in right side of num[n-1]
    for (int i = n - 2; i >= 0; i--) {
      right[i] = right[i + 1] * nums[i + 1];
    }

    // multiply two array Left and Right
    for (int i = 0; i < n; i++) {
      answer[i] = left[i] * right[i];
    }
    for (int a : answer) {
      System.out.println(a);
    }
    return 0;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 4 };
    productExceptSelf(nums);
  }
}
