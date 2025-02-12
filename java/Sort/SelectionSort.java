
public class SelectionSort {
  public static void main(String[] args) {
    int[] arr = { 7, 12, 11, 13, 9 };

    int n = arr.length;

    for (int i = 0; i < n - 1; i++) {
      // lowest's index value
      int min_index = i;
      // inner loop, find the lowest value
      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[min_index]) {
          min_index = j;
        }
      }

      // move the lowest value to front of array
      if (min_index != i) {
        int temp = arr[i];
        arr[i] = arr[min_index];
        arr[min_index] = temp;
      }
    }

    for (int i : arr) {
      System.out.println(i);
    }

  }
}
