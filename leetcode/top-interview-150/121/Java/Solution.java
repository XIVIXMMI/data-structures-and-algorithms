public class Solution {
    
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    
    public static int maxProfit(int[] prices){
        int profit = 0;
        int maxValue = 0; 
        int minValue = prices[0];
        for ( int i = 0; i < prices.length; i++){
            if ( prices[i] < minValue){
                minValue = prices[i];
            }
            maxValue = prices[i];
            // profit = Math.max(maxValue - minValue, profit); // 1 ms 94.5mb
            profit = (maxValue - minValue > profit) ? maxValue - minValue : profit; // 1 ms 94.5mb
            
        }
        return profit;
    }
}
