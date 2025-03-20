import java.util.Arrays;

/**
 * There is a biker going on a road trip
 * The road trip consists of n + 1 points at different altitudes
 * The biker starts his trip on point 0 with altitude equal 0
 * 
 * You are given an integer array gain of length n where gain[i] is the net gain
 * in altitude between points i and i + 1 for all (0 <= i < n)
 * Return the highest altitude of a point
 */

public class Solution {
  public static int largestAltitude(int[] gain) {
    int a = 0;
    int[] arr = new int[gain.length + 1];
    arr[0] = 0;
    for (int i = 1; i < arr.length; i++) {
      arr[i] = gain[i - 1];
    }
    System.out.println(Arrays.toString(arr));
    for (int i = 0; i < arr.length - 1; i++) {
      arr[i + 1] += arr[i];
      // a = Math.max(a, arr[i + 1]);
    }
    System.out.println(Arrays.toString(arr));
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > a) {
        a = arr[i];
      }
    }
    return a;
  }

  public static void main(String[] args) {
    int[] gain = { 44, 32, -9, 52, 23, -50, 50, 33, -84, 47, -14, 84, 36, -62, 37, 81, -36, -85, -39, 67, -63, 64, -47,
        95, 91, -40, 65, 67, 92, -28, 97, 100, 81 };
    System.out.println(largestAltitude(gain));
  }
}
