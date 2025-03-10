import java.util.HashMap;

public class BetterSolution {
  private static int maxOperation(int[] nums, int k) {
    int count = 0;
    // create Hashmap
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int num : nums) {
      // find the complement value of num
      int complement = k - num;
      // nếu giá trị bù của k được tìm thấy thì count + 1
      if (map.getOrDefault(complement, 0) > 0) {
        count++;
        // giảm số làn xuất hiện của complement ( phần bù của num để tạo thành k) 1 lần
        // vì khi đã tồn tại giá trị complement nên giảm số lần xuất hiện của nó đi 1
        map.put(complement, map.get(complement) - 1);
      } else {
        // nếu không tìm thấy thì thêm số lần xuất hiện của nó vào map
        map.put(num, map.getOrDefault(num, 0) + 1);
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[] num = { 4, 5, 6, 3, 1, 5, 6 };
    int k = 10;
    System.out.println(maxOperation(num, k));
  }
}
