/**
 * BEST TIME TO BUY AND SELL STOCK II
 *
 * You are given an integer array prices where prices[i] is the price of a given
 * stock on the ith day
 * On each day, you may decide to buy and/or sell the stock
 * You can only hold at most one share of the stock at any time
 * However, you can buy it then immediately sell it on the same day
 * Find and return the maximum profit you can achieve
 *
 */

public class Solution {
  public static int maxProfit(int[] prices) {
    int n = prices.length;
    int currentProfit = 0;
    int profit = 0;
    int i = 0;

    while (i < n - 1) {
      if (prices[i] < prices[i + 1]) {
        currentProfit = prices[i + 1] - prices[i];
      }
      profit += currentProfit;
      currentProfit = 0;
      i++;
    }
    return profit;
  }

  public static void main(String[] args) {
    int[] prices = { 7, 1, 5, 3, 6, 4 };
    System.out.println(maxProfit(prices));
  }
}
