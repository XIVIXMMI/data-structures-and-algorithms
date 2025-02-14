import java.util.Arrays;

public class CountingSort {
  public static void main(String[] args) {
    int[] arr = { 4, 2, 2, 8, 3, 3, 1 };
    countingSort(arr);
    System.out.println("Sorted array: " + Arrays.toString(arr));
  }

  private static void countingSort(int[] arr) {

    // find the maximum value in the Arrays
    int max = Arrays.stream(arr).max().getAsInt();
    int min = Arrays.stream(arr).max().getAsInt();
    int range = max - min + 1;

    // create a count aray to store the count of each element
    int[] count = new int[range];
    int[] output = new int[arr.length];

    // count the occurrence of each element
    for (int num : arr) {
      count[num - min]++;
    }

    // update the coutn array to store the position of each element in the output
    // array
    for (int i = 0; i < count.length; i++) {
      count[i] += count[i - 1];
    }

    // build the output array
    for (int i = arr.length - 1; i >= 0; i--) {
      output[count[arr[i] - min] - 1] = arr[i];
      count[arr[i] - min]--;
    }

    System.arraycopy(output, 0, arr, 0, arr.length);
  }
}
