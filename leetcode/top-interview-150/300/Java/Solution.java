import java.util.Arrays;

class Solution {
    // Time Complexity = O(n^2)
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int rs = 0;
        for (int i : dp) {
            rs = Math.max(i, rs);
        }

        return rs;
    }
}