
/**
 * You are given an integer array nums consisting of n elements, and an integer
 * k
 * Find a contiguous subarray whose length is equal to k that has the maximum
 * average value and return this value
 * Any answer with a calculation error less than 10-5 will be accepted
 */

public class Solution {
  public double findMaxAverage(int[] nums, int k) {
    int sum = 0;
    // tính tổng sum hiện tại
    for (int i = 0; i < k; i++) {
      sum += nums[i];
    }
    int maxSum = sum;
    // dùng sliding window để trượt qua mảng
    for (int i = k; i < nums.length; i++) {
      sum += nums[i] - nums[i - k]; // thêm phần tử mới, bỏ phần tử cũ
      maxSum = Math.max(maxSum, sum);
    }
    return (double) maxSum / k; // trả về giá trị trung bình lớn nhất
  }
}
