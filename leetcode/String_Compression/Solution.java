
/**
 * Given an array of characters chars, compress it using the following
 * algorithm:
 * Begin with an empty string s
 * For each group of consecutive repeating characters in chars:
 * If the group's length is 1, append the character to s
 * Otherwise, append the character followed by the group's length
 * The compressed string s should not be returned separately, but instead, be
 * stored in the input character array chars
 * Note that group lengths that are 10 or longer will be split into multiple
 * characters in chars
 * After you are done modifying the input array, return the new length of the
 * array
 * You must write an algorithm that uses only constant extra space.
 */

public class Solution {
  public static int compress(char[] chars) {
    int count = 1;
    int n = chars.length;

    if (n == 0) {
      return 0;
    }
    // read for loop through value of array, write for update the value of array
    int read = 0;
    int write = 0;

    for (read = 1; read <= n; read++) {
      // compare the current value to the next value of array
      if (read == n || chars[read] != chars[read - 1]) {
        // if there are an unique value of array, write the value
        chars[write++] = chars[read - 1];
        // incase count have value, write it to the next position in array, then reset
        // value of count
        if (count > 1) {
          int start = write;
          while (count > 0) {
            chars[write++] = (char) (count % 10 + '0');
            count /= 10;
          }
          reverse(chars, start, write - 1);
        }
        count = 1;
      } else {
        count++;
      }
    }

    // result
    for (char c : chars) {
      System.out.print(c + " ");
    }
    System.out.println("");
    return write;
  }

  private static void reverse(char[] chars, int left, int right) {
    while (left < right) {
      char temp = chars[left];
      chars[left++] = chars[right];
      chars[right--] = temp;
    }
  }

  public static void main(String[] args) {
    char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
    System.out.println(compress(chars));
  }
}
