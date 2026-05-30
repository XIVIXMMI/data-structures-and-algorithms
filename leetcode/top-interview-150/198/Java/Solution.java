class Solution {
    // dp[i] = max(dp[i-1], dp[i-2] + nums[i])
    public int rob(int[] nums) {
        int n = nums.length;
        if ( n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        
        // base case
        // dp[i] means the best result up to i position.
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for( int i = 2; i < n; i++) {
            // dp[i - 1] -> skip the current house - keep the best result from previous house
            // dp[i -2] + nums[i] -> rob the current house - add the current money to the best result from i - 2
            // max(skip current, rob current)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }
}