/**
 * divide and conquer algorithm
 * divide: start with breaking the array into smaller and smaller pieces until
 * once such sub-array only consists of one element
 * conquer: merges the small pieces of the array back together by putting the
 * lowest value first,
 * resulting in a sorted array
 *
 * The breaking down the and building up of the array to sort the array until
 * done recursively.
 *
 *
 **/

public class MergeSort {

  /**
   * merges two sub-array of array[]
   * first sub-array is array[ left -> mid]
   * second sub-array is array[mid + 1 -> right]
   */
  private static void merges(int[] arr, int left, int mid, int right) {
    // find size of sub-array to be merges
    int n1 = mid - left + 1; // -> size of left array
    int n2 = right - mid; // -> size of right array

    // create temp array
    int[] leftArray = new int[n1];
    int[] rightArray = new int[n2];

    // copy value into sub-array
    for (int i = 0; i < n1; i++) {
      leftArray[i] = arr[left + i];
    }

    for (int j = 0; j < n2; j++) {
      rightArray[j] = arr[mid + 1 + j];
    }

    // merges two sub-array to original array
    int i = 0;
    int j = 0;
    int k = left;
    while (i < n1 && j < n2) {
      if (leftArray[i] <= rightArray[j]) {
        arr[k] = leftArray[i];
        i++;
      } else {
        arr[k] = rightArray[j];
        j++;
      }
      k++;
    }

    // copy the remaining elements of leftAgrray[] if any
    while (i < n1) {
      arr[k] = leftArray[i];
      i++;
      k++;
    }

    // copy the remaining elements of rightArray[] if any
    while (j < n2) {
      arr[k] = rightArray[j];
      j++;
      k++;
    }
  }

  // main fuction that sort array[left -> right]
  private static void sort(int[] arr, int left, int right) {
    if (left < right) {
      // find middle point
      int mid = (right + left) / 2;

      // sort first and second sub-array
      sort(arr, left, mid);
      sort(arr, mid + 1, right);

      // merges 2 sub-array
      merges(arr, left, mid, right);
    }
  }

  private static void print(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] arr = { 12, 11, 5, 6, 13, 7 };
    System.out.println("Given array is: ");
    print(arr);
    sort(arr, 0, arr.length - 1);
    System.out.println("\n Sorted Array: ");
    print(arr);
  }
}
