
/**
 * You are given an integer array height of length n
 * There are n vertical lines drawn such that the two endpoints of the ith line
 * are (i, 0) and (i, height[i])
 * Find two lines that together with the x-axis form a container, such that the
 * container contains the most after
 * Return the maximum amount of water a container can store
 * Notice that you may not slant the container
 */

class Solution {
  public static int maxArea(int[] height) {
    int i = 0;
    int j = height.length - 1;
    int result = 0;

    while (i < j) {
      int minHeight = Math.min(height[i], height[j]);
      int currentArea = minHeight * (j - i);
      // cập nhật result
      result = Math.max(result, currentArea);
      if (height[i] < height[j]) {
        i++;
      } else {
        j--;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] height = { 8, 7, 2, 1 };
    System.out.println(maxArea(height)); // OUTPUT: expect 7
  }
}
