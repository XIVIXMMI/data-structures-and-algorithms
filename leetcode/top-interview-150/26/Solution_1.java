/**
 * REMOVE DUPLICATES FROM SORTED ARRAY
 * Given an integer array nums sorted in non-decreasing order,
 * remove the duplicates in-place such that each unique element appears only
 * once.
 * The relative order of the elements should be kept the same.
 * Consider the number of unique elements in nums to be k​​​​​​​​​​​​​​.
 * After removing duplicates, return the number of unique elements k.
 * The first k elements of nums should contain the unique numbers in sorted
 * order.
 * The remaining elements beyond index k - 1 can be ignored.
 */

public class Solution_1 {
    public static int removeDuplicates(int[] nums) {
        int n = nums.length ;
        int i = 0;
        int j = 0;
        while (i < n) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
            i++;

        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 3 }; // 2
        int rs = removeDuplicates(nums);
        for (int n : nums) {
            System.out.println(n);
        }
        System.out.println("\n " + rs);
    }
}
