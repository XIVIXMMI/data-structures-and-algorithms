
/**
 *
 * Time complexity: O(n + k)
 * 
 * Counting Sort algorithm sorts an array by counting the number of times each
 * value occurs
 * 
 * Coutinng Sort replies in couting occurrences of distinct values, so they must
 * be integer,
 * with integer, each value fits with an index (for non negative values)
 *
 * Couting sort is usually implemented by creating an array for counting,
 * so that if we tried to sorting negative value we would get in trouble
 * because negative values is outside the counting array
 *
 * If the number of possibile different values to be sorted k is larger than the
 * number of
 * value sorted n, the counting array we need for sorting will be larger than
 * the original array
 * we have that needs sorting, and the algorithm becomes ineffective
 * 
 * e.g: k= 40 n= 45 -> then the size of counting array would be 40
 *
 *
 * And if k = k^7 = 10000000 we can still counting sort
 */

public class CountingSort {
  public static void main(String[] args) {
    int[] inputArray = { 4, 2, 2, 8, 3, 3, 1 };
    for (int i = 0; i < inputArray.length; i++) {
      System.out.print(inputArray[i] + " ");
    }
    int[] outputArray = countingSort(inputArray);
    System.out.println("\n");
    for (int i = 0; i < outputArray.length; i++) {
      System.out.print(outputArray[i] + " ");
    }
  }

  private static int[] countingSort(int[] inputArray) {

    int n = inputArray.length;
    int k = 0;

    // find the maximum values of unsorted array
    for (int i = 0; i < n; i++) {
      k = Math.max(k, inputArray[i]);
    }

    // creating new array to count each value occurs in array
    int[] countArray = new int[k + 1];

    // counting each time value occurs in array
    for (int i = 0; i < n; i++) {
      countArray[inputArray[i]]++;
    }

    // Store the cumulative sum or prefix sum of the elecments of the countArray
    for (int i = 1; i <= k; i++) {
      // this will help in placing of the input array at the correct index in the
      // output array
      // mean you will know the position of elements will end at the sorted array
      countArray[i] += countArray[i - 1];
    }

    int[] outputArray = new int[n];

    for (int i = n - 1; i >= 0; i--) {
      outputArray[countArray[inputArray[i]] - 1] = inputArray[i];
      countArray[inputArray[i]]--;
    }

    return outputArray;
  }
}
