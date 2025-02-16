import java.util.Arrays;

public class RadixSort {

  public static void main(String[] args) {
    int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
    radixSort(arr);
    print(arr);
  }

  // function to get the maximum value in array
  static int getMax(int arr[]) {
    int max = arr[0];
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

  // function do couting sort of array[] according to
  // the digit represented by exp
  static void countSort(int arr[], int exp) {
    int n = arr.length;
    int[] output = new int[n];
    int i;
    int[] count = new int[10];

    Arrays.fill(count, 0); // asignt all the value of count[] = 0

    // store count of occurences in count[]
    for (i = 0; i < n; i++) {
      count[(arr[i] / exp) % 10]++;
    }

    // change the count[i] si that count[i] now contain
    // acctual position of this digit in output
    // make sure that you will know the end of element in the sorted array
    for (i = 1; i < 10; i++) {
      count[i] += count[i - 1];
    }

    // build output array
    for (i = n - 1; i >= 0; i--) {
      output[count[(arr[i] / exp) % 10] - 1] = arr[i];
      count[(arr[i] / exp) % 10]--;
    }

    // copy output array to arr[]
    // so that arr[] now contain sorted numbers according to current digit
    for (i = 0; i < n; i++) {
      arr[i] = output[i];
    }
  }

  // main function to sorts arr[] of size n using radixSort
  static void radixSort(int arr[]) {
    int m = getMax(arr);

    for (int exp = 1; m / exp > 0; exp *= 10)
      countSort(arr, exp);
  }

  static void print(int arr[]) {
    int n = arr.length;

    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
