/**
 * Given an integer array nums, 
 * move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 */

public class Solution {
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        while( i < n){
            if( nums[i] != 0 ){
                nums[j] = nums[i];
                if(i > j){
                    nums[i] = 0;
                }
                j++;
            }
            i++;
        }

        for(int num : nums){
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        moveZeroes(nums);
    }
}
