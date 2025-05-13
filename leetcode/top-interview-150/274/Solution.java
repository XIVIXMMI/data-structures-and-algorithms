
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

  public static int betterHIndex(int[] citations) {
    int n = citations.length;
    int[] count = new int[n + 1];
    int h = 0;

    for (int i = 0; i < count.length - 1; i++) {
      int c = citations[i];
      if (c >= n) {
        count[n]++;
      } else {
        count[c]++;
      }
    }

    for (int i = n; i >= 0; i--) {
      h += count[i];
      if (h >= i) {
        return i;
      }
    }

    return h;

  }

  public static void main(String[] args) {
    int[] citations = { 1, 3, 1 };
    System.out.println(betterHIndex(citations));
  }
}
