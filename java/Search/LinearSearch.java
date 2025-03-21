public class LinearSearch {
  private static int linearSearch(int[] arr, int x) {
    int n = arr.length;

    for (int i = 0; i < n; i++) {
      if (arr[i] == x) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int arr[] = { 13, 5, 87, 90, 30, 2 };
    int rs = linearSearch(arr, 2);
    System.out.println("index of result is: " + rs);
  }
}
