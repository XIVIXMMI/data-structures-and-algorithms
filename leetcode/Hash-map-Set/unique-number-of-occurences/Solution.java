import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers arr, return true if the number of occurrences of
 * each value in the array is unique or false otherwise.
 */

public class Solution {
  public static boolean uniqueOccurrences(int[] arr) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      // lưu số lần xuất hiện của giá trị theo cặp key value
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }

    Set<Integer> set = new HashSet<>();

    // lặp qua map xem số lần xuất hiện có trùng hay không
    for (Integer value : map.values()) {
      /**
       * set.add(value) sẽ trả về false nếu có giá trị trùng
       * dấu ! để trả thành true, chạy statement if
       */
      if (!set.add(value)) {
        // trà về false nếu số lần xuất hiện của các element trùng nhau
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    int[] arr = { 3, 5, -2, -3, -6, -6 };
    boolean result = uniqueOccurrences(arr);
    System.out.println(result);
  }
}
