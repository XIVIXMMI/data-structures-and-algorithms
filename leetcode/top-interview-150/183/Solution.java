/*
    ROTATE ARRAY
    Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.



    Example 1:

    Input: nums = [1,2,3,4,5,6,7], k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]

*/

public class Solution {

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n; // handle cases k >= n

        reverse(0, n - 1, nums);
        reverse(0, k - 1, nums);
        reverse(k, n - 1, nums);
    }

    public static void reverse(int left, int right, int[] nums) {
        while (left < right) {
            swap(left, right, nums);
            left++;
            right--;
        }
    }

    public static void swap(int left, int right, int[] nums) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] agrs) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        rotate(nums, k);

        for (int n : nums) {
            System.out.println(n);
        }
    }
}
