import java.util.*;
import java.util.stream.Collectors;

/**
 * Given two 0-indexed integer arrays nums1 and nums2, return a list answer of
 * size 2 where:
 * answer[0] is a list of all distinct integers in nums1 which are not present
 * in nums2
 * answer[1] is a list of all distinct integers in nums2 which are not present
 * in nums1
 * Note that the integers in the lists may be returned in any order
 */

public class Solution {
  public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    Set<Integer> set1 = Arrays.stream(nums1) // chuyển mảng thành stream
        .boxed() // chuyển int thành Integer
        .collect(Collectors.toSet()); // lưu vào set

    Set<Integer> set2 = Arrays.stream(nums2) // chuyển mảng thành stream
        .boxed() // chuyển int thành Integer
        .collect(Collectors.toSet()); // lưu vào set

    Set<Integer> uniqueNums1 = new HashSet<>(set1);
    Set<Integer> uniqueNums2 = new HashSet<>(set2);

    uniqueNums1.removeAll(set2);
    uniqueNums2.removeAll(set1);

    return List.of(new ArrayList<>(uniqueNums1), new ArrayList<>(uniqueNums2));
  }

  public static void main(String[] args) {
    int[] nums1 = { 1, 2, 4, 6 };
    int[] nums2 = { 1, 2, 3, 7 };
    List<List<Integer>> answers = findDifference(nums1, nums2);
    System.out.println(answers);
  }
}
