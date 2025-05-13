
/**
 * H-INDEX
 *
 * Given an array of integers citations where citations[i] is the number of
 * citations
 * researcher received for their ith paper, return the researcher's h-index
 * According to the definition of h-index on Wikipedia:
 * The h-index is defined as the maximum value of h such that
 * the given researcher has published at least h papers that have each been
 * cited at least
 * h times
 */

public class Solution {
  public static int hIndex(int[] citations) {
    int n = citations.length;
    int h = 0;

    // Use Selection sort to sort the array descending O(n^2)
    for (int i = 0; i < n - 1; i++) {
      int maxIndex = i;
      for (int j = i + 1; j < n; j++) {
        if (citations[j] > citations[maxIndex]) {
          maxIndex = j;
        }
      }
      // swap elements
      int temp = citations[i];
      citations[i] = citations[maxIndex];
      citations[maxIndex] = temp;
    }

    for (int i = 0; i < n; i++) {
      if (citations[i] >= i + 1) {
        h++;
      } else {
        break; // no need to check cause the array is descending
      }
    }
    return h;
  }

  /**
   * First create a count[] array with n+1 elements
   * use to count papers have been cited `i` times
   * if the papers have the citations >= n, we'll combine them at the count[n]
   *
   */

  public static int betterHIndex(int[] citations) {
    int n = citations.length;
    int[] count = new int[n + 1];
    int total = 0;

    /**
     * With each citations[i], if c >= n then count[n]++
     * ( we will not follow exactly which elements > n, just throw them to the end)
     * if c < n then count[c]++; (count elements at c position)
     * after the loop, count[i] = papers with exactly i citations
     */
    for (int i = 0; i < count.length - 1; i++) {
      int c = citations[i];
      if (c >= n) {
        count[n]++;
      } else {
        count[c]++;
      }
    }

    /**
     * Then we'll do a reverse loop
     * Browser from n to 0 element, find the greatest value i which total >= i
     * total will cucumlative papers at least i citations
     * when total >= i -> then exist at least i papers have >= i citations
     * then return i
     */
    for (int i = n; i >= 0; i--) {
      total += count[i];
      if (total >= i) {
        return i;
      }
    }

    /**
     * in case we couldn't find i with at least i papers >= i ci
     */
    return total;

  }

  public static void main(String[] args) {
    int[] citations = { 1, 3, 1 };
    System.out.println(betterHIndex(citations));
  }
}
