public class Solution {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = 0;
        for( int i = 0; i < n; i++){
            if( nums[i] != 0 ) {
                nums[j] = nums[i];
                nums[i] = 0;
                j++;
            }
        }
    }

    public static void moveZeroesOptimized(int[] nums){
        int n = nums.length;
        int j = 0; 
        for(int i = 0; i < n; i++ ){
            if ( nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }

        while (j < n) {
            nums[j] = 0;
            j++;
        }
    }
}
