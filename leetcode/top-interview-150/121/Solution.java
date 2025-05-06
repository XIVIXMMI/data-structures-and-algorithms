/**
 * BEST TIME TO BUY AND SELL STOCK
 *
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock
 * Return the maximum profit you can achieve from this transaction
 * If you cannot achieve any profit, return 0
 */

public class Solution {
  public static int maxProfit(int[] prices) {
    int n = prices.length;
    int min = 0;
    int max = 0;
    int profit = 0;

    for (int i = 0; i < n; i++) {
      if (prices[min] > prices[i]) {
        min = i;
      }
      max = prices[i] - prices[min];
      profit = Math.max(profit, max);
    }

    return profit;
  }

  public static void main(String[] args) {
    int[] prices = { 7, 1, 5, 3, 6, 4 };
    int rs = maxProfit(prices);
    System.out.println(rs);
  }
}
