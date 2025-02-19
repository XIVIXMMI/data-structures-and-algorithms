public class FindLowest {
  public static void main(String[] args) {
    int[] arr = { 4, 13, 11, 45, 1, 9 };

    int lowest = arr[0];

    for (int i = 0; i < 6; i++) {
      if (arr[i] < lowest) {
        lowest = arr[i];
      }
    }
    System.out.println(lowest);
  }
}
