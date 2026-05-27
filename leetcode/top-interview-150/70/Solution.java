class Solution {
    // f(n)=f(n−1)+f(n−2)
    public int climbStairsRecursive(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        return climbStairs(n - 1 ) + climbStairs(n - 2);
    }

    //dp[i]=dp[i−1]+dp[i−2]
    public int climbStairsDynamicProgramming(int n) {
        int[] dp = new int[n + 1];
        if (n <= 2)
            return n;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}