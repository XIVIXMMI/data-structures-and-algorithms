/**
 * You have a long flowerbed in which some of the plots are planted, and some
 * are not
 * However, flowers cannot be planted in adjacent plots
 * Given an integer array flowerbed containing 0's and 1's,
 * where 0 means empty and 1 means not empty, and an integer n,
 * return true if n new flowers can be planted in the flowerbed
 * without violating the no-adjacent-flowers rule and false otherwise.
 */

public class Solution {
  public static boolean canFlowerPlace(int[] flowerbed, int n) {
    int count = 0;
    int size = flowerbed.length;
    if (n < 1) {
      return false;
    }
    // loop through the array, find the place flowers can be planted
    for (int i = 0; i < size; i++) {
      if (flowerbed[i] <= 1) {
        if (flowerbed[i] == 0) {
          boolean emtyLeft = (i == 0 || flowerbed[i - 1] == 0);
          boolean emtyRight = (i == size - 1 || flowerbed[i + 1] == 0);
          if (emtyLeft && emtyRight) {
            flowerbed[i] = 1;
            count++;
            if (count >= n) {
              return true;
            }
          }
        }
      }
    }
    return count >= n;
  }

  public static void main(String[] args) {
    int[] arr = { 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 };
    boolean rs1 = canFlowerPlace(arr, 2);
    boolean rs2 = canFlowerPlace(arr, 3);
    System.out.println(rs1 + "\n" + rs2);

  }
}
