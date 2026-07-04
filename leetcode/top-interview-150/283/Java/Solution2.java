class Solution2 {
    public void moveZeroes(int[] nums) {
        int i = 1;
        int j = 0;

        while (i < nums.length) {
            if( nums[j] != 0) {
                j++;
            }
            if(nums[j] == 0 && nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
            i++;
        }
    }
}
