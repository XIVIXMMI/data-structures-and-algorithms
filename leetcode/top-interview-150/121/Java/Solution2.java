class Solution2 {
    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            }
            max = prices[i];

            maxProfit = Math.max(maxProfit, max - min);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = { 2, 4, 1 };
        System.out.println(maxProfit(prices));
    }
}