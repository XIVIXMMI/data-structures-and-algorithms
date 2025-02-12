import java.util.Random;

public class InsertionSort {
  public static void main(String[] args) {
    Random random = new Random();
    int[] arr = new int[10];
    int n = arr.length;

    for (int i = 0; i < n; i++) {
      arr[i] = random.nextInt(40);
    }

    for (int i : arr) {
      System.out.println("Before: " + i);
    }

    for (int i = 1; i < n; i++) {
      int currentValue = arr[i];
      // Lấy giá trị đầu tiên để tạo phần chưa sắp xếp của mảng
      int j = i - 1;
      while (j >= 0 && arr[j] > currentValue) {
        // Di chuyển mảng sang phải
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = currentValue;
    }

    for (int i : arr) {
      System.out.println("After: " + i);
    }
  }
}
