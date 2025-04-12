
/**
 * Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri,
 * cj) such that row ri and column cj are equal
 * A row and column pair is considered equal if they contain the same elements
 * in the same order (i.e., an equal array)
 * 
 */

import java.util.*;
import java.util.stream.Collectors;

/**
 * Ý tưởng chính:
 * Duyệt qua từng hàng và cột của ma trận
 * Biến chúng thành mảng hoặc chuỗi rồi so sánh có bao nhiêu hàng giống với cột
 * Cách tối ưu:
 * - Duyệt qua các hàng, lưu vào tầng xuất xuất hiện vào hashMap
 * - Duyệt qua các cột và đếm xem cột đó tồn tại bao nhiêu lần tương ứng với
 * hàng.
 * 
 */

public class Solution {
  public static int equalPairs(int[][] grid) {

    // create a hashMap to store the frequencies of column number
    HashMap<List<Integer>, Integer> map = new HashMap<>();

    // loop through the grid and convert element to String
    for (int[] row : grid) {
      List<Integer> rowList = Arrays.stream(row).boxed().collect(Collectors.toList());
      map.put(rowList, map.getOrDefault(rowList, 0) + 1);
    }

    int n = grid.length;
    int count = 0;

    for (int j = 0; j < n; j++) {
      List<Integer> colList = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        colList.add(grid[i][j]);
      }
      if (map.containsKey(colList)) {
        count += map.get(colList);
      }
    }

    return count;
  }

  public static void main(String[] args) {
    int[][] grid = {
        { 3, 2, 1 },
        { 1, 7, 6 },
        { 2, 7, 7 }
    };
    System.out.println(equalPairs(grid));
  }
}
