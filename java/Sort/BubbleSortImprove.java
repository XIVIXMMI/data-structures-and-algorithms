public class BubbleSortImprove {
  public static void main(String[] args) {
    int[] arr = { 7, 3, 9, 12, 11 };
    int n = arr.length;

    boolean swapped = false;

    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          swapped = true;
        }
      }
      if (!swapped)
        break;
    }

    for (int i : arr) {
      System.out.println(i);
    }
  }
}
