
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

    // read for loop through value of array, write for update the value of array
    int read = 0;
    int write = 0;

    for (read = 0; read < n - 1; read++) {
      // compare the current value to the next value of array
      if (chars[read] != chars[read + 1]) {
        // if there are an unique value of array, write the value
        chars[write] = chars[read];
        write++;
        // incase count have value, write it to the next position in array, then reset
        // value of count
        if (count > 1) {
          for (char c : String.valueOf(count).toCharArray()) {
            chars[write] = c;
            write++;
          }
          count = 1;
        }
      } else {
        count++;
      }
    }

    // handle the last unique element of array
    chars[write] = chars[read];
    write++;
    if (count > 1) {
      for (char c : String.valueOf(count).toCharArray()) {
        chars[write] = c;
        write++;
      }
    }

    // remove the rest of array
    for (int i = write; i < n; i++) {
      chars[i] = '\0';
    }

    // result
    for (char c : chars) {
      System.out.print(c + " ");
    }
    System.out.println("");
    return write;
  }

  public static void main(String[] args) {
    char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
    System.out.println(compress(chars));
  }
}
